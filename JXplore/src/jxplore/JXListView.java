package jxplore;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;

public class JXListView {
	
	private JList<JXploreFile> fileList;
	private JXplorer data;
	private JPanel viewPanel;
	private DefaultListModel<JXploreFile> listModel;
	public JXploreFile currentFile;
	public JXAdressView adressView;
	
	public void JXAdressView(){
		data = new JXplorer();
		fileList = new JList<JXploreFile>();
		listModel = new DefaultListModel<JXploreFile>();
		
	}
	
	public JPanel getViewPanel(){
		return viewPanel;
	}
	
	public JXplorer getData()
	{
		return data;
	}
	
	public void setData(JXplorer data)
	{
		this.data = data;
	}
}
