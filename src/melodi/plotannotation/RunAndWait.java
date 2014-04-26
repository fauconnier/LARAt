package melodi.plotannotation;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.UIManager;

import melodi.main.MIG_JFrame;
import melodi.main.MIG_JPanel_Parent;

public class RunAndWait {
	MIG_JPanel_Parent mig;
	
	
	public RunAndWait(String doc, String phase, String annotateur,int index_doc){
		// Turn off metal's use of bold fonts
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		MIG_JFrame annotationSE_jframe = new MIG_JFrame(annotateur);
	    this.mig = new MIG_JPanel_Parent(annotationSE_jframe);
		mig.addMenu();
		// ImageIcon leftButtonIcon = new ImageIcon("images/star.png");
		// annotationSE_jframe.setIconImage(leftButtonIcon.getImage());

		annotationSE_jframe.setDefaultCloseOperation(MIG_JFrame.EXIT_ON_CLOSE);
		annotationSE_jframe.setSize(1024, 768); // On donne une taille à notre
												// fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
		Point newLocation = new Point(middle.x
				- (annotationSE_jframe.getWidth() / 2), middle.y
				- (annotationSE_jframe.getHeight() / 2));
		annotationSE_jframe.setLocation(newLocation); // On centre la fenêtre
														// sur l'écran
		annotationSE_jframe.setResizable(true); // On interdit la
												// redimensionnement de la
												// fenêtre

		// Add content to the window.

		annotationSE_jframe.add(mig);

		// Display the window.
		// annotationSE_jframe.pack();
		annotationSE_jframe.setVisible(true);
		if(phase.equals("Phase_2")){
		mig.document_path = "/home/jfaucon/Thesis/Data/LARAt_Corpus/Annotation/"+annotateur+"/LARA_corpus/"
				+ doc + ".html";
		}
		else{
			mig.document_path = "/home/jfaucon/Thesis/Data/LARA_phase1/"+annotateur+"/LARA_corpus/"
					+ doc + ".html";
		}
		mig.initDoc();

		
		mig.current_SE = mig.chain_SE.get(index_doc);
		mig.init();
	}
	
	public void refresh(int index_doc){
		mig.current_SE = mig.chain_SE.get(index_doc);
		mig.init();
	}

}
