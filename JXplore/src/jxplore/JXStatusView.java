package jxplore;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JXStatusView extends JPanel {
	
	private static final long serialVersionUID = 0;
	private JXplorer data;
	private JLabel statusLabel;
	
	public JXStatusView(){
		statusLabel = new JLabel("Aayyy Lmao");
		this.add(statusLabel);
	}

	public JPanel getViewPanel(){
		return this;
	}
	
	public JXplorer getData() {
		return  data;
	}
	
	public void setData(JXplorer data){
		this.data = data;
	}

}


