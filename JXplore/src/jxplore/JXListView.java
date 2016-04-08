package jxplore;

import javax.swing.JList;
import javax.swing.JPanel;

public class JXListView {
	
	private JList<JXploreFile> fileList;
	private JXplorer data;
	private JPanel viewPanel;
	public JXploreFile currentFile;
	
	public void JXAdressView(){
		currentFile = JXplorer.currentFile;
		fileList = new JList<JXploreFile>();
		
	}
	
	public JPanel getViewPanel(){
		return viewPanel;
	}
}
