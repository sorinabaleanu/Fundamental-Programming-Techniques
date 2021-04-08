package PT_Baleanu_Sorina_Assignment2.Pt_Baleanu_Sorina_Assignment2;

public class Task implements Comparable<Task> {

	private int id;
	private int arrivalTime;
	private int serviceTime;

	public Task(int id, int arrivalTime, int serviceTime) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;

	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getFinishTime() {
		return this.arrivalTime + this.serviceTime;
	}

	public String toString() {
		return "(" + id + " " + arrivalTime + " " + serviceTime + ")";
	}

	public int compareTo(Task t) {
		// TODO Auto-generated method stub

		return this.arrivalTime - t.getArrivalTime();

	}

}
