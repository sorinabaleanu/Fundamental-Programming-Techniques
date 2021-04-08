package PT2020.assigment1.Assigment1;

public class Monomial {

	
	private double coeficient;
	private int grad;

	
	public Monomial(double coeficient,int grad)
	{
		
		this.coeficient=coeficient;
		this.grad=grad;
	
		
	}
	

	public int getGrad() {
		return grad;
	}
	public void setGrad(int grad) {
		this.grad = grad;
	}
	public double getCoeficient() {
		return coeficient;
	}
	public void setCoeficient(double d) {
		this.coeficient = d;
	}
	
	
	
	public Monomial add(Monomial m)
	{
		double coef;
		coef=this.coeficient+m.getCoeficient();
		return new Monomial(coef,this.grad);
	}
	
	public Monomial substract(Monomial m)
	{
		double coef;
		coef=this.coeficient-m.getCoeficient();
		return new Monomial(coef,this.grad);
		
	}
	
	public Monomial multiply(Monomial m)
	{
		double coef;
		int gr;
		coef=this.coeficient*m.getCoeficient();
		gr=this.grad+m.getGrad();
		return new Monomial(coef,gr);
		
		
	}
	
	public Monomial divide(Monomial m)
	{
		double coef;
		int gr;
		coef=this.coeficient/m.getCoeficient();
		gr=this.grad-m.getGrad();
		return new Monomial(coef,gr);
		
	}
	
	public Monomial derivate()
	{
		
		double coef;
		int gr;
		coef=this.coeficient*this.grad;
		gr=this.grad-1;
		return new Monomial(coef,gr);
		
	}
	
	public Monomial integrate()
	{
	
	double coef;
	int gr;
	coef=this.coeficient/(this.grad+1);
	gr=this.grad+1;
	return new Monomial(coef,gr);
		
	}
	
	public String toString()
	{
		int coef=(int)coeficient;
		if(coeficient==0)
			return "";
		else 
		if(grad==1)
			return coef+"x";
		else if(grad==0)
			return coef+"";
		return coef+"x^"+grad;
		
	}
	
	public String toString2()
	{
		
		if(coeficient==0)
			return "";
		else 
		if(grad==1)
			return coeficient+"x";
		else if(grad==0)
			return coeficient+"";
		return coeficient+"x^"+grad;
		
	}
	
	
}
