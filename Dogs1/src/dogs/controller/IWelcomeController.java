package dogs.controller;

public interface IWelcomeController extends IController {

	void startApplication();

	void addDog();

	void viewDogs();

	void viewClientsByName();
	
	void viewClientsByPhone();

	void addClient();
	
	
}
