package PT_Baleanu_Sorina_Assignment2.Pt_Baleanu_Sorina_Assignment2;



/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		SimulationManager s = new SimulationManager(args[0], args[1]);
		Thread t = new Thread(s);
		t.start();

	}
}
