package jxplore;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JXStatusView extends JPanel {
	
	private static final long serialVersionUID = 0;
	private JXplorer data;
	private JLabel statusLabel;
	private int fileCount;
	
	public JXStatusView(){
		JXploreFile root = new JXploreFile();
		fileCount = root.getSubFiles().length;
		statusLabel = new JLabel(fileCount + " Files");
		this.add(statusLabel);
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

}


