package jxplore;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JXTreeView extends JPanel {
	
	private static final long serialVersionUID = 0;
	private JList<JXploreFile> fileList;
	private JXplorer data;
	private JXTreeCellRenderer treeRenderer;
	private JScrollPane scrollPane;
	
	public JXTreeView(){
		fileList = new JList<JXploreFile>();
		treeRenderer = new JXTreeCellRenderer();
		scrollPane = new JScrollPane(fileList);
		this.add(scrollPane);
		
	}

	public class JXTreeCellRenderer extends DefaulTreeCellRenderer {

		  private static final long serialVersionUID = 0;
	}
}
