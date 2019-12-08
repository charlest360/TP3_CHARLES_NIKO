package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import DTO.DisplayDogDTO;
import dogs.controller.IDogController;

public class DisplayDogView extends View {
		
		private static final String VIEW_TITLE = "Voir les chiens";
		private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
		
		private static final int NB_OF_ROWS = 0;
		private static final int NB_OF_COLLUMNS = 6;
		
		private static final String ID_LABEL = "Id";
		private static final String NAME_LABEL = "Nom";
		private static final String BREED_LABEL = "Race";
		private static final String OWNER_ID_LABEL = "Id du maitre";
		private static final String OWNER_FIRST_NAME_LABEL = "Prénom du maitre";
		private static final String OWNER_LAST_NAME_LABEL = "Nom du maitre";
		
		private List<DisplayDogDTO> dogList;
		@SuppressWarnings("unused")
		private IDogController controller; 	
		
		public DisplayDogView(IDogController controller, List<DisplayDogDTO> dogToDisplayList) {
			
			super(controller,VIEW_TITLE,DEFAULT_SIZE);
			this.controller = controller;
			this.dogList = dogToDisplayList;
			
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
			
		}

		
		
		private void setUpNorthPanel() {
			JPanel panel = new JPanel();
			
			panel.setLayout(new GridLayout(NB_OF_ROWS,NB_OF_COLLUMNS));
			this.addDogLabels(panel);
			this.displayDogs(panel);
			this.add(panel,BorderLayout.NORTH);
			
		}
		
		
		
		private void addDogLabels(JPanel panel) {
			super.addLabel(panel, ID_LABEL);
			super.addLabel(panel, NAME_LABEL);
			super.addLabel(panel, BREED_LABEL);
			super.addLabel(panel, OWNER_ID_LABEL);
			super.addLabel(panel, OWNER_FIRST_NAME_LABEL);
			super.addLabel(panel, OWNER_LAST_NAME_LABEL);
		}
		
		
		void displayDogs(JPanel panel) {
			
			DisplayDogDTO dog;
			for (int i =0 ;i< this.dogList.size();i++) {
				dog = this.dogList.get(i);
				super.addLabel(panel, Integer.toString(dog.ID));
				super.addLabel(panel, dog.NAME);
				super.addLabel(panel, dog.BREED);
				super.addLabel(panel, Integer.toString(dog.OWNER_ID) );
				super.addLabel(panel, dog.OWNER_FIRST_NAME);
				super.addLabel(panel, dog.OWNER_LAST_NAME);
			}
		}
	}


