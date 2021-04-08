package PT_Baleanu_Sorina_Assignment2.Pt_Baleanu_Sorina_Assignment2;

import java.io.File;
import java.util.*;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.*;
import java.util.Scanner;

public class SimulationManager implements Runnable {

	public int timeLimit;
	public int maxArrivalTime;
	public int minArrivalTime;
	public int maxServiceTime;
	public int minServiceTime;
	public int numberOfServers;
	public int numberOfClients;
	private Scheduler scheduler;
	private CopyOnWriteArrayList<Task> generatedTasks;
	private StringBuilder output;
	private String outputPath;

	public SimulationManager(String inputPath, String outputPath) {
		try {
			File inputFile = new File(inputPath);
			Scanner myReader = new Scanner(inputFile);
			this.numberOfClients = Integer.parseInt(myReader.nextLine());
			this.numberOfServers = Integer.parseInt(myReader.nextLine());
			this.timeLimit = Integer.parseInt(myReader.nextLine());
			String[] arrivalTime = myReader.nextLine().split(",");
			this.minArrivalTime = Integer.parseInt(arrivalTime[0]);
			this.maxArrivalTime = Integer.parseInt(arrivalTime[1]);
			String[] serviceTime = myReader.nextLine().split(",");
			this.minServiceTime = Integer.parseInt(serviceTime[0]);
			this.maxServiceTime = Integer.parseInt(serviceTime[1]);

			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		output = new StringBuilder("START: \n");
		scheduler = new Scheduler(numberOfServers);
		generateNRandomTasks();
		this.outputPath = outputPath;

	}

	public void generateNRandomTasks() {
		generatedTasks = new CopyOnWriteArrayList<Task>();

		Random random = new Random();

		for (int i = 1; i <= numberOfClients; i++) {
			int arrivalTime, serviceTime;
			arrivalTime = random.nextInt(maxArrivalTime - minArrivalTime) + minArrivalTime;
			serviceTime = random.nextInt(maxServiceTime - minServiceTime) + minServiceTime;
			generatedTasks.add(new Task(i, arrivalTime, serviceTime));

		}

		Collections.sort((List<Task>) generatedTasks);

	}

	public void writeOutputInFile() {
		try {
			FileWriter writer = new FileWriter(outputPath, true);
			writer.write(output.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		int currentTime = 0;

		while (currentTime < timeLimit && (!generatedTasks.isEmpty() || scheduler.serversStillRunning())) {
			
			for (Task t : generatedTasks) {
				if (t.getArrivalTime() == currentTime) {

					scheduler.dispatchTask(t);
					generatedTasks.remove(t);

				}
			}

			output.append("Time " + currentTime + "\n");
			output.append("Waiting Clients: " + generatedTasks.toString() + "\n");
			output.append(scheduler.toString() + "\n");

			try {

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			currentTime++;

		}
		output.append(scheduler.averageTime());

		writeOutputInFile();
	}

}
