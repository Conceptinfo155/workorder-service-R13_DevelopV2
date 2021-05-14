
package com.comcast.orion.workorder.config;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.comcast.xsp.security.helpers.TokenManager;

public class RequestTraceFilterTest {

	@Mock
	HttpServletRequest httpServletRequest;

	@Mock
	TokenManager tokenManager;

//	@Test
//	public void testDoFilter() {
//		
//		ServletRequest request = new HttpServletRequestWrapper(new ThreadLocalHttpServletRequest());
//		ServletResponse response = new ServletResponseWrapper(new HttpServletResponseWrapper(new ThreadLocalHttpServletResponse()));
//		FilterChain chain = new MockFilterChain();
//
//		try {
//			RequestTraceFilter fixture = mock(RequestTraceFilter.class);
//			fixture.doFilter(request, response, chain);
//			assertNotNull("FAILURE");
//		} catch (IOException | ServletException e) {
//			
//		}
//		
//	}

	@Test
	public void testSetRequestHeaderParams() throws Exception {
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		Mockito.when(httpServletRequest.getHeader("trackingId")).thenReturn("testtrackingID");
		Mockito.when(httpServletRequest.getRequestURI()).thenReturn("/workorder/v2/createworkorder");
		Mockito.when(httpServletRequest.getRequestURL())
				.thenReturn(new StringBuffer("http://localhost:9001/workorder/v2/createworkorder"));
		RequestTraceFilter fixture = mock(RequestTraceFilter.class);
		fixture.setRequestHeaderParams(httpServletRequest);
		assertNotNull("check", httpServletRequest);
	}

//	@Test(expected = Exception.class)
//	public void testDoFilter1() throws Exception {
//		RequestTraceFilter filter = new RequestTraceFilter();
//		ServletRequest request = new HttpServletRequestWrapper(new ThreadLocalHttpServletRequest());
//		ServletResponse response = new ServletResponseWrapper(
//				new HttpServletResponseWrapper(new ThreadLocalHttpServletResponse()));
//		FilterChain chain = new MockFilterChain();
//		// filter.doFilter(request, response, chain);
//		assertNotNull("check", request);
//	}

	@Test(expected = Exception.class)
	public void testSetRequestHeaderParams2() throws Exception {
		RequestTraceFilter filter = new RequestTraceFilter();
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		when(httpServletRequest.getHeader("Authorization")).thenReturn(null);
		filter.setRequestHeaderParams(httpServletRequest);
		assertNotNull("check", httpServletRequest);
	}
}
