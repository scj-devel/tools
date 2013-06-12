package analyser;

import java.util.Iterator;
import java.util.LinkedList;

public class ScjScopeStack extends LinkedList<ScjScope> {
	
	public ScjScopeStack deepCopy()
	{
		ScjScopeStack clone = new ScjScopeStack();
		
		for (int i = 0; i < this.size(); i++)
		{
			clone.add(this.get(i).deepCopy());
		}
		
		return clone;
	}

	public boolean less(ScjScopeStack s) {
		
		// Check top of instance scopestack is not ScopeType Unknown
		if (this.get(this.size()-1).getScopeType() == ScjScopeType.UNKNOWN)			
			return false;
		
		// Take top of instance scopestack and check if it is in the pointer scopestack.
		Iterator<ScjScope> myIter = s.iterator();
		
		while (myIter.hasNext())
		{			
			if (myIter.next().equals(this.get(this.size()-1)))
				return true;
		}
		
		return false;
	}
} 
