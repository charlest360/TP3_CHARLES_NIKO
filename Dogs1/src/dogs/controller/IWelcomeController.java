package dogs.controller;

import javax.swing.JTextField;

public interface IWelcomeController extends IController {

	void startApplication();

	void addDog();

	void viewDogs();

	void viewClientsByName();
	
	void viewClientsByPhone();

	void addClient();

	void searchClientById(String id);
	
	
}
