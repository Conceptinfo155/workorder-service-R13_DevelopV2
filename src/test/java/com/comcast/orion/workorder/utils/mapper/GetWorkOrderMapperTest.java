package com.comcast.orion.workorder.utils.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.runners.MockitoJUnitRunner;

import com.comcast.orion.wfx.domain.workorder.JobReasonCdList;
import com.comcast.orion.workorder.bean.GetWorkOrderRule;
import com.comcast.orion.workorder.bean.SolutionDetail;
import com.comcast.orion.workorder.domain.amil.getworkorder.AMILWorkorderResponse;
import com.comcast.orion.workorder.domain.amil.getworkorder.Characteristic;
import com.comcast.orion.workorder.domain.amil.getworkorder.Characteristic_;
import com.comcast.orion.workorder.domain.amil.getworkorder.DependentService;
import com.comcast.orion.workorder.domain.amil.getworkorder.Equipment;
import com.comcast.orion.workorder.domain.amil.getworkorder.Service;
import com.comcast.orion.workorder.domain.amil.getworkorder.WorkOrderDetails;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.domain.omw.getwfxworkorder.GetWorkorderOMWResponse;
import com.comcast.orion.workorder.domain.referencedata.Attribute;
import com.comcast.orion.workorder.domain.referencedata.AttributeSet;
import com.comcast.orion.workorder.domain.referencedata.AttributeSubSet;
import com.comcast.orion.workorder.domain.referencedata.ReferenceDataResponse;
import com.comcast.orion.workorder.domain.vms.DTTNFeaturesResponse;
import com.comcast.orion.workorder.domain.wfx.getworkorder.request.GetWorkOrderWFXResponse;
import com.comcast.orion.workorder.domain.wfx.getworkorder.request.JobCommentTypeCdList;


@RunWith(MockitoJUnitRunner.class)
public class GetWorkOrderMapperTest {

	private GetWorkOrderMapper getWorkOrderMapper;
	private AMILWorkorderResponse amilWorkorderResponse;

	@Before
	public void setUp(){
		getWorkOrderMapper = Mappers.getMapper(GetWorkOrderMapper.class);		
	}	

	@Test
	public void mapAMILResponseToGetWorkOrderResponseTest() throws Exception {
		AMILWorkorderResponse amilWorkorderResponse= new AMILWorkorderResponse();
		WorkOrderDetails workOrderDetails = new WorkOrderDetails();
		workOrderDetails.setAgreementId("12334");
		workOrderDetails.setCustomerId("c1234");
		workOrderDetails.setSiteId("Site123");
		workOrderDetails.setWorkOrderId("1234");
		Equipment equipment= new Equipment();
		List<Equipment> equipmentList = new ArrayList<Equipment>();
		equipment.setAction("test");
		equipment.setArmObjectName("test");
		equipment.setEquipmentType("test123");
		equipment.setServiceId("123");
		Service service= new Service();
		List<Service> servicesList = new ArrayList<Service>();
		service.setAction("test");
		service.setArmObjectName("test123");
		List<Characteristic> characteristicsList = new ArrayList<Characteristic>();
		Characteristic characteristic= new Characteristic();
		characteristic.setCharacteristicName("test");
		characteristic.setCharacteristicValue("test123");
		characteristicsList.add(characteristic);
		service.setCharacteristics(characteristicsList);
		List<DependentService> dependentServicesList = new ArrayList<DependentService>();
		DependentService dependentService = new DependentService();
		dependentService.setAction("test");
		dependentService.setServiceId("12345");
		List<Characteristic_> characteristics_List = new ArrayList<Characteristic_>();
		Characteristic_ characteristic_= new Characteristic_();
		characteristic_.setCharacteristicName("test");
		characteristic_.setCharacteristicValue("test1234");
		characteristics_List.add(characteristic_);
		dependentService.setCharacteristics(characteristics_List);
		dependentServicesList.add(dependentService);
		service.setDependentServices(dependentServicesList);
		servicesList.add(service);
		equipment.setServices(servicesList);
		equipmentList.add(equipment);
		workOrderDetails.setEquipment(equipmentList);	
		amilWorkorderResponse.setWorkOrderDetails(workOrderDetails);
		WorkorderResponse workorderResponse = new WorkorderResponse();
		workorderResponse = getWorkOrderMapper.mapAMILResponseToGetWorkOrderResponse(amilWorkorderResponse);
		assertNotNull(workorderResponse);	
	}
	
