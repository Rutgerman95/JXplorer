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
	
	public static JPanel viewPanel;
	
	public static Container container;
	
	
	public JXAdressView(){
		viewPanel = new JPanel();
		adressLabel = new JLabel("Adress");
		adressTextField = new JTextField("", 30);
		goButton = new JButton("Go");
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
