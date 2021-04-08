package Assignment5.Assignment5;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toMap;

public class Task {

	List<MonitoredData> data=new ArrayList<MonitoredData>();
	
	public Task()
	{
		 String file = "Activities.txt";
	        

	        try (Stream<String> stream = Files.lines(Paths.get(file))) {  

	        	data= stream.map(line -> line.split("\t\t"))
	             .map(o -> new MonitoredData(o[0], o[1], o[2])).collect(Collectors.toList());    	 

	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }	
	}
	
	 	

	public void task1() {
		
		try {
		      FileWriter myWriter = new FileWriter("task1.txt");
		      for(MonitoredData m:data)
		      {
		    	  myWriter.write("Activity: "+m.getActivity()+" started at "+m.getStartTime()+" and ended at "+m.getEndTime()+"\n");
		      }
		      	
		      myWriter.close();
		      System.out.println("Task1 done!");
		    } catch (IOException e) {
		      System.out.println("An error occurred during Task 1.");
		      e.printStackTrace();
		    }
	}

	public void task2()
	{
			long result=data.stream().map(d->d.getDistinctDay()).distinct().count();
			try {
			      FileWriter myWriter = new FileWriter("task2.txt");
			      
				  myWriter.write("There are "+result+" distinct days.\n");	
			      myWriter.close();
			      System.out.println("Task2 done!");
			    } catch (IOException e) {
			      System.out.println("An error occurred during Task 2.");
			      e.printStackTrace();
			    }	
	}
	
	
	public void task3()
	{
		
		Map<String, Integer> result = data.stream()
		        .collect(Collectors.groupingBy(MonitoredData::getActivity,Collectors.summingInt(c->1)));
		
		try {
		      FileWriter myWriter = new FileWriter("task3.txt");
		      
			for(Map.Entry <String,Integer> entry:result.entrySet())
				{
					myWriter.write("Activity : "+
				entry.getKey()+ " apears "+entry.getValue()+" times\n");
				}
		      myWriter.close();
		      System.out.println("Task3 done!");
		    } catch (IOException e) {
		      System.out.println("An error occurred during Task 3.");
		      e.printStackTrace();
		    }
	}	
	
	
	public void task4()
	{
		 Map<Integer, Map<String, Integer>> result=data.stream()
				 .collect(Collectors.groupingBy(MonitoredData::getDistinctDay,Collectors.groupingBy(MonitoredData::getActivity,Collectors.summingInt(c->1))));
		
		
		try {
		      FileWriter myWriter = new FileWriter("task4.txt");
		      for(Map.Entry <Integer,Map<String,Integer>> entry:result.entrySet())
				{
		    	  	Map<String,Integer> otherEntry=entry.getValue();
		    	  for(Map.Entry<String,Integer> entry2:otherEntry.entrySet())
		    	  {
		    		  myWriter.write("In the day of the month: "+entry.getKey()+" the activity "+entry2.getKey()+" was done "+entry2.getValue()+" times.\n");
		    	  }
					
				
				}
		      myWriter.close();
		      System.out.println("Task4 done!");
		    } catch (IOException e) {
		      System.out.println("An error occurred during Task 4.");
		      e.printStackTrace();
		    }
	}
	
	public void task5()
	{
		
		Map<String,Duration> result =data.stream()
			    .collect(toMap(MonitoredData::getActivity, MonitoredData::getDuration, Duration::plus));
		try {
		      FileWriter myWriter = new FileWriter("task5.txt");
		      for(Map.Entry <String,Duration> entry:result.entrySet())
				{
					myWriter.write("Activity : "+
				entry.getKey()+ " takes "+entry.getValue().toString()+" \n");
				}
		      myWriter.close();
		      System.out.println("Task5 done!");
		    } catch (IOException e) {
		      System.out.println("An error occurred during Task 5.");
		      e.printStackTrace();
		    }
		
	}
	
	public void task6()
	{
		List<String> result =data.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity,Collectors.averagingDouble(d->d.getDuration().toMinutes())))
					.entrySet().stream().filter(d->d.getValue()<5.55).map(a->a.getKey()).collect(Collectors.toList());
		
		try {
		      FileWriter myWriter = new FileWriter("task6.txt");
		      for(String  entry:result)
				{
					myWriter.write("Activity : "+
				entry+ " lasts less than 5 minutes 90% of the time \n");
				}
		      myWriter.close();
		      System.out.println("Task6 done!");
		    } catch (IOException e) {
		      System.out.println("An error occurred during Task 6s	.");
		      e.printStackTrace();
		    }
	}
	
	
	
	
	 
}
