package dogs.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controller.mock.ClientControllerDummy;
import controller.mock.ClientControllerSpy;
import controller.mock.DogControllerDummy;
import controller.mock.DogControllerSpy;

public class WelcomeControllerTest {
	
	private final IDogController ANY_DOG_CONTROLLER = new DogControllerDummy();
	private final IClientController ANY_CLIENT_CONTROLLER = new ClientControllerDummy();
	private final String ANY_STRING = "a string";
	
	@Test 
	public void WHEN_callingAddClientInWelcomeController_THEN_showAddClientsViewIsCalledInClientController() {		
		//Arrange
		IClientController clientController = new ClientControllerSpy();
		IWelcomeController welcomeController = new WelcomeController(clientController, ANY_DOG_CONTROLLER);;
		
		//Act
		welcomeController.addClient();
		
		//Assert
		final boolean HAS_FUNCTION_BEEN_CALLED =  ((ClientControllerSpy) clientController).showAddClientsViewWasCalled;
		
		assertTrue(HAS_FUNCTION_BEEN_CALLED);
	}
	
	@Test 
	public void WHEN_callingViewClientsByNameInWelcomeController_THEN_showDisplayClientByNameViewIsCalledInClientController() {		
		//Arrange
		IClientController clientController = new ClientControllerSpy();
		IWelcomeController welcomeController = new WelcomeController(clientController, ANY_DOG_CONTROLLER);;
		
		//Act
		welcomeController.viewClientsByName();
		
		//Assert
		final boolean HAS_FUNCTION_BEEN_CALLED =  ((ClientControllerSpy) clientController).showDisplayClientByNameViewWasCalled;
		
		assertTrue(HAS_FUNCTION_BEEN_CALLED);	
	}
	
	@Test 
	public void WHEN_callingViewClientsByPhoneInWelcomeController_THEN_showDisplayClientByPhoneViewIsCalledInClientController() {		
		//Arrange
		IClientController clientController = new ClientControllerSpy();
		IWelcomeController welcomeController = new WelcomeController(clientController, ANY_DOG_CONTROLLER);;
		
		//Act
		welcomeController.viewClientsByPhone();
		
		//Assert
		final boolean HAS_FUNCTION_BEEN_CALLED =  ((ClientControllerSpy) clientController).showDisplayClientByPhoneViewWasCalled;
		
		assertTrue(HAS_FUNCTION_BEEN_CALLED);	
	}
	
	@Test 
	public void WHEN_callingSearchClientByIdInWelcomeController_THEN_getClientMatchIdIsCalledInClientController() {		
		//Arrange
		IClientController clientController = new ClientControllerSpy();
		IWelcomeController welcomeController = new WelcomeController(clientController, ANY_DOG_CONTROLLER);;
		
		//Act
		welcomeController.searchClientById(ANY_STRING);
		
		//Assert
		final boolean HAS_FUNCTION_BEEN_CALLED =  ((ClientControllerSpy) clientController).getClientMatchIdWasCalled;
		
		assertTrue(HAS_FUNCTION_BEEN_CALLED);	
	}
	
	@Test 
	public void WHEN_callingSearchClientByNameInWelcomeController_THEN_getClientMatchNameIsCalledInClientController() {		
		//Arrange
		IClientController clientController = new ClientControllerSpy();
		IWelcomeController welcomeController = new WelcomeController(clientController, ANY_DOG_CONTROLLER);;
		
		//Act
		welcomeController.searchClientByName(ANY_STRING);
		
		//Assert
		final boolean HAS_FUNCTION_BEEN_CALLED =  ((ClientControllerSpy) clientController).getClientMatchNameWasCalled;
		
		assertTrue(HAS_FUNCTION_BEEN_CALLED);	
	}
	
	@Test 
	public void WHEN_callingAddDogInWelcomeController_THEN_showAddDogsViewIsCalledInDogController() {		
		//Arrange
		IDogController dogController = new DogControllerSpy();
		IWelcomeController welcomeController = new WelcomeController(ANY_CLIENT_CONTROLLER, dogController);
		
		//Act
		welcomeController.addDog();
		
		//Assert
		final boolean HAS_FUNCTION_BEEN_CALLED =  ((DogControllerSpy) dogController).showAddDogsViewWasCalled;
		
		assertTrue(HAS_FUNCTION_BEEN_CALLED);	
	}
	
	@Test 
	public void WHEN_callingViewDogsInWelcomeController_THEN_showDisplayDogsViewIsCalledInDogController() {		
		//Arrange
		IDogController dogController = new DogControllerSpy();
		IWelcomeController welcomeController = new WelcomeController(ANY_CLIENT_CONTROLLER, dogController);
		
		//Act
		welcomeController.viewDogs();
		
		//Assert
		final boolean HAS_FUNCTION_BEEN_CALLED =  ((DogControllerSpy) dogController).showDisplayDogsViewWasCalled;
		
		assertTrue(HAS_FUNCTION_BEEN_CALLED);	
	}
	
	@Test 
	public void WHEN_callingSearchDogByIdInWelcomeController_THEN_getDogMatchIdIsCalledInDogController() {		
		//Arrange
		IDogController dogController = new DogControllerSpy();
		IWelcomeController welcomeController = new WelcomeController(ANY_CLIENT_CONTROLLER, dogController);
		
		//Act
		welcomeController.searchDogById(ANY_STRING);
		
		//Assert
		final boolean HAS_FUNCTION_BEEN_CALLED =  ((DogControllerSpy) dogController).getDogMatchIdWasCalled;
		
		assertTrue(HAS_FUNCTION_BEEN_CALLED);	
	}
	
	@Test 
	public void WHEN_callingSearchDogByBreedInWelcomeController_THEN_getDogMatchBreedIsCalledInDogController() {		
		//Arrange
		IDogController dogController = new DogControllerSpy();
		IWelcomeController welcomeController = new WelcomeController(ANY_CLIENT_CONTROLLER, dogController);
		
		//Act
		welcomeController.searchDogByBreed(ANY_STRING);
		
		//Assert
		final boolean HAS_FUNCTION_BEEN_CALLED =  ((DogControllerSpy) dogController).getDogMatchBreedWasCalled;
		
		assertTrue(HAS_FUNCTION_BEEN_CALLED);	
	}
	
	
	
}
