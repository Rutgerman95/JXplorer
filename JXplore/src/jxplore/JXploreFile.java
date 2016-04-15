package jxplore;

import java.io.File;

import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;

public class JXploreFile {

	private File file;
	
	public JXploreFile(){
		this.file = FileSystemView.getFileSystemView().getHomeDirectory();
	}
	
	public JXploreFile(String name){
		file = new File(name);
	}
	
	public JXploreFile(File file){
		this.file = file;
	}
	
	public File getFile(){
		return file;
	}
	
	
	public String getName(){
		return FileSystemView.getFileSystemView().getSystemDisplayName(file);
	}
	
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
}
