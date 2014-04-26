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
	
//	public String returnPath(){
//        JFileChooser dialogue = new JFileChooser();
//        
//        // affichage
//        dialogue.showOpenDialog(null);
//         
//        // récupération du fichier sélectionné
//        System.out.println("Fichier choisi : " + dialogue.getSelectedFile());
//        return ""+dialogue.getSelectedFile();
//	}

//	public void addMenu() {
//		// Create the menu bar.
//		menuBar = new JMenuBar();
//
//		// Build the first menu.
//		menuFichier = new JMenu("Fichier");
//		menuFichier.setMnemonic(KeyEvent.VK_A);
//		menuFichier.getAccessibleContext().setAccessibleDescription(
//				"");
//		menuFichier.addMenuListener(mig);
//		menuBar.add(menuFichier);
//		
//		
//
//		// a group of JMenuItems
//		JMenuItem menuItem = new JMenuItem("Ouvrir un corpus", KeyEvent.VK_O);
//		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
//				ActionEvent.ALT_MASK));
//		menuItem.getAccessibleContext().setAccessibleDescription(
//				"");
//		menuFichier.add(menuItem);
//		
//		
//		JMenuItem menuItem2 = new JMenuItem("Sauvegarder", KeyEvent.VK_S);
//		menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
//				ActionEvent.ALT_MASK));
//		menuItem2.getAccessibleContext().setAccessibleDescription(
//				"");
//		menuFichier.add(menuItem2);
//		
//		
//		JMenuItem menuItem3 = new JMenuItem("Propriétés", KeyEvent.VK_P);
//		menuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
//				ActionEvent.ALT_MASK));
//		menuItem3.getAccessibleContext().setAccessibleDescription(
//				"");
//		menuFichier.add(menuItem3);
//		
//
//
//		// a group of radio button menu items
//		menuFichier.addSeparator();
//		
//		JMenuItem menuItem5 = new JMenuItem("Préférences", KeyEvent.VK_F);
//		menuItem5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
//				ActionEvent.ALT_MASK));
//		menuItem5.getAccessibleContext().setAccessibleDescription(
//				"");
//		menuFichier.add(menuItem5);
//		
//		
//		menuFichier.addSeparator();
//		
//		JMenuItem menuItem4 = new JMenuItem("Quitter", KeyEvent.VK_Q);
//		menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
//				ActionEvent.ALT_MASK));
//		menuItem4.getAccessibleContext().setAccessibleDescription(
//				"");
//		menuFichier.add(menuItem4);
//		
//
//		// Build second menu in the menu bar.
//		JMenu menuCredit = new JMenu("Crédits");
//		menuCredit.setMnemonic(KeyEvent.VK_N);
//		menuCredit.getAccessibleContext().setAccessibleDescription(
//				"This menu does nothing");
//		menuBar.add(menuCredit);
//		
//		JMenuItem menuItem6 = new JMenuItem("About", KeyEvent.VK_T);
//		menuItem6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
//				ActionEvent.ALT_MASK));
//		menuItem6.getAccessibleContext().setAccessibleDescription(
//				"");
//		menuCredit.add(menuItem6);
//
//		setJMenuBar(menuBar);
//		// frame.setJMenuBar(theJMenuBar);
//	}
}
