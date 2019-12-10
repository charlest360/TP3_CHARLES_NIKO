package dogs.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import DTO.CreateClientDTO;
import DTO.DisplayClientDTO;
import DTO.UpdateClientDTO;
import dogs.controller.ClientController;
import dogs.controller.IClientController;
import dogs.model.ClientRepositorySpy;
import dogs.model.ClientRepositoryStub;
import dogs.model.ClientSpy;
import dogs.model.ClientStub;
import dogs.model.IClient;
import dogs.model.IClientRepository;

public class ClientControllerTest {
	private final String ANY_STRING ="a string";
	private final String OTHER_ANY_STRING ="another string";
	private final String ANY_VALID_FIRST_NAME = "Pablo";
	private final String ANY_VALID_LAST_NAME = "Picasso";
	private final String ANY_VALID_PHONE_NUMBER = "418-123-4567";
	private final int ANY_VALID_ID = 10;
	
	private final String ANY_INVALID_FIRST_NAME = "A";
	private final String ANY_INVALID_LAST_NAME = "Z";
	private final String ANY_INVALID_PHONE_NUMBER = "911";
	
	
	

	
	@Test
	public void GIVEN_validClientInfos_WHEN_callingAddClientInClientController_THEN_addClientIsCalledInClientRepository() {
		
		//Arrange
		CreateClientDTO clientToAdd = new CreateClientDTO(ANY_VALID_FIRST_NAME,ANY_VALID_LAST_NAME,ANY_VALID_PHONE_NUMBER);
		IClientRepository clientRepository = new ClientRepositorySpy();
		
		IClientController  controller = new ClientController(clientRepository);
		
		//Act
		controller.addClient(clientToAdd);

		//Assert
		final boolean HAS_ADD_CLIENT_REALLY_BEEN_CALLED = ((ClientRepositorySpy) clientRepository).hasAddClientBeenCalled;
		
		assertTrue(HAS_ADD_CLIENT_REALLY_BEEN_CALLED);
	}
	
	@Test
	public void GIVEN_invalidClientFirstName_WHEN_callingAddClientInClientController_THEN_addClientIsNotCalledInClientRepository() {
		
		//Arrange
		CreateClientDTO clientToAdd = new CreateClientDTO(ANY_INVALID_FIRST_NAME,ANY_VALID_LAST_NAME,ANY_VALID_PHONE_NUMBER);
		IClientRepository clientRepository = new ClientRepositorySpy();
		
		IClientController  controller = new ClientController(clientRepository);
		
		//Act
		controller.addClient(clientToAdd);

		//Assert
		final boolean HAS_ADD_CLIENT_REALLY_BEEN_CALLED = ((ClientRepositorySpy) clientRepository).hasAddClientBeenCalled;
		
		assertFalse(HAS_ADD_CLIENT_REALLY_BEEN_CALLED);
	}
	
	@Test
	public void GIVEN_invalidClientLastName_WHEN_callingAddClientInClientController_THEN_addClientIsNotCalledInClientRepository() {
		
		//Arrange
		CreateClientDTO clientToAdd = new CreateClientDTO(ANY_VALID_FIRST_NAME,ANY_INVALID_LAST_NAME,ANY_VALID_PHONE_NUMBER);
		IClientRepository clientRepository = new ClientRepositorySpy();
		
		IClientController  controller = new ClientController(clientRepository);
		
		//Act
		controller.addClient(clientToAdd);

		//Assert
		final boolean HAS_ADD_CLIENT_REALLY_BEEN_CALLED = ((ClientRepositorySpy) clientRepository).hasAddClientBeenCalled;
		
		assertFalse(HAS_ADD_CLIENT_REALLY_BEEN_CALLED);
	}
	
