package jxplore;

import javax.swing.JPanel;

//Superklasse voor alle view-klassen
public abstract class JXploreView extends JPanel{
	
	private static final long serialVersionUID = 0;
	public JXplorer data;
	
	public JXploreView(){
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
