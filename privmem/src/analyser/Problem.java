package analyser;

public abstract class Problem {
	
	boolean showPrimordial = false;
	
	public int hashCode()
	{		
	    return this.toString().hashCode();
	}
	
	public boolean equals(Object obj) {
		
	    if (obj instanceof Problem) {
	      if (obj.getClass().equals(getClass())) {
	    	  Problem other = (Problem) obj;	    	  
	    	  return other.hashCode() == this.hashCode();
	      } else {
	        return false;
	      }
	    } else {
	      return false;
	    }
	}
		
	abstract protected boolean isPrimordial();
	
}