	@Test
	public void GIVEN_invalidClientPhoneNumber_WHEN_callingAddClientInClientController_THEN_addClientIsNotCalledInClientRepository() {
		
		//Arrange
		CreateClientDTO clientToAdd = new CreateClientDTO(ANY_INVALID_FIRST_NAME,ANY_VALID_LAST_NAME,ANY_INVALID_PHONE_NUMBER);
		IClientRepository clientRepository = new ClientRepositorySpy();
		
		IClientController  controller = new ClientController(clientRepository);
		
		//Act
		controller.addClient(clientToAdd);

		//Assert
		final boolean HAS_ADD_CLIENT_REALLY_BEEN_CALLED = ((ClientRepositorySpy) clientRepository).hasAddClientBeenCalled;
		
		assertFalse(HAS_ADD_CLIENT_REALLY_BEEN_CALLED);
	}
	
	
	@Test
	public void GIVEN_validClientAttributes_WHEN_savingClientChangesInClientController_THEN_setFirstNameSetLastNameAndSetPhoneNumberAreCalled() {
		
		//Arrange
		int clientId = ANY_VALID_ID;
		IClient client = new ClientSpy(ANY_STRING,ANY_STRING,ANY_STRING,clientId);
		UpdateClientDTO dto = new UpdateClientDTO(clientId,ANY_VALID_FIRST_NAME,ANY_VALID_LAST_NAME,ANY_VALID_PHONE_NUMBER);
		IClientRepository repository = new ClientRepositoryStub(client); //Client ajouté ici
		IClientController controller = new ClientController(repository);
		
		//Act
		controller.saveClientChanges(dto);
		
		//Assert
		final boolean HAS_SET_FIRST_NAME_BEEN_CALLED = ((ClientSpy) client).hasSetFirstNameBeenCalled;
		final boolean HAS_SET_LAST_NAME_BEEN_CALLED = ((ClientSpy) client).hasSetLastNameBeenCalled;
		final boolean HAS_SET_PHONE_NUMBER_BEEN_CALLED = ((ClientSpy) client).hasSetPhoneNumberBeenCalled;
		
		assertTrue(HAS_SET_FIRST_NAME_BEEN_CALLED);
		assertTrue(HAS_SET_LAST_NAME_BEEN_CALLED);
		assertTrue(HAS_SET_PHONE_NUMBER_BEEN_CALLED);
	}
	
	@Test
	public void GIVEN_invalidClientFirstName_WHEN_savingClientChangesInClientController_THEN_setFirstNameSetLastNameAndSetPhoneNumberAreNotCalled() {
		
		//Arrange
		int clientId = ANY_VALID_ID;
		IClient client = new ClientSpy(ANY_STRING,ANY_STRING,ANY_STRING,clientId);
		UpdateClientDTO dto = new UpdateClientDTO(clientId,ANY_INVALID_FIRST_NAME,ANY_VALID_LAST_NAME,ANY_VALID_PHONE_NUMBER);
		IClientRepository repository = new ClientRepositoryStub(client); //Client ajouté ici
		IClientController controller = new ClientController(repository);
		
		//Act
		controller.saveClientChanges(dto);
		
		//Assert
		final boolean HAS_SET_FIRST_NAME_BEEN_CALLED = ((ClientSpy) client).hasSetFirstNameBeenCalled;
		final boolean HAS_SET_LAST_NAME_BEEN_CALLED = ((ClientSpy) client).hasSetLastNameBeenCalled;
		final boolean HAS_SET_PHONE_NUMBER_BEEN_CALLED = ((ClientSpy) client).hasSetPhoneNumberBeenCalled;
		
		assertFalse(HAS_SET_FIRST_NAME_BEEN_CALLED);
		assertFalse(HAS_SET_LAST_NAME_BEEN_CALLED);
		assertFalse(HAS_SET_PHONE_NUMBER_BEEN_CALLED);
	}
	
	@Test
	public void GIVEN_invalidClientLastName_WHEN_savingClientChangesInClientController_THEN_setFirstNameSetLastNameAndSetPhoneNumberAreNotCalled() {
		
		//Arrange
		int clientId = ANY_VALID_ID;
		IClient client = new ClientSpy(ANY_STRING,ANY_STRING,ANY_STRING,clientId);
		UpdateClientDTO dto = new UpdateClientDTO(clientId,ANY_VALID_FIRST_NAME,ANY_INVALID_LAST_NAME,ANY_VALID_PHONE_NUMBER);
		IClientRepository repository = new ClientRepositoryStub(client); //Client ajouté ici
		IClientController controller = new ClientController(repository);
		
		//Act
		controller.saveClientChanges(dto);
		
		//Assert
		final boolean HAS_SET_FIRST_NAME_BEEN_CALLED = ((ClientSpy) client).hasSetFirstNameBeenCalled;
		final boolean HAS_SET_LAST_NAME_BEEN_CALLED = ((ClientSpy) client).hasSetLastNameBeenCalled;
		final boolean HAS_SET_PHONE_NUMBER_BEEN_CALLED = ((ClientSpy) client).hasSetPhoneNumberBeenCalled;
		
		assertFalse(HAS_SET_FIRST_NAME_BEEN_CALLED);
		assertFalse(HAS_SET_LAST_NAME_BEEN_CALLED);
		assertFalse(HAS_SET_PHONE_NUMBER_BEEN_CALLED);
	}
	
