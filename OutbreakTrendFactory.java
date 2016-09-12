package com.jackniu.trident;

import java.util.Map;

import backtype.storm.task.IMetricsContext;
import storm.trident.state.State;
import storm.trident.state.StateFactory;

public class OutbreakTrendFactory implements StateFactory{

	@Override
	public State makeState(Map conf, IMetricsContext metrics, int partitionIndex, int numPartitions) {
		
		return new OutbreakTrendState(new OutbreakTrendBackingMap());
	}

}
