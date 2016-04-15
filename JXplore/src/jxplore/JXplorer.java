package jxplore;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class JXplorer {
	
	public JXploreFile currentFile;
	public JPanel contentPanel;
	public JSplitPane splitPane;
	
	public static void main(String[] args){
		JXplorer app = new JXplorer();
		app.buildGUI();
	}
		
	public JXplorer(){
		currentFile = new JXploreFile();
	}
	
	public JXplorer(JXploreFile file){
		currentFile = file;
	}
	
	public JXploreFile getCurrentFile() {
		return currentFile;
	}
	
	public void setCurrentFile(JXploreFile newFile){
		this.currentFile = newFile;
	}
	
	public void printName(JXploreFile currentFile){
		System.out.println(currentFile);
	}
		
	public void printSubFiles(JXploreFile currentSubFile){
		JXploreFile[] subFiles = currentFile.getSubFiles();
		if (subFiles.length == 0)
		{
			System.out.println("this file is not a directory or doesnt contain any files");
		}
		else
		{
			String files = "the files in this directory are: ";
			for(JXploreFile f : subFiles)
			{
				files += f.getName()+ "\n";
			}
			System.out.println(files);
		}
	}
	
	public void printSubFolders(JXploreFile currentFolder){
		
			JXploreFile[] subFolders = currentFile.getSubFolders();
			if (subFolders.length == 0)
			{
				System.out.println("this file is not a directory or doesnt contain any folders");
			}
			else
			{
				String folders = "the folders in this directory are: ";
				for(JXploreFile f : subFolders)
				{
					folders += f.getName()+ "\n";
				}
				System.out.println(folders);
			}
		}
	private void buildGUI(){
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		
		
		JXAdressView adressView = new JXAdressView();
		adressView.setData(this);
		JPanel a = adressView.getViewPanel();
		
		JXListView listView = new JXListView();
		listView.setData(this);
		listView.createList();
		JPanel l =listView.getViewPanel();
		
		contentPanel.add(a, BorderLayout.NORTH);
		contentPanel.add(new JLabel("JXStatus"), BorderLayout.SOUTH);
		splitPane = new JSplitPane(1, new JLabel("JXTreeView"), l);
		contentPanel.add(splitPane, BorderLayout.CENTER);
		
		//GroupLayout layout = new GroupLayout(JXAdressView.container);
		//JXAdressView.container.setLayout(layout);
		
		JFrame frame = new JFrame();
		frame.setContentPane(contentPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}	
