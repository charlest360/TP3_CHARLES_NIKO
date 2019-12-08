package dogs;

import DataSeed.DogDataSeed;
import dogs.controller.IWelcomeController;

import dogs.controller.WelcomeController;
import dogs.model.DogRepository;

public class MainAppDogs {

	
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		DogRepository repository = new DogRepository();
		this.createDataSeed(repository);
		this.createControllers(repository);
		
	}
	
	private void createControllers(DogRepository repository) {
		IWelcomeController appController = new WelcomeController(repository);
		appController.startApplication();
	}
	
	private void createDataSeed(DogRepository repository) {
		DogDataSeed.AddInitialDogs(repository);
	}
}
