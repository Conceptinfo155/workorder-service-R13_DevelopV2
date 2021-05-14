package com.comcast.orion.workorder.command;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.domain.saveNotes.SaveRequest;
import com.comcast.orion.workorder.domain.saveNotes.SaveResponse;
import com.comcast.orion.workorder.domain.scheduleDomain.BookApmtRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.BookAppointmentResponseDetails;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@RunWith(MockitoJUnitRunner.class)
public class SaveNotesCommandTest {

	@InjectMocks
	private SaveNotesCommand saveNotesCommand;

	@Mock
	RestTemplate saveNotesRestTemplate;

	@Mock
	ServiceUtil serviceUtil;

	private ResponseEntity<Object> responseEntity;

	public void testSsaveJobComments() throws Exception {
		responseEntity = new ResponseEntity<>(new SaveResponse(), HttpStatus.OK);

		SaveRequest saveNoteReq = new SaveRequest();
		Mockito.when(serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
		Mockito.when(saveNotesRestTemplate.postForEntity(anyString(), eq(HttpMethod.POST), anyObject(),
				eq(SaveResponse.class))).thenReturn(responseEntity);
		saveNotesCommand.saveJobComments(saveNoteReq);
		assertNotNull("verify", saveNoteReq);
	}

	@Test(expected = OrionMiddlewareServiceException.class)
	public void testSsaveJobCommentsFallBack() throws OrionMiddlewareServiceException {
		Exception e = new Exception();
		SaveRequest saveNoteReq = new SaveRequest();
		try {
			saveNotesCommand.saveNotesHystrixFallback(saveNoteReq, e);
		} catch (OrionMiddlewareServiceException e1) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.NOTES_SERVICE_CONNECTIVITY_ERROR);
		}
	}

}
