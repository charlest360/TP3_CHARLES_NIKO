package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.CreateClientDTO;
import dogs.controller.IClientController;

public class AddClientView extends View implements ActionListener{
	private static final String VIEW_TITLE = "Ajout d'un client";
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	
	private static final int NB_OF_ROWS = 0;
	private static final int NB_OF_COLLUMNS = 3;
	
	private static final String FIRST_NAME_LABEL = "Pr�nom";
	private static final String LAST_NAME_LABEL = "Nom";
	private static final String PHONE_NUMBER_LABEL = "T�l�phone";
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
	
		this.addButton(panel);
		
		this.add(panel,BorderLayout.SOUTH);
	}
	
	private void addButton(JPanel panel) {
		JButton button = new JButton(INSCRIPTION_BUTTON_TEXT);
		button.addActionListener(this);
		button.setActionCommand(ADD_CLIENT_ACTION);
		panel.add(button,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == ADD_CLIENT_ACTION) {
			
			CreateClientDTO dto = new CreateClientDTO(this.firstNameText.getText(),this.lastNameText.getText(),this.phoneNumberText.getText());

			this.controller.addClient(dto);
			
			
		}
	}

}
