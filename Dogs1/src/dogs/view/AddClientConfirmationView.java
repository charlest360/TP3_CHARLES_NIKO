package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dogs.controller.IClientController;

public class AddClientConfirmationView extends View{
	
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	private static final String TITLE = "Confirmation";
	private final String CONFIRMATION_MESSAGE ;
	
	public AddClientConfirmationView(IClientController controller, String message) {
		super(controller, TITLE, DEFAULT_SIZE);
		
		this.CONFIRMATION_MESSAGE = message;
		this.setUpComponents();
	}

	private void setUpComponents() {
		this.setUpConfirmationPanel();
	}
	
	private void setUpConfirmationPanel() {
		JPanel confirmationPanel = new JPanel();
		this.add(confirmationPanel, BorderLayout.CENTER);  // CENTER -> par défaut

		confirmationPanel.setLayout(new BorderLayout());   // Strategy pattern: le gestionnaire de mise en forme				
		addConfirmationMessage(confirmationPanel);		
	}
	
	private void addConfirmationMessage(JPanel confirmationPanel) {
		JLabel confirmationMessage = new JLabel(CONFIRMATION_MESSAGE, SwingConstants.CENTER);
		confirmationPanel.add(confirmationMessage, BorderLayout.NORTH);
	}
	
	
	
	
	
}
