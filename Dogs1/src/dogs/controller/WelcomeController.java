package dogs.controller;

import dogs.model.DogRepository;

import dogs.view.WelcomeView;

public class WelcomeController extends Controller implements IWelcomeController {

	private IDogController dogController;
	
	public WelcomeController(DogRepository dogRepository) {
		this.dogController = new DogController(dogRepository);
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

}
