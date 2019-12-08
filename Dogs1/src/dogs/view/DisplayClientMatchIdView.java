package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import DTO.DisplayClientDTO;
import dogs.controller.IClientController;

public class DisplayClientMatchIdView extends View {
	
	private static final String VIEW_TITLE = "Voir un client selon son Id";
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	
	private static final int NB_OF_ROWS = 0;
	private static final int NB_OF_COLLUMNS = 4;
	
	private static final String ID_LABEL = "Id";
	private static final String LAST_NAME_LABEL = "Nom";
	private static final String FIRST_NAME_LABEL = "Prénom";
	private static final String PHONE_NUMBER_LABEL = "Téléphone";
	
	
	private IClientController controller ;
	private DisplayClientDTO clientToDisplay;
	
	public DisplayClientMatchIdView(IClientController controller,DisplayClientDTO clientToDisplay) {
		super(controller, VIEW_TITLE, DEFAULT_SIZE);
		this.controller = controller;
		this.clientToDisplay = clientToDisplay;
		
		this.setUpComponents();
	}
	
	private void setUpComponents() {
		this.setUpClientPanel();
	}
	
	
	
	private void setUpClientPanel() {
		JPanel clientFormPanel = new JPanel();
		this.add(clientFormPanel,BorderLayout.CENTER);
		clientFormPanel.setLayout(new BorderLayout());
		
		this.setUpNorthPanel();
		
	}

	
	private void setUpNorthPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(NB_OF_ROWS,NB_OF_COLLUMNS));
		this.addClientLabels(panel);
		this.displayClients(panel);
		this.add(panel,BorderLayout.NORTH);
		
	}
	
	private void addClientLabels(JPanel panel) {
		super.addLabel(panel, ID_LABEL);
		super.addLabel(panel, FIRST_NAME_LABEL);
		super.addLabel(panel, LAST_NAME_LABEL);
		super.addLabel(panel, PHONE_NUMBER_LABEL);
	}
	
	
	void displayClients(JPanel panel) {
			super.addLabel(panel, Integer.toString(this.clientToDisplay.ID));
			super.addLabel(panel, this.clientToDisplay.FIRST_NAME);
			super.addLabel(panel, this.clientToDisplay.LAST_NAME);
			super.addLabel(panel, this.clientToDisplay.PHONE_NUMBER);
		}
}

