package analyser;

public class ProblemUnknown extends Problem {

	String description;	
	ScjContext iContext;
	ScjContext pContext;
	
	public ProblemUnknown(String description) {		
		this.description = description;
	}
	
	
	public String toString()
	{
		if ( !this.isPrimordial() )
			return description;		
		else
			return "";
	}
	
	protected boolean isPrimordial() 
	{
		if ( this.description.contains("Primordial") && !this.showPrimordial )
			return true;
			
		return false;
	}
}