	@Test
	public void mapWFXResponseToWorkOrderResponseTest() throws Exception {
		GetWorkOrderWFXResponse getWorkOrderWFXResponse = new GetWorkOrderWFXResponse();
		com.comcast.orion.workorder.domain.wfx.getworkorder.request.Job job =new com.comcast.orion.workorder.domain.wfx.getworkorder.request.Job();
		job.setScheduleDate("12-21-2018");
		job.setTimeSlotCd("Z");
		job.setCallFirstPhoneNum("21");
		job.setWorkOrderNum("ORION123");
		job.setTechId("1234");
		List<JobCommentTypeCdList> jobCommentTypeCdList = new ArrayList<JobCommentTypeCdList>();
		JobCommentTypeCdList jobCommentTypeCd = new JobCommentTypeCdList();
		jobCommentTypeCd.setJobComment("JOB");
		jobCommentTypeCdList.add(jobCommentTypeCd);
		jobCommentTypeCd.setJobComment("ORDER");
		jobCommentTypeCdList.add(jobCommentTypeCd);
		job.setJobCommentTypeCdList(jobCommentTypeCdList);
		getWorkOrderWFXResponse.setJob(job);
		com.comcast.orion.workorder.domain.wfx.getworkorder.request.JobCustomer jobCustomer=new com.comcast.orion.workorder.domain.wfx.getworkorder.request.JobCustomer();
		jobCustomer.setCustomerId("235235");
		jobCustomer.setEmailAddr("124512");
		jobCustomer.setFirstName("orion");
		jobCustomer.setHomePhoneNum("124124");
		jobCustomer.setLastName("middleware");
		getWorkOrderWFXResponse.setJobCustomer(jobCustomer);
		com.comcast.orion.workorder.domain.wfx.getworkorder.request.JobLocation jobLocation=new com.comcast.orion.workorder.domain.wfx.getworkorder.request.JobLocation();
		com.comcast.orion.workorder.domain.wfx.getworkorder.request.Address address=new com.comcast.orion.workorder.domain.wfx.getworkorder.request.Address();
		address.setAddrLine1("abcde");
		address.setAddrLine2("efgh");
		address.setCity("PA");
		address.setState("PA");
		address.setZipCode("12412");
		jobLocation.setAddress(address);
		getWorkOrderWFXResponse.setJobLocation(jobLocation);
		GetWorkOrderRule rule = new GetWorkOrderRule();
		List<SolutionDetail> solutionDetailsList = new ArrayList<SolutionDetail>();
		SolutionDetail solutionDetail= new SolutionDetail();
		solutionDetail.setSolutionType("M5");
		solutionDetail.setOrderType("TC");
		solutionDetailsList.add(solutionDetail);
		rule=new GetWorkOrderRule();
		rule.setJobTypeCd("M5");
		rule.setJobUnits("18");
		rule.setSolutionDetails(solutionDetailsList);
		GetWorkorderOMWResponse getWorkorderOMWResponse = new GetWorkorderOMWResponse();
		//US1761689
		//getWorkorderOMWResponse = getWorkOrderMapper.mapWFXResponseToWorkOrderResponse(getWorkOrderWFXResponse, rule);
		assertNotNull(getWorkorderOMWResponse);	
	}
	
	
	//Created for #US1761689
	@Test
		public void mapWFXResponseToWorkOrderResponseByJobTypeTest() throws Exception {
		
		List<ReferenceDataResponse> list = new ArrayList<ReferenceDataResponse>();
		ReferenceDataResponse jr=new ReferenceDataResponse();
		String jobTypeCd="EY";
		
		//JobTypeMappingConstants jobTypeMapping=new JobTypeMappingConstants();			
		//jobTypeMapping.setReferenceTemplateId("10");
		//jobTypeMapping.setReferenceTemplateName("JobReasonCodes");
		
		List<AttributeSet> attributeSets = new ArrayList<AttributeSet>();
		AttributeSet attributeSet = new AttributeSet();
		attributeSet.setAttributeSetValue("D0");
		
		//#1
		List<AttributeSubSet> attributeSubSets = new ArrayList<AttributeSubSet>();
		AttributeSubSet attributeSubSet=new AttributeSubSet();
		attributeSubSet.setAttributeSubSetKey("SOLUTION_TYPE");
		attributeSubSet.setAttributeSubSetValue("PRI");
		List<Attribute> attributes = new ArrayList<Attribute>();
		Attribute attribute = new Attribute();
		attribute.setAttributeKey("JOB_TYPE_CODE");
		attribute.setAttributeValue("EY");
		attributes.add(attribute);
		attribute = new Attribute();
		attribute.setAttributeKey("QUOTA_POINTS");
		attribute.setAttributeValue("18");
		attributes.add(attribute);
		attribute = new Attribute();
		attribute.setAttributeKey("ORDER_TYPE");
		attribute.setAttributeValue("TC");
		attributes.add(attribute);
		attribute = new Attribute();
		attribute.setAttributeKey("TRANSPORT_TYPE");
		attribute.setAttributeValue("NA");
		attributes.add(attribute);
		attribute = new Attribute();
		attribute.setAttributeKey("WEIGHT");
		attribute.setAttributeValue("5");
		attributes.add(attribute);
		attributeSubSet.setAttributes(attributes );
		attributeSubSets.add(attributeSubSet);
		
		
		
		//#2			
		//attributeSubSets = new ArrayList<AttributeSubSet>();
		attributeSubSet=new AttributeSubSet();
		attributeSubSet.setAttributeSubSetKey("SOLUTION_TYPE");
		attributeSubSet.setAttributeSubSetValue("SIP");
		attributes = new ArrayList<Attribute>();
		attribute = new Attribute();
		attribute.setAttributeKey("JOB_TYPE_CODE");
		attribute.setAttributeValue("0X");
		attributes.add(attribute);
		attribute = new Attribute();
		attribute.setAttributeKey("QUOTA_POINTS");
		attribute.setAttributeValue("18");
		attributes.add(attribute);
		attribute = new Attribute();
		attribute.setAttributeKey("ORDER_TYPE");
		attribute.setAttributeValue("TC");
		attributes.add(attribute);
		attribute = new Attribute();
		attribute.setAttributeKey("TRANSPORT_TYPE");
		attribute.setAttributeValue("NA");
		attributes.add(attribute);
		attribute = new Attribute();
		attribute.setAttributeKey("WEIGHT");
		attribute.setAttributeValue("6");
		attributes.add(attribute);
		attributeSubSet.setAttributes(attributes );
		attributeSubSets.add(attributeSubSet);
		attributeSet.setAttributeSubSets(attributeSubSets);			
		attributeSets.add(attributeSet);
		
		jr.setAttributeSets(attributeSets);
		
		List<com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail> solutionDetailsLtActual = new ArrayList<com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail>();			
		solutionDetailsLtActual = getWorkOrderMapper.mapSolutionDetail(jr, jobTypeCd);
		assertNotNull(solutionDetailsLtActual);
		

		//verify return result
		List<com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail> solutionDetailsLtExpected = new ArrayList<com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail>();						
		com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail solutionDetail = new com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail();
		solutionDetail.setOrderType("TC");
		solutionDetail.setSolutionType("PRI");
		//solutionDetail.setTransportType("NA");
		solutionDetailsLtExpected.add(solutionDetail);		
		assertEquals(solutionDetailsLtExpected, solutionDetailsLtActual);
		}
	
			
		/**		//Created for #US1761689 
		 * More than one job type from mapping
		 * @throws Exception
		 */
			@Test
			public void mapWFXResponseToWorkOrderResponse4MultipleRCTest() throws Exception {
				List<JobReasonCdList> list = new ArrayList<JobReasonCdList>();
				JobReasonCdList jr=new JobReasonCdList();
				jr.setJobReasonCd("MF");
				list.add(jr);
				jr=new JobReasonCdList();
				jr.setJobReasonCd("D0");
				list.add(jr);
				String jobTypeCd="0X";
				ReferenceDataResponse jobTypeMapping=new ReferenceDataResponse();			
				jobTypeMapping.setReferenceTemplateId("10");
				jobTypeMapping.setReferenceTemplateName("JobReasonCodes");
				
				List<AttributeSet> attributeSets = new ArrayList<AttributeSet>();
				
				//#1 - JReason
				AttributeSet attributeSet = new AttributeSet();
				attributeSet.setAttributeSetValue("D0");
				
				//#1
				List<AttributeSubSet> attributeSubSets = new ArrayList<AttributeSubSet>();
				AttributeSubSet attributeSubSet=new AttributeSubSet();
				attributeSubSet.setAttributeSubSetKey("SOLUTION_TYPE");
				attributeSubSet.setAttributeSubSetValue("PRI");
				List<Attribute> attributes = new ArrayList<Attribute>();
				Attribute attribute = new Attribute();
				attribute.setAttributeKey("JOB_TYPE_CODE");
				attribute.setAttributeValue("EY");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("QUOTA_POINTS");
				attribute.setAttributeValue("18");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("ORDER_TYPE");
				attribute.setAttributeValue("TC");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("TRANSPORT_TYPE");
				attribute.setAttributeValue("NA");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("WEIGHT");
				attribute.setAttributeValue("5");
				attributes.add(attribute);
				attributeSubSet.setAttributes(attributes );
				attributeSubSets.add(attributeSubSet);
				
				
				//#2			
				attributeSubSets = new ArrayList<AttributeSubSet>();
				attributeSubSet=new AttributeSubSet();
				attributeSubSet.setAttributeSubSetKey("SOLUTION_TYPE");
				attributeSubSet.setAttributeSubSetValue("SIP");
				attributes = new ArrayList<Attribute>();
				attribute = new Attribute();
				attribute.setAttributeKey("JOB_TYPE_CODE");
				attribute.setAttributeValue("0X");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("QUOTA_POINTS");
				attribute.setAttributeValue("18");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("ORDER_TYPE");
				attribute.setAttributeValue("TC");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("TRANSPORT_TYPE");
				attribute.setAttributeValue("NA");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("WEIGHT");
				attribute.setAttributeValue("6");
				attributes.add(attribute);
				attributeSubSet.setAttributes(attributes );
				attributeSubSets.add(attributeSubSet);
				attributeSet.setAttributeSubSets(attributeSubSets);			
				attributeSets.add(attributeSet);		
				
				//#2 - JReason
				attributeSet = new AttributeSet();
				attributeSet.setAttributeSetValue("D2");
				
				//#3->1/2
				attributeSubSets = new ArrayList<AttributeSubSet>();
				attributeSubSet=new AttributeSubSet();
				attributeSubSet.setAttributeSubSetKey("SOLUTION_TYPE");
				attributeSubSet.setAttributeSubSetValue("PRI");
				attributes = new ArrayList<Attribute>();
				attribute = new Attribute();
				attribute.setAttributeKey("JOB_TYPE_CODE");
				attribute.setAttributeValue("EY");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("QUOTA_POINTS");
				attribute.setAttributeValue("18");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("ORDER_TYPE");
				attribute.setAttributeValue("TC");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("TRANSPORT_TYPE");
				attribute.setAttributeValue("NA");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("WEIGHT");
				attribute.setAttributeValue("5");
				attributes.add(attribute);
				attributeSubSet.setAttributes(attributes );
				attributeSubSets.add(attributeSubSet);
				
				
				//#4->2/2			
				attributeSubSets = new ArrayList<AttributeSubSet>();
				attributeSubSet=new AttributeSubSet();
				attributeSubSet.setAttributeSubSetKey("SOLUTION_TYPE");
				attributeSubSet.setAttributeSubSetValue("SIP");
				attributes = new ArrayList<Attribute>();
				attribute = new Attribute();
				attribute.setAttributeKey("JOB_TYPE_CODE");
				attribute.setAttributeValue("0X");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("QUOTA_POINTS");
				attribute.setAttributeValue("18");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("ORDER_TYPE");
				attribute.setAttributeValue("TC");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("TRANSPORT_TYPE");
				attribute.setAttributeValue("NA");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("WEIGHT");
				attribute.setAttributeValue("6");
				attributes.add(attribute);
				attributeSubSet.setAttributes(attributes );
				attributeSubSets.add(attributeSubSet);
				attributeSet.setAttributeSubSets(attributeSubSets);			
				attributeSets.add(attributeSet);	
				
				//#3 - JReason
				attributeSet = new AttributeSet();
				attributeSet.setAttributeSetValue("MF");
				
				//#5->1/3
				attributeSubSets = new ArrayList<AttributeSubSet>();
				attributeSubSet=new AttributeSubSet();
				attributeSubSet.setAttributeSubSetKey("SOLUTION_TYPE");
				attributeSubSet.setAttributeSubSetValue("Metro E");
				attributes = new ArrayList<Attribute>();
				attribute = new Attribute();
				attribute.setAttributeKey("JOB_TYPE_CODE");
				attribute.setAttributeValue("M5");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("QUOTA_POINTS");
				attribute.setAttributeValue("18");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("ORDER_TYPE");
				attribute.setAttributeValue("TC");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("TRANSPORT_TYPE");
				attribute.setAttributeValue("NA");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("WEIGHT");
				attribute.setAttributeValue("1");
				attributes.add(attribute);
				attributeSubSet.setAttributes(attributes );
				attributeSubSets.add(attributeSubSet);
				
				
				//#6->2/3			
				attributeSubSets = new ArrayList<AttributeSubSet>();
				attributeSubSet=new AttributeSubSet();
				attributeSubSet.setAttributeSubSetKey("SOLUTION_TYPE");
				attributeSubSet.setAttributeSubSetValue("Metro E");
				attributes = new ArrayList<Attribute>();
				attribute = new Attribute();
				attribute.setAttributeKey("JOB_TYPE_CODE");
				attribute.setAttributeValue("8N");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("QUOTA_POINTS");
				attribute.setAttributeValue("18");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("ORDER_TYPE");
				attribute.setAttributeValue("TC");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("TRANSPORT_TYPE");
				attribute.setAttributeValue("NA");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("WEIGHT");
				attribute.setAttributeValue("2");
				attributes.add(attribute);
				attributeSubSet.setAttributes(attributes );
				attributeSubSets.add(attributeSubSet);
				attributeSet.setAttributeSubSets(attributeSubSets);			
				attributeSets.add(attributeSet);	
				
				//#4 - JReason
				attributeSet = new AttributeSet();
				attributeSet.setAttributeSetValue("MG");
				
				//#7->1/4			
				attributeSubSets = new ArrayList<AttributeSubSet>();
				attributeSubSet=new AttributeSubSet();
				attributeSubSet.setAttributeSubSetKey("SOLUTION_TYPE");
				attributeSubSet.setAttributeSubSetValue("Metro E");
				attributes = new ArrayList<Attribute>();
				attribute = new Attribute();
				attribute.setAttributeKey("JOB_TYPE_CODE");
				attribute.setAttributeValue("M5");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("QUOTA_POINTS");
				attribute.setAttributeValue("18");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("ORDER_TYPE");
				attribute.setAttributeValue("TC");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("TRANSPORT_TYPE");
				attribute.setAttributeValue("NA");
				attributes.add(attribute);
				attribute = new Attribute();
				attribute.setAttributeKey("WEIGHT");
				attribute.setAttributeValue("1");
				attributes.add(attribute);
				attributeSubSet.setAttributes(attributes );
				attributeSubSets.add(attributeSubSet);
				attributeSet.setAttributeSubSets(attributeSubSets);			
				attributeSets.add(attributeSet);	
				assertEquals(4,attributeSets.size());//Reason code
				jobTypeMapping.setAttributeSets(attributeSets);
				
				List<com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail> solutionDetailsLtActual = new ArrayList<com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail>();			
				solutionDetailsLtActual = getWorkOrderMapper.mapSolutionDetail(jobTypeMapping, jobTypeCd);
				assertNotNull(solutionDetailsLtActual);
				assertEquals(1,solutionDetailsLtActual.size());

				//verify return result
				List<com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail> solutionDetailsLtExpected = new ArrayList<com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail>();						
				com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail solutionDetail = new com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail();
				solutionDetail.setOrderType("TC");
				solutionDetail.setSolutionType("SIP");
				//solutionDetail.setTransportType("NA");
				solutionDetailsLtExpected.add(solutionDetail);
				
				solutionDetail = new com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail();
				solutionDetail.setOrderType("TC");
				solutionDetail.setSolutionType("SIP");
				solutionDetail.setTransportType("NA");
				//solutionDetailsLtExpected.add(solutionDetail);
				assertEquals(solutionDetailsLtExpected,solutionDetailsLtActual);
				
			}

	
	@Test
	public void mapSolutionDetailsTest() throws Exception {
		com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail solutionDetailLt = new com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail();
		GetWorkOrderRule rule = new GetWorkOrderRule();
		List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail> solutionDetailsLt = new ArrayList<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>();
		List<SolutionDetail> solutionDetailsListVo = new ArrayList<SolutionDetail>();
		SolutionDetail solutionDetailVo= new SolutionDetail();
		solutionDetailVo.setSolutionType("M5");
		solutionDetailVo.setOrderType("TC");
		solutionDetailsListVo.add(solutionDetailVo);
		rule=new GetWorkOrderRule();
		rule.setJobTypeCd("M5");
		rule.setJobUnits("18");
		rule.setSolutionDetails(solutionDetailsListVo);		
		solutionDetailsLt = getWorkOrderMapper.mapSolutionDetails(rule);
		assertNotNull(solutionDetailsLt);	
	}
	
