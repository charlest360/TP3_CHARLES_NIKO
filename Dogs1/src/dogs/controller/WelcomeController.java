package dogs.controller;

import dogs.view.WelcomeView;

public class WelcomeController extends Controller implements IWelcomeController {

	private IDogController dogController;
	private IClientController clientController;
	
	public WelcomeController(IClientController clientController,IDogController dogController) {
		this.clientController = clientController;
		this.dogController = dogController;
	}
	
	public void startApplication() {
		super.showView(new WelcomeView(this));
	}
	
	public void addDog() {
		this.dogController.showAddDogsView();
	}
	
	
	public void viewDogs() {
		this.dogController.showDisplayDogsView();		
	}
	
	@Override
	public void searchDogById(String id) {
		this.dogController.getDogMatchId(id);
	}

	@Override
	public void viewClientsByName() {
		this.clientController.showDisplayClientByNameView();
	}
	
	public void viewClientsByPhone() {
		this.clientController.showDisplayClientByPhoneView();
	}

	@Override
	public void addClient() {
		this.clientController.showAddClientsView();
	}

	@Override
	public void searchClientById(String id) {
		this.clientController.getClientMatchId(id);	
	}

	@Override
	public void searchClientByName(String name) {
		this.clientController.getClientMatchName(name);
	}

	

}
