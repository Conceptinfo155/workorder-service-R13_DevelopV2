package com.comcast.orion.workorder.utils.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.runners.MockitoJUnitRunner;

import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.Job;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.JobCommentTypeCdList;
import com.comcast.orion.workorder.domain.getfutureworkorder.WorkOrderDetail;
import com.comcast.orion.workorder.domain.getworkorder.Characteristic;
import com.comcast.orion.workorder.domain.getworkorder.Characteristic_;
import com.comcast.orion.workorder.domain.getworkorder.DependentService;
import com.comcast.orion.workorder.domain.getworkorder.Equipment;
import com.comcast.orion.workorder.domain.getworkorder.Service;
import com.comcast.orion.workorder.domain.getworkorder.WorkOrderDetails;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;

@RunWith(MockitoJUnitRunner.class)
public class FutureWorkOrderMapperTest {

	private GetFutureWorkOrderMapper futureWorkOrderMapper;
	private WorkOrderDetail workOrderDetails = new WorkOrderDetail();
	private GetWorkorderBySiteIdResponse futureWorkOrderWFXResponse = new GetWorkorderBySiteIdResponse();
	private WorkorderResponse futureWorkOrderOdoResponse = new WorkorderResponse();
	
	@Before
	public void setUp(){
		futureWorkOrderMapper = Mappers.getMapper(GetFutureWorkOrderMapper.class);		
	}
	
	@Test
	public void MapFutureWorkOrderTest() {
		WorkOrderDetail response = new WorkOrderDetail();
		Job job = new Job();
		job.setJobNum("ABH125669");
		job.setJobUnits("Nh221221");
		job.setScheduleDate("2012-01-03");
		List<JobCommentTypeCdList> jobCommentTypeCdList = new ArrayList<JobCommentTypeCdList>();
		JobCommentTypeCdList j = new JobCommentTypeCdList();
		j.setJobComment("JOB");
		j.setJobCommentTypeCd("ORDER");
		jobCommentTypeCdList.add(j);
		job.setJobCommentTypeCdList(jobCommentTypeCdList);
		job.setBuId("1233324");
		job.setWorkOrderNum("4454554545");
		job.setTimeSlotDesc("hsjghhjsgh");		
		WorkOrderDetails workOrderDetailss = new WorkOrderDetails();
		workOrderDetailss.setWorkOrderId("WO2002");
		workOrderDetailss.setSiteId("Site_1221");
		workOrderDetailss.setCustomerId("C77");
		List<Equipment> equipment = new ArrayList<Equipment>();
		Equipment e = new Equipment();
		e.setAction("OPEN");
		e.setServiceId("SITE1");
		e.setArmObjectName("RR");
		e.setEquipmentType("122235");
		List<Service> services = new ArrayList<Service>();
		Service s = new Service();
		s.setAction("Set");
		s.setServiceId("Site_154");
		s.setArmObjectName("125458563655");
		s.setServiceType("Service");
		s.setName("HOBBY");
		List<Characteristic> characteristics = new ArrayList<Characteristic>();
		Characteristic c = new Characteristic();
		c.setCharacteristicName("String1225");
		c.setCharacteristicValue("1256955");
		characteristics.add(c);
		s.setCharacteristics(characteristics);
		List<DependentService> dependentServices = new ArrayList<DependentService>();
		DependentService d = new DependentService();
		List<Characteristic_> characteristic = new ArrayList<Characteristic_>();
		Characteristic_ cc = new Characteristic_();
		cc.setCharacteristicName("ONE");
		cc.setCharacteristicValue("TWO");
		characteristic.add(cc);
		d.setCharacteristics(characteristic );
		dependentServices.add(d);
		s.setDependentServices(dependentServices );
		services.add(s);
		e.setServices(services);
		equipment.add(e);
		workOrderDetailss.setEquipment(equipment);		
		futureWorkOrderOdoResponse.setWorkOrderDetails(workOrderDetailss);
		futureWorkOrderWFXResponse.setJob(job);
		response = futureWorkOrderMapper.mapWorkOrderResponseToFutureWorkOrderResponse(futureWorkOrderWFXResponse, futureWorkOrderOdoResponse);
		assertNotNull(response);	
	}
}
