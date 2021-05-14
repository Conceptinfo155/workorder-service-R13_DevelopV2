package com.comcast.orion.workorder.integration;

import com.comcast.orion.workorder.utils.WorkOrderConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SQOScheduleWORouter {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String SITE_CHANNEL = "sqoScheduleWoSiteChannel";
    private static final String CUSTOMER_CHANNEL = "sqoScheduleWoCustomerChannel";
    private static final String ORDER_CHANNEL = "sqoScheduleWoOrderChannel";
    private static final String AGGREGATOR_CHANNEL = "sqoScheduleWoAggregator";

    @Router(inputChannel = "sqoScheduleWORouter")
    public List<String> route(@Header("INVOKE_SERVICE") String service){
        List<String> channels = new ArrayList<>();
        if (WorkOrderConstants.SITE.getValue().equalsIgnoreCase(service)) {
            channels.add(SITE_CHANNEL);
        }
        if (WorkOrderConstants.ACCOUNT.getValue().equalsIgnoreCase(service)) {
            channels.add(CUSTOMER_CHANNEL);
        }
        if (WorkOrderConstants.DATA.getValue().equalsIgnoreCase(service)) {
            channels.add(ORDER_CHANNEL);
        }
        if (WorkOrderConstants.INBOUND_REQUEST.getValue().equalsIgnoreCase(service)) {
            channels.add(AGGREGATOR_CHANNEL);
        }
        return channels;
    }

}
