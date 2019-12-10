package dogs.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import DTO.CreateDogDTO;
import DTO.DeleteDogDTO;
import DTO.DisplayDogDTO;
import DTO.UpdateDogDTO;
import dogs.model.ClientRepositoryDummy;
import dogs.model.ClientRepositoryStub;
import dogs.model.ClientStub;
import dogs.model.DogRepositorySpy;
import dogs.model.DogRepositoryStub;
import dogs.model.DogStub;
import dogs.model.DogSpy;
import dogs.model.IClient;
import dogs.model.IClientRepository;
import dogs.model.IDog;
import dogs.model.IDogRepository;

public class DogControllerTest {
	
	private final IClientRepository ANY_CLIENT_REPOSITORY = new ClientRepositoryDummy();
	private final String ANY_STRING ="a string";
	private final String OTHER_ANY_STRING ="another string";

	private final int ANY_INT = 10;
	
	
	private final String ANY_VALID_NAME = "Pablo";
	private final String ANY_VALID_BREED = "Pug";
	private final int ANY_VALID_ID = 10;
	
	private final String ANY_INVALID_NAME = "A";
	private final String ANY_INVALID_BREED = "B";
	
	
	

	
	@Test
	public void GIVEN_clientListContainingClientAndDogWithValidAttributes_WHEN_callingAddDogInDogController_THEN_addDogIsCalledInDogRepository() {
		
		//Arrange
		IClient client = new ClientStub(ANY_STRING,ANY_STRING,ANY_STRING,ANY_INT);
		CreateDogDTO dto = new CreateDogDTO(ANY_VALID_NAME,ANY_VALID_BREED,client.getId());
		IClientRepository clientRepository = new ClientRepositoryStub(client);	//Client ajouté ici
		IDogRepository dogRepository = new DogRepositorySpy();
		
		IDogController  controller = new DogController(dogRepository,clientRepository);
		
		//Act
		controller.addDog(dto);

		//Assert
		final boolean HAS_ADD_DOG_REALLY_BEEN_CALLED = ((DogRepositorySpy) dogRepository).hasAddDogBeenCalled;
		
		assertTrue(HAS_ADD_DOG_REALLY_BEEN_CALLED);
	}
	
	@Test
	public void GIVEN_clientListNotContainingClient_WHEN_callingAddDogInDogController_THEN_addDogIsNotCalledInDogRepository() {
		
		//Arrange
		IClient client = new ClientStub(ANY_STRING,ANY_STRING,ANY_STRING,ANY_INT);
		CreateDogDTO dto = new CreateDogDTO(ANY_VALID_NAME,ANY_VALID_BREED,client.getId());
		IClientRepository clientRepository = new ClientRepositoryStub();
		IDogRepository dogRepository = new DogRepositorySpy();
		
		IDogController  controller = new DogController(dogRepository,clientRepository);
		
		//Act
		controller.addDog(dto);

		//Assert
		final boolean HAS_ADD_DOG_REALLY_BEEN_CALLED = ((DogRepositorySpy) dogRepository).hasAddDogBeenCalled;
		
		assertFalse(HAS_ADD_DOG_REALLY_BEEN_CALLED);
	}
	
	@Test
	public void GIVEN_invalidDogName_WHEN_callingAddDogInDogController_THEN_addDogIsNotCalledInDogRepository() {
		
		//Arrange
		IClient client = new ClientStub(ANY_STRING,ANY_STRING,ANY_STRING,ANY_INT);
		CreateDogDTO dto = new CreateDogDTO(ANY_INVALID_NAME,ANY_VALID_BREED,client.getId());
		IClientRepository clientRepository = new ClientRepositoryStub(client);	//Client ajouté ici
		IDogRepository dogRepository = new DogRepositorySpy();
		
		IDogController  controller = new DogController(dogRepository,clientRepository);
		
		//Act
		controller.addDog(dto);

		//Assert
		final boolean HAS_ADD_DOG_REALLY_BEEN_CALLED = ((DogRepositorySpy) dogRepository).hasAddDogBeenCalled;
		
		assertFalse(HAS_ADD_DOG_REALLY_BEEN_CALLED);
	}
	
