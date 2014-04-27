package melodi.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLDocument;

import melodi.view.listener.Listener_RightButtons;
import melodi.zcontroler.LaratControler;


public class Larat_RightPanel extends JPanel  {
	
	public JLabel annotation_id;
	public JLabel SE_int;
	public JLabel annotation_set_size;
//	public JTextPane alignPane;
	public HTMLDocument htmlDocTextPane;
	
	Listener_RightButtons rightButtonsListener;
	/**
	 * Pane
	 */
	public JEditorPane commentTextPane;
	// public JButton addConcept;

	JComboBox fonctionComboBox;
	
	public JButton previousButton;
	public JButton nextButton;
//	public JLabel SE_id_in_chain;
//	public JLabel chain_SE_size;
	/**
	 * Visuel
	 */
	public JRadioButton verticaleJRadio;
	public JRadioButton horizontaleJRadio;
	public JRadioButton hypertextualJRadio;
	public JRadioButton navigationnelJRadio;
	
	/**
	 * 
	 * Rhétorique
	 */
	public JRadioButton paradigmatique;
	public JRadioButton syntagmatique;
	public JRadioButton hybride;
	public JRadioButton bivalente;
	
	/**
	 * Intentionnel
	 */
	public JRadioButton descriptive;
	public JRadioButton narrative;
	public JRadioButton explicative;
	public JRadioButton prescriptive;
	public JRadioButton procedurale;
	public JRadioButton argumentative;
	public JRadioButton autre_intentionnel;
	
	/**
	 * Sémantique
	 */
	public JRadioButton isA;
	public JRadioButton partOf;
	public JRadioButton instanceOf;
	public JRadioButton ontologiqueAutre;
	
	public JRadioButton hyperonymie;
	public JRadioButton meronymie;
	public JRadioButton homonymie;
	public JRadioButton synonymie;
	public JRadioButton multilingue;
	public JRadioButton lexicalAutre;
	
	public JRadioButton semantiqueAutre;
	
	
	// Autre
	public JButton valid;
	
	/**
	 * Contexte
	 */
	public JRadioButton contextuelle;
	public JRadioButton non_contextuelle;

