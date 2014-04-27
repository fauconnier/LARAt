package melodi.view.listener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import melodi.zcontroler.LaratControler;

public class Listener_CenterTextPane implements CaretListener, MouseListener{
	LaratControler controler;
	JTextPane textPane;
	
	/**
	 * Listen to events from textPane and notifies those
	 * to controler.
	 * @param controler
	 */
	public Listener_CenterTextPane(JTextPane textPane, LaratControler controler){
		this.textPane=textPane;
		this.controler=controler;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getClickCount() == 2) {
			Point pt = new Point(e.getX(), e.getY());
			int pos = textPane.viewToModel(pt);
			controler.selectSubAnnotationAtChar(pos);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caretUpdate(CaretEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
