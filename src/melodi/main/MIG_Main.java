package melodi.main;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MIG_Main {
	
	public static void main(String[] args) {
		// Schedule a job for the event dispatching thread:
		// creating and showing this application's GUI.
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				
				MIG_JFrame annotationSE_jframe = new MIG_JFrame("LARAt : R1.1.2b");
				MIG_JPanel_Parent mig = new MIG_JPanel_Parent(annotationSE_jframe);
				mig.addMenu();
//				ImageIcon leftButtonIcon = new ImageIcon("images/star.png");
//				annotationSE_jframe.setIconImage(leftButtonIcon.getImage());
				
				annotationSE_jframe.setDefaultCloseOperation(MIG_JFrame.EXIT_ON_CLOSE);
				annotationSE_jframe.setSize(1280, 800); // On donne une taille à notre fenêtre
				annotationSE_jframe.setLocationRelativeTo(null); // On centre la fenêtre sur l'écran
				annotationSE_jframe.setResizable(true); // On interdit la redimensionnement de la fenêtre
				
				annotationSE_jframe.add(mig);

				// Display the window.
//				annotationSE_jframe.pack();
				annotationSE_jframe.setVisible(true);
			}
		});
	}

}