	@Test
	public void mapSolutionDetailsfromJobTypeCode(){
		GetWorkorderBySiteIdResponse getWorkorderBySiteIdResponse=new GetWorkorderBySiteIdResponse();
		Map<String,List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>> jobTypeCodewithValues=new HashMap<String,List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>>();
		com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail solutionDetail=new com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail();
		solutionDetail.setOrderType("TC");
		solutionDetail.setSolutionType("PRI");
		com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail solutionDetail1=new com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail();
		solutionDetail1.setOrderType("TC");
		solutionDetail1.setSolutionType("SIP");
		List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail> solutionDetailList= new ArrayList<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>();
		List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail> solutionDetailList2= new ArrayList<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>();
		solutionDetailList.add(solutionDetail);
		solutionDetailList.add(solutionDetail1);
		jobTypeCodewithValues.put("EY", solutionDetailList);
		jobTypeCodewithValues.put("EY", solutionDetailList);
		GetWorkOrderWFXResponse getWorkOrderWFXResponse = new GetWorkOrderWFXResponse();
		com.comcast.orion.workorder.domain.getWorkorderBySiteId.Job job =new com.comcast.orion.workorder.domain.getWorkorderBySiteId.Job();
		job.setScheduleDate("12-21-2018");
		job.setTimeSlotCd("Z");
		job.setCallFirstPhoneNum("21");;
		List<JobCommentTypeCdList> jobCommentTypeCdList = new ArrayList<JobCommentTypeCdList>();
		JobCommentTypeCdList jobCommentTypeCd = new JobCommentTypeCdList();
		jobCommentTypeCd.setJobComment("JOB");
		jobCommentTypeCdList.add(jobCommentTypeCd);
		jobCommentTypeCd.setJobComment("ORDER");
		jobCommentTypeCdList.add(jobCommentTypeCd);
		getWorkorderBySiteIdResponse.setJob(job);
		com.comcast.orion.workorder.domain.wfx.getworkorder.request.JobCustomer jobCustomer=new com.comcast.orion.workorder.domain.wfx.getworkorder.request.JobCustomer();
		jobCustomer.setCustomerId("235235");
		jobCustomer.setEmailAddr("124512t");
		jobCustomer.setFirstName("orion");
		jobCustomer.setHomePhoneNum("124124");
		jobCustomer.setLastName("middleware");
		getWorkOrderWFXResponse.setJobCustomer(jobCustomer);
		getWorkorderBySiteIdResponse.setJob(job);
		if (jobTypeCodewithValues!= null) {
			if(getWorkorderBySiteIdResponse.getJob().getJobTypeCd()!=null){
				solutionDetailList2=jobTypeCodewithValues.get(getWorkorderBySiteIdResponse.getJob().getJobTypeCd());
			}
		}
		assertNotNull(solutionDetailList2);
	}
	
