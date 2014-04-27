package melodi.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLDocument;

import melodi.view.listener.Listener_LeftTextPane;
import melodi.zcontroler.LaratControler;


public class Larat_LeftPanel extends JPanel {
	
	public JTextPane leftTextPane;
	private static final long serialVersionUID = 1L;

	public Larat_LeftPanel(LaratControler controler) {
		
		this.leftTextPane = new JTextPane(); 
		Listener_LeftTextPane leftTextPaneListener = new Listener_LeftTextPane(leftTextPane,controler);
		leftTextPane.addCaretListener(leftTextPaneListener);
		leftTextPane.addMouseListener(leftTextPaneListener);
		
		this.setLayout(new BorderLayout());

		leftTextPane.setFont(new Font("Serif", Font.PLAIN, 12));
		leftTextPane.setEditable(false);
		
		JScrollPane areaScrollPane = new JScrollPane(leftTextPane);
		areaScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(5000, 5000));
		areaScrollPane.setMinimumSize(new Dimension(400, 400));

		areaScrollPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder("Texte"),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)),
				areaScrollPane.getBorder()));

		this.add(areaScrollPane, BorderLayout.CENTER);
	}
}
