package jxplore;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeCellRenderer;

public class JXTreeView extends JPanel {
	
	private static final long serialVersionUID = 0;
	private JList<JXploreFile> fileList;
	private JXplorer data;
	private JTree tree;
	private TreeSelectionListener tsl;
	private JXTreeCellRenderer treeRenderer;
	private JScrollPane scrollPane;
	
	public JXTreeView(){
		fileList = new JList<JXploreFile>();
		tree = new JTree();
		treeRenderer = new JXTreeCellRenderer();
		scrollPane = new JScrollPane(fileList);
		this.add(scrollPane);
		
	}
	
	public JPanel getViewPanel(){
		return this;
	}
	
	public JXplorer getData() {
		return  data;
	}
	
	public void setData(JXplorer data){
		this.data = data;
	}
	
	public void createTree() {
		//tree.setTreeData(data.getCurrentFile().getSubFiles());
		tree.setCellRenderer(treeRenderer);
		tree.addTreeSelectionListener(tsl);
		
	}

	public class JXTreeCellRenderer implements TreeCellRenderer {

		private static final long serialVersionUID = 0;

		@Override
		public Component getTreeCellRendererComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4,
				int arg5, boolean arg6) {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
