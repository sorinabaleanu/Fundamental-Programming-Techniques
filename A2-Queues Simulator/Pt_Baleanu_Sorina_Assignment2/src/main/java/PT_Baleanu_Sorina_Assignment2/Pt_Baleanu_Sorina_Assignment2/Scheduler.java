package PT_Baleanu_Sorina_Assignment2.Pt_Baleanu_Sorina_Assignment2;

import java.util.ArrayList;

public class Scheduler {

	public ArrayList<Server> servers;
	private int maxNoServers;

	private Strategy strategy;

	public Scheduler(int maxNoServers) {
		this.maxNoServers = maxNoServers;

		servers = new ArrayList<Server>(maxNoServers);
		for (int i = 1; i <= maxNoServers; i++) {
			servers.add(new Server(i));

		}

		this.strategy = new ConcreteStrategyTime();

	}

	public enum SelectionPolicy {
		SHORTEST_QUEUE, SHORTEST_TIME
	}

	public ArrayList<Server> getServers() {
		return servers;
	}

	public void setServers(ArrayList<Server> servers) {
		this.servers = servers;
	}

	public int getMaxNoServers() {
		return maxNoServers;
	}

	public void setMaxNoServers(int maxNoServers) {
		this.maxNoServers = maxNoServers;
	}

	public void dispatchTask(Task t) {
		strategy.addTask(servers, t);

	}

	public boolean serversStillRunning() {
		for (Server s : servers) {
			if (s.isRunning())
				return true;
		}
		return false;
	}

	public String averageTime() {
		String result = "";
		double average = 0;
		for (Server s : servers) {

			result += "Queue " + s.getId() + " average time: " + s.getAverageTime() + "\n";
			average += s.getAverageTime();
		}
		average /= servers.size();
		result += "Average time for all queues is: " + average;
		return result;
	}

	public String toString() {
		String result = "";
		for (Server s : servers) {
			result += s.toString() + "\n";
		}

		return result;
	}

}
