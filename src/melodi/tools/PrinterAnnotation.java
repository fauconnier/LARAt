package melodi.tools;

import melodi.controler.LaratControler;
import melodi.model.LaratModel;
import melodi.view.LaratView;


public class PrinterAnnotation {
	
	String docname;
	int index_doc;
	
	public PrinterAnnotation(String docname, int index_doc){
		this.docname=docname;
		this.index_doc=index_doc;
	}
	
	public void run(){
		
		// Input
		String doc = docname;
		int index = index_doc;
		
		/**
		 *  Model–view–controller
		 */
		LaratModel laratModel = new LaratModel();
		LaratControler laratControler = new LaratControler(laratModel);
		LaratView laratInterface = new LaratView(laratControler);
		laratModel.addObserver(laratInterface);
		
		laratInterface.setTitle("A1 consensus");
		/**
		 * Do something
		 */
		laratModel.openFile("/home/jfaucon/Thesis/Data/LARAt_Consensus/Consensus/LARA_corpus/"+doc+".html");
		laratModel.selectUnit(index);
	}


}
