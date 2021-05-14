package com.comcast.orion.workorder.utils.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.comcast.orion.workorder.command.CreateUpdateOTTCommand;
import com.comcast.orion.workorder.domain.poi.Attribute;
import com.comcast.orion.workorder.domain.poi.Contact;
import com.comcast.orion.workorder.domain.poi.Customer;
import com.comcast.orion.workorder.domain.poi.POIRequest;
import com.comcast.orion.workorder.domain.poi.Site;

import services.web.trackem.InsertOrUpdatePointOfInterest;
import services.web.trackem.Operations;
import services.web.trackem.ResultBase;

@RunWith(MockitoJUnitRunner.class)
public class CustomerSiteMapperTest {

	@Test
	public void testSetterMethod() throws Exception {
		InsertOrUpdatePointOfInterest siteRequest = new InsertOrUpdatePointOfInterest();
		siteRequest.setUserName("j7szFmkRfnzrsvw");
		siteRequest.setPassword("lab2V0~h4J~9B27e*p3RwsB4Wf4G*n");
		BeanUtils.setProperty(siteRequest, "data1", "dynamic data1");
		assertEquals(siteRequest.getUserName(), "j7szFmkRfnzrsvw");
		assertEquals(siteRequest.getData1(), "dynamic data1");
	}

	@Test
	public void testSoap() throws Exception {
		CreateUpdateOTTCommand cmd = new CreateUpdateOTTCommand("j7szFmkRfnzrsvw", "lab2V0~h4J~9B27e*p3RwsB4Wf4G*n",
				"https://test3.officetrack.com/services/webservices.asmx?wsdl");
		InsertOrUpdatePointOfInterest request = new InsertOrUpdatePointOfInterest();
//		request.setUserName("j7szFmkRfnzrsvw");
//		request.setPassword("lab2V0~h4J~9B27e*p3RwsB4Wf4G*n");
		request.getType().add("POI");
		request.setOperation(Operations.AUTO_SELECT);
		request.setIsParent(true);
		request.setName("newname1");
		request.setCustomerNumber("12341241001");
		ResultBase res = cmd.insertOrUpdate(request,"default");
		res.getResultCodeAsInt();
		assertEquals(res.getResultCode().toString(), "OK");
	}

	@Test
	public void testMapCase() throws Exception {
		CustomerSiteMapper map = Mappers.getMapper(CustomerSiteMapper.class);
		Site a1 = mock(Site.class);
		Mockito.when(a1.getCity()).thenReturn("t1");
		Mockito.when(a1.getHouseNumber()).thenReturn("t2");
		Mockito.when(a1.getLatitude()).thenReturn("t3");

		InsertOrUpdatePointOfInterest res = map.mapSite(a1);
		assertNotNull(res);
		assertEquals(res.getHouseNum(), a1.getHouseNumber());

		Customer a2 = mock(Customer.class);
		Mockito.when(a2.getId()).thenReturn("c1");
		Mockito.when(a2.getName()).thenReturn("c2");
		InsertOrUpdatePointOfInterest res1 = map.mapCustomer(a2);
		assertNotNull(res1);
		assertEquals(res1.getCustomerNumber(), a2.getId());

		res = map.mergeSite(res, res1);
		assertNotNull(res);
		assertEquals(res.getHouseNum(), a1.getHouseNumber());
		assertEquals(res.getCustomerNumber(), a2.getId());

		Contact a3 = mock(Contact.class);
		Mockito.when(a3.getEmail()).thenReturn("e1");
		Mockito.when(a3.getFax()).thenReturn("e2");
		InsertOrUpdatePointOfInterest res2 = map.mapContact(a3);
		assertNotNull(res2);
		assertEquals(res2.getEmail(), a3.getEmail());

		POIRequest a4 = mock(POIRequest.class);
		Mockito.when(a4.getCategories()).thenReturn("f1");
		Mockito.when(a4.getCustomer()).thenReturn(a2);
		Mockito.when(a1.getLatitude()).thenReturn(null);
		Mockito.when(a1.getLongitude()).thenReturn(null);
		Mockito.when(a4.getSite()).thenReturn(a1);
		res = map.mapOther(res, a4);
		assertNotNull(res);
		assertNull(res.getX());
		assertNull(res.getY());

		Attribute i1 = mock(Attribute.class);
		Mockito.when(i1.getValue()).thenReturn("attribute1");
		List<Attribute> attr = new ArrayList<>();
		attr.add(i1);
		Mockito.when(a4.getAttributes()).thenReturn(attr);
		res = map.mapAttributes(res, a4, null);
		assertNotNull(res);
		assertNull(res.getData1());
	}
}
