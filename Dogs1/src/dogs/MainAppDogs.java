package dogs;

import DataSeed.DataSeeder;
import dogs.controller.IWelcomeController;

import dogs.controller.WelcomeController;
import dogs.model.ClientRepository;
import dogs.model.DogRepository;

public class MainAppDogs {

	
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		DogRepository dogRepository = new DogRepository();
		ClientRepository clientRepository = new ClientRepository();
		this.createDataSeed(dogRepository,clientRepository);
		this.createControllers(dogRepository,clientRepository);
		
	}
	
	private void createControllers(DogRepository dogRepository,ClientRepository clientRepository) {
		IWelcomeController appController = new WelcomeController(dogRepository,clientRepository);
		appController.startApplication();
	}
	
	private void createDataSeed(DogRepository dogRepository,ClientRepository clientRepository) {
		DataSeeder.AddInitialDogsAndClients(dogRepository,clientRepository);
	}
}
