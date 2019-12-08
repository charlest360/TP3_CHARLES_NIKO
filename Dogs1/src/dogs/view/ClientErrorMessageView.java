package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dogs.controller.IClientController;

public class ClientErrorMessageView extends View{
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	private static final String TITLE = "Erreur";
	private final String ERROR_MESSAGE;
	
	public ClientErrorMessageView(IClientController controller, String errorMessage) {
		super(controller, TITLE, DEFAULT_SIZE);
		this.ERROR_MESSAGE = errorMessage;
		
		this.setUpComponents();
	}
	
	private void setUpComponents() {
		this.setUpErrorPanel();
	}
	
	private void setUpErrorPanel() {
		JPanel errorPanel = new JPanel();
		this.add(errorPanel, BorderLayout.CENTER);  // CENTER -> par défaut

		errorPanel.setLayout(new BorderLayout());   // Strategy pattern: le gestionnaire de mise en forme				
		addErrorMessage(errorPanel);		
	}
	
	private void addErrorMessage(JPanel errorPanel) {
		JLabel errorMessage = new JLabel(ERROR_MESSAGE, SwingConstants.CENTER);
		errorPanel.add(errorMessage, BorderLayout.NORTH);
	}
}
