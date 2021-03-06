package jxplore;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class JXplorer {
	
	public JXploreFile currentFile;
	public JPanel contentPanel;
	public JSplitPane splitPane;
	public JFrame frame;
	
	//Initialiseert de app
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
	
	//Zet de GUI op
	public void buildGUI(){
		frame = new JFrame("JXplorer: Browse your files with Java!");
		ImageIcon img = new ImageIcon("src/resource/Folder-icon.png");
		frame.setIconImage(img.getImage());
		updateGUI();
	}
	
	//Vult de view-klassen in de JFrame in en werkt de GUI bij
	public void updateGUI(){
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		
		JXListView listView = new JXListView();
		listView.setData(this);
		listView.createList();
		
		JXAdressView adressView = new JXAdressView();
		adressView.setData(this);
		adressView.updateAdress();
		
		JXTreeView treeView = new JXTreeView();
		treeView.setData(this);
		treeView.createTree();
		
		JXStatusView statusView = new JXStatusView();
		statusView.setData(this);
		statusView.getStatus();
		
		contentPanel.add(adressView, BorderLayout.NORTH);
		contentPanel.add(statusView, BorderLayout.SOUTH);
		splitPane = new JSplitPane(1, treeView, listView);
		contentPanel.add(splitPane, BorderLayout.CENTER);
		
		frame.setContentPane(contentPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}	
