package melodi.main;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class MIG_JFrame extends JFrame{
	
	JMenuBar menuBar;
	JMenu menuFichier, submenu;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;
	public MIG_JPanel_Parent mig;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MIG_JFrame(String title) {
		super(title);
	}
	
}
