package jxplore;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JXAdressView extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 0;	
	private JLabel adressLabel;	
	private JButton goButton;
	private JXplorer data;
	//private JLabel iconLabel;
	
	public static JPanel viewPanel;
	public static Container container;
	public JTextField adressTextField;
	
	public JXAdressView(){
		viewPanel = new JPanel();
		adressLabel = new JLabel("Adress");
		adressTextField = new JTextField("", 30);
		goButton = new JButton("Go");
		goButton.addActionListener(this);
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
	
	public void actionPerformed(ActionEvent c)	{
		String t = adressTextField.getText();
		JXploreFile file = new JXploreFile(t);
		data.setCurrentFile(file);
		data.updateGUI();
	}
}
