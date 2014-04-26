package melodi.main;


import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MIG_Main {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				
				MIG_JFrame annotationSE_jframe = new MIG_JFrame("LARAt : R1.1.2b");
				MIG_JPanel_Parent mig = new MIG_JPanel_Parent(annotationSE_jframe);
				mig.addMenu();
				
				annotationSE_jframe.setDefaultCloseOperation(MIG_JFrame.EXIT_ON_CLOSE);
				annotationSE_jframe.setSize(1280, 800); 
				annotationSE_jframe.setLocationRelativeTo(null); 
				annotationSE_jframe.setResizable(true); 
				
				annotationSE_jframe.add(mig);
				annotationSE_jframe.setVisible(true);
			}
		});
	}

}
