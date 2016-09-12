package com.jackniu.trident;

import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;

import storm.trident.spout.ITridentSpout;

public class DiagnoseEventSpout implements ITridentSpout<Long>{
	SpoutOutputCollector collector;
	BatchCoordinator<Long> coordinator = new DefaultCoordinator();
	
	Emitter<Long> emitter = new DiagnosisEventEmitter();
	
	@Override
	public storm.trident.spout.ITridentSpout.BatchCoordinator<Long> getCoordinator(String txStateId, Map conf,
			TopologyContext context) {
		
		return coordinator;
	}

	@Override
	public storm.trident.spout.ITridentSpout.Emitter<Long> getEmitter(String txStateId, Map conf,
			TopologyContext context) {
		
		return emitter;
	}

	@Override
	public Map getComponentConfiguration() {
		
		return null;
	}

	@Override
	public Fields getOutputFields() {
		
		return new Fields("event");
	}
	

}
