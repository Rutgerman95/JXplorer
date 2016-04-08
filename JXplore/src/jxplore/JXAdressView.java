package jxplore;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JXAdressView {
	
	private JLabel adressLabel;
	
	public JTextField adressTextField;
	
	private JButton goButton;
	
	private JXplorer data;
	
	//private JLabel iconLabel;
	
	private JPanel viewPanel;
	
	public static Container container;
	
	
	public JXAdressView(){
		viewPanel = new JPanel();
		adressLabel = new JLabel("adress");
		adressTextField = new JTextField("");
		goButton = new JButton("go");
		viewPanel.add(adressLabel);
		viewPanel.add(adressTextField);
		viewPanel.add(goButton);
	}
	
	public JPanel getViewPanel(){
		return viewPanel;
	}
	
	public JXplorer getData() {
		return  data;
	}
	
	public void setData(JXplorer data){
		this.data = data;
	}
	
	//public void actionPerformed(ActionEvent){
		//new action;
	//}
}
