package jxplore;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.TreeNode;

public class JXploreFile implements TreeNode{

	private File file;
	private JXploreFile[] foldersCache;
	
	public JXploreFile(){
		this.file = FileSystemView.getFileSystemView().getHomeDirectory();
	}
	
	//Maakt een nieuw bestand aan
	public JXploreFile(String name){
		file = new File(name);
	}
	
	//Definieert een nieuw bestand
	public JXploreFile(File file){
		this.file = file;
	}
	
	public File getFile(){
		this.initCache();
		this.getCache();
		return file;
	}
	
	
	public String getName(){
		return FileSystemView.getFileSystemView().getSystemDisplayName(file);
	}
	
	//Geeft het bestandspad terug
	public String getPath(){
		return file.getAbsolutePath();
	}
	
	
	public Icon getIcon(){
		return FileSystemView.getFileSystemView().getSystemIcon(this.file);
	}
	
	public boolean isFolder() {
		return !file.isFile();
	}
	
	
	public JXploreFile[] getSubFiles()
	{
		JXploreFile[] subFiles;
		if(file.listFiles() == null)
		{
			subFiles = new JXploreFile[0];
		}
		else
		{
			File[] files = file.listFiles();
			subFiles = new JXploreFile[files.length];
			int i = 0;
			for(File f : files)
			{
				subFiles[i] = new JXploreFile(f);
				i++;
			}
		}
		return subFiles;
	}
	
	public JXploreFile[] getSubFolders()
	{
		JXploreFile[] subFolders;
		if(file.listFiles() == null)
		{
			subFolders = new JXploreFile[0];
		}
		else
		{
			File[] files = file.listFiles();
			int n = 0;
			for(File f : files)
			{
				if(f.isDirectory())
				{
					n++;
				}
			}
			subFolders = new JXploreFile[n];
			int i = 0;
			for(File f : files)
			{
				if(f.isDirectory())
				{
					subFolders[i] = new JXploreFile(f);
					i++;
				}
			}
		}
		return subFolders;	
	}

	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		TreeNode x = getSubFiles()[arg0];
		return x;
	}

	@Override
	public int getChildCount() {
		int i = this.getSubFiles().length;
		return i;
	}

	@Override
	public int getIndex(TreeNode arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}	
	
	//Vult de foldersCache array
	private void initCache(){
		foldersCache = getAllItems(true);
	}
	
	private JXploreFile[] getCache(){
		return foldersCache;
	}
	
	//Verzamelt bestandenv voor de initCache() methode
	private JXploreFile[] getAllItems(boolean filesNeeded) {
		if (filesNeeded == false) {
			JXploreFile[] childFilesAndFolders = getSubFiles();
			ArrayList<JXploreFile> directoryList = new ArrayList<JXploreFile>();
			for (JXploreFile iterationFile : childFilesAndFolders) {
				if (iterationFile.isFolder()) {
					directoryList.add(iterationFile);
				}
			}
			return directoryList.toArray(new JXploreFile[directoryList.size()]);
		}
		if (filesNeeded == true) {
			return makeFiles(FileSystemView.getFileSystemView().getFiles(file, false));
		} else {
			return new JXploreFile[0];
		}
	}
	
	private JXploreFile[] makeFiles(File[] input) {
		JXploreFile[] output = new JXploreFile[input.length];
		for (int index = 0; index < input.length; index++) {
			output[index] = new JXploreFile(input[index]);
		}
		return output;
	}
}
