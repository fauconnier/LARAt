package melodi.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import melodi.tools.*;

public class MIG_JPanel_Center extends JPanel {

	/**
	 * Contrôle SE
	 */
	public JButton addButton;
	public JButton clearButton;
	public JButton recButton;
	public JButton delButton;

	/**
	 * Contrôle interne SE
	 */
	public JButton addPrimer;
	public JButton addItem;
	public JButton addContextSpatio;
	public JButton addContextTempo;
	public JButton clearThis;
	public JButton clotIcon;
	
	/**
	 * Sélection concepts/circonstant/marqueurs/switch
	 */
	public JButton addConcept;
	public JButton addCirconstant;
	public JButton addMarqRel;
	public JButton switchView;


	/**
	 * Info
	 */
	public JLabel primer_info;
	public JLabel nbrItems_info;
	public JLabel axe_visuel_info;
	public JLabel axe_rheto_info;
	public JLabel axe_intentionnel_info;
	public JLabel axe_sem_info;



	public MIG_JTextPane SEPane;
	private static final long serialVersionUID = 1L;
	public MIG_JPanel_Parent mig;

	public void setNewPane(MIG_JTextPane SEPane) {
		this.SEPane = SEPane;
	}

	public MIG_JPanel_Center(MIG_JPanel_Parent mig, MIG_JTextPane SEPane) {

		this.mig = mig;
		this.SEPane = SEPane;
		this.setLayout(new BorderLayout());


		/**
		 * UP
		 */
		// Create an editor pane.
		SEPane.setContentType("text/html");
		SEPane.addCaretListener(mig);
		SEPane.addMouseListener(mig);

		SEPane.setEditable(false);
		JScrollPane editorScrollPane = new JScrollPane(SEPane);
		editorScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// editorScrollPane.setPreferredSize(new Dimension(250, 155));

		JPanel centerUp = new JPanel(new BorderLayout());
		centerUp.add(editorScrollPane);

		/**
		 * Middle
		 */
		JPanel centerMiddle = new JPanel(new BorderLayout());

		// All Button
		JPanel buttonPane = new JPanel(new GridLayout(1, 0));

		// Identification
		JPanel buttonPanelUp = new JPanel(new GridBagLayout());

		ImageIcon plusIcon = new ImageIcon("ressources/images/plus.png");
		addButton = new JButton(plusIcon);
		addButton.setVerticalTextPosition(AbstractButton.CENTER);
		addButton.setHorizontalTextPosition(AbstractButton.RIGHT); // aka LEFT,
																	// for
		addButton.setMnemonic(KeyEvent.VK_D);
		addButton.setActionCommand("addSE");

		ImageIcon clearIcon = new ImageIcon("ressources/images/clear.png");
		clearButton = new JButton(clearIcon);
		clearButton.setHorizontalTextPosition(AbstractButton.LEFT);
		clearButton.setMnemonic(KeyEvent.VK_E);
		clearButton.setActionCommand("clear");
		clearButton.setEnabled(true);

		ImageIcon verIcon = new ImageIcon("ressources/images/ver.png");
		recButton = new JButton(verIcon);
		recButton.setHorizontalTextPosition(AbstractButton.LEFT);
		recButton.setMnemonic(KeyEvent.VK_E);
		recButton.setActionCommand("rec");
		recButton.setEnabled(true);

		ImageIcon delIcon = new ImageIcon("ressources/images/croix.png");
		delButton = new JButton(delIcon);
		delButton.setHorizontalTextPosition(AbstractButton.LEFT);
		delButton.setMnemonic(KeyEvent.VK_E);
		delButton.setActionCommand("del");
		delButton.setEnabled(true);

		// Listen for actions on buttons 1 and 3.
		clearButton.addActionListener(mig);
		addButton.addActionListener(mig);
		recButton.addActionListener(mig);
		delButton.addActionListener(mig);

		selectSE(buttonPanelUp, addButton, clearButton, recButton, delButton);

		buttonPanelUp.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Sélection"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		// Sélection
		ImageIcon primerIcon = new ImageIcon("ressources/images/plus3.png");
		addPrimer = new JButton(primerIcon);
		addPrimer.setVerticalTextPosition(AbstractButton.CENTER);
		addPrimer.setHorizontalTextPosition(AbstractButton.RIGHT); // aka LEFT,
																	// for
		addPrimer.setMnemonic(KeyEvent.VK_D);
		addPrimer.setActionCommand("addPrimer");

		ImageIcon itemIcon = new ImageIcon("ressources/images/plus4.png");
		addItem = new JButton(itemIcon);
		addItem.setVerticalTextPosition(AbstractButton.CENTER);
		addItem.setHorizontalTextPosition(AbstractButton.RIGHT); // aka LEFT,
																	// for
		addItem.setMnemonic(KeyEvent.VK_D);
		addItem.setActionCommand("addItem");

		ImageIcon clearItemPrimerIcon = new ImageIcon(
				"ressources/images/clear2.png");
		clearThis = new JButton(clearItemPrimerIcon);
		clearThis.setVerticalTextPosition(AbstractButton.CENTER);
		clearThis.setHorizontalTextPosition(AbstractButton.RIGHT); // aka LEFT,
																	// for
		clearThis.setMnemonic(KeyEvent.VK_D);
		clearThis.setActionCommand("clearAll");

		ImageIcon imageIcon = new ImageIcon("ressources/images/clot.png");
		clotIcon = new JButton(imageIcon);
		clotIcon.setVerticalTextPosition(AbstractButton.CENTER);
		clotIcon.setHorizontalTextPosition(AbstractButton.RIGHT); // aka LEFT,
																	// for
		clotIcon.setMnemonic(KeyEvent.VK_D);
		clotIcon.setActionCommand("cloture");

		addPrimer.addActionListener(mig);
		addItem.addActionListener(mig);
		clearThis.addActionListener(mig);
		clotIcon.addActionListener(mig);

		JPanel buttonPanelUp2 = new JPanel(new GridBagLayout());
		buttonPanelUp2.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Composants"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		select2SE(buttonPanelUp2, addPrimer, addItem, clearThis, clotIcon);
		
		
		
		
		// V2 : Selection Concepts/Circonstantants/Marqueurs
		ImageIcon conceptIcon = new ImageIcon("ressources/images/addConcept.png");
		addConcept = new JButton(conceptIcon);
		addConcept.setVerticalTextPosition(AbstractButton.CENTER);
		addConcept.setHorizontalTextPosition(AbstractButton.RIGHT); // aka LEFT,
		addConcept.setMnemonic(KeyEvent.VK_D);
		addConcept.setActionCommand("addConcept");

		ImageIcon circonstantIcon = new ImageIcon("ressources/images/addCirc.png");
		addCirconstant = new JButton(circonstantIcon);
		addCirconstant.setVerticalTextPosition(AbstractButton.CENTER);
		addCirconstant.setHorizontalTextPosition(AbstractButton.RIGHT); // aka LEFT,
		addCirconstant.setMnemonic(KeyEvent.VK_D);
		addCirconstant.setActionCommand("addCirconstant");

		ImageIcon switchIcon = new ImageIcon(
				"ressources/images/switch.png");
		switchView = new JButton(switchIcon);
		switchView.setVerticalTextPosition(AbstractButton.CENTER);
		switchView.setHorizontalTextPosition(AbstractButton.RIGHT); // aka LEFT,
		switchView.setMnemonic(KeyEvent.VK_D);
		switchView.setActionCommand("switch");

		ImageIcon marqueurIcon = new ImageIcon("ressources/images/addMarq.png");
		addMarqRel = new JButton(marqueurIcon);
		addMarqRel.setVerticalTextPosition(AbstractButton.CENTER);
		addMarqRel.setHorizontalTextPosition(AbstractButton.RIGHT); // aka LEFT,
		addMarqRel.setMnemonic(KeyEvent.VK_D);
		addMarqRel.setActionCommand("addMarqRel");

		addConcept.addActionListener(mig);
		addCirconstant.addActionListener(mig);
		switchView.addActionListener(mig);
		addMarqRel.addActionListener(mig);

		JPanel buttonPanelUp3 = new JPanel(new GridBagLayout());
		buttonPanelUp3.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Unités"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		select2SE(buttonPanelUp3, addConcept, addCirconstant, switchView, addMarqRel);
		
		

		// Put all Together (Everybody need somebody)
		buttonPane.add(buttonPanelUp);
		buttonPane.add(buttonPanelUp2);
//		buttonPane.add(buttonPanelUp3);
		// buttonPane.add(buttonPanelMidle);

		// buttonPane.setBorder(BorderFactory.createCompoundBorder(
		// BorderFactory.createTitledBorder("Contrôle"),
		// BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		centerMiddle.add(buttonPane, BorderLayout.CENTER);

		
		
		
		
		// Create a text pane.
		JPanel middleValid_Comment = new JPanel(new GridLayout());

		
		// CommentPane
		JPanel commentPane = new JPanel(new GridLayout(0, 1));
		commentPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Statut de la SE"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		hackInfo(commentPane);
		
		
		

		middleValid_Comment.add(commentPane);
//		middleValid_Comment.add(validPane);
		middleValid_Comment.add(buttonPanelUp3);
		centerMiddle.add(middleValid_Comment, BorderLayout.SOUTH);

		/**
		 * Bottom - Contrôle
		 */
		JPanel centerBottom = new JPanel(new GridLayout(0, 1));

		// 2.1 Information
		JPanel information = new JPanel(new GridBagLayout());


		// 2.1.2
		JPanel details = new JPanel();
		details.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Détails"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		// JLabel myExLabel2 = new JLabel("Utilisateur : annot1");
		// details.add(myExLabel2);

		// information.add(details);

		JPanel bottom = new JPanel(new GridLayout(0, 1));
		bottom.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Contrôle"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		// Add Components to this container, using the default FlowLayout.
		bottom.add(information);

		// Add.
		// controlBox.add(checkBoxRelation, BorderLayout.NORTH);
//		centerBottom.add(bottom, BorderLayout.CENTER);

		// this.add(controlBox);
		// this.setBorder(BorderFactory.createCompoundBorder(
		// BorderFactory.createTitledBorder("Structure énumérative"),
		// BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		// Put together!
		
//		this.add();
		
		JSplitPane jsp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				centerUp, centerMiddle);
		jsp1.setOneTouchExpandable(true);

