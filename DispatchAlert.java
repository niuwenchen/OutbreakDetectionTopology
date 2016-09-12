package com.jackniu.trident;

import java.util.ArrayList;
import java.util.List;

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
//		List<String> list = new ArrayList<String>();
//		list=(List<String>) tuple.getValue(0);
//		
//		for(String str:list)
//		{
//			System.out.println(str);
//		}
		
		// 感觉有点不对，这里的应该是很多个值
		// 这个是分组后的计算结果，应该不会有问题 就是理解不了。
		LOG.error("ALERT  RECEIVED [ "+ alert+"]");
		LOG.error("Dispatch  the national guard !!!");
		System.exit(0);
		
	}

}
