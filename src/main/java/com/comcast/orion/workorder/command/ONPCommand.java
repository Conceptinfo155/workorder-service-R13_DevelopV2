package com.comcast.orion.workorder.command;

import com.comcast.orion.workorder.utils.WorkOrderConstants;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import services.web.trackem.ResultBase;

@Component
public class ONPCommand {

    /** The log. */
    private final Logger log = LoggerFactory.getLogger(ONPCommand.class);

    /** The onp rest template. */
    @Autowired
    private RestTemplate onpRestTemplate;

    @Value("${onp.endpoint}")
    private String endpoint;

    @Value("${onp.path}")
    private String path;

    @Value("${onp.insertWOEventName}")
    private String insertWOEventName;

    @Value("${onp.source}")
    private String source;

    @HystrixCommand(groupKey = "insertWOEventHystrix", commandKey = "insertWOEventHystrix", fallbackMethod = "insertWOEventHystrixFallback", ignoreExceptions = {
            HttpClientErrorException.class, HttpServerErrorException.class, ResourceAccessException.class })
    public String insertWOEvent(String payload)
            throws OrionMiddlewareServiceException, HttpClientErrorException {
        log.info("ONPCommand::insertWOEvent::Enters");
        String downstreamResponse = null;
        MDC.put("downstreamName","ONP");
        MDC.put("downstreamUrl", endpoint + path);
        HttpHeaders header = new HttpHeaders();
        header.set(WorkOrderConstants.SOURCE.getValue(), source);
        header.set("trackingId", MDC.get("trackingId")+"_onp");
        header.set(WorkOrderConstants.EVENT_NAME_HEADER_KEY.getValue(), insertWOEventName);
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(payload, header);
        ResponseEntity<String> responseEntity = onpRestTemplate.postForEntity(endpoint + path, entity, String.class);
        downstreamResponse = responseEntity.getBody();
        log.info("ONPCommand::insertWOEvent::Enters");
        return downstreamResponse;
    }

    @HystrixCommand(groupKey = "insertWOEventHystrix")
    public String insertWOEventHystrixFallback(String request, Throwable e)
            throws OrionMiddlewareServiceException {
        throw new OrionMiddlewareServiceException(OrionErrorCode.ONP_CONNECTIVITY_ERROR);
    }

}
