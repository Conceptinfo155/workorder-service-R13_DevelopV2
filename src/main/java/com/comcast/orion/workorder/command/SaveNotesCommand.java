package com.comcast.orion.workorder.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.comcast.orion.workorder.domain.saveNotes.SaveRequest;
import com.comcast.orion.workorder.domain.saveNotes.SaveResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * The Class SaveNotesCommand.
 */
@Component
public class SaveNotesCommand {

	/** The log. */
	private final Logger LOG = LoggerFactory.getLogger(SaveNotesCommand.class);

	/** The saveNotesRestTemplate. */
	@Autowired
	private RestTemplate saveNotesRestTemplate;

	/**
	 * ServiceUtil
	 */
	@Autowired
	private ServiceUtil serviceUtil;

	/**
	 * notesServiceEndPoint
	 */
	@Value("${saveNotes.endpoint}")
	private String saveNotesEndPoint;

	@Value("${saveNotes.source}")
	private String source;
	/**
	 * @param SaveRequest
	 * @return
	 */
	@HystrixCommand(groupKey = "saveNotesHystrix", commandKey = "saveNotesHystrix", fallbackMethod = "saveNotesHystrixFallback", ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class, UnknownHttpStatusCodeException.class,
			RestClientException.class })
	public void saveJobComments(SaveRequest saveNoteReq) {
		LOG.info("Inside the SaveNotesCommand##saveJobComments method.");
		MDC.put("downstream", "notes-service");
		HttpHeaders headers = serviceUtil.httpHeader("saveNotes");
		headers.set("sourceSystemId", source);
		HttpEntity<SaveRequest> entity = new HttpEntity<>(saveNoteReq, headers);
		saveNotesRestTemplate.postForEntity(saveNotesEndPoint, entity, SaveResponse.class);
	}

	/**
	 * @param SaveRequest
	 * @param e
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	@HystrixCommand(groupKey = "saveNotesHystrix")
	public void saveNotesHystrixFallback(SaveRequest saveNoteReq, Throwable e)
			throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.NOTES_SERVICE_CONNECTIVITY_ERROR, e);
	}

}
