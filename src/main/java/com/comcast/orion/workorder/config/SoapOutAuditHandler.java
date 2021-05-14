package com.comcast.orion.workorder.config;

import static net.logstash.logback.marker.Markers.append;

import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.io.CacheAndWriteOutputStream;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedOutputStreamCallback;
import org.apache.cxf.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import com.comcast.orion.logging.interceptor.LogProcessor;
import com.comcast.orion.logging.messaging.JmsMessageTemplate;
import com.comcast.orion.logging.messaging.vo.AuditLoggingVO;

@Component
public class SoapOutAuditHandler extends LoggingOutInterceptor {

	private static final Logger log = LoggerFactory.getLogger(SoapOutAuditHandler.class);

	public SoapOutAuditHandler() {
		super();
	}

	@Override
	protected String formatLoggingMessage(LoggingMessage loggingMessage) {
		log.info("CXFDSLoggingOutInterceptor: formatLoggingMessage - Enters");
		String formattedLoggingMessage = null;
		if (loggingMessage != null) {
			log.info("CXFDSLoggingOutInterceptor - Removing Line Feed in LoggingMessage");
			formattedLoggingMessage = loggingMessage.toString().replaceAll("\n", "");
		}
		log.info("CXFDSLoggingOutInterceptor: formatLoggingMessage - Exits");
		return formattedLoggingMessage;
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		log.info("Inside the CXFDSLoggingOutInterceptor#handleMessage method - start");
		OutputStream out = message.getContent(OutputStream.class);
		final CacheAndWriteOutputStream newOut = new CacheAndWriteOutputStream(out);
		message.setContent(OutputStream.class, newOut);
		newOut.registerCallback(new LoggingCallback(message));
		log.info("Inside the CXFDSLoggingOutInterceptor#handleMessage method - end");
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

				writePayload(builder, cos, encoding, ct, false);

				String dsRequestURI = (String) message.get(Message.ENDPOINT_ADDRESS);
				Map<String, List<String>> reqHeaders = (Map<String, List<String>>) message
						.get(Message.PROTOCOL_HEADERS);

				String trackingId = (String) message.getExchange().get("trackingId");
				String operationName = (String) message.getExchange().get("operationName");

				if (trackingId == null) {
					// trackingId = MDC.get(LogProcessor.TRACE_MDC_KEY);
					trackingId = MDC.get("trackingId");

				}

				//if (operationName == null) {
					operationName = MDC.get("operationName");
				//}
				AuditLoggingVO auditLoggingVO = new AuditLoggingVO();
				String spanId = MDC.get("X-B3-SpanId");
				// long receivedTimeStamp = System.currentTimeMillis();

				// auditLoggingVO.MDC.put("receivedTimeStamp", "" + receivedTimeStamp);
				// MDC.put("CXFSpanId", spanId);
				auditLoggingVO.setId(spanId);
				auditLoggingVO.setTraceId(MDC.get("X-B3-TraceId"));
				auditLoggingVO.setParentId(MDC.get("X-B3-TraceId"));
				auditLoggingVO.setSpanId(spanId);
				// auditLoggingVO.setRequestTimeStamp("" + receivedTimeStamp);

				// auditLoggingVO.setDsRequestBody(builder.toString().replaceAll("&|#|13|\\\\n|\\\\r|\\\\n\\\\r",
				// ""));
				String requestXML = builder.toString().replaceAll("\\\\n|\\\\r|\\\\n\\\\r", "");
				requestXML = builder.toString().replaceAll("&#13|\\\\n|\\\\r|\\\\n\\\\r|;\n", "");
				auditLoggingVO.setDsRequestBody(requestXML);
				MDC.put("requestSOAPXML", requestXML);
				// System.out.println(builder.toString().replaceAll("&|#|13|;", ""));
				auditLoggingVO.setServiceName(MDC.get("serviceName"));
				auditLoggingVO.setEnvName(MDC.get(LogProcessor.ENV_NAME_MDC_KEY));
				auditLoggingVO.setBusinessParam(MDC.get(LogProcessor.BUSINESS_MDC_KEY));
				auditLoggingVO.setSpringAppName(MDC.get(LogProcessor.SPRINGAPPNAME_MDC_KEY));
				auditLoggingVO.setHostName(dsRequestURI);

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
				auditLoggingVO.setTrackingId(trackingId);
				auditLoggingVO.setDsRequestUri(dsRequestURI);
				String createTime = "" + System.currentTimeMillis();
				MDC.put("createTime", createTime);
				auditLoggingVO.setDownstreamName(LogProcessor.ORION_SOURCE_MDC_KEY);
				auditLoggingVO.setOperationName(operationName);
				Map<String, String> headers = new HashMap<String, String>();
				for (Entry<String, List<String>> e : reqHeaders.entrySet()) {
					if (e.getValue() != null)
						headers.put(e.getKey(), e.getValue().toString());
				}
				auditLoggingVO.setREQ_HEADERS(headers);
				log.info(auditLoggingVO.toString().replaceAll(";\n", ""));

				jmsMessageTemplate.send(auditLoggingVO);
				log.info(append("dsRequestUri", dsRequestURI).and(append("dsRequestBody", requestXML)),
						"downstream SOAP request");
			} catch (Exception ex) {
				// ignore
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