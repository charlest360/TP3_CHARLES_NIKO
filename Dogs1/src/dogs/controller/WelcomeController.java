package dogs.controller;

import dogs.model.ClientRepository;
import dogs.model.DogRepository;

import dogs.view.WelcomeView;

public class WelcomeController extends Controller implements IWelcomeController {

	private IDogController dogController;
	private IClientController clientController;
	
	public WelcomeController(DogRepository dogRepository,ClientRepository clientRepository) {
		this.dogController = new DogController(dogRepository,clientRepository);
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

	@Override
	public void searchClientById(String id) {
		this.clientController.showClientMatchId(id);
		
	}

	@Override
	public void searchClientByName(String text) {
		this.clientController.showClientsMatchName(text);
		
	}

	@Override
	public void searchDogById(String id) {
		this.dogController.showDogMatchId(id);
	}

}