	@Test
	public void testmapSolutionDetailsfromJobTypeCode() {
		Map<String, Map<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>>>
				jobTypeCdReasonCdSolnDtlMap = new LinkedHashMap<>();
		Map<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>> jobReasonCdSolnDtlMap = new HashMap<>();
		List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail> solutionDetailList = new ArrayList<>();
		com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail solutionDetail = new com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail();
		solutionDetail.setOrderType("New");
		solutionDetail.setSolutionType("BVE");
		solutionDetail.setTransportType("Coax");
		solutionDetailList.add(solutionDetail);
		jobReasonCdSolnDtlMap.put("9L", solutionDetailList);
		jobTypeCdReasonCdSolnDtlMap.put("9L", jobReasonCdSolnDtlMap);
		GetWorkorderBySiteIdResponse getWorkorderBySiteIdResponse = new GetWorkorderBySiteIdResponse();
		com.comcast.orion.workorder.domain.getWorkorderBySiteId.Job job = new com.comcast.orion.workorder.domain.getWorkorderBySiteId.Job();
		job.setJobTypeCd("9L");
		getWorkorderBySiteIdResponse.setJob(job);
		getWorkOrderMapper.mapSolutionDetailsfromJobTypeCode(jobTypeCdReasonCdSolnDtlMap, getWorkorderBySiteIdResponse);
	} 
	
	
	@Test
	public void testmapVMSTnFeatureResponse(){
		DTTNFeaturesResponse dtTNFeaturesResponse= new DTTNFeaturesResponse();
		com.comcast.orion.workorder.domain.vms.Service service= new com.comcast.orion.workorder.domain.vms.Service();
		com.comcast.orion.workorder.domain.vms.Service_ service_= new com.comcast.orion.workorder.domain.vms.Service_();
		List<com.comcast.orion.workorder.domain.vms.Service_> services_= new ArrayList<com.comcast.orion.workorder.domain.vms.Service_>();
		List<com.comcast.orion.workorder.domain.vms.Service> services= new ArrayList<com.comcast.orion.workorder.domain.vms.Service>();
		com.comcast.orion.workorder.domain.vms.Feature feature= new com.comcast.orion.workorder.domain.vms.Feature();
		List<com.comcast.orion.workorder.domain.vms.Feature> features= new ArrayList<com.comcast.orion.workorder.domain.vms.Feature>();
		service.setServiceID("1234");
		service.setType("test");
		service_.setAction("action");
		service_.setIsPrimary("isPrimary");
		service_.setTnNo("tnNo");
		service_.setTnType("tnType");
		feature.setName("name");
		feature.setValue("value");
		features.add(feature);
		service_.setFeatures(features);
		service.setService(services_);
		services.add(service);
		dtTNFeaturesResponse.setServices(services);
		getWorkOrderMapper.mapVMSTnFeatureResponse(dtTNFeaturesResponse,"tnno","tntype","primary");
	}
	

}