package jxplore;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;

public class JXTreeView extends JXploreView implements MouseListener{
	
	private static final long serialVersionUID = 0;
	private JTree fileTree;
	private JScrollPane scrollPane;
	private JXTreeRenderer treeRenderer;
	
	public JXTreeView(){
		
	}
	
	public void createTree() {
		JXploreFile root = new JXploreFile();
		fileTree = new JTree(root);
		treeRenderer = new JXTreeRenderer();
		scrollPane = new JScrollPane(fileTree);
		this.setLayout(new BorderLayout());
		this.add(scrollPane);
		fileTree.setCellRenderer(treeRenderer);
		fileTree.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2)	
		{
			data.updateGUI();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public class JXTreeRenderer extends DefaultTreeCellRenderer {

		  private static final long serialVersionUID = 1L;
		  
		  @Override
			public Component getTreeCellRendererComponent(JTree tree, Object value,boolean selected, boolean expanded, boolean leaf, int row,boolean hasFocus) {
				TreeNode entry = (TreeNode) value;
				JXploreFile file = (JXploreFile) entry;
				
			    this.setIcon(file.getIcon());
				this.setText(file.getName());
				 
				return this;
			}

		 

	}
}
