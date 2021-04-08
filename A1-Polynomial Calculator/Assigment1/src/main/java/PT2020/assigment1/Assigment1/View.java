package PT2020.assigment1.Assigment1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class View extends JFrame {
 
 private JTextField input1 = new JTextField(40);
 private JTextField input2 = new JTextField(40);
 private JTextField result = new JTextField(40);
 
 private JButton addBtn= new JButton("Add");
 private JButton substractBtn = new JButton("Substract");
 private JButton multiplyBtn = new JButton("Multiply");
 private JButton deriveBtn= new JButton("Derive");
 private JButton integrateBtn = new JButton("Integrate");
 
 private JButton clearBtn = new JButton("Clear");
 

 private Model calcModel;

 
 View(Model model) {


calcModel= model;
 model.setResult("0x^0");

 result.setText(calcModel.getResult());
 result.setEditable(false);




 JPanel panel = new JPanel();
 panel.setLayout(new FlowLayout());
 panel.add(new JLabel("Polynom1:"));
 panel.add(input1);
 panel.add(new JLabel("Polynom2:"));
 panel.add(input2);
 panel.add(addBtn);
 panel.add(multiplyBtn);
 panel.add(substractBtn);
 panel.add(deriveBtn);
 panel.add(integrateBtn);
 panel.add(new JLabel("Total"));
 panel.add(result);
 panel.add(clearBtn);

 
 	panel.setBackground(Color.WHITE);
 	
	 this.setContentPane(panel);
	 this.setSize(450, 250);
	 this.setTitle("Polynomial Calculator");
	 this.setBackground(Color.WHITE);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }

 
 
 void reset() {
 result.setText(" ");
 } 

 String getUserInput() {
 return input1.getText();
 }
 String getUserInput2() {
 return input2.getText();
 }

 void setTotal(String newResult) {
 result.setText(newResult);
 }

 void showError(String errMessage) {
 
JOptionPane.showMessageDialog(this, errMessage);
 }

 void addMultiplyListener(ActionListener mal) {
 multiplyBtn.addActionListener(mal);
 }
 
 void addDerivateListener(ActionListener dal) {
	 deriveBtn.addActionListener(dal);
 }
 
 void addIntegrateListener(ActionListener ial) {
	 integrateBtn.addActionListener(ial);
 }

 void addSubstractListener(ActionListener sal) {
 substractBtn.addActionListener(sal);
 }

 void addClearListener(ActionListener cal) {
 clearBtn.addActionListener(cal);
 }
 
 void addAddListener(ActionListener ala)
 {
	 addBtn.addActionListener(ala);
 }
}
