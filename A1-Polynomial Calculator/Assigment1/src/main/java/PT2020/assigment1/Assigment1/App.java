package PT2020.assigment1.Assigment1;


public class App  {


	public static void main(String[] args) {
	
	Model model = new Model();
	View view = new View(model);
	Controller controller = new Controller(model, view);
	view.setVisible(true);
		
	
	
	
		
		
	}
	
	

}
