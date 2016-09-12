package com.jackniu.trident;

import org.apache.log4j.Logger;

import storm.trident.operation.BaseFilter;
import storm.trident.tuple.TridentTuple;

public class DiseaseFilter extends BaseFilter{

	private static final Logger LOG = 
			Logger.getLogger(DiseaseFilter.class);
	
	@Override
	public boolean isKeep(TridentTuple tuple) {
		DiagnosisEvent diagnose =(DiagnosisEvent) tuple.getValue(0);
		Integer code = Integer.parseInt(diagnose.diagnosisCode);
		
		// 如果是true，则继续执行
		// 如果是false，则停止执行
		if(code.intValue() <=322)
		{
			LOG.debug("Emitting disease ["+diagnose.diagnosisCode+"]");
//			System.out.println("*********8"+diagnose);
			return true;
		}else
		{
			LOG.debug("Filtering disease ["+diagnose.diagnosisCode+"]");
			return false;
		}
	
	}
	
}
