package com.comcast.orion.workorder.command;

import com.comcast.orion.workorder.domain.getorderdetails.CustomerAccountResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
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
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.*;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class AccountCommand {

    /** The log. */
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /** The accountRestTemplate. */
    @Autowired
    private RestTemplate accountRestTemplate;

    /**
     * ServiceUtil
     */
    @Autowired
    private ServiceUtil serviceUtil;

    /**
     * siteEndpoint
     */
    @Value("${omw.account.customer.endpoint}")
    private String accountCustomerEndpoint;

    @Value("${omw.account.customer.source}")
    private String accountCustomerSource;


    /**
     * @param customerId
     * @return
     */
    @HystrixCommand(groupKey = "accountHystrix", commandKey = "accountHystrix", fallbackMethod = "accountHystrixFallback", ignoreExceptions = {
            HttpClientErrorException.class, HttpServerErrorException.class, UnknownHttpStatusCodeException.class, ResourceAccessException.class })
    public CustomerAccountResponse getCustomerDetails(String customerId) throws OrionMiddlewareServiceException{
        log.info("AccountCommand::getCustomerDetails::enters");
        HttpHeaders headers = serviceUtil.httpHeader("customer");
        MDC.put("downstream", "account");
        MDC.put("sourceName", "Orion");
        MDC.put("downstreamUrl", accountCustomerEndpoint);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(accountCustomerEndpoint);
        builder.path(customerId);
        builder.queryParam("source",accountCustomerSource);
        HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);
        ResponseEntity<CustomerAccountResponse> customerAccountResponseResponseEntity = accountRestTemplate.exchange(builder.build().toUri(), HttpMethod.GET, entity,
                CustomerAccountResponse.class);
        log.info("AccountCommand::getCustomerDetails::exits");
        return customerAccountResponseResponseEntity.getBody();

    }

    /**
     * @param customerId
     * @param e
     * @return
     * @throws OrionMiddlewareServiceException
     */
    @HystrixCommand(groupKey = "accountHystrix")
    public CustomerAccountResponse accountHystrixFallback(String customerId,Throwable e) throws OrionMiddlewareServiceException {
        throw new OrionMiddlewareServiceException(OrionErrorCode.ACCOUNT_SERVICE_CONNECTIVITY_ERROR, e);
    }

}
