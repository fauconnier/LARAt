package melodi.main;

import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;

public class Tree_CheckNode extends DefaultMutableTreeNode {

	  public final static int SINGLE_SELECTION = 0;

	  public final static int DIG_IN_SELECTION = 4;

	  protected int selectionMode;

	  protected boolean isSelected;

	  public Tree_CheckNode() {
	    this(null);
	  }

	  public Tree_CheckNode(Object userObject) {
	    this(userObject, true, false);
	  }

	  public Tree_CheckNode(Object userObject, boolean allowsChildren,
	      boolean isSelected) {
	    super(userObject, allowsChildren);
	    this.isSelected = isSelected;
	    setSelectionMode(DIG_IN_SELECTION);
	  }

	  public void setSelectionMode(int mode) {
	    selectionMode = mode;
	  }

	  public int getSelectionMode() {
	    return selectionMode;
	  }

	  public void setSelected(boolean isSelected) {
	    this.isSelected = isSelected;

	    if ((selectionMode == DIG_IN_SELECTION) && (children != null)) {
	      Enumeration e = children.elements();
	      while (e.hasMoreElements()) {
	        Tree_CheckNode node = (Tree_CheckNode) e.nextElement();
	        node.setSelected(isSelected);
	      }
	    }
	  }

	  public boolean isSelected() {
	    return isSelected;
	  }

	  // If you want to change "isSelected" by CellEditor,
	  /*
	   public void setUserObject(Object obj) { if (obj instanceof Boolean) {
	   * setSelected(((Boolean)obj).booleanValue()); } else {
	   * super.setUserObject(obj); } }
	   */

}
