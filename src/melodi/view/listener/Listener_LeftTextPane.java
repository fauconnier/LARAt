package melodi.view.listener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import melodi.internal.Graphical_Component;
import melodi.internal.SE;
import melodi.zcontroler.LaratControler;

public class Listener_LeftTextPane implements CaretListener, MouseListener{
	LaratControler controler;
	JTextPane textPane;
	
	/**
	 * Listen to events from textPane and notifies those
	 * to controler.
	 * @param controler
	 */
	public Listener_LeftTextPane(JTextPane textPane, LaratControler controler){
		this.textPane=textPane;
		this.controler=controler;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getClickCount() == 2) {
			Point pt = new Point(e.getX(), e.getY());
			int pos = textPane.viewToModel(pt);
			controler.selectAnnotationAtChar(pos);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caretUpdate(CaretEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
