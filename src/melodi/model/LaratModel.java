package melodi.model;

import java.util.ArrayList;


import melodi.view.LaratView;

public class LaratModel {

	private LaratView obs;
	
	/**
	 * Constructor
	 */
	public LaratModel(){
		
	}

	public void addObserver(LaratView obs) {
		this.obs = obs;
	}
	
	public void notifyObserver(String str) {
		obs.update();
	}
	
	public void reset() {
		notifyObserver(String.valueOf("String vide"));
	}

}
