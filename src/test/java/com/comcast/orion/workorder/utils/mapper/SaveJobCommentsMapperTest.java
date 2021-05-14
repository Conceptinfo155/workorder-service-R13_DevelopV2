package com.comcast.orion.workorder.utils.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.runners.MockitoJUnitRunner;

import com.comcast.orion.workorder.domain.createwo.Job;
import com.comcast.orion.workorder.domain.createwo.JobCustomer;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderRequest;
import com.comcast.orion.workorder.domain.saveNotes.SaveNoteRequest;
import com.comcast.orion.workorder.domain.saveNotes.SaveRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelApmtRequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWORequest;

@RunWith(MockitoJUnitRunner.class)
public class SaveJobCommentsMapperTest {

	private SaveJobCommentsMapper saveJobCommentsMapper;
	private SaveNoteRequest saveNoteRequest;
	private SaveRequest saveRequest;
	private CreateWorkorderRequest createWorkorderRequest;

	@Before
	public void setUp() {
		saveJobCommentsMapper = Mappers.getMapper(SaveJobCommentsMapper.class);
		saveRequest = new SaveRequest();
		saveNoteRequest = new SaveNoteRequest();
		createWorkorderRequest = new CreateWorkorderRequest();
		Job job = new Job();
		job.setJobComment("Technician Notes Test");
		JobCustomer jobCustomer = new JobCustomer();
		jobCustomer.setCustomerId("2459034");
		jobCustomer.setSiteId("4587987967");
		createWorkorderRequest.setJob(job);
		createWorkorderRequest.setJobCustomer(jobCustomer);
	}

	@Test
	public void testGetSaveNotesRequest() throws Exception {

		SaveRequest saveRq = saveJobCommentsMapper.getSaveNotesRequest(createWorkorderRequest, "ORION-7458734658",
				"Technician Notes", "ORION");
		assertNotNull("check", saveRq);
	}

	@Test
	public void testGetSaveNotesRequest1() throws Exception {
		createWorkorderRequest.setJob(null);
		SaveRequest saveRq = saveJobCommentsMapper.getSaveNotesRequest(createWorkorderRequest, "ORION-7458734658",
				"Technician Notes", "ORION");
		assertNotNull("check", saveRq);
	}

	@Test
	public void testGetSaveNotesRequest2() throws Exception {
		createWorkorderRequest.setJobCustomer(null);
		SaveRequest saveRq = saveJobCommentsMapper.getSaveNotesRequest(createWorkorderRequest, "", "Technician Notes",
				"ORION");
		assertNotNull("check", saveRq);
	}

}