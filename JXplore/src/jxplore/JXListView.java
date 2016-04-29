package jxplore;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JXListView extends JPanel {
	
	private static final long serialVersionUID = 0;
	private JList<JXploreFile> fileList;
	private JXplorer data;
	private JPanel viewPanel;
	private JXListCellRenderer listRenderer;
	private JScrollPane scrollPane;
	
	
	public JXListView(){
		viewPanel = new JPanel();
		fileList = new JList<JXploreFile>();
		listRenderer = new JXListCellRenderer();
		scrollPane = new JScrollPane(fileList);
		viewPanel.add(scrollPane);
		
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
	
	public void createList() {
		fileList.setListData(data.getCurrentFile().getSubFiles());
		fileList.setCellRenderer(listRenderer);
	}
	
	public class JXListCellRenderer extends DefaultListCellRenderer {

		  private static final long serialVersionUID = 0;

		  @Override
		  public Component getListCellRendererComponent(JList<?> fileList,
		    Object value, int index, boolean isSelected, boolean cellHasFocus) {
		   Component result = super.getListCellRendererComponent(fileList, value, index, isSelected, cellHasFocus);
		   
		   JLabel label = (JLabel) result;
		   
		   if (value instanceof JXploreFile) {
		    JXploreFile data = (JXploreFile) value;
		    
		    label.setText(data.getName());
		    label.setIcon(data.getIcon());
		   }
		   return label;
		  }
	}   
}
