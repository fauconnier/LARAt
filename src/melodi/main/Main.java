package melodi.main;

import melodi.model.LaratModel;
import melodi.view.LaratView;
import melodi.zcontroler.LaratControler;

public class Main {

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
