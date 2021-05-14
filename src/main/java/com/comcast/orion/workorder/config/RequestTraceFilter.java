package com.comcast.orion.workorder.config;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HttpMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.comcast.orion.workorder.utils.WorkOrderConstants;
import com.comcast.xsp.security.helpers.TokenManager;
import com.comcast.xsp.security.helpers.XspOauthToken;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

/**
 * RequestTraceFilter
 *
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestTraceFilter extends GenericFilterBean {

	/**
	 * ONE
	 */
	private static final int ONE = 1;

	/**
	 * TWO
	 */
	private static final int TWO = 2;

	/**
	 * THREE
	 */
	private static final int THREE = 3;

	/**
	 * FOUR
	 */
	private static final int FOUR = 4;

	/**
	 * Logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(RequestTraceFilter.class);

	/** The token manager. */
	@Autowired
	private TokenManager tokenManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	//Filter chain
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HystrixRequestContext context = null;
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		try {
			context = HystrixRequestContext.initializeContext();
			if (httpServletRequest.getServletPath().contains("workorder")) {
				setRequestHeaderParams(httpServletRequest);
				LOG.info("EnteringIntoFilter");
				chain.doFilter(request, response);
				LOG.info("ExitingFromFilter");
			} else {
				chain.doFilter(request, response);
			}
		} finally {
			if (context != null) {
				context.close();
			}
		}
	}

	/**
	 * Sets Request header Parameters
	 * 
	 * @param httpServletRequest
	 */
	public void setRequestHeaderParams(HttpServletRequest httpServletRequest) {
		String clientId = getClient(httpServletRequest);
		String correlationId = clientId + UUID.randomUUID().toString();
		String sourceTrackingID = httpServletRequest.getHeader("trackingId");
		String mdcData = String.format("[%s][%s] ", "TrackingID ", sourceTrackingID);
		if (null == sourceTrackingID) {
			sourceTrackingID = "workorder-" + correlationId;
			mdcData = String.format("[%s][%s] ", "TrackingID ", sourceTrackingID);
		}

		String serviceName = null;
		String serviceVersion = null;
		String operationName = null;
		LOG.info("RequestTraceFilter--- >httpServletRequest.getRequestURI() () :"+httpServletRequest.getRequestURI());

		String[] serviceDetails = httpServletRequest.getRequestURI().split("/");
		if (serviceDetails != null && serviceDetails.length >= 3) {
			serviceName = serviceDetails[1] != null ? serviceDetails[1] : "";
			serviceVersion = serviceDetails[2] != null ? serviceDetails[2] : "";
			operationName = serviceDetails[3] != null ? serviceDetails[3] : "";

			String httpMethod= httpServletRequest.getMethod();
			
			if(HttpMethod.DELETE.equals(httpMethod) && !operationName.equalsIgnoreCase("pointofinterest") ) {
				operationName = WorkOrderConstants.CANCEL_WORK_ORDER.getValue();
			}else if (HttpMethod.DELETE.equals(httpMethod)){
				operationName = WorkOrderConstants.CANCEL_POINT_OF_INTEREST.getValue();
			}
			
			if("PATCH".equals(httpMethod)) {
				operationName = WorkOrderConstants.RESCHEDULE_APPOINTMENT.getValue();
			}else if(serviceDetails.length == 4 &&  !operationName.equalsIgnoreCase("scheduleworkorder") && !operationName.equalsIgnoreCase(WorkOrderConstants.CANCEL_POINT_OF_INTEREST.getValue()) && !operationName.equalsIgnoreCase("pointofinterest")) {
				operationName = WorkOrderConstants.GET_WFX_WORKORDER.getValue();
			} 
			
			 if(serviceDetails.length==6){
				operationName= serviceDetails[5];
				if(!operationName.equalsIgnoreCase("futureworkorders") && !operationName.equalsIgnoreCase("workorders")){
					operationName = WorkOrderConstants.CANCEL_WORK_ORDER.getValue();
				}
			}else if(operationName.equalsIgnoreCase("odo")){
				operationName= WorkOrderConstants.ODO_WO_DETAILS.getValue();
			}
				
			
			LOG.info("RequestTraceFilter--- >serviceName : "+serviceName+" serviceVersion : "+serviceVersion+" operationName : "+operationName);
					
			
		}

		StringBuffer url = httpServletRequest.getRequestURL();
		String host = url.substring(0, url.indexOf(httpServletRequest.getRequestURI()));

		MDC.put("mdcData", mdcData);
		MDC.put("trackingId", sourceTrackingID);
		MDC.put("correlationId", correlationId);
		MDC.put("cspUserId", clientId);
		MDC.put("envName", System.getenv("SPRING_PROFILES_ACTIVE"));
		MDC.put("hostName", host);
		MDC.put("serverInstance", System.getenv("CF_INSTANCE_INDEX"));
		MDC.put("serviceName", serviceName+serviceVersion);
		MDC.put("serviceVersion", serviceVersion);
		MDC.put("operationName", operationName);
		MDC.put("source", "OMW");
		MDC.put("businessParam", "NA");
		String[] requestUri = httpServletRequest.getRequestURL().toString().split("v2");
		MDC.put("requestUri", requestUri[0] + "v2/");
		LOG.info("MDC values ---> {}", MDC.getCopyOfContextMap());
	}

	/**
	 * Returns the clientId from bearer token.
	 *
	 * @param httpServletRequest
	 *            the http servlet request
	 * @return the client
	 */
	private String getClient(HttpServletRequest httpServletRequest) {	
		String token = httpServletRequest.getHeader("Authorization");
		XspOauthToken xspToken = tokenManager.decodeToken(token);
		if(xspToken != null) {
			return xspToken.getClientId();
		}else {
			return null;
		}

	}

}
