package dogs.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dogs.controller.IController;

public abstract class View extends JFrame implements IView {
	
	@SuppressWarnings("unused")
	protected IController controller;
	
	
	public View(IController controller,String title,Dimension defaultSize) {
		
		super(title);
		
		this.controller = controller;
		this.initialize(defaultSize);
		
	}
	
	private void initialize(Dimension defaultSize) {
		this.setSize(defaultSize);
	}
	
	public void display() {
		this.setVisible(true);
	}
	
	public void addLabel(JPanel panel,String text) {
		JLabel label = new JLabel(text);
		panel.add(label);
	}
}
