package melodi.internal;

import java.util.ArrayList;

import talismane_client.datamodel.Structure;
import melodi.internal.Concept;

public class Primer extends ArrayList<String> implements java.io.Serializable, Graphical_Component{
	
	
	/**
	 * Machine Learning : EKAW
	 */
	Structure structure;
	
	int id_se;
	int indice_begin;
	int indice_end;
	
	/**
	 * Unités
	 */
	private Concept concept;
	private Circonstant circonstant;
	private MarqueurRelation marqueurRel;
	
	public Primer(){
		this.concept = new Concept();
		this.circonstant = new Circonstant();
		this.marqueurRel = new MarqueurRelation();
		this.structure =  new Structure();
	}
	
	public void setMarqueurRel(MarqueurRelation marqueurRel){
		this.marqueurRel = marqueurRel;
	}
	
	public MarqueurRelation getMarqueurRel(){
		return this.marqueurRel;
	}
	
	public void setCirconstant(Circonstant circonstant){
		this.circonstant = circonstant;
	}
	
	public Circonstant getCirconstant(){
		return this.circonstant;
	}
	
	public boolean hasCirconstant(){
		return this.circonstant.size() > 0;
	}
	
	public boolean hasConcept(){
		return this.concept.size() > 0;
	}
	
	public boolean hasMarqRel(){
		return this.marqueurRel.size() > 0;
	}
	
	public void setConcept(Concept concept){
		this.concept = concept;
	}
	
	public Concept getConcept(){
		return this.concept;
	}

	@Override
	public String toString() {
		String toReturn = "	#Primer# = [\n";
		for (String sequence : this) {
			toReturn += sequence.toString();
		}
		return toReturn + "	]";
	}
	
	public String getText(){
		return this.get(0);
	}
	
	public void setText(String primer_string){
		this.add(primer_string);
	}
	
	public String getSurface(){
		String toReturn = "";
		for (String sequence : this) {
			toReturn += sequence.toString();
		}
		return toReturn;
	}

	public int getId_se() {
		return id_se;
	}

	public void setId_se(int id_se) {
		this.id_se = id_se;
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
	
	public void setStructure(Structure structure){
		this.structure=structure;
	}
	
	public Structure getStructure(){
		return this.structure;
	}

}
