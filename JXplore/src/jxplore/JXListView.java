package jxplore;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class JXListView extends JXploreView implements MouseListener {
	
	private static final long serialVersionUID = 0;
	private JList<JXploreFile> fileList;
	private JXListCellRenderer listRenderer;
	private JScrollPane scrollPane;
	
	
	public JXListView(){
		fileList = new JList<JXploreFile>();
		scrollPane = new JScrollPane(fileList);
		listRenderer = new JXListCellRenderer();
		this.setLayout(new BorderLayout());
		this.add(scrollPane);
		
	}
	
	public void createList() {
		fileList.setListData(data.getCurrentFile().getSubFiles());
		fileList.setCellRenderer(listRenderer);
		fileList.addMouseListener(this);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2)	
		{
			data.setCurrentFile(fileList.getSelectedValue());
			data.updateGUI();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
