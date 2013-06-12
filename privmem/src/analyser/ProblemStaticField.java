package analyser;

import com.ibm.wala.analysis.reflection.InstanceKeyWithNode;
import com.ibm.wala.ipa.callgraph.propagation.StaticFieldKey;

public class ProblemStaticField extends Problem {

	InstanceKeyWithNode ikn;
	StaticFieldKey pk;
	ScjContext iContext;
	ScjContext pContext;
	
	public ProblemStaticField(InstanceKeyWithNode ikn, StaticFieldKey pk) {		
		this.pk = pk;
		this.ikn = ikn;
	}
	
	
	public String toString()
	{
		if ( !this.isPrimordial() ) 
		{
			return "StaticField mismatch between scope of pointer and instance, type: "+this.pk.getField().getDeclaringClass() + " field: " + this.pk.getField().getName()+ "\n"+	    					   					
					"   in class: "+this.ikn.getNode().getMethod().getDeclaringClass() + " in method: " + this.ikn.getNode().getMethod().getName()+ "\n";
		} else {
			return "";		
		}
	}
	
	@Override
	protected boolean isPrimordial() {
		
		if ( this.ikn.getNode().getMethod().getDeclaringClass().getClassLoader().toString().equals("Primordial") && 
				!this.ikn.getNode().getMethod().getDeclaringClass().getName().toString().startsWith("Ljava/") && 
				!this.showPrimordial )
			return true;
		
		if (ScjMemoryScopeAnalysis.analyseWithoutJRE) {
			if ( this.pk.getField().getName().toString().equals("RegisteredEventHandler") &&
					!this.showPrimordial )
				return true;
		}
		
		return false;
	}
}
