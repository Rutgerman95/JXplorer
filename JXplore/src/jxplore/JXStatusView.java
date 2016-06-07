package jxplore;

import javax.swing.JLabel;

public class JXStatusView extends JXploreView {
	
	private static final long serialVersionUID = 0;
	private JLabel statusLabel;
	private String text;
	
	public JXStatusView(){
		statusLabel = new JLabel("");
		this.add(statusLabel);
	}
	
	//Vult de statusbalk en werkt deze bij
	public void getStatus(){ 
		text = data.getCurrentFile().getChildCount() + " Files|Location: " + data.getCurrentFile().getName();
		statusLabel.setText(text);
	}

}