	@Test
	public void GIVEN_invalidDogBreed_WHEN_callingAddDogInDogController_THEN_addDogIsNotCalledInDogRepository() {
		
		//Arrange
		IClient client = new ClientStub(ANY_STRING,ANY_STRING,ANY_STRING,ANY_INT);
		CreateDogDTO dto = new CreateDogDTO(ANY_VALID_NAME,ANY_INVALID_BREED,client.getId());
		IClientRepository clientRepository = new ClientRepositoryStub(client);	//Client ajouté ici
		IDogRepository dogRepository = new DogRepositorySpy();
		
		IDogController  controller = new DogController(dogRepository,clientRepository);
		
		//Act
		controller.addDog(dto);

		//Assert
		final boolean HAS_ADD_DOG_REALLY_BEEN_CALLED = ((DogRepositorySpy) dogRepository).hasAddDogBeenCalled;
		
		assertFalse(HAS_ADD_DOG_REALLY_BEEN_CALLED);
	}
	
	@Test
	public void GIVEN_dogListContainingDog_WHEN_CallingRemovesDogInDogController_THEN_removeDogIsCalledInDogRepository() {
		
		//Arrange
		IDog dog = new DogStub(ANY_VALID_ID,ANY_VALID_NAME,ANY_VALID_BREED);
		DeleteDogDTO dto = new DeleteDogDTO(dog.getId());
		IDogRepository dogRepository = new DogRepositorySpy(dog); 	//Chien ajouté ici
		IDogController controller = new DogController(dogRepository,ANY_CLIENT_REPOSITORY);
	
		//Act
		controller.removeDog(dto);

		//Assert
		final boolean HAS_REMOVE_DOG_REALLY_BEEN_CALLED = ((DogRepositorySpy) dogRepository).hasRemoveDogBeenCalled;
		
		assertTrue(HAS_REMOVE_DOG_REALLY_BEEN_CALLED);
	}
	
	@Test
	public void GIVEN_dogListNotContainingDog_WHEN_CallingRemovesDogInDogController_THEN_removeDogIsNotCalledInDogRepository() {
		
		//Arrange
		IDog dog = new DogStub(ANY_VALID_ID,ANY_VALID_NAME,ANY_VALID_BREED);
		DeleteDogDTO dto = new DeleteDogDTO(dog.getId());
		IDogRepository dogRepository = new DogRepositorySpy(); 
		IDogController controller = new DogController(dogRepository,ANY_CLIENT_REPOSITORY);

		//Act
		controller.removeDog(dto);
		
		//Assert
		final boolean HAS_REMOVE_DOG_REALLY_BEEN_CALLED = ((DogRepositorySpy) dogRepository).hasRemoveDogBeenCalled;
		
		assertFalse(HAS_REMOVE_DOG_REALLY_BEEN_CALLED);
	}
	
	@Test
	public void GIVEN_validDogAttributes_WHEN_savingDogChangesInDogController_THEN_setNameAndSetBreedAreCalledInDog() {
		
		//Arrange
		IClient client = new ClientStub(ANY_STRING,ANY_STRING,ANY_STRING,ANY_INT);
		IClientRepository clientRepository = new ClientRepositoryStub(client); //Client ajouté ici
		
		int dogId = ANY_VALID_ID;
		IDog dog = new DogSpy(dogId,ANY_STRING,ANY_STRING);
		UpdateDogDTO dto = new UpdateDogDTO(dogId,ANY_VALID_NAME,ANY_VALID_BREED,client.getId());
		IDogRepository dogRepository = new DogRepositoryStub(dog); //Client ajouté ici
		
		IDogController controller = new DogController(dogRepository,clientRepository);
		
		//Act
		controller.saveDogChanges(dto);
		
		//Assert
		final boolean HAS_SET_NAME_BEEN_CALLED = ((DogSpy) dog).hasSetNameBeenCalled;
		final boolean HAS_SET_BREED_BEEN_CALLED = ((DogSpy) dog).hasSetBreedBeenCalled;
		
		assertTrue(HAS_SET_NAME_BEEN_CALLED);
		assertTrue(HAS_SET_BREED_BEEN_CALLED);
	}
	
	
	@Test
	public void GIVEN_invalidDogName_WHEN_savingDogChangesInDogController_THEN_setNameAndSetBreedAreNotCalledInDog() {
		
		//Arrange
		IClient client = new ClientStub(ANY_STRING,ANY_STRING,ANY_STRING,ANY_INT);
		IClientRepository clientRepository = new ClientRepositoryStub(client); //Client ajouté ici
		
		int dogId = ANY_VALID_ID;
		IDog dog = new DogSpy(dogId,ANY_STRING,ANY_STRING);
		UpdateDogDTO dto = new UpdateDogDTO(dogId,ANY_INVALID_NAME,ANY_VALID_BREED,client.getId());
		IDogRepository dogRepository = new DogRepositoryStub(dog); //Client ajouté ici
		
		IDogController controller = new DogController(dogRepository,clientRepository);
		
		//Act
		controller.saveDogChanges(dto);
		
		//Assert
		final boolean HAS_SET_NAME_BEEN_CALLED = ((DogSpy) dog).hasSetNameBeenCalled;
		final boolean HAS_SET_BREED_BEEN_CALLED = ((DogSpy) dog).hasSetBreedBeenCalled;
		
		assertFalse(HAS_SET_NAME_BEEN_CALLED);
		assertFalse(HAS_SET_BREED_BEEN_CALLED);
		
	}
	
