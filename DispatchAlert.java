package com.jackniu.trident;

import org.slf4j.*;


import storm.trident.operation.BaseFunction;
import storm.trident.operation.TridentCollector;
import storm.trident.tuple.TridentTuple;

public class DispatchAlert extends BaseFunction{
	
	private static final Logger LOG =
			LoggerFactory.getLogger(DispatchAlert.class);
	@Override
	public void execute(TridentTuple tuple, TridentCollector collector) {
		String  alert=(String) tuple.getValue(0);
		LOG.error("ALERT  RECEIVED [ "+ alert+"]");
		LOG.error("Dispatch  the national guard !!!");
		System.exit(0);
		
	}

}
