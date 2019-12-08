package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.CreateClientDTO;
import dogs.controller.IClientController;

public class AddClientView extends DynamicView {
	private static final String VIEW_TITLE = "Ajout d'un client";
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	
	private static final int NB_OF_ROWS = 0;
	private static final int NB_OF_COLLUMNS = 3;
	
	private static final String FIRST_NAME_LABEL = "Prénom";
	private static final String LAST_NAME_LABEL = "Nom";
	private static final String PHONE_NUMBER_LABEL = "Téléphone";
	private static final String INSCRIPTION_BUTTON_TEXT = "Ajouter";
	private static final String ADD_CLIENT_ACTION = "Add client";
	
	private IClientController controller; 
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField phoneNumberText;
	
	
	public AddClientView(IClientController controller) {
		super(controller, VIEW_TITLE, DEFAULT_SIZE);
		this.controller = controller;

		this.setUpComponents();
		this.setUpActionPanels();
	}
	
	private void setUpComponents() {
		this.setUpClientPanel();
	}
	
	private void setUpClientPanel() {
		JPanel clientFormPanel = new JPanel();
		this.add(clientFormPanel,BorderLayout.CENTER);
		clientFormPanel.setLayout(new BorderLayout());
		
	}

	private void setUpActionPanels() {
		this.setUpNorthPanel();
		this.setUpSouthPanel();
	}

	private void setUpNorthPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(NB_OF_ROWS,NB_OF_COLLUMNS));
		this.addInscriptionDetails(panel);
		
		this.add(panel,BorderLayout.NORTH);
	}
	
	private void addInscriptionDetails(JPanel panel) {

		
		super.addLabel(panel, FIRST_NAME_LABEL);
		super.addLabel(panel, LAST_NAME_LABEL);
		super.addLabel(panel, PHONE_NUMBER_LABEL);
		
		this.firstNameText = new JTextField();
		this.lastNameText = new JTextField();
		this.phoneNumberText = new JTextField();
		
		panel.add(this.firstNameText);
		panel.add(this.lastNameText);
		panel.add(this.phoneNumberText);
		
	}
	
	private void setUpSouthPanel() {
		JPanel panel = new JPanel();
	
		super.addButton(panel, INSCRIPTION_BUTTON_TEXT, ADD_CLIENT_ACTION,BorderLayout.CENTER);
		
		this.add(panel,BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == ADD_CLIENT_ACTION) {
			
			CreateClientDTO dto = new CreateClientDTO(this.firstNameText.getText(),this.lastNameText.getText(),this.phoneNumberText.getText());

			this.controller.addClient(dto);
			
		}
	}

}
