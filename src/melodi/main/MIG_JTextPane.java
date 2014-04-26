package melodi.main;

import javax.swing.JTextPane;

public class MIG_JTextPane extends JTextPane implements Cloneable {
	
	String type;
	
	public MIG_JTextPane(){
		super();
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
	
	public MIG_JTextPane clone() {
		MIG_JTextPane o = null;
		try {
			// On récupère l'instance à renvoyer par l'appel de la 
			// méthode super.clone()
			o = (MIG_JTextPane) super.clone();
		} catch(CloneNotSupportedException cnse) {
			// Ne devrait jamais arriver car nous implémentons 
			// l'interface Cloneable
			cnse.printStackTrace(System.err);
		}
		// on renvoie le clone
		return o;
	}

}
