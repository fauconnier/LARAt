package melodi.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class Tree_NodeSelectionListener extends MouseAdapter {
    JTree tree;
    
    Tree_NodeSelectionListener(JTree tree) {
      this.tree = tree;
    }
    
    public void mouseClicked(MouseEvent e) {
        
        
    	
      int x = e.getX();
      int y = e.getY();
      int row = tree.getRowForLocation(x, y);
      TreePath  path = tree.getPathForRow(row);
      //TreePath  path = tree.getSelectionPath();
      if (path != null) {
        Tree_CheckNode node = (Tree_CheckNode)path.getLastPathComponent();
        boolean isSelected = ! (node.isSelected());
        node.setSelected(isSelected);
        if (node.getSelectionMode() == Tree_CheckNode.DIG_IN_SELECTION) {
          if ( isSelected) {
            tree.expandPath(path);
          } else {
            tree.collapsePath(path);
          }
        }
        ((DefaultTreeModel) tree.getModel()).nodeChanged(node);
        // I need revalidate if node is root.  but why?
        if (row == 0) {
          tree.revalidate();
          tree.repaint();
        }
      }
      
//      JEditorPane editor = (JEditorPane) e.getSource();
//      Point pt = new Point(e.getX(), e.getY());
//      int pos = editor.viewToModel(pt);
//      // whatever you need to do here
//      System.out.println(pos);
    }
  }
