package dogs.controller;

import dogs.model.ClientRepository;
import dogs.model.DogRepository;

import dogs.view.WelcomeView;

public class WelcomeController extends Controller implements IWelcomeController {

	private IDogController dogController;
	private IClientController clientController;
	
	public WelcomeController(DogRepository dogRepository,ClientRepository clientRepository) {
		this.dogController = new DogController(dogRepository);
		this.clientController = new ClientController(clientRepository);
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

}
