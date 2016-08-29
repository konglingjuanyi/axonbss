package com.ai.bss.api.base;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable
public class TimePeriod {
	private Timestamp beginTime;
	private Timestamp endTime;

	public Timestamp getCurrenttTime(){
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		return currentTimestamp;
	}
	
	public Timestamp getForeverTime() throws Exception{
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd Hh:mm:ss");  
		Date date = dateFormat.parse("9999-12-31 00:00:00");  
		calendar.setTime(date);  
		return new java.sql.Timestamp(calendar.getTime().getTime());
	}
	
	
	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	
	public void setBeginTime(Timestamp beginTime) {
		this.beginTime=beginTime;
	}

	
	public Timestamp getEndTime() {
		return this.endTime;
	}

	
	public void setEndTime(Timestamp endTime) {
		this.endTime=endTime;
	}
	
}
