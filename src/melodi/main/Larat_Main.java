package melodi.main;

import melodi.controler.LaratControler;
import melodi.model.LaratModel;
import melodi.view.LaratView;

public class Larat_Main {

	public static void main(String[] args) {
		
		/**
		 *  Model–view–controller
		 */
		LaratModel laratModel = new LaratModel();
		LaratControler laratControler = new LaratControler(laratModel);
		LaratView laratInterface = new LaratView(laratControler);
		laratModel.addObserver(laratInterface);
		
		

	}

}
