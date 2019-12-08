package dogs.controller;

public interface IWelcomeController extends IController {

	void startApplication();

	void addDog();

	void viewDogs();

	void viewClientsByName();
	
	void viewClientsByPhone();

	void addClient();

	void searchClientById(String id);

	void searchClientByName(String text);

	void searchDogById(String id);

	void searchDogByBreed(String breed);
	
	
}
