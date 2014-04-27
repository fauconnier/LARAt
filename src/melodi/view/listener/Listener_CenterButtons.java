package melodi.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import melodi.zcontroler.LaratControler;

public class Listener_CenterButtons implements ActionListener{
	LaratControler controler;
	
	public Listener_CenterButtons(LaratControler controler){
		this.controler=controler;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		/*
		 * Previous & Next Button
		 */
		if ("previous".equals(e.getActionCommand())) {
			controler.actionPerformedPrevious();
		} else if ("next".equals(e.getActionCommand())) {
			controler.actionPerformedNext();
		}

		/*
		 * Center Buttons
		 */
		if ("addSE".equals(e.getActionCommand())) {
			controler.actionPerformedAddSE();
		} else if ("clear".equals(e.getActionCommand())) {
			controler.actionPerformedClearSE();
		} else if ("rec".equals(e.getActionCommand())) {
			controler.actionPerformedRecSE();
		} else if ("del".equals(e.getActionCommand())) {
			controler.actionPerformedDelSE();
		}

		/*
		 * Boutons Sélection Button
		 */
		if ("addPrimer".equals(e.getActionCommand())) {
			controler.actionPerformedAddPrimer();
		} else if ("addItem".equals(e.getActionCommand())) {
			controler.actionPerformedAddItem();
		} else if ("clearAll".equals(e.getActionCommand())) {
			controler.actionPerformedClearThis();
		} else if ("valid".equals(e.getActionCommand())) {
			controler.actionPerformedValid();
		} else if ("cloture".equals(e.getActionCommand())) {
			controler.actionPerformedAddClot();
		}

		/*
		 * Boutons Concepts/Circonstant/Marqueurs
		 */
		if ("addConcept".equals(e.getActionCommand())) {
			controler.actionPerformedAddConcept();
		} else if ("addCirconstant".equals(e.getActionCommand())) {
			controler.actionPerformedAddCirconstant();
		} else if ("switch".equals(e.getActionCommand())) {
			controler.actionPerformedSwitch();
		} else if ("addMarqRel".equals(e.getActionCommand())) {
			controler.actionPerformedAddMarqRel();
		}
		
	}

}
