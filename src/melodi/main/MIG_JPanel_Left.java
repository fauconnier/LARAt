package melodi.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLDocument;


public class MIG_JPanel_Left extends JPanel {
	/**
	 * 
	 */
	public JTextPane textPane;
	public HTMLDocument htmlDocTextPane;
	private static final long serialVersionUID = 1L;
	public MIG_JPanel_Parent mig;

	public MIG_JPanel_Left(MIG_JPanel_Parent mig, JTextPane textPane) {

		this.mig = mig;
		this.textPane=textPane;
		this.setLayout(new BorderLayout());

		htmlDocTextPane = new HTMLDocument();

//		textPane.setContentType("text/html"); 
//		textPane.setDocument(htmlDocTextPane);
		textPane.setFont(new Font("Serif", Font.PLAIN, 12));
		textPane.setEditable(false);
		textPane.addCaretListener(mig);
		textPane.addMouseListener(mig);

		
		// areaScrollPane
		JScrollPane areaScrollPane = new JScrollPane(textPane);
		areaScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(5000, 5000));
		areaScrollPane.setMinimumSize(new Dimension(400, 400));

		// areaScrollPane : compoundBorder
		areaScrollPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder("Texte"),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)),
				areaScrollPane.getBorder()));
		

		// Put everything together.
		this.add(areaScrollPane, BorderLayout.CENTER);

	}


}
