package PT_Baleanu_Sorina_Assignment2.Pt_Baleanu_Sorina_Assignment2;

import java.util.ArrayList;

public class ConcreteStrategyTime implements Strategy {

	public void addTask(ArrayList<Server> servers, Task t) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		boolean startThread = false;

		for (Server s : servers) {
			if (s.getWaitingPeriod() < min) {
				min = s.getWaitingPeriod();
			}
		}
		for (Server s : servers) {
			if (s.getWaitingPeriod() == min) {
				if (s.isRunning() == false)
					startThread = true;
				s.addTask(t);
				if (startThread == true) {
					Thread th = new Thread(s);
					th.start();
				}

				return;
			}
		}

	}
}