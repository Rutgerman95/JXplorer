package jxplore;

import javax.swing.JFrame;

public class JXplorer {
	
	private JXploreFile currentFile;
	
	public static void main(String[] args){
		JXplorer app = new JXplorer();
		app.buildGUI();
	}
	
	private void buildGUI(){
		JXAdressView adressView = new JXAdressView();	
		adressView.setData(null);
		JFrame frame = new JFrame();
		frame.setContentPane(adressView.getViewPanel());
		//GroupLayout layout = new GroupLayout(JXAdressView.container);
		//JXAdressView.container.setLayout(layout);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
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
	
	public void setCurrentFile(JXploreFile currentFile){
		this.currentFile = currentFile;
	}
	
	public void printName(JXploreFile currentFile){
		System.out.println(currentFile);
	}
		
	public void printSubFiles(JXploreFile currentSubFile){
		System.out.println(currentSubFile);
	}
	
	public void printSubFolders(JXploreFile currentFolder){
		System.out.println(currentFolder);
	}
}	
