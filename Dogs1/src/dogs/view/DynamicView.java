package dogs.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dogs.controller.IController;

public abstract class DynamicView extends View implements ActionListener{

	public DynamicView(IController controller, String title, Dimension defaultSize) {
		super(controller, title, defaultSize);
		
	}

	//addButton avec layout par défaut
	public void addButton(JPanel actionPanel,String textToAdd,String actionCommand) {
		JButton button = new JButton(textToAdd);
		button.addActionListener(this);
		button.setActionCommand(actionCommand);
		actionPanel.add(button);
	}
	
	//addButton avec layout précis
	public void addButton(JPanel actionPanel,String textToAdd,String actionCommand,String layout) {
		JButton button = new JButton(textToAdd);
		button.addActionListener(this);
		button.setActionCommand(actionCommand);
		actionPanel.add(button,layout);
	}
	

}
