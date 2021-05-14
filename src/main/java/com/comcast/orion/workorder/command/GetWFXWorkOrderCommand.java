package com.comcast.orion.workorder.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import com.comcast.orion.workorder.domain.wfx.getworkorder.request.GetWorkOrderWFXResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class GetWFXWorkOrderCommand {
	/** The log. */
	private static final Logger log = LoggerFactory.getLogger(GetWFXWorkOrderCommand.class);

	/** The wo rest template. */
	@Autowired
	private RestTemplate woRestTemplate;

	/** The service util. */
	@Autowired
	private ServiceUtil serviceUtil;

	@Value("${workorder.wfx.getworkorder.url}")
	private String getWorkOrderUrl;

	/**
	 * Get WFX the workorder.
	 *
	 * @param orderNumber the order number
	 * @param authToken   the auth token
	 * @return the response entity
	 */
	@HystrixCommand(groupKey = "getWFXWOHystrix", commandKey = "getWFXWOHystrix", fallbackMethod = "getWFXWOHystrix", ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class, ResourceAccessException.class })
	public ResponseEntity<GetWorkOrderWFXResponse> getWFXWorkorder(String orderNumber, String authToken) {

		log.info("Entering into getWFXWorkorder() method");

		HttpHeaders headers = serviceUtil.httpHeaders(authToken.trim());
		HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);
		return woRestTemplate.exchange(getWorkOrderUrl + orderNumber, HttpMethod.GET, entity,
				GetWorkOrderWFXResponse.class);
	}

	/**
	 * Get the WO hystrix fallback.
	 * 
	 * @param orderNumber the order number
	 * @param authToken   the auth token
	 * @param e           the e
	 * @return the response entity
	 * @throws OrionMiddlewareServiceException the orion middleware service
	 *                                         exception
	 */
	@HystrixCommand(groupKey = "getWFXWOHystrix")
	public ResponseEntity<GetWorkOrderWFXResponse> getWFXWOHystrix(String orderNumber, String authToken, Throwable e)
			throws OrionMiddlewareServiceException {
		log.info("getWFXWOHystrix() Fallback{} " );
		throw new OrionMiddlewareServiceException(OrionErrorCode.GETWFXWO_CONNECTIVITY_ERROR, e);
	}

}
