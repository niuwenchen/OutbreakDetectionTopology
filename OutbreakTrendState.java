package com.jackniu.trident;

import storm.trident.state.map.IBackingMap;
import storm.trident.state.map.NonTransactionalMap;

public class OutbreakTrendState extends NonTransactionalMap<Long>{

	protected OutbreakTrendState(OutbreakTrendBackingMap backing) {
		super(backing);
		
	}
	

}