		this.add(jsp1);
//		JSplitPane jsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, centerUp,
//				jsp1);
//		jsp2.setOneTouchExpandable(true);
//		this.add(jsp2);

		int iSliderPos = 99;
		((JSplitPane) jsp1).setDividerSize(6);
		((JSplitPane) jsp1).setContinuousLayout(true);
		((JSplitPane) jsp1).setResizeWeight((iSliderPos * 0.01)); // VERY
																	// IMPORTANT!!!
		((JSplitPane) jsp1).setDividerLocation((iSliderPos * 0.01));

//		int iSliderPosBottom = 99;
//		((JSplitPane) jsp2).setDividerSize(6);
//		((JSplitPane) jsp2).setContinuousLayout(true);
//		((JSplitPane) jsp2).setResizeWeight((iSliderPosBottom * 0.01)); // VERY
//																		// IMPORTANT!!!
//		((JSplitPane) jsp2).setDividerLocation((iSliderPosBottom * 0.01));
	}

	public static void select3SE(JPanel mainFrame, JButton button1) {

	}

	public static void select2SE(JPanel mainFrame, JButton button1,
			JButton button2, JButton button3, JButton button4) {

		GridBagConstraints gbc = new GridBagConstraints();
		// button1.setPreferredSize(dimension);
		// button2.setPreferredSize(dimension);
		// button3.setPreferredSize(dimension);
		// button4.setPreferredSize(dimension);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets.top = 10;
		gbc.insets.right = 10;

		/* ajout du premier bouton. */
		gbc.gridx = gbc.gridy = 0;
		mainFrame.add(button1, gbc);
		gbc.fill = GridBagConstraints.BOTH;
		/* ajout du second bouton. */
		gbc.gridx = 0;
		gbc.gridy = 1;
		mainFrame.add(button3, gbc);
		gbc.fill = GridBagConstraints.BOTH;
		/* ajout du troisieme bouton. */
		gbc.gridx = 1;
		gbc.gridy = 0;
		mainFrame.add(button2, gbc);
		gbc.fill = GridBagConstraints.BOTH;
		/* ajout du dernier bouton. */
		gbc.gridx = 1;
		gbc.gridy = 1;
		mainFrame.add(button4, gbc);
	}

	public static void selectSE(JPanel mainFrame, JButton button1,
			JButton button2, JButton button3, JButton button4) {

		/*
		 * 3- Ajout de ces composants en spécifiant les contraintes de type
		 * GridBagConstraints.
		 */
		// Dimension dimension = new Dimension(80, 100);

		GridBagConstraints gbc = new GridBagConstraints();
		// button1.setPreferredSize(dimension);
		// button2.setPreferredSize(dimension);
		// button3.setPreferredSize(dimension);
		// button4.setPreferredSize(dimension);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets.top = 10;
		gbc.insets.right = 10;

		/* ajout du premier bouton. */
		gbc.gridx = gbc.gridy = 0;
		mainFrame.add(button1, gbc);
		gbc.fill = GridBagConstraints.BOTH;
		/* ajout du second bouton. */
		gbc.gridx = 0;
		gbc.gridy = 1;
		mainFrame.add(button2, gbc);
		gbc.fill = GridBagConstraints.BOTH;
		/* ajout du troisieme bouton. */
		gbc.gridx = 1;
		gbc.gridy = 1;
		mainFrame.add(button3, gbc);
		gbc.fill = GridBagConstraints.BOTH;
		/* ajout du dernier bouton. */
		gbc.gridx = 1;
		gbc.gridy = 0;
		mainFrame.add(button4, gbc);
	}
	
	
	public void hackInfo(JPanel jpanel){
		
		GridBagConstraints gbc = new GridBagConstraints();

		/* a- ajout du label contenant le matricule. */
		gbc.gridx = gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // gbc.gridheight = 1;
		gbc.insets = new Insets(10, 5, 0, 0);
		/*
		 * Le point d'ancrage ici n'a pas une grande importance. Nous allons
		 * quand m�me essayer d'aligner tout les composants qui le peuvent sur
		 * leur ligne de base.
		 */
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		
		
		primer_info = new JLabel("Amorce :");
		jpanel.add(primer_info, gbc);
		
		nbrItems_info = new JLabel("Items :");
		jpanel.add(nbrItems_info, gbc);
		
		axe_visuel_info = new JLabel("Axe visuel :");
		jpanel.add(axe_visuel_info, gbc);
		
		axe_rheto_info= new JLabel("Axe rhéto :");
		jpanel.add(axe_rheto_info, gbc);
		
		axe_intentionnel_info= new JLabel("Axe inten :");
		jpanel.add(axe_intentionnel_info, gbc);
		
		axe_sem_info = new JLabel("Axe sem :");
		jpanel.add(axe_sem_info, gbc);
		
		
	}
}
