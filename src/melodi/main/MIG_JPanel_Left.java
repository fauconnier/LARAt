package melodi.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.Segment;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

import melodi.tools.TextLineNumber;
import melodi.tools.Tools;


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
