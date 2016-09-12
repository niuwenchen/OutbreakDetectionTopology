package com.jackniu.trident;

import java.io.Serializable;

public class DiagnosisEvent implements Serializable{
	public double lat;
	public double lng;
	public long time;
	public String diagnosisCode;
	
	public DiagnosisEvent(double lat,double lng,long time,String diagnosisCode)
	{
		this.lat=lat;
		this.lng=lng;
		this.time=time;
		this.diagnosisCode=diagnosisCode;
	}

	@Override
	public String toString() {
		return "DiagnosisEvent [lat=" + lat + ", lng=" + lng + ", time=" + time + ", diagnosisCode=" + diagnosisCode
				+ "]";
	}
	

}