	@Test
	public void GIVEN_invalidClientPhoneNumber_WHEN_savingClientChangesInClientController_THEN_setFirstNameSetLastNameAndSetPhoneNumberAreNotCalled() {
		
		//Arrange
		int clientId = ANY_VALID_ID;
		IClient client = new ClientSpy(ANY_STRING,ANY_STRING,ANY_STRING,clientId);
		UpdateClientDTO dto = new UpdateClientDTO(clientId,ANY_VALID_FIRST_NAME,ANY_VALID_LAST_NAME,ANY_INVALID_PHONE_NUMBER);
		IClientRepository repository = new ClientRepositoryStub(client); //Client ajouté ici
		IClientController controller = new ClientController(repository);
		
		//Act
		controller.saveClientChanges(dto);
		
		//Assert
		final boolean HAS_SET_FIRST_NAME_BEEN_CALLED = ((ClientSpy) client).hasSetFirstNameBeenCalled;
		final boolean HAS_SET_LAST_NAME_BEEN_CALLED = ((ClientSpy) client).hasSetLastNameBeenCalled;
		final boolean HAS_SET_PHONE_NUMBER_BEEN_CALLED = ((ClientSpy) client).hasSetPhoneNumberBeenCalled;
		
		assertFalse(HAS_SET_FIRST_NAME_BEEN_CALLED);
		assertFalse(HAS_SET_LAST_NAME_BEEN_CALLED);
		assertFalse(HAS_SET_PHONE_NUMBER_BEEN_CALLED);
	}
	
	@Test
	public void GIVEN_clientRepositoryWithClients_WHEN_callingGetClientListInClientController_THEN_itReturnsListOfClient() {
		
		//Arrange
		IClient client1 = new ClientStub(ANY_STRING,ANY_STRING,ANY_STRING,ANY_VALID_ID);
		IClient client2 = new ClientStub(OTHER_ANY_STRING,OTHER_ANY_STRING,OTHER_ANY_STRING,ANY_VALID_ID+1);
		
		IClientRepository repository = new ClientRepositoryStub();
		repository.addClient(client1);
		repository.addClient(client2);
		
		
		IClientController controller = new ClientController(repository);
		
		List<DisplayClientDTO> list = new ArrayList<DisplayClientDTO>();
		
		list.add(new DisplayClientDTO(client1));
		list.add(new DisplayClientDTO(client2));
		
		//Act
		final List<DisplayClientDTO> ACTUAL_CLIENT_LIST =controller.getClientList();
		
		//Assert
		assertEquals(list.size(),ACTUAL_CLIENT_LIST.size());
		
		for (int i = 0; i < ACTUAL_CLIENT_LIST.size();i++) {
			assertEquals(list.get(i).ID,ACTUAL_CLIENT_LIST.get(i).ID);
			assertEquals(list.get(i).FIRST_NAME,ACTUAL_CLIENT_LIST.get(i).FIRST_NAME);
			assertEquals(list.get(i).LAST_NAME,ACTUAL_CLIENT_LIST.get(i).LAST_NAME);
			assertEquals(list.get(i).PHONE_NUMBER,ACTUAL_CLIENT_LIST.get(i).PHONE_NUMBER);
		}

	}
	