	@Test
	public void GIVEN_invalidDogBreed_WHEN_savingDogChangesInDogController_THEN_setNameAndSetBreedAreNotCalledInDog() {
		
		//Arrange
		IClient client = new ClientStub(ANY_STRING,ANY_STRING,ANY_STRING,ANY_INT);
		IClientRepository clientRepository = new ClientRepositoryStub(client); //Client ajouté ici
		
		int dogId = ANY_VALID_ID;
		IDog dog = new DogSpy(dogId,ANY_STRING,ANY_STRING);
		UpdateDogDTO dto = new UpdateDogDTO(dogId,ANY_VALID_NAME,ANY_INVALID_BREED,client.getId());
		IDogRepository dogRepository = new DogRepositoryStub(dog); //Client ajouté ici
		
		IDogController controller = new DogController(dogRepository,clientRepository);
		
		//Act
		controller.saveDogChanges(dto);
		
		//Assert
		final boolean HAS_SET_NAME_BEEN_CALLED = ((DogSpy) dog).hasSetNameBeenCalled;
		final boolean HAS_SET_BREED_BEEN_CALLED = ((DogSpy) dog).hasSetBreedBeenCalled;
		
		assertFalse(HAS_SET_NAME_BEEN_CALLED);
		assertFalse(HAS_SET_BREED_BEEN_CALLED);
		
	}
	
	@Test
	public void GIVEN_dogRepositoryWithDog_WHEN_callingGetDogListInDogController_THEN_itReturnsListOfDogs() {
		
		//Arrange		
		IDog dog1 = new DogStub(ANY_VALID_ID,ANY_STRING,ANY_STRING);
		IDog dog2 = new DogStub(ANY_VALID_ID+1,OTHER_ANY_STRING,OTHER_ANY_STRING);
		
		IDogRepository dogRepository = new DogRepositoryStub(); 
		dogRepository.addDog(dog1);
		dogRepository.addDog(dog2);
		IDogController controller = new DogController(dogRepository,ANY_CLIENT_REPOSITORY);
		
		List<DisplayDogDTO> list = new ArrayList<DisplayDogDTO>();
		
		list.add(new DisplayDogDTO(dog1));
		list.add(new DisplayDogDTO(dog2));
		
		//Act
		final List<DisplayDogDTO> ACTUAL_DOG_LIST =controller.getDogList();
		
		//Assert
		assertEquals(list.size(),ACTUAL_DOG_LIST.size());
		
		for (int i = 0; i < ACTUAL_DOG_LIST.size();i++) {
			assertEquals(list.get(i).ID,ACTUAL_DOG_LIST.get(i).ID);
			assertEquals(list.get(i).NAME,ACTUAL_DOG_LIST.get(i).NAME);
			assertEquals(list.get(i).BREED,ACTUAL_DOG_LIST.get(i).BREED);
		}
		
		
	}
	
	
	
	
	
	
}
