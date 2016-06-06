package jxplore;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JXAdressView extends JXploreView implements ActionListener {
	
	private static final long serialVersionUID = 0;	
	private JLabel adressLabel;	
	private JButton goButton;
	
	public static Container container;
	public JTextField adressTextField;
	
	public JXAdressView(){
		adressLabel = new JLabel("Adress");
		adressTextField = new JTextField("", 30);
		goButton = new JButton("Go");
		goButton.addActionListener(this);
		this.add(adressLabel);
		this.add(adressTextField);
		this.add(goButton);
	}
	
	
	public void actionPerformed(ActionEvent c)	{
		String t = adressTextField.getText();
		JXploreFile file = new JXploreFile(t);
		data.setCurrentFile(file);
		data.updateGUI();
	}
}
