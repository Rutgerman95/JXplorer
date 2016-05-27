package jxplore;

import javax.swing.JLabel;

public class JXStatusView extends JXploreView {
	
	private static final long serialVersionUID = 0;
	private JLabel statusLabel;
	private int fileCount;
	
	public JXStatusView(){
		JXploreFile root = new JXploreFile();
		fileCount = root.getSubFiles().length;
		statusLabel = new JLabel(fileCount + " Files");
		this.add(statusLabel);
	}

}



