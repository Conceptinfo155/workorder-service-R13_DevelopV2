package com.comcast.orion.workorder.config;

import static net.logstash.logback.marker.Markers.append;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedOutputStreamCallback;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import com.comcast.orion.logging.interceptor.LogProcessor;
import com.comcast.orion.logging.messaging.JmsMessageTemplate;
import com.comcast.orion.logging.messaging.vo.AuditLoggingVO;

@Component
public class SoapInAuditHandler extends LoggingInInterceptor {

	private static final Logger log = LoggerFactory.getLogger(SoapInAuditHandler.class);

	public SoapInAuditHandler() {
		super(Phase.RECEIVE);
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		try {
			log.info("Inside the CXFLoggingInnInterceptor#handleMessage method - start");
			InputStream is = message.getContent(InputStream.class);
			CachedOutputStream bos = new CachedOutputStream();
			IOUtils.copy(is, bos);
			bos.flush();
			message.setContent(InputStream.class, bos.getInputStream());
			is.close();
			bos.registerCallback(new LoggingCallback(message));
			bos.close();
			log.info("Inside the CXFLoggingInInterceptor#handleMessage method - end");
		} catch (IOException e) {
			log.error("CXFLoggingInInterceptor: handleMessage(): " + e.getMessage());
		}
	}

	private class LoggingCallback implements CachedOutputStreamCallback {

		private final Message message;
		JmsMessageTemplate jmsMessageTemplate = new JmsMessageTemplate();

		LoggingCallback(final Message msg) {
			this.message = msg;
		}

		public void onFlush(CachedOutputStream cos) {

		}

		public void onClose(CachedOutputStream cos) {

			try {
				StringBuilder builder = new StringBuilder();

				String ct = (String) message.get(Message.CONTENT_TYPE);
				String encoding = (String) message.get(Message.ENCODING);
				String responseStatus = (String) message.get(Message.RESPONSE_CODE).toString();
				String responseHeaders = (String) message.get(Message.PROTOCOL_HEADERS).toString();
				String dsRequestURI = (String) message.get(Message.ENDPOINT_ADDRESS);
				Map<String, List<String>> reqHeaders = (Map<String, List<String>>) message
						.get(Message.PROTOCOL_HEADERS);

				writePayload(builder, cos, encoding, ct, true);

				// Log Message
				String trackingId = (String) message.getExchange().get("trackingId");
				String operationName = (String) message.getExchange().get("operationName");

				if (trackingId == null) {
					trackingId = MDC.get("trackingId");
				}

			//	if (operationName == null) {
					operationName = MDC.get("operationName");
			//	}

				AuditLoggingVO auditLoggingVO = new AuditLoggingVO();
				String spanId = MDC.get("X-B3-SpanId");
				auditLoggingVO.setId(spanId);
				auditLoggingVO.setTraceId(MDC.get("X-B3-TraceId"));
				auditLoggingVO.setParentId(MDC.get("X-B3-TraceId"));
				auditLoggingVO.setSpanId(spanId);
				auditLoggingVO.setDsRequestUri(dsRequestURI);
				auditLoggingVO.setServiceName(MDC.get("serviceName"));
				auditLoggingVO.setTrackingId(trackingId);
				auditLoggingVO.setDsResponseStatusCode(responseStatus);
				auditLoggingVO.setDownstreamName(LogProcessor.ORION_SOURCE_MDC_KEY);
				auditLoggingVO.setOperationName(operationName);
				auditLoggingVO.setEnvName(MDC.get(LogProcessor.ENV_NAME_MDC_KEY));
				auditLoggingVO.setBusinessParam(MDC.get(LogProcessor.BUSINESS_MDC_KEY));
				auditLoggingVO.setSpringAppName(MDC.get(LogProcessor.SPRINGAPPNAME_MDC_KEY));
				auditLoggingVO.setHostName(dsRequestURI);
				auditLoggingVO.setDsRequestBody(MDC.get("requestSOAPXML"));
				Map<String, String> headers = new HashMap<String, String>();
				for (Entry<String, List<String>> e : reqHeaders.entrySet()) {
					if (e.getValue() != null)
						headers.put(e.getKey(), e.getValue().toString());
				}
				auditLoggingVO.setREQ_HEADERS(headers);
				auditLoggingVO.setOperationName(operationName);
				// auditLoggingVO.setDsRequestBody(builder.toString().replaceAll("\\n|\\r|\\n\\r",
				// ""));
				auditLoggingVO.setDsResponseBody(builder.toString().replaceAll("\\n|\\r|\\n\\r", ""));
				SimpleDateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date currentdate = new Date();
				Date receivedTimedate = new Date();
				String requestTimeStampa = dateformatter.format(currentdate).toString();
				String receivedTimeStamp = dateformatter.format(receivedTimedate).toString();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date receivedTS = null;
				Date responseTS = null;
				try {
					receivedTS = formatter.parse(requestTimeStampa);
					responseTS = formatter.parse(receivedTimeStamp);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// auditLoggingVO.setRequestTimeStamp(requestTimeStamp);
				log.info("requestTimeStampa : " + requestTimeStampa);
				auditLoggingVO.setRequestTimeStamp(requestTimeStampa);
				auditLoggingVO.setReceivedTimeStamp("" + receivedTimeStamp);

				Long currentTime = Calendar.getInstance().getTimeInMillis();
				Long processingTS = responseTS.getTime() - receivedTS.getTime();
				long diffSeconds = processingTS / 1000 % 60;
				long diffMinutes = processingTS / (60 * 1000) % 60;
				@SuppressWarnings("unused")
				String processingTime = diffMinutes + "Min" + diffSeconds + "sec";
				log.info("processingTime : " + processingTime + " requestTimeStamp : " + requestTimeStampa
						+ "responseTimeStamp : " + receivedTimeStamp);

				Long endTimeSec = Calendar.getInstance().getTimeInMillis();

				log.info("LogReqResFilter::doFilterInternal()::endTimeSec::" + endTimeSec);

				double timeDifferenceSeconds = ((endTimeSec - currentTime) / 1000.0);

				log.info("LogReqResFilter::doFilterInternal()::timeDifferenceSeconds::" + timeDifferenceSeconds);
				auditLoggingVO.setTimeDiff(processingTime + " : " + timeDifferenceSeconds);
				log.info(builder.toString());
				// MDC.remove("CXFSpanId");
				log.info(auditLoggingVO.toString());
				jmsMessageTemplate.send(auditLoggingVO);

				log.info(
						append("dsResponseStatus", responseStatus).and(append("dsResponseHeaders", responseHeaders))
								.and(append("dsResponseBody", builder.toString().replaceAll("\\n|\\r|\\n\\r", ""))),
						"downstream SOAP response");

			} catch (Exception ex) {
				System.out.println("ex" + ex);
			}

			try {
				// empty out the cache
				cos.lockOutputStream();
				cos.resetOut(null, false);
			} catch (Exception ex) {
				// ignore
			}
		}
	}
}