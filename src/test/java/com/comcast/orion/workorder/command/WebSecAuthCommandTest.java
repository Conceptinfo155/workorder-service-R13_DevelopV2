package com.comcast.orion.workorder.command;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@RunWith(MockitoJUnitRunner.class)
public class WebSecAuthCommandTest {
	
	@InjectMocks
	WebSecAuthCommand authCommand;
	@Mock
	RestTemplate nWoRestTemplate;

	@Test
	public void test() {
		ReflectionTestUtils.setField(authCommand,
				  "oauth", "https://websec-int.cable.comcast.com/OAuthPlayground/token-endpoint-proxy.jsp");
		
		ResponseEntity<String> x = new ResponseEntity<>("{\"access_token\":\"eyJhbGciOiJSUzI\",\"token_type\":\"Bearer\",\"expires_in\":7199}", HttpStatus.OK);

		Mockito.when(nWoRestTemplate.postForEntity(any(), any(), eq(String.class))).thenReturn(x);
		ResponseEntity<String> token = authCommand.getAuthToken();
		assertNotNull(x);
		}
	 

		@Test(expected = OrionMiddlewareServiceException.class)
		public void testFallback() throws OrionMiddlewareServiceException {
			Exception e = new Exception();
			authCommand.websecAuthHystrixFallback(e);
		}

}
