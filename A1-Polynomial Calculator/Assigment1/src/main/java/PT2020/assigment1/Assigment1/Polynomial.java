package PT2020.assigment1.Assigment1;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

	
	private List<Monomial> elements=new CopyOnWriteArrayList();
	
	public Polynomial(String input)throws 	PatternException
	{
		Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
		
		Matcher m=p.matcher(input) ;
		boolean notFound=true;
		
		while (m.find()) {
			double c=Double.parseDouble(m.group(1));
			int g=Integer.parseInt(m.group(2));
			
		   this.elements.add(new Monomial(c,g));
		  notFound=false;
		}
		
		
		if(notFound) throw new PatternException();
		
		
		
	}
	
	public Polynomial()
	{
		
	}
	
	public void setValue(String input)
	{
Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
		
		Matcher m=p.matcher(input) ;
		boolean notFound=true;
		
		while (m.find()) {
			double c=Double.parseDouble(m.group(1));
			int g=Integer.parseInt(m.group(2));
			
		   this.elements.add(new Monomial(c,g));
		  notFound=false;
		}
	}
	
	
	
	public List<Monomial> getElements() {
		return elements;
	}

	public void setElements(List<Monomial> elements) {
		this.elements = elements;
	}
	
	public void removeElement(Monomial m)
	{
		this.elements.remove(m);
	}
	
	
	public void regroup()
	{
		 
		for(int i=0;i<elements.size();i++)
			for(int j=i+1;j<elements.size();j++)
				if(elements.get(i).getGrad()==elements.get(j).getGrad())
				{
					Monomial m1= new Monomial(elements.get(i).getCoeficient(),elements.get(i).getGrad());
					Monomial m2= new Monomial(elements.get(j).getCoeficient(),elements.get(j).getGrad());
					Monomial sum=m1.add(m2);
					
					elements.get(i).setGrad(sum.getGrad());
					elements.get(i).setCoeficient(sum.getCoeficient());
					
					elements.remove(j);
					
				}
			
		
		
	}

public String toString()
	{
		String result="";
		for(Monomial m:elements)
			if(m.getCoeficient()>0)result+="+"+m;
			else result+=m;
		return result;
	}

public String toString2()
{
	String result="";
	for(Monomial m:elements)
		if(m.getCoeficient()>0)result+="+"+m.toString2();
		else result+=m.toString2();
	return result;
}
	
	

	
}
