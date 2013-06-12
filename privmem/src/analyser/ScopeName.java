package analyser;

import com.ibm.wala.ipa.callgraph.ContextKey;

public class ScopeName implements ContextKey {

	private String name;
	
	public ScopeName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public String toString() {	    
	    return name.toString();
	}

	
	public boolean equals(Object o) {
		return (o instanceof ScopeName) && ((ScopeName) o).getName().equals(name);
	}
}
