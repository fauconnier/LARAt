package melodi.internal;

import java.util.ArrayList;

public class SE  implements Graphical_Component, Comparable{

	
	Cloture clot;
	
	/**
	 * Caractérisation : Axe
	 */
	String axe_visuel;
	String axe_visuel_nav_hyp;
	
	String axe_rhetorique;
	ArrayList<String> axe_intentionnel;
	String axe_semantique;
	String axe_semantique_context;
	
	/**
	 * Objets internes
	 */
	
	private String text;
	private int indice_begin;
	private int indice_end;
	private String comment;
	

	/**
	 * Unités
	 */
	private Primer primer;
	private Items items;
	private int id;
	private Annotation annot;
	

	// Un concept est associé au Primer et aux Items
	
	public SE(){
		Items myInternalItems = new Items();
		items=myInternalItems;
		axe_intentionnel = new ArrayList<String>();
		
		axe_rhetorique = "";
		axe_semantique = "";
		axe_visuel = "";
		axe_semantique_context = "";
	
	}
	
	public void addAxe_intentionnel(String axe_intentionnel){
		this.axe_intentionnel.add(axe_intentionnel);
	}
	
	public ArrayList<String> getAxe_intentionnel(){
		return this.axe_intentionnel;
	}
	
	
	public String getAxe_semantiqueContext(){
		return this.axe_semantique_context;
	}
	
	public void setAxe_semantiqueCircon(String axe_semantique_context){
		this.axe_semantique_context = axe_semantique_context;
	}
	
	public String getAxe_semantique(){
		return this.axe_semantique;
	}
	
	public void setAxe_semantique(String axe_semantique){
		this.axe_semantique = axe_semantique;
	}
	
	public String getAxe_rhetorique(){
		return this.axe_rhetorique;
	}
	
	public void setAxe_rhetorique(String axe_rethorique){
		this.axe_rhetorique = axe_rethorique;
	}
	
	public String getAxe_visuel() {
		return axe_visuel;
	}

	public void setAxe_visuel(String axe_visuel) {
		this.axe_visuel = axe_visuel;
	}

	public String getAxe_visuel_nav_hyp() {
		return axe_visuel_nav_hyp;
	}

	public void setAxe_visuel_nav_hyp(String axe_visuel_nav_hyp) {
		this.axe_visuel_nav_hyp = axe_visuel_nav_hyp;
	}

	
	public void setAnnotation(Annotation annot){
		this.annot=annot;
	}
	public Annotation getAnnotation(){
		return this.annot;
	}
	
	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Primer getPrimer() {
		return primer;
	}

	public void setPrimer(Primer primer) {
		this.primer = primer;
	}

	public Items getItems() {
		return items;
	}
	
	public Item getItem(int index){
		return items.get(index);
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
	public void addItem(Item item){
		this.items.add(item);
	}
	
	public int sizeItems(){
		return this.items.size();
	}

	public String toString(){
		String retur ="SE :";

		if(text != null){
			retur = retur + text;
		}
		
		if(primer !=null){
			retur = retur + primer.toString();
		}
		if(items.size() > 0){
			for(Item ite : items){
				retur = retur +  ite.toString();
			}
		}
		return retur;
	}
	
	public Cloture getClot() {
		return clot;
	}

	public void setClot(Cloture clot) {
		this.clot = clot;
	}
	

	@Override
	public int compareTo(Object arg0) {
		SE b = (SE) arg0;
		return this.getIndice_begin() - b.getIndice_begin() ;
	}

	
}