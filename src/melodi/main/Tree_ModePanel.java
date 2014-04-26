package melodi.main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class Tree_ModePanel extends JPanel implements ActionListener {
	Tree_CheckNode[] nodes;

    JRadioButton b_single, b_dig_in;

    public Tree_ModePanel(Tree_CheckNode[] nodes) {
      this.nodes = nodes;
      setLayout(new GridLayout(2, 1));
      setBorder(new TitledBorder("Check Mode"));
      ButtonGroup group = new ButtonGroup();
      add(b_dig_in = new JRadioButton("DIG_IN  "));
      add(b_single = new JRadioButton("SINGLE  "));
      group.add(b_dig_in);
      group.add(b_single);
      b_dig_in.addActionListener(this);
      b_single.addActionListener(this);
      b_dig_in.setSelected(true);
    }

    public void actionPerformed(ActionEvent e) {
      int mode;
      if (b_single == e.getSource()) {
        mode = Tree_CheckNode.SINGLE_SELECTION;
      } else {
        mode = Tree_CheckNode.DIG_IN_SELECTION;
      }
      for (int i = 0; i < nodes.length; i++) {
        nodes[i].setSelectionMode(mode);
      }
    }
  }
