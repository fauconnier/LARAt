package melodi.zcontroler;

import melodi.internal.Graphical_Component;
import melodi.internal.SE;
import melodi.model.LaratModel;

public class LaratControler {
	
	protected LaratModel LaratModel;
	
	/**
	 * Class which controls LaratModel
	 * @param abstractModel
	 */
	public LaratControler(LaratModel abstractModel) {
		this.LaratModel = abstractModel;
	}

	public void reset() {
		this.LaratModel.reset();
	}
	
	
	public void initDoc(){
		System.out.println("Initdoc");
	}
	
	public void actionPerformedValid(){
		System.out.println("actionPerformedValid");
		
	}
	
	public void actionPerformedQuit(){
		System.out.println("actionPerformedQuit");
	}

	public void actionPerformedAbout(){
		System.out.println("actionPerformedAbout");
	}
	
	public void actionPerformedPrevious(){
		System.out.println("actionPerformedPrevious");
	}
	
	public void actionPerformedNext(){
		System.out.println("actionPerformedNext");
	}

	public void actionPerformedAddSE(){
		System.out.println("actionPerformedAddSE");
	}
	
	public void actionPerformedClearSE(){
		System.out.println("actionPerformedClearSE");
	}
	
	public void actionPerformedRecSE(){
		System.out.println("actionPerformedRecSE");
	}
	
	public void actionPerformedDelSE(){
		System.out.println("actionPerformedDelSE()");
	}
	
	public void actionPerformedAddPrimer(){
		System.out.println("actionPerformedAddPrimer");
	}
	
	public void actionPerformedAddItem(){
		System.out.println("actionPerformedAddItem");
	}
	
	public void actionPerformedClearThis(){
		System.out.println("actionPerformedClearThis");
	}
	
	public void actionPerformedAddClot(){
		System.out.println("actionPerformedAddClot");
	}
	
	public void actionPerformedAddConcept(){
		System.out.println("actionPerformedAddConcept");
	}
	
	public void actionPerformedAddCirconstant(){
		System.out.println("actionPerformedAddCirconstant");
	}
	
	public void actionPerformedSwitch(){
		System.out.println("actionPerformedSwitch()");
	}
	
	public void actionPerformedAddMarqRel(){
		System.out.println("actionPerformedAddMarqRel");
	}
	
	
	
	public void selectAnnotationAtChar(int pos){
		System.out.println("selectAnnotationAtChar : "+pos);
		
//		SE toTest = toolsGetSEFromSouris(pos);
//		if (toTest != null) {
//			if (!chain_SE.contains(current_SE) && (current_SE != null)) {
//				removeHighLighterFormSE(current_SE, textPane);
//			}
//			current_SE = toTest;
//			logger.info("Souris cliquée TextPane: Sélection SE");
//			init();
//		}  else {
//			logger.info("Souris cliquée TextPane: Aucune sélection");
//		}
	}
	
	public void selectSubAnnotationAtChar(int pos){
		System.out.println("selectSubAnnotationAtChar : "+pos);
		
//		Graphical_Component myGraphicalCompo = toolsGetGraphicalComponentFromSouris(pos);
//		if (myGraphicalCompo.getIndice_begin() != 0
//				&& myGraphicalCompo.getIndice_end() != 0) {
//			logger.info("Souris cliquee SEPane: Graphical Component sélectionné");
//			// modifyHighLighterForm(myGraphicalCompo, SEPane,
//			// currentSelectedSEPane);
//			removeItemPrimer(myGraphicalCompo);
//			refreshSEPane();
//		} else {
//			logger.info("Souris cliquee SEPane: Aucune selection");
//		}
	}
	void control() {
		
	}

}