	public Larat_RightPanel(LaratControler controler) {
		
		
		this.rightButtonsListener = new Listener_RightButtons(controler);
		/*
		 * Rigth
		 */
		// JPanel rightPane = new JPanel(new GridLayout(0, 1));
		this.setLayout(new GridLayout(0, 1));
		
		// 1. Typologie
		JPanel typologyPane = new JPanel(new GridLayout(0, 1));
		typologyPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory
				.createTitledBorder(""),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		
		// 1.
		
		// 1.0.1 Axe visuel
		JPanel axe_visuel = new JPanel(new GridLayout(0, 1));
		verticaleJRadio = new JRadioButton("verticale");
		verticaleJRadio.setMnemonic(KeyEvent.VK_C);
		verticaleJRadio.setSelected(false);
		verticaleJRadio.addActionListener(rightButtonsListener);
		verticaleJRadio.setActionCommand("vertical");

		horizontaleJRadio = new JRadioButton("horizontale");
		horizontaleJRadio.setMnemonic(KeyEvent.VK_G);
		horizontaleJRadio.setSelected(false);
		horizontaleJRadio.addActionListener(rightButtonsListener);
		horizontaleJRadio.setActionCommand("horizon");

		hypertextualJRadio = new JRadioButton("hypertextuelle");
		hypertextualJRadio.setMnemonic(KeyEvent.VK_G);
		hypertextualJRadio.setSelected(false);
		hypertextualJRadio.addActionListener(rightButtonsListener);
		hypertextualJRadio.setActionCommand("hypertextual");

		navigationnelJRadio = new JRadioButton("navigationnelle");
		navigationnelJRadio.setMnemonic(KeyEvent.VK_G);
		navigationnelJRadio.setSelected(false);
		navigationnelJRadio.addActionListener(rightButtonsListener);
		navigationnelJRadio.setActionCommand("navigationnelle");

		axe_visuel.add(verticaleJRadio);
		axe_visuel.add(horizontaleJRadio);
		
		axe_visuel.add(hypertextualJRadio);
		axe_visuel.add(navigationnelJRadio);

		axe_visuel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Axe visuel"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		
		
		// 1.1 Rhétorique
		JPanel axe_rhetorique = new JPanel(new GridLayout(0, 1));
		axe_rhetorique.setBorder(BorderFactory.createCompoundBorder(BorderFactory
				.createTitledBorder("Axe rhétorique"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		paradigmatique = new JRadioButton("Paradigmatique");
		paradigmatique.setMnemonic(KeyEvent.VK_C);
		paradigmatique.setSelected(false);
		paradigmatique.addActionListener(rightButtonsListener);
		paradigmatique.setActionCommand("paradigmatique");
		
		syntagmatique = new JRadioButton("Syntagmatique");
		syntagmatique.setMnemonic(KeyEvent.VK_C);
		syntagmatique.setSelected(false);
		syntagmatique.addActionListener(rightButtonsListener);
		syntagmatique.setActionCommand("syntagmatique");
		
		hybride = new JRadioButton("Hybride");
		hybride.setMnemonic(KeyEvent.VK_C);
		hybride.setSelected(false);
		hybride.addActionListener(rightButtonsListener);
		hybride.setActionCommand("hybride");
		
		bivalente = new JRadioButton("Bivalente");
		bivalente.setMnemonic(KeyEvent.VK_C);
		bivalente.setSelected(false);
		bivalente.addActionListener(rightButtonsListener);
		bivalente.setActionCommand("bivalente");
		
		axe_rhetorique.add(paradigmatique);
		axe_rhetorique.add(syntagmatique);
		axe_rhetorique.add(hybride);
		axe_rhetorique.add(bivalente);
		
		
		
		
		// 1.2 Intentionnel
		JPanel axe_intentionnel = new JPanel(new GridLayout(0, 2));
		axe_intentionnel.setBorder(BorderFactory.createCompoundBorder(BorderFactory
				.createTitledBorder("Axe intentionnel"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		descriptive = new JRadioButton("descriptive");
		descriptive.setMnemonic(KeyEvent.VK_C);
		descriptive.setSelected(false);
		descriptive.addActionListener(rightButtonsListener);
		descriptive.setActionCommand("descriptive");
		
		narrative = new JRadioButton("narrative");
		narrative.setMnemonic(KeyEvent.VK_C);
		narrative.setSelected(false);
		narrative.addActionListener(rightButtonsListener);
		narrative.setActionCommand("narrative");
		
		explicative = new JRadioButton("explicative ");
		explicative .setMnemonic(KeyEvent.VK_C);
		explicative .setSelected(false);
		explicative .addActionListener(rightButtonsListener);
		explicative .setActionCommand("explicative");
		
		prescriptive = new JRadioButton("prescriptive");
		prescriptive.setMnemonic(KeyEvent.VK_C);
		prescriptive.setSelected(false);
		prescriptive.addActionListener(rightButtonsListener);
		prescriptive.setActionCommand("prescriptive");
		
		procedurale = new JRadioButton("procedurale");
		procedurale .setMnemonic(KeyEvent.VK_C);
		procedurale .setSelected(false);
		procedurale .addActionListener(rightButtonsListener);
		procedurale .setActionCommand("procedurale");
		
		argumentative = new JRadioButton("argumentative");
		argumentative .setMnemonic(KeyEvent.VK_C);
		argumentative .setSelected(false);
		argumentative .addActionListener(rightButtonsListener);
		argumentative.setActionCommand("argumentative");
		
		autre_intentionnel = new JRadioButton("autre intent.");
		autre_intentionnel.setMnemonic(KeyEvent.VK_C);
		autre_intentionnel .setSelected(false);
		autre_intentionnel .addActionListener(rightButtonsListener);
		autre_intentionnel.setActionCommand("autre_intentionnel");
		
		// descriptive, narrative, explicative, prescriptive, procédurale, argumentative
		// + Autre
		
		
		axe_intentionnel .add(descriptive);
		axe_intentionnel .add(narrative);
		axe_intentionnel .add(explicative);
		axe_intentionnel .add(prescriptive);
		axe_intentionnel.add(procedurale);
		axe_intentionnel.add(argumentative);
		axe_intentionnel.add(autre_intentionnel);
//		intentionnel.add(new JPanel(new GridLayout(0, 1)));
		
		
		// Fin de 1.0
		JPanel container = new JPanel(new GridLayout(1,1));
		JPanel container2 = new JPanel(new GridLayout(0, 1));
		
		container.add(axe_visuel);
		container.add(axe_rhetorique);
//		container2.add(rhetorique);
		container2.add(container);
		
		container2.add(axe_intentionnel);
		
//		rheto_intentionel.add(rhetorique);
//		rheto_intentionel.add(intentionnel);
		typologyPane.add(container2);
//		typologyPane.add(new JPanel(new GridLayout(0, )));
		
		
		// 2.
		JPanel axe_semantique = new JPanel(new GridLayout(0, 2));
		axe_semantique.setBorder(BorderFactory.createCompoundBorder(BorderFactory
				.createTitledBorder("Axe semantique"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		// 2.1 Visée_ontologique
		JPanel visee_ontologique = new JPanel(new GridLayout(0, 1));
		visee_ontologique.setBorder(BorderFactory.createCompoundBorder(BorderFactory
				.createTitledBorder("A visée ontologique"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		isA = new JRadioButton("isA");
		isA .setMnemonic(KeyEvent.VK_C);
		isA .setSelected(false);
		isA .addActionListener(rightButtonsListener);
		isA.setActionCommand("isA");
		
		partOf = new JRadioButton("partOf");
		partOf.setMnemonic(KeyEvent.VK_C);
		partOf.setSelected(false);
		partOf.addActionListener(rightButtonsListener);
		partOf.setActionCommand("partOf");
		
		instanceOf = new JRadioButton("instanceOf");
		instanceOf.setMnemonic(KeyEvent.VK_C);
		instanceOf.setSelected(false);
		instanceOf.addActionListener(rightButtonsListener);
		instanceOf.setActionCommand("instanceOf");
		
		ontologiqueAutre = new JRadioButton("ontologiqueAutre");
		ontologiqueAutre.setMnemonic(KeyEvent.VK_C);
		ontologiqueAutre.setSelected(false);
		ontologiqueAutre.addActionListener(rightButtonsListener);
		ontologiqueAutre.setActionCommand("ontologiqueAutre");
		
		visee_ontologique.add(isA);
		visee_ontologique.add(partOf);
		visee_ontologique.add(instanceOf);
		visee_ontologique.add(ontologiqueAutre);
		
		
		// 2.2 MétaLinguistique
		JPanel metalinguistique = new JPanel(new GridLayout(0, 1));
		metalinguistique.setBorder(BorderFactory.createCompoundBorder(BorderFactory
				.createTitledBorder("Metalinguistique"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		hyperonymie = new JRadioButton("hyperonymie");
		hyperonymie .setMnemonic(KeyEvent.VK_C);
		hyperonymie .setSelected(false);
		hyperonymie.addActionListener(rightButtonsListener);
		hyperonymie.setActionCommand("hyperonymie");
		
		meronymie = new JRadioButton("meronymie");
		meronymie .setMnemonic(KeyEvent.VK_C);
		meronymie .setSelected(false);
		meronymie.addActionListener(rightButtonsListener);
		meronymie.setActionCommand("meronymie");
		
		homonymie = new JRadioButton("homonymie");
		homonymie .setMnemonic(KeyEvent.VK_C);
		homonymie .setSelected(false);
		homonymie.addActionListener(rightButtonsListener);
		homonymie.setActionCommand("homonymie");
		
		synonymie = new JRadioButton("synonymie");
		synonymie .setMnemonic(KeyEvent.VK_C);
		synonymie .setSelected(false);
		synonymie.addActionListener(rightButtonsListener);
		synonymie.setActionCommand("synonymie");
		
		multilingue  = new JRadioButton("multilingue");
		multilingue .setMnemonic(KeyEvent.VK_C);
		multilingue .setSelected(false);
		multilingue.addActionListener(rightButtonsListener);
		multilingue.setActionCommand("multilingue");
		
		lexicalAutre = new JRadioButton("lexicalAutre");
		lexicalAutre  .setMnemonic(KeyEvent.VK_C);
		lexicalAutre  .setSelected(false);
		lexicalAutre .addActionListener(rightButtonsListener);
		lexicalAutre .setActionCommand("lexicalAutre");
		
		metalinguistique.add(hyperonymie);
		metalinguistique.add(meronymie);
		metalinguistique.add(homonymie);
		metalinguistique.add(synonymie);
		metalinguistique.add(multilingue);
		metalinguistique.add(lexicalAutre);
		
		
		
		
		// Fin 2.
		axe_semantique.add(visee_ontologique);
		axe_semantique.add(metalinguistique);
		typologyPane.add(axe_semantique);

		
		
		// 3
//		JPanel axe_semantique2 = new JPanel(new GridLayout(0, 2));
//		axe_semantique2.setBorder(BorderFactory.createCompoundBorder(BorderFactory
//				.createTitledBorder("Axe Sémantique"),
//				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		
		// 3.1 Autre sémantique
		JPanel autre_semantique = new JPanel(new GridLayout(0, 1));
		autre_semantique.setBorder(BorderFactory.createCompoundBorder(BorderFactory
				.createTitledBorder("Autre semantique"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		semantiqueAutre = new JRadioButton("semantiqueAutre");
		semantiqueAutre  .setMnemonic(KeyEvent.VK_C);
		semantiqueAutre  .setSelected(false);
		semantiqueAutre .addActionListener(rightButtonsListener);
		semantiqueAutre.setActionCommand("semantiqueAutre");
		
		autre_semantique.add(semantiqueAutre);
		
		axe_semantique.add(autre_semantique);
		
		
		
		// 3.2 Contextuelle
		JPanel contextuel = new JPanel(new GridLayout(0, 1));
		contextuel.setBorder(BorderFactory.createCompoundBorder(BorderFactory
				.createTitledBorder("Contexte"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		contextuelle = new JRadioButton("contextuelle");
		contextuelle .setMnemonic(KeyEvent.VK_C);
		contextuelle  .setSelected(false);
		contextuelle .addActionListener(rightButtonsListener);
		contextuelle.setActionCommand("contextuelle");
		
		non_contextuelle = new JRadioButton("non contextuelle");
		non_contextuelle .setMnemonic(KeyEvent.VK_C);
		non_contextuelle  .setSelected(false);
		non_contextuelle .addActionListener(rightButtonsListener);
		non_contextuelle.setActionCommand("non_contextuelle");
		
		contextuel.add(contextuelle);
		contextuel.add(non_contextuelle);
		
		axe_semantique.add(contextuel);
		
		

		
		// LE BAS
		/**
		 * Middle
		 */
		JPanel centerMiddle = new JPanel(new BorderLayout());
		JPanel middleValid_Comment = new JPanel(new GridLayout());

		JPanel validPane = new JPanel(new GridBagLayout());
		ImageIcon validIcon = new ImageIcon("resources/images/v.png");
		valid = new JButton(validIcon);
		valid.setVerticalTextPosition(AbstractButton.CENTER);
		valid.setHorizontalTextPosition(AbstractButton.RIGHT); // aka LEFT, for
		valid.setMnemonic(KeyEvent.VK_D);
		valid.setActionCommand("valid");
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		valid.addActionListener(rightButtonsListener);
		validPane.add(valid, gbc);

		JPanel commentPane = new JPanel(new GridLayout(0, 1));


		commentTextPane = new JEditorPane();
		JScrollPane paneScrollPane = new JScrollPane(commentTextPane);
		paneScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		paneScrollPane.setPreferredSize(new Dimension(10, 10));
		paneScrollPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Commentaire"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		commentPane.add(paneScrollPane);
		validPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Validation"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		middleValid_Comment.add(commentPane);
		middleValid_Comment.add(validPane);

		centerMiddle.add(middleValid_Comment);

		/**
		 * Bottom - Contrôle
		 */
		JPanel centerBottom = new JPanel(new GridLayout(0, 1));

		// 2.1 Information
		JPanel information = new JPanel(new GridBagLayout());

//		setDetailsPanel(information);

		JPanel details = new JPanel();
		details.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Détails"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		annotation_id = new JLabel("SE id : 0");
		details.add(annotation_id);
		annotation_set_size = new JLabel("SE chain: 0");
//		details.add(chain_SE_size);
		JPanel bottom = new JPanel(new GridLayout(0, 1));
		bottom.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Contrôle"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		bottom.add(information);
		centerBottom.add(bottom, BorderLayout.CENTER);

		
		// Ensemble
		JPanel container3 = new JPanel(new GridLayout(0,1));
		container3.add(centerMiddle);
		container3.add(centerBottom);
		typologyPane.add(container3);
		
		// Fin de tout
		this.add(typologyPane);

		
		
		
	}
	
	
	public void setDetailsPanel(JPanel mainFrame) {
		ImageIcon leftButtonIcon = new ImageIcon("resources/images/left.gif");
		ImageIcon rightButtonIcon = new ImageIcon("resources/images/right.gif");
		previousButton = new JButton("SE Prec.", leftButtonIcon);
		previousButton.setVerticalTextPosition(AbstractButton.CENTER);
		previousButton.setHorizontalTextPosition(AbstractButton.RIGHT); // aka
																		// LEFT,
																		// for
		previousButton.setMnemonic(KeyEvent.VK_D);
		previousButton.setActionCommand("previous");
		previousButton.setEnabled(false);

		nextButton = new JButton("SE Suiv.", rightButtonIcon);
		// Use the default text position of CENTER, TRAILING (RIGHT).
		nextButton.setHorizontalTextPosition(AbstractButton.LEFT);
		nextButton.setMnemonic(KeyEvent.VK_E);
		nextButton.setActionCommand("next");
		nextButton.setEnabled(false);

		// Listen for actions on buttons 1 and 3.
		previousButton.addActionListener(rightButtonsListener);
		nextButton.addActionListener(rightButtonsListener);

		previousButton.setToolTipText("Retourner à la SE précédente.");
		nextButton.setToolTipText("Avancer à la SE suivante.");

		JLabel nomLabel = new JLabel("ID SE :");
		JLabel prenomLabel = new JLabel("Nb. SE :");
		JLabel fonctionLabel = new JLabel("Opérateur :");
		// JLabel sexeLabel = new JLabel("Sexe :");
		// JLabel matriculeLabel = new JLabel("Details");

		fonctionComboBox = new JComboBox(new String[] { "Sophie", "Julien",
				"Autre" });

		// JRadioButton hommeRadioButton = new JRadioButton("Homme");
		// JRadioButton femmeRadioButton = new JRadioButton("Femme");
		// femmeRadioButton.setSelected(true);

		JSeparator separator = new JSeparator();

		/*
		 * 3- Ajout de ces composants en sp�cifiant les contraintes de type
		 * GridBagConstraints.
		 */
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
		// mainFrame.add(matriculeLabel, gbc);
		/* ************************************************************************************** */

		/*
		 * b- ajout de la zone pour la photo. nous avons utilis� une �tiquette
		 * pour cela.
		 */
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 4;
		/*
		 * Ici, nous ne voulons surement pas que le composant s'aligne sur la
		 * ligne de base. Il n'est pas cens� repr�sent� un �l�m�nt de texte mais
		 * bien une image. Nous allons donc utiliser la constance LINE_START.
		 */
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5, 5, 0, 0);
		// mainFrame.add(photoLabel, gbc);
		/* ************************************************************************************** */

		/* c- �tiquette contenant le nom. */
		gbc.gridx = gbc.gridy = gbc.gridwidth = gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 5, 0, 0);
		mainFrame.add(nomLabel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER; 
														// ligne.
		gbc.fill = GridBagConstraints.HORIZONTAL; // �talons le sur l'espace
													// disponible.
		gbc.insets = new Insets(3, 5, 0, 5); // laissons tout de m�me une marge
												// � droite.
		gbc.anchor = GridBagConstraints.BASELINE; // alignons le sur la m�me
													// ligne de base que son
													// �tiquette.
		mainFrame.add(annotation_id, gbc);

		gbc.gridx = gbc.gridwidth = gbc.gridheight = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 5, 0, 0);
		mainFrame.add(prenomLabel, gbc);


		gbc.gridx = gbc.gridy = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(3, 5, 0, 5);
		mainFrame.add(annotation_set_size, gbc);

		gbc.gridx = gbc.gridwidth = gbc.gridheight = 1;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		// gbc.insets = new Insets(0, 5, 0, 0);
		mainFrame.add(fonctionLabel, gbc);

		/* h- la liste d�roulante pour les fonctions. */
		gbc.gridx = 2;
		gbc.gridwidth = GridBagConstraints.RELATIVE; /*
													 * avant dernier composant
													 * de sa ligne
													 */
		gbc.weightx = 1.;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.BASELINE;
		// gbc.insets = new Insets(3, 5, 0, 0);
		mainFrame.add(fonctionComboBox, gbc);
		/* ************************************************************************************** */

		/*
		 * i- le bouton permettant (immaginaire) d'ajouter une fonction qui est
		 * inexistante dans la liste d�roulante.
		 */
		gbc.gridx = 4;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.weightx = 0.; // supprimons le poids.
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 3, 0, 5);
		// mainFrame.add(moreFunctionsButton, gbc);
		/* ************************************************************************************** */

		/* j- L'étiquette pour le sexe. */
		gbc.gridy = 4;
		gbc.gridx = gbc.gridwidth = gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(5, 5, 0, 0);
		// mainFrame.add(sexeLabel, gbc);
		/* ************************************************************************************** */

		/* k- le bouton radio pour l'option Homme. */
		gbc.gridx = 2;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 2, 0, 0);
		// mainFrame.add(hommeRadioButton, gbc);
		/* ************************************************************************************** */

		/* l- le bouton radio pour l'option Femme. */
		gbc.gridx = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		// mainFrame.add(femmeRadioButton, gbc);
		/* ************************************************************************************** */

		/* M- Un s�parateur. */
		gbc.gridy = 5;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(3, 5, 0, 5);
		mainFrame.add(separator, gbc);
		/* ************************************************************************************** */

		/* N- Le bouton permettant d'imprimer. */
		gbc.gridy = 6;
		gbc.gridheight = GridBagConstraints.REMAINDER; /*
														 * dernier composant de
														 * la colonne
														 */
		gbc.weighty = 1.;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		// gbc.insets = new Insets(3, 0, 5, 5);
		mainFrame.add(nextButton, gbc);

		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.gridheight = GridBagConstraints.REMAINDER; /*
														 * dernier composant de
														 * la colonne
														 */
		gbc.weighty = 1.;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		// gbc.insets = new Insets(3, 0, 5, 5);

		mainFrame.add(previousButton, gbc);

		// mainFrame.setLocationRelativeTo(null);
	}
}