	@Test
	public void GIVEN_clientRepositoryWithClients_WHEN_callingGetClientListByNameInClientController_THEN_itReturnsTheSortedList() {
		
		//Arrange
		
		final String LAST_NAME1 = "Tremblay";
		final String LAST_NAME2 = "Avoine";
		final String LAST_NAME3 = "Gallant";
		
		IClient client1 = new ClientStub(ANY_STRING,LAST_NAME1,ANY_STRING,ANY_VALID_ID);
		IClient client2 = new ClientStub(ANY_STRING,LAST_NAME2,ANY_STRING,ANY_VALID_ID+1);
		IClient client3 = new ClientStub(ANY_STRING,LAST_NAME3,ANY_STRING,ANY_VALID_ID+2);
		
		IClientRepository repository = new ClientRepositoryStub();
		repository.addClient(client1);
		repository.addClient(client2);
		repository.addClient(client3);
		
		IClientController controller = new ClientController(repository);
		
		List<DisplayClientDTO> expectedSortedlist = new ArrayList<DisplayClientDTO>();
		
		expectedSortedlist.add(new DisplayClientDTO(client2));
		expectedSortedlist.add(new DisplayClientDTO(client3));
		expectedSortedlist.add(new DisplayClientDTO(client1));
		
		//Act
		final List<DisplayClientDTO> ACTUAL_CLIENT_LIST =controller.getClientListByName();
		
		//Assert
		assertEquals(expectedSortedlist.size(),ACTUAL_CLIENT_LIST.size());
		
		for (int i = 0; i < ACTUAL_CLIENT_LIST.size();i++) {
			assertEquals(expectedSortedlist.get(i).ID,ACTUAL_CLIENT_LIST.get(i).ID);
			assertEquals(expectedSortedlist.get(i).FIRST_NAME,ACTUAL_CLIENT_LIST.get(i).FIRST_NAME);
			assertEquals(expectedSortedlist.get(i).LAST_NAME,ACTUAL_CLIENT_LIST.get(i).LAST_NAME);
			assertEquals(expectedSortedlist.get(i).PHONE_NUMBER,ACTUAL_CLIENT_LIST.get(i).PHONE_NUMBER);
		}

	}
	
	
	@Test
	public void GIVEN_clientRepositoryWithClients_WHEN_callingGetClientListByPhoneNumberInClientController_THEN_itReturnsTheSortedList() {
		
		//Arrange
		
		final String PHONE_NUMBER1 = "555-555-5555";
		final String PHONE_NUMBER2 = "111-111-1111";
		final String PHONE_NUMBER3 = "999-999-9999";
		
		IClient client1 = new ClientStub(ANY_STRING,ANY_STRING,PHONE_NUMBER1,ANY_VALID_ID);
		IClient client2 = new ClientStub(ANY_STRING,ANY_STRING,PHONE_NUMBER2,ANY_VALID_ID+1);
		IClient client3 = new ClientStub(ANY_STRING,ANY_STRING,PHONE_NUMBER3,ANY_VALID_ID+2);
		
		IClientRepository repository = new ClientRepositoryStub();
		repository.addClient(client1);
		repository.addClient(client2);
		repository.addClient(client3);
		
		IClientController controller = new ClientController(repository);
		
		List<DisplayClientDTO> expectedSortedlist = new ArrayList<DisplayClientDTO>();
		
		expectedSortedlist.add(new DisplayClientDTO(client2));
		expectedSortedlist.add(new DisplayClientDTO(client1));
		expectedSortedlist.add(new DisplayClientDTO(client3));
		
		//Act
		final List<DisplayClientDTO> ACTUAL_CLIENT_LIST =controller.getClientListByPhoneNumber();
		
		//Assert
		assertEquals(expectedSortedlist.size(),ACTUAL_CLIENT_LIST.size());
		
		for (int i = 0; i < ACTUAL_CLIENT_LIST.size();i++) {
			assertEquals(expectedSortedlist.get(i).ID,ACTUAL_CLIENT_LIST.get(i).ID);
			assertEquals(expectedSortedlist.get(i).FIRST_NAME,ACTUAL_CLIENT_LIST.get(i).FIRST_NAME);
			assertEquals(expectedSortedlist.get(i).LAST_NAME,ACTUAL_CLIENT_LIST.get(i).LAST_NAME);
			assertEquals(expectedSortedlist.get(i).PHONE_NUMBER,ACTUAL_CLIENT_LIST.get(i).PHONE_NUMBER);
		}

	}
	
	//Collections.sort(list,new ClientNameComparator());
}
