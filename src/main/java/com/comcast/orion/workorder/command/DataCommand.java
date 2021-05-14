package com.comcast.orion.workorder.command;

import com.comcast.orion.data.vo.CustomerVO;
import com.comcast.orion.workorder.utils.DiscoveryClientUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@Component
public class DataCommand {

    /** The log. */
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate dataRestTemplate;

    @Value("${data.endpoint}")
    private String dataEndPoint;

    @Value("${data.serviceName}")
    private String serviceName;

    @Value("${data.serviceDiscovery}")
    private boolean serviceDiscovery;

    @Value("${data.getOrderSummary}")
    private String getOrderSummary;

    @Autowired
    private DiscoveryClientUtil discoveryClientUtil;

    @HystrixCommand(groupKey = "dataHystrix", commandKey = "dataHystrix", fallbackMethod = "dataHystrixFallBack", ignoreExceptions = {
            HttpServerErrorException.class, HttpClientErrorException.class, ResourceAccessException.class })
    public CustomerVO getOrderSummary(String customerId, String productOfferInstanceId) throws OrionMiddlewareServiceException {
        log.info("Inside the dataCommand#getOrderSummary method --- enters");
        HttpHeaders header = new HttpHeaders();
        CustomerVO customerVO = null;
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        header.set("trackingId", MDC.get("trackingId"));
        String endPoint = null;
        if(serviceDiscovery) {
            endPoint = discoveryClientUtil.getUriFromEureka(serviceName);
        } else {
            endPoint = dataEndPoint;
        }
        String url = endPoint+getOrderSummary;
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        builder.queryParam("customerId", customerId);
        builder.queryParam("productOfferInstanceId", productOfferInstanceId);
        MDC.put("downstreamName", serviceName);
        MDC.put("downstreamUrl", builder.build().toString());
        ResponseEntity<CustomerVO> customerVOResponseEntity = dataRestTemplate.exchange(builder.build().toString(), HttpMethod.GET,
                new HttpEntity<>(header), CustomerVO.class);
        log.info("Inside the dataCommand#getOrderSummary method --- exits");
        return customerVOResponseEntity.getBody();
    }

    @HystrixCommand(groupKey = "dataHystrix")
    public CustomerVO dataHystrixFallBack(String customerId, String productOfferInstanceId, Throwable e) throws OrionMiddlewareServiceException {
        log.error("data hystrix error",e);
        throw new OrionMiddlewareServiceException(OrionErrorCode.DATA_SERVICE_CONNECTIVITY_ERROR);
    }

}
