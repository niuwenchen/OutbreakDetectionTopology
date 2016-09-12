package com.jackniu.trident;

import java.util.ArrayList;
import java.util.List;

import storm.trident.operation.BaseFunction;
import storm.trident.operation.TridentCollector;
import storm.trident.tuple.TridentTuple;

public class OutbreakDetector extends BaseFunction{
	public static final int THRESTHOLD=10000;
	
	@Override
	public void execute(TridentTuple tuple, TridentCollector collector) {
		
		String key =(String) tuple.getValue(0);
		Long count = (Long) tuple.getValue(1);
		
		
		
		if(count> THRESTHOLD)
		{
			List<Object>  values = new ArrayList<>();
			values.add("Outbreak detected  for["+ key +"]");
			System.out.println("********************** Outbreak detected  for["+ key +"]");
			collector.emit(values);
		}
			
	}

}
