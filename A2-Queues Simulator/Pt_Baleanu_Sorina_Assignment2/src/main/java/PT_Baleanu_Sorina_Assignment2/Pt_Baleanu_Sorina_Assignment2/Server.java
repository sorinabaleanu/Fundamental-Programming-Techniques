package PT_Baleanu_Sorina_Assignment2.Pt_Baleanu_Sorina_Assignment2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Server implements Runnable {

	private BlockingQueue<Task> tasks;
	private int waitingPeriod;
	private int clientsNumber;
	private int id;
	private boolean isRunning;
	private int totalWaitingTime;

	public Server(int id) {
		this.id = id;
		this.clientsNumber = 0;
		this.tasks = new LinkedBlockingQueue<Task>();
		this.waitingPeriod = 0;
		this.isRunning = false;
	}

	public int getTotalWaitingTime() {
		return totalWaitingTime;
	}

	public void setTotalWaitingTime(int totalWaitingTime) {
		this.totalWaitingTime = totalWaitingTime;
	}

	public BlockingQueue<Task> getTasks() {
		return tasks;
	}

	public void setTasks(BlockingQueue<Task> tasks) {
		this.tasks = tasks;
	}

	public int getWaitingPeriod() {

		return waitingPeriod;
	}

	public void setWaitingPeriod(int waitingPeriod) {
		this.waitingPeriod = waitingPeriod;
	}

	public int getClientsNumber() {
		return clientsNumber;
	}

	public void setClientsNumber(int clientsNumber) {
		this.clientsNumber = clientsNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addTask(Task newTask) {

		tasks.add(newTask);
		waitingPeriod += newTask.getServiceTime();
		isRunning = true;
		clientsNumber++;
		totalWaitingTime += newTask.getServiceTime();
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public double getAverageTime() {
		return (double) totalWaitingTime / clientsNumber;
	}

	public void run() {
		// TODO Auto-generated method stub
		while (isRunning) {
			Task t = this.tasks.peek();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.waitingPeriod--;
			t.setServiceTime(t.getServiceTime() - 1);
			if (t.getServiceTime() == 0) {
				this.tasks.poll();
				if (this.tasks.isEmpty()) {
					this.isRunning = false;
					return;
				}

			}
		}
	}

	public String toString() {
		String result = "";
		result += "Queue " + id + ":";
		if (isRunning == false) {
			result += " closed";
		} else {
			for (Task t : tasks) {
				result += " " + t.toString();
			}
		}

		return result;

	}

}
