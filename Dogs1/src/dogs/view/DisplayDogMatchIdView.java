package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.DeleteDogDTO;
import DTO.DisplayDogDTO;
import DTO.UpdateDogDTO;
import dogs.controller.IDogController;


public class DisplayDogMatchIdView extends DynamicView {
	
	private static final String VIEW_TITLE = "Voir les chiens";
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	
	private static final int NB_OF_ROWS = 0;
	private static final int NB_OF_COLLUMNS = 7;
	
	private static final String ID_LABEL = "Id ";
	private static final String NAME_LABEL = "Nom";
	private static final String BREED_LABEL = "Race";
	private static final String OWNER_ID_LABEL = "Id maitre";
	private static final String OWNER_LAST_NAME_LABEL = "Nom maitre";
	private static final String OWNER_FIRST_NAME_LABEL = "Prénom maitre";
	private static final String OWNER_PHONE_NUMBER_LABEL = "Téléphone maitre";
	
	private static final String EDIT_DOG_BUTTON_TEXT = "Sauvegarder";
	private static final String EDIT_DOG_ACTION = "Éditer Chien";
	private static final String DELETE_DOG_BUTTON_TEXT = "Supprimer";
	private static final String DELETE_DOG_ACTION = "Supprimer Chien";
	
	private JTextField dogName; 
	private JTextField dogBreed;
	private DisplayDogDTO dogToDisplay;
	private IDogController controller;
	
	public DisplayDogMatchIdView(IDogController controller,DisplayDogDTO dto) {
		super(controller, VIEW_TITLE, DEFAULT_SIZE);
		
		this.controller = controller;
		this.dogToDisplay = dto;
		
		this.setUpComponents();
	}
	
	private void setUpComponents() {
		this.setUpDogPanel();
	}
	
	private void setUpDogPanel() {
		JPanel dogFormPanel = new JPanel();
		this.add(dogFormPanel,BorderLayout.CENTER);
		dogFormPanel.setLayout(new BorderLayout());
		
		this.setUpNorthPanel();
		this.setUpSouthPanel();
	}

	
	private void setUpNorthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(NB_OF_ROWS,NB_OF_COLLUMNS));
		this.addDogLabels(panel);
		this.addDogTextfields(panel);
		this.addClientLabels(panel);
		
		this.add(panel,BorderLayout.NORTH);
		
	}
	
	private void setUpSouthPanel() {
		JPanel panel = new JPanel();
	
		this.add(panel,BorderLayout.SOUTH);
		super.addButton(panel, EDIT_DOG_BUTTON_TEXT, EDIT_DOG_ACTION);
		super.addButton(panel, DELETE_DOG_BUTTON_TEXT, DELETE_DOG_ACTION);
		
	}
	
	private void addDogLabels(JPanel panel) {
		super.addLabel(panel, ID_LABEL);
		super.addLabel(panel, NAME_LABEL);
		super.addLabel(panel, BREED_LABEL);
		super.addLabel(panel,OWNER_ID_LABEL);
		super.addLabel(panel, OWNER_FIRST_NAME_LABEL);
		super.addLabel(panel, OWNER_LAST_NAME_LABEL);
		super.addLabel(panel, OWNER_PHONE_NUMBER_LABEL);
		super.addLabel(panel, Integer.toString(this.dogToDisplay.ID));
	}
	
	private void addClientLabels(JPanel panel) {
		super.addLabel(panel,Integer.toString(this.dogToDisplay.OWNER_ID));
		super.addLabel(panel, this.dogToDisplay.OWNER_FIRST_NAME);
		super.addLabel(panel, this.dogToDisplay.OWNER_LAST_NAME);
		super.addLabel(panel, this.dogToDisplay.OWNER_PHONE_NUMBER);

	}
	
	private void addDogTextfields(JPanel panel) {
		this.dogName = new JTextField(this.dogToDisplay.NAME);
		this.dogBreed = new JTextField(this.dogToDisplay.BREED.toString());		
		
		panel.add(this.dogName);
		panel.add(this.dogBreed);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getActionCommand()== EDIT_DOG_ACTION) {
			UpdateDogDTO dto = new UpdateDogDTO(this.dogToDisplay.ID,this.dogName.getText(),this.dogBreed.getText(),this.dogToDisplay.OWNER_ID);
			this.controller.SaveDogChanges(dto);
		}
		
		if(arg0.getActionCommand()== DELETE_DOG_ACTION) {
			DeleteDogDTO dto = new DeleteDogDTO(this.dogToDisplay.ID);
			this.controller.DeleteDog(dto);
		}
		
	}
}
