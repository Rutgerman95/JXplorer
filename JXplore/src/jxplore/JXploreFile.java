package jxplore;

import java.io.File;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;

public class JXploreFile {

	private File file;
	private JXploreFile[] fileCollection;
	
	public JXploreFile(){
		this.file = FileSystemView.getFileSystemView().getRoots()[0];
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
	
	private void initChilderen() {
		fileCollection = getAllItems(false);
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
	
	private JXploreFile[] makeFiles(File[] input) {
		JXploreFile[] output = new JXploreFile[input.length];
		for (int index = 0; index < input.length; index++) {
			output[index] = new JXploreFile(input[index]);
		}
		return output;
	
	}
	private JXploreFile[] getAllItems(boolean needFiles) {
		if (needFiles == false) {
			JXploreFile[] childFilesAndFolders = getSubFiles();
			ArrayList<JXploreFile> dirList = new ArrayList<JXploreFile>();
			for (JXploreFile iterationFile : childFilesAndFolders) {
				if (iterationFile.isFolder()) {
					dirList.add(iterationFile);
				}
			}
			return dirList.toArray(new JXploreFile[dirList.size()]);
		}
		if (needFiles == true) {
			return makeFiles(FileSystemView.getFileSystemView().getFiles(file,false));
		} else {
			return new JXploreFile[0];
		}
	}
	
	public JXploreFile[] getSubFiles(){
		return getAllItems(true);
	}
	
	public JXploreFile[] getSubFolders() {
		if (fileCollection == null && !file.isFile()) {
			initChilderen();
		}
		return fileCollection;
	}
}
