package Assignment5.Assignment5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MonitoredData {

	private String startTime;
	private String endTime;
	private String activity;

	public MonitoredData(String startTime, String endTime, String activity) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.activity = activity;

	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	
	public int getDistinctDay()
	{	
		try {
			Date date=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(startTime);
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
			cal.setTime(date);
			
			int day = cal.get(Calendar.DAY_OF_MONTH);
			return day;	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return 0;
	}
	
	public Duration getDuration()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime start= LocalDateTime.parse(startTime,formatter);
		LocalDateTime end= LocalDateTime.parse(endTime,formatter);
		Duration d= Duration.between(start, end);
		return d;
		
	}
	
	
}
