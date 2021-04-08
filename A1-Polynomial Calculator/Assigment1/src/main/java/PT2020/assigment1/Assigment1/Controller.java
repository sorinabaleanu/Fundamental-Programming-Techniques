package PT2020.assigment1.Assigment1;
import java.awt.event.*;
public class Controller {
	
	 private Model calcModel;
	 private View calcView;

	 Controller(Model model, View view) {
		 calcModel= model;
		 calcView = view;
		 view.addMultiplyListener(new MultiplyListener());
		 view.addClearListener(new ClearListener());
		 view.addAddListener(new AddListener());
		 view.addSubstractListener(new SubstractListener());
		 view.addDerivateListener(new DerivateListener());
		 view.addIntegrateListener(new IntegrateListener());
	 }

	
	 
	 class AddListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
		 String input1 = "";
		 String input2 = "";
		 try {
		 input1 = calcView.getUserInput();
		 input2 = calcView.getUserInput2();
		 Polynomial p1=new Polynomial(input1);
		 Polynomial p2=new Polynomial(input2);
		
		 calcModel.add(p1,p2);
		
		 calcView.setTotal(calcModel.getResult());

		 } catch (PatternException ex) {
			 calcView.showError("Formatul termenilor trebuie sa fie coeficient x^putere.Toti termenii trebuie sa fie introdusi explicit.");
		 }
		 }
		 }
	 
	 class SubstractListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
		 String input1 = "";
		 String input2 = "";
		 try {
		 input1 = calcView.getUserInput();
		 input2 = calcView.getUserInput2();
		 Polynomial p1=new Polynomial(input1);
		 Polynomial p2=new Polynomial(input2);
		 
		 calcModel.sub(p1,p2);

		 calcView.setTotal(calcModel.getResult());

		 } catch (PatternException ex) {
			 calcView.showError("Formatul termenilor trebuie sa fie coeficient x^putere.Toti termenii trebuie sa fie introdusi explicit.");
		 }
		 }
		 }
	 
	 class MultiplyListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
		 String input1 = "";
		 String input2 = "";
		 try {
		 input1 =calcView.getUserInput();
		 input2 = calcView.getUserInput2();
		 Polynomial p1=new Polynomial(input1);
		 Polynomial p2=new Polynomial(input2);
		
		 calcModel.mul(p1,p2);
		 
		 calcView.setTotal(calcModel.getResult());

		 } catch (PatternException ex) {
			calcView.showError("Formatul termenilor trebuie sa fie coeficient x^putere.Toti termenii trebuie sa fie introdusi explicit.");
		 }
		 }
		 }
	 
	 class 	DerivateListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
		 String input = "";
		
		 try {
		 input = calcView.getUserInput();
		 Polynomial p1=new Polynomial(input);
		 calcModel.derv(p1);
		
		 calcView.setTotal(calcModel.getResult());

		 } catch (PatternException ex) {
			 calcView.showError("Formatul termenilor trebuie sa fie coeficient x^putere.Toti termenii trebuie sa fie introdusi explicit." );
		 }
		 }
		 }
	 
	 class 	IntegrateListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
		 String input = "";
		
		 try {
		 input = calcView.getUserInput();
		 Polynomial p1=new Polynomial(input);
		 calcModel.integ(p1);
		
		 calcView.setTotal(calcModel.getResult2());

		 } catch (PatternException ex) {
			 calcView.showError("Formatul termenilor trebuie sa fie coeficient x^putere.Toti termenii trebuie sa fie introdusi explicit.");
		 }
		 }
		 }
	 
	 
	 class ClearListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	calcModel.reset();
	 calcView.reset();
	 }
	 }
	}

