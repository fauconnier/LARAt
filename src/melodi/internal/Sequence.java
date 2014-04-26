package melodi.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Sequence extends ArrayList<Token>{
	
	String id;
	
	public void setId(String id){
		this.id=id;
	}
	
	public String getId(){
		return id;
	}
	
	public String toString() {
		String toReturn = "		Sequence = "+ id+" [\n";
		for (Token token : this) {
			toReturn += token.toString();
		}
		return toReturn + "		]\n";
	}

	public String getSurface() {
		String toReturn = "";
		for (Token token : this) {
			toReturn += " " + token.getSurface();
		}
		return toReturn;
	}

	
}
