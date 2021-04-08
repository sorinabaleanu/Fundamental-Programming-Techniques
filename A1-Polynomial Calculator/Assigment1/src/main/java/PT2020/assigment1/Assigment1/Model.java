package PT2020.assigment1.Assigment1;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
public class Model {

	
	private Polynomial polynomTotal;

 Model() {
 reset();
 }

 public void reset() {
 try {
	 polynomTotal= new Polynomial("0x^0");
} catch (PatternException e) {
	e.printStackTrace();
}
 }

 public void add(Polynomial p1,Polynomial p2)
 {    List<Monomial> elements=new CopyOnWriteArrayList();
 	
 	
 		for (Monomial m1:p1.getElements())
 			for(Monomial m2:p2.getElements())
 			{
 				if(m1.getGrad()==m2.getGrad())
 				{
 					elements.add(m1.add(m2));
 					p1.getElements().remove(m1);
 					p2.getElements().remove(m2);
 				}
 			} 
 		
 		for (Monomial m:p1.getElements())
 			elements.add(m);
 		for (Monomial m:p2.getElements())
 			elements.add(m);
 			
 		polynomTotal.setElements(elements);		
 }
 

 
 
 public void sub(Polynomial p1,Polynomial p2)
 {    List<Monomial> elements=new CopyOnWriteArrayList();
 	
 	
 		for (Monomial m1:p1.getElements())
 			for(Monomial m2:p2.getElements())
 			{
 				if(m1.getGrad()==m2.getGrad())
 				{
 					elements.add(m1.substract(m2));
 					p1.getElements().remove(m1);
 					p2.getElements().remove(m2);
 				}
 			} 
 		
 		for (Monomial m:p1.getElements())
 			elements.add(m);
 		for (Monomial m:p2.getElements())
 			elements.add(new Monomial(-m.getCoeficient(),m.getGrad()));
 			
 		polynomTotal.setElements(elements);		
 }
		
 
 public void mul(Polynomial p1,Polynomial p2)
 {    List<Monomial> elements=new CopyOnWriteArrayList();
 	
 	
 		for (Monomial m1:p1.getElements())
 			for(Monomial m2:p2.getElements())
 			{
 				elements.add(m1.multiply(m2));
 			} 
 		
 		for (Monomial m1:p1.getElements())
 			for(Monomial m2:p2.getElements())
 			{
 				if(m1.getGrad()==m2.getGrad())
 				{
 					elements.add(m1.substract(m2));
 					p1.getElements().remove(m1);
 					p2.getElements().remove(m2);
 				}
 			} 
 			
 		polynomTotal.setElements(elements);	
 		polynomTotal.regroup();
 		
 		
 		
 }
 
 public void derv(Polynomial p)
 {    List<Monomial> elements=new CopyOnWriteArrayList();
 	
 	
 		for (Monomial m:p.getElements())
 			elements.add(m.derivate());
 		
 			
 		polynomTotal.setElements(elements);		
 		
 		
 }
 
 public void integ(Polynomial p)
 {    List<Monomial> elements=new CopyOnWriteArrayList();
 	
 	
 		for (Monomial m:p.getElements())
 			elements.add(m.integrate());
 		
 			
 		polynomTotal.setElements(elements);	
 		
 		
 		
 }
	

 
 public void setResult(String result) {
 try {
	 polynomTotal = new Polynomial(result);
} catch (PatternException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 }

 public String getResult() {
 return polynomTotal.toString();
 }
 
 public String getResult2() {
 return polynomTotal.toString2();
 }
 

}

