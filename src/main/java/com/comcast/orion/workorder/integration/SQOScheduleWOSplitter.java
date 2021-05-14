package com.comcast.orion.workorder.integration;

import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWO;
import com.comcast.orion.workorder.utils.WorkOrderConstants;
import org.springframework.integration.annotation.Splitter;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SQOScheduleWOSplitter {

    @Splitter(inputChannel = "sqoScheduleWOSplitter", outputChannel = "sqoScheduleWORouter")
    public List<Message> splitMessage(@Payload SQOScheduleWO sqoScheduleWO) {
        List<Message> messageList = new ArrayList<>();
        messageList.add(MessageBuilder.withPayload(sqoScheduleWO)
                .setHeader(WorkOrderConstants.INVOKE_SERVICE.getValue(), WorkOrderConstants.SITE.getValue())
                .build());
        messageList.add(MessageBuilder.withPayload(sqoScheduleWO)
                .setHeader(WorkOrderConstants.INVOKE_SERVICE.getValue(), WorkOrderConstants.ACCOUNT.getValue())
                .build());
        messageList.add(MessageBuilder.withPayload(sqoScheduleWO)
                .setHeader(WorkOrderConstants.INVOKE_SERVICE.getValue(), WorkOrderConstants.DATA.getValue())
                .build());
        messageList.add(MessageBuilder.withPayload(sqoScheduleWO)
                .setHeader(WorkOrderConstants.INVOKE_SERVICE.getValue(), WorkOrderConstants.INBOUND_REQUEST.getValue())
                .build());
        return messageList;
    }

}
