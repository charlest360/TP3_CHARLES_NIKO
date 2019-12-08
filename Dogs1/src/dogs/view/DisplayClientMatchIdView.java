package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.DisplayClientDTO;
import DTO.UpdateClientDTO;
import dogs.controller.IClientController;

public class DisplayClientMatchIdView extends DynamicView {
	
	private static final String VIEW_TITLE = "Voir un client selon son Id";
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	
	
	private static final int NB_OF_ROWS = 0;
	private static final int NB_OF_COLLUMNS = 4;
	private static final String EDIT_CLIENT_BUTTON_TEXT = "Sauvegarder";
	private static final String EDIT_CLIENT_ACTION = "Éditer Client";
	private static final String ID_LABEL = "Id";
	private static final String LAST_NAME_LABEL = "Nom";
	private static final String FIRST_NAME_LABEL = "Prénom";
	private static final String PHONE_NUMBER_LABEL = "Téléphone";
	
	private IClientController controller ;
	private DisplayClientDTO clientToDisplay;
	
	private JTextField clientFirstName; 
	private JTextField clientLastName;
	private JTextField clientPhoneNumber;
	
	
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
		this.setUpSouthPanel();
	}

	
	private void setUpNorthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(NB_OF_ROWS,NB_OF_COLLUMNS));
		this.addClientLabels(panel);
		this.addClientTextfields(panel);
		
		this.add(panel,BorderLayout.NORTH);
		
	}
	
	private void setUpSouthPanel() {
		JPanel panel = new JPanel();
		
		super.addButton(panel, EDIT_CLIENT_BUTTON_TEXT, EDIT_CLIENT_ACTION,BorderLayout.CENTER);
		
		this.add(panel,BorderLayout.SOUTH);
	}
	
	private void addClientLabels(JPanel panel) {
		super.addLabel(panel, ID_LABEL);
		super.addLabel(panel, FIRST_NAME_LABEL);
		super.addLabel(panel, LAST_NAME_LABEL);
		super.addLabel(panel, PHONE_NUMBER_LABEL);
		super.addLabel(panel, Integer.toString(this.clientToDisplay.ID));
	}
	
	private void addClientTextfields(JPanel panel) {
		this.clientFirstName = new JTextField(this.clientToDisplay.FIRST_NAME);
		this.clientLastName = new JTextField(this.clientToDisplay.LAST_NAME);
		this.clientPhoneNumber = new JTextField(this.clientToDisplay.PHONE_NUMBER);
		
		panel.add(this.clientFirstName);
		panel.add(this.clientLastName);
		panel.add(this.clientPhoneNumber);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getActionCommand()== EDIT_CLIENT_ACTION) {
			UpdateClientDTO dto = new UpdateClientDTO(this.clientToDisplay.ID,this.clientFirstName.getText(),this.clientLastName.getText(),this.clientPhoneNumber.getText());
			this.controller.SaveClientChanges(dto);
		}
		
	}
	
}

