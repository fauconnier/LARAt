package melodi.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import melodi.view.listener.Listener_CenterTextPane;
import melodi.view.listener.Listener_LeftTextPane;
import melodi.view.listener.Listener_MenuBar;
import melodi.zcontroler.LaratControler;

public class LaratView extends JFrame {

	private LaratControler controler;
	private JPanel larat_ParentPanel;
	
	/**
	 * Panel 
	 */
	private Larat_LeftPanel leftPanel;
	private Larat_CenterPanel centerPanel;
	private Larat_RightPanel rightPanel;

	/**
	 * Pane
	 */
	private JTextPane leftTextPane;
	private JTextPane centerTextPane;

	/**
	 * Constructor
	 */
	public LaratView(LaratControler controler) {
		// Initialize controler
		this.controler = controler;
		
		// Configure view
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		this.setSize(1280, 800);
		this.setTitle("LARAt : R1.1.5b");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.addMenu();
		
		// Add Panels
		this.initComposant();
		this.setContentPane(larat_ParentPanel);
		
		// Visible
		this.setVisible(true);
	}
	
	
	private void initComposant(){
		
		larat_ParentPanel =  new JPanel();
		larat_ParentPanel.setLayout(new GridLayout(1, 3));
		
		// leftPanel
		leftPanel = new Larat_LeftPanel(controler);
		
		// centerPanel
		centerPanel = new Larat_CenterPanel(controler);
		
		// rightPanel
		rightPanel = new Larat_RightPanel(controler);

		// Merge leftPanel and centerPanel
		JSplitPane left_center_splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				leftPanel, centerPanel);
		left_center_splitPanel.setOneTouchExpandable(true);
		left_center_splitPanel.setResizeWeight(0.90);
		larat_ParentPanel.add(left_center_splitPanel);

		// Add rightPanel
		JSplitPane all_panels_splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				left_center_splitPanel, rightPanel);
		all_panels_splitPane.setOneTouchExpandable(true);
		all_panels_splitPane.setResizeWeight(0.999);

		larat_ParentPanel.add(all_panels_splitPane);
	}

	
	
	
	
	/**
	 * Update View from Larat_Model
	 */
	public void update() {
		
	}

	
	
	

	/**
	 * Add menu bar to LaratView
	 */
	private void addMenu() {
		
		// menuBar and Listener
		JMenuBar menuBar = new JMenuBar();
		Listener_MenuBar menuListener = new Listener_MenuBar(controler);

		// Menu 'File'
		JMenu menuFile = new JMenu("File");
		menuFile.addMenuListener(menuListener);
		menuBar.add(menuFile);

		JMenuItem itemOpenFile = new JMenuItem("Open a file", KeyEvent.VK_O);
		itemOpenFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.ALT_MASK));
		itemOpenFile.addActionListener(menuListener);
		menuFile.add(itemOpenFile);

		JMenuItem itemSaveFile = new JMenuItem("Save", KeyEvent.VK_S);
		itemSaveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.ALT_MASK));
		itemSaveFile.addActionListener(menuListener);
		menuFile.add(itemSaveFile);
		
		menuFile.addSeparator();

		JMenuItem itemQuit = new JMenuItem("Quit", KeyEvent.VK_Q);
		itemQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.ALT_MASK));
		menuFile.add(itemQuit);
		itemQuit.addActionListener(menuListener);

		// Menu "Credits"
		JMenu menuCredit = new JMenu("Credits");
		menuCredit.setMnemonic(KeyEvent.VK_N);
		menuBar.add(menuCredit);

		JMenuItem itemAbout = new JMenuItem("About", KeyEvent.VK_T);
		itemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.ALT_MASK));
		menuCredit.add(itemAbout);
		itemAbout.addActionListener(menuListener);

		// Add Menu bar to LaratView
		this.setJMenuBar(menuBar);
	}



}
