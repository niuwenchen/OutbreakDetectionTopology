package com.jackniu.trident;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import storm.trident.spout.ITridentSpout.BatchCoordinator;

public class DefaultCoordinator implements BatchCoordinator<Long>,Serializable{

	private static final Logger LOG =
			LoggerFactory.getLogger(DefaultCoordinator.class);
	
	@Override
	public Long initializeTransaction(long txid, Long prevMetadata, Long currMetadata) {
		LOG.info("Initializing Transaction ["+txid+"]");
		
		return null;
	}

	@Override
	public void success(long txid) {
		LOG.info("Successful Transaction ["+ txid +"]");
		
	}

	@Override
	public boolean isReady(long txid) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	

}
