package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.CreateDogDTO;
import dogs.controller.IDogController;



public class AddDogView extends DynamicView{
	private static final String VIEW_TITLE = "Ajout de chiens";
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	
	private static final int NB_OF_ROWS = 0;
	private static final int NB_OF_COLLUMNS = 3;
	
	private static final String NAME_LABEL = "Nom";
	private static final String BREED_LABEL = "Race";
	private static final String OWNER_ID_LABEL = "Id du propriétaire";
	private static final String INSCRIPTION_BUTTON_TEXT = "Inscrire";
	private static final String ADD_DOG_ACTION = "Add dog";
	
	private IDogController controller; 
	private JTextField nameText;
	private JTextField breedText;	
	private JTextField ownerIdText;
	
	public AddDogView(IDogController controller) {
		super(controller, VIEW_TITLE, DEFAULT_SIZE);
		this.controller = controller;

		this.setUpComponents();
		this.setUpActionPanels();
	}
	
	private void setUpComponents() {
		this.setUpDogPanel();
	}
	
	private void setUpDogPanel() {
		JPanel dogFormPanel = new JPanel();
		this.add(dogFormPanel,BorderLayout.CENTER);
		dogFormPanel.setLayout(new BorderLayout());
		
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
		
		super.addLabel(panel, NAME_LABEL);
		super.addLabel(panel, BREED_LABEL);
		super.addLabel(panel, OWNER_ID_LABEL);
		
		this.nameText = new JTextField();
		this.breedText = new JTextField();
		this.ownerIdText = new JTextField();
	
		panel.add(nameText);
		panel.add(breedText);
		panel.add(ownerIdText);
	}
	
	private void setUpSouthPanel() {
		JPanel panel = new JPanel();

		super.addButton(panel, INSCRIPTION_BUTTON_TEXT, ADD_DOG_ACTION, BorderLayout.CENTER);
		this.add(panel,BorderLayout.SOUTH);
	}

	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == ADD_DOG_ACTION) {
			int ownerId = Integer.valueOf(this.ownerIdText.getText());
			CreateDogDTO dto = new CreateDogDTO(this.nameText.getText(),this.breedText.getText(),ownerId);

			this.controller.addDog(dto);
		}
	}
	
}
