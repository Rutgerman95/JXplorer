package jxplore;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class JXTreeView extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 0;
	private JTree fileTree;
	private JXplorer data;
	private JScrollPane scrollPane;
	private JXTreeRenderer treeRenderer;
	
	public JXTreeView(){
		
	}
	
	public JXplorer getData()
	{
		return data;
	}
	
	public void setData(JXplorer data)
	{
		this.data = data;
	}
	
	public void createTree() {
		JXploreFile root = new JXploreFile();
		fileTree = new JTree(root);
		treeRenderer = new JXTreeRenderer();
		scrollPane = new JScrollPane(fileTree);
		this.add(scrollPane);
		fileTree.setCellRenderer(treeRenderer);
		fileTree.addMouseListener(this);
	}
	
	public JPanel getViewPanel(){
		return this;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2)	
		{
			//data.setCurrentFile(fileList.getSelectedValue());
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

		  private static final long serialVersionUID = 0;

//		  @Override
//		  public Component getListCellRendererComponent(JList<?> list,
//		    Object value, int index, boolean isSelected, boolean cellHasFocus) {
//		   Component result = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//		   
//		   JLabel label = (JLabel) result;
//		   
//		   if (value instanceof JXploreFile) {
//		    JXploreFile data = (JXploreFile) value;
//		    
//		    label.setText(data.getName());
//		    label.setIcon(data.getIcon());
//		 	}
//		  return label;
//		 }

	}
}
