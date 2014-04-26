package melodi.internal;

import java.util.ArrayList;

public class Item extends ArrayList<String> implements Graphical_Component, Comparable {

	String id;
	int indice_begin;
	int indice_end;
	
	/**
	 * Unités
	 */
	private Concept concept;
	private Circonstant circonstant;
	private MarqueurRelation marqueurRel;
	
	public Item(){
		this.concept = new Concept();
		this.circonstant = new Circonstant();
		this.marqueurRel = new MarqueurRelation();
	}
	
	public void setMarqueurRel(MarqueurRelation marqueurRel){
		this.marqueurRel = marqueurRel;
	}
	
	public boolean hasMarqRel(){
		return this.marqueurRel.size() > 0;
	}
	
	public MarqueurRelation getMarqueurRel(){
		return this.marqueurRel;
	}
	
	public boolean hasCirconstant(){
		return this.circonstant.size() > 0;
	}
	
	public boolean hasConcept(){
		return this.concept.size() > 0;
	}
	
	public void setCirconstant(Circonstant circonstant){
		this.circonstant = circonstant;
	}
	
	public Circonstant getCirconstant(){
		return this.circonstant;
	}
	
	public void setConcept(Concept concept){
		this.concept = concept;
	}
	
	public Concept getConcept(){
		return this.concept;
	}

	public int getIndice_begin() {
		return indice_begin;
	}

	public void setIndice_begin(int indice_begin) {
		this.indice_begin = indice_begin;
	}

	public int getIndice_end() {
		return indice_end;
	}

	public void setIndice_end(int indice_end) {
		this.indice_end = indice_end;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return this.get(0);
	}

	public void setText(String toadd){
		this.add(toadd);
	}
	
	@Override
	public String toString() {
		String toReturn = "	Item " + id + " = [\n";
		for (String sequence : this) {
			toReturn += sequence.toString();
		}
		return toReturn + "\n	]\n";
	}

	public String getSurface() {
		String toReturn = "";
		for (String sequence : this) {
			toReturn += sequence.toString();
		}
		return toReturn + "\n";
	}

	public int compareTo(Item o2) {

		if (this.getIndice_begin() > o2.getIndice_begin()) {
			return 1;
		} else {

			return 0;
		}
	}

	@Override
	public int compareTo(Object arg0) {
		Item b = (Item) arg0;
		return this.getIndice_begin() - b.getIndice_begin() ;
	}

}
