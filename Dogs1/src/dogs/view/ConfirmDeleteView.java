package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import DTO.DeleteDogDTO;
import dogs.controller.IDogController;

public class ConfirmDeleteView extends DynamicView{
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	private static final String TITLE = "Confirmation";
	private static final String CONFIRM_BUTTON_TEXT = "Confirmer la suppression";
	private static final String CONFIRM_BUTTON_ACTION = "suppression";
	private IDogController controller;
	private final DeleteDogDTO dto;
	
	public ConfirmDeleteView(IDogController controller,DeleteDogDTO dto) {
		super(controller, TITLE, DEFAULT_SIZE);
		
		this.controller = controller;
		this.dto =dto;
		this.setUpComponents();
	}

	private void setUpComponents() {
		this.setUpConfirmationPanel();
	}
	
	private void setUpConfirmationPanel() {
		JPanel confirmationPanel = new JPanel();
		this.add(confirmationPanel, BorderLayout.CENTER);  

		super.addButton(confirmationPanel, CONFIRM_BUTTON_TEXT, CONFIRM_BUTTON_ACTION, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == CONFIRM_BUTTON_ACTION) {

			this.controller.removeDog(this.dto);
			
		}
		
	}
}
