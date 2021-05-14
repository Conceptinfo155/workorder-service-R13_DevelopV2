package com.comcast.orion.workorder.config;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.codehaus.groovy.runtime.IteratorClosureAdapter;
import org.junit.Test;

import com.comcast.orion.workorder.config.MDCHystrixContextCallable;

public class MDCHystrixContextCallableTest {

	/**
	 * Run the Object call() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/8/18 4:42 PM
	 */
	@Test
	public void testCall_1() {
	MDCHystrixContextCallable mdcHystrixContextCallable = new MDCHystrixContextCallable(new IteratorClosureAdapter(new Object()));
	Object response;
		try {
			response = mdcHystrixContextCallable.call();
			assertNull(response);
		} catch (Exception e) {
			
		}
	}
}