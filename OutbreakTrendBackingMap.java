package com.jackniu.trident;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jboss.netty.util.internal.ConcurrentHashMap;

import storm.trident.state.map.IBackingMap;


/*
 * 这才是最终的执行存储的类
 * */
public class OutbreakTrendBackingMap implements IBackingMap<Long>{

	private static final Logger LOG =Logger.getLogger(OutbreakTrendBackingMap.class);
	
	Map<String,Long> storage =
			new ConcurrentHashMap<String,Long>();

	@Override
	public List<Long> multiGet(List<List<Object>> keys) {
		List<Long> values = new ArrayList<Long>();
		for(List<Object> key:keys)
		{
			Long value = storage.get(key.get(0));
			if(value == null)
			{
				values.add(new Long(0));
			}else{
				values.add(value);
			}
		}
		return values;
	}

	// 这里的 keys是cityDiseaseHour的集合List<List<CityDiswaseHour>>  
	//  就是上一个分组之后的结果
	@Override
	public void multiPut(List<List<Object>> keys, List<Long> vals) {
		for(int i=0;i<keys.size();i++)
		{
			LOG.info("Persisting [ "+keys.get(i).get(0)+" ] ==> ["+vals.get(i)+" ]");
			
//			Long aaa = (Long) keys.get(i).get(0);   String 类型的
//			System.out.println("*****************"+aaa);
//			System.out.println(keys.get(i).get(0)+"   "+vals.get(i));
			
			
			storage.put((String) keys.get(i).get(0), vals.get(i));
		}
		
	}
	
}
