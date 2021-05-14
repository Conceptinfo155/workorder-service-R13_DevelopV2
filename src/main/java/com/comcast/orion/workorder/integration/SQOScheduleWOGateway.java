package com.comcast.orion.workorder.integration;

import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWO;
import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWoResponse;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface SQOScheduleWOGateway {

    @Gateway(requestChannel = "sqoScheduleWOSplitter", replyChannel = "sqoScheduleWOResponse")
    SQOScheduleWoResponse scheduleWO(SQOScheduleWO sqoScheduleWO) throws OrionMiddlewareServiceException;

}
