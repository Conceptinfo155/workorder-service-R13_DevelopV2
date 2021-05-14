package com.comcast.orion.workorder.config;


import static org.junit.Assert.*;

import static org.junit.Assert.assertNotNull;


import java.util.concurrent.Callable;

import org.codehaus.groovy.runtime.IteratorClosureAdapter;
import org.junit.Test;


import com.comcast.orion.workorder.config.MDCHystrixConcurrencyStrategy;
import com.comcast.orion.workorder.config.MDCHystrixContextCallable;

public class MDCHystrixConcurrencyStrategyTest  {

	@Test
	public void testWrapCallableCallableOfT()  {

		MDCHystrixConcurrencyStrategy mdcHystrixConcurrencyStrategy = new MDCHystrixConcurrencyStrategy();
		Callable<Object> callable = new MDCHystrixContextCallable(new IteratorClosureAdapter(new Object()));
		Callable<Object> response = mdcHystrixConcurrencyStrategy.wrapCallable(callable);
		assertNotNull(response);
	}


}

