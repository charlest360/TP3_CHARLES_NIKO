package dogs.model;

import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.Test;


import model.mock.DogStub;

public class DogRepositoryTest {
	
	final private String ANY_NAME = "toto";
	final private String ANY_BREED = "Beagle";
	final private int ANY_ID = 10;
	
	
	@Test
	public void GIVEN_dogRepository_WHEN_addingDog_THEN_TheDogIsAdded() {
		
		//Arrange
		IDog dog = new DogStub(ANY_ID, ANY_NAME, ANY_BREED);
		DogRepository repository = new DogRepository();
		
		//Act
		repository.addDog(dog);
		
		//Assert
		final IDog ACTUAL_DOG = repository.getDogList().get(dog.getId());
		final IDog EXPECTED_DOG = dog;
		
		Assert.assertEquals(EXPECTED_DOG, ACTUAL_DOG);
	}
	
	@Test
	public void GIVEN_dogRepository_WHEN_removingDog_THEN_TheDogIsRemoved() {
		
		//Arrange
		IDog dog = new DogStub(ANY_ID, ANY_NAME, ANY_BREED);
		DogRepository repository = new DogRepository();
		repository.addDog(dog);
		
		//Act
		repository.removeDog(dog.getId());
		
		//Assert
		final boolean isDogInList = repository.getDogList().containsKey(dog.getId());
		
		assertFalse(isDogInList);
	}
}
