package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import DTO.DisplayClientDTO;
import dogs.controller.IClientController;

public class DisplayClientView extends View {

	private static final String VIEW_TITLE = "Voir les clients";
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	
	private static final int NB_OF_ROWS = 0;
	private static final int NB_OF_COLLUMNS = 4;
	
	private static final String ID_LABEL = "Id";
	private static final String LAST_NAME_LABEL = "Nom";
	private static final String FIRST_NAME_LABEL = "Prénom";
	private static final String PHONE_NUMBER_LABEL = "Téléphone";
	
	private List<DisplayClientDTO> clientList;
	private IClientController controller; 	
	
	
	public DisplayClientView(IClientController controller) {
		super(controller,VIEW_TITLE,DEFAULT_SIZE);
		this.controller = controller;
		this.clientList = this.controller.getClientListByName();
		
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
		
		DisplayClientDTO client;
		for (int i =0 ;i< this.clientList.size();i++) {
			client = this.clientList.get(i);
			super.addLabel(panel, Integer.toString(client.ID));
			super.addLabel(panel, client.FIRST_NAME);
			super.addLabel(panel, client.LAST_NAME);
			super.addLabel(panel, client.PHONE_NUMBER);
		}
	}

}
