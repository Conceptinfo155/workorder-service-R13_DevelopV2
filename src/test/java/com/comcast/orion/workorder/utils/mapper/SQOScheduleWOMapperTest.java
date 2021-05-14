package com.comcast.orion.workorder.utils.mapper;

import com.comcast.orion.data.vo.CustomerVO;
import com.comcast.orion.workorder.domain.getorderdetails.CustomerAccountResponse;
import com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest;
import com.comcast.orion.workorder.domain.sitev2.*;
import com.comcast.orion.workorder.domain.sqoschedulewo.CreateWorkOrder;
import com.comcast.orion.workorder.domain.sqoschedulewo.Job;
import com.comcast.orion.workorder.domain.sqoschedulewo.JobCustomer;
import com.comcast.orion.workorder.domain.sqoschedulewo.ScheduleWorkorderRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.FileNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class SQOScheduleWOMapperTest {

    SQOScheduleWOMapper sqoScheduleWOMapper = Mappers.getMapper(SQOScheduleWOMapper.class);

    WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest;

    @Before
    public void setUp() throws FileNotFoundException {
        ReflectionTestUtils.setField(sqoScheduleWOMapper, "orderManagementSystem", "test");
        ReflectionTestUtils.setField(sqoScheduleWOMapper, "jobNumPrefix", "test");
        ReflectionTestUtils.setField(sqoScheduleWOMapper, "defaultJobClassCode", "C");
        ReflectionTestUtils.setField(sqoScheduleWOMapper, "defaultDispatcherStatusCode", "O");
    }


    @Test
    public void mapOTUpdateWorkOrderRequest() {
        ScheduleWorkorderRequest scheduleWorkorderRequest = new ScheduleWorkorderRequest();
        scheduleWorkorderRequest.setWorkOrderNumber("12344");
        CreateWorkOrder createWorkOrder = new CreateWorkOrder();
        Job job = new Job();
        job.setJobComment("test");
        job.setScheduleDate("121211");
        job.setOrderComment("test");
        job.setCallFirstPhoneNum("1211211");
        job.setTroubleCallIndicator(Job.TroubleCallIndicator.R);
        job.setTimeSlotCd("121211");
        job.setJobReasonCode("test");
        createWorkOrder.setJob(job);
        JobCustomer jobCustomer = new JobCustomer();
        jobCustomer.setCustomerId("test");
        jobCustomer.setSiteId("test");
        createWorkOrder.setJobCustomer(jobCustomer);
        scheduleWorkorderRequest.setCreateWorkOrder(createWorkOrder);
        SiteResponse siteResponse = new SiteResponse();
        SiteAddress siteAddress = new SiteAddress();
        siteAddress.setAddressLine1("1234");
        siteAddress.setAddressLine2("5677");
        siteAddress.setCity("test");
        siteAddress.setState("test");
        siteAddress.setCountry("1234");
        siteResponse.setSiteAddress(siteAddress);
        LocationIdentifierInfo locationIdentifierInfo = new LocationIdentifierInfo();
        locationIdentifierInfo.setELocId("1234");
        siteResponse.setLocationIdentifierInfo(locationIdentifierInfo);
        BillingDetailsInfo billingDetailsInfo = new BillingDetailsInfo();
        CsgDetails csgDetails = new CsgDetails();
        csgDetails.setTechnicianArea("test");
        billingDetailsInfo.setCsgDetails(csgDetails);
        siteResponse.setBillingDetailsInfo(billingDetailsInfo);
        CustomerAccountResponse customerAccountResponse = new CustomerAccountResponse();
        CustomerVO customerVO = new CustomerVO();
        WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest = sqoScheduleWOMapper.mapSqoScheduleWORequest(scheduleWorkorderRequest,siteResponse,customerAccountResponse,customerVO);
        System.out.println("test");
    }



}
