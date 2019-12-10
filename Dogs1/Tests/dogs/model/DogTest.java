package dogs.model;

import org.junit.Assert;
import org.junit.Test;

import dogs.model.Dog;
import model.mock.ClientDummy;
import model.mock.ClientStub;

public class DogTest {
	
	final private String ANY_NAME = "toto";
	final private String ANY_BREED = "Beagle";
	final private String ANY_FIRST_NAME = "Charles";
	final private String ANY_LAST_NAME = "Tremblay";
	final private String ANY_PHONE_NUMBER = "418-123-4567";
	final private int ANY_ID = 10;
	
	final private IClient ANY_OWNER = new ClientDummy();
	
	
	
	@Test
	public void GIVEN_Dog_WHEN_CreatinSecondDog_THEN_TheNextDogIdIsIncremented() {
		
		//Arrange
		Dog dog1 = new Dog(ANY_NAME, ANY_BREED, ANY_OWNER);
		
		
		//Act
		Dog dog2 = new Dog(ANY_NAME, ANY_BREED, ANY_OWNER);
		
		//Assert
		final int ACTUAL_ID = dog2.getId();
		final int EXPECTED_ID = dog1.getId() + 1;
		
		Assert.assertEquals(EXPECTED_ID, ACTUAL_ID);
	}
	
	@Test
	public void WHEN_CreateDog_THEN_callingGetNameReturnsGoodName() {
		//Arrange
		String name = "Fido";
		Dog dog = new Dog(name, ANY_BREED, ANY_OWNER);
		
		//Act
		final String ACTUAL_NAME = dog.getName();
		final String EXPECTED_NAME = name;
		
		//Assert
		Assert.assertEquals(EXPECTED_NAME, ACTUAL_NAME);
	}
	
	@Test
	public void WHEN_CreateDog_THEN_callingGetBreedReturnsGoodBreed() {
		//Arrange
		String breed = "Labarador";
		Dog dog = new Dog(ANY_NAME, breed, ANY_OWNER);
		
		//Act
		final String EXPECTED_VALUE = breed;
		final String ACTUAL_VALUE = dog.getBreed();
		
		//Assert
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateDog_getOwnerFirstName_returnGoodOwnerFirstName() {
		//Arrange
		String firstName = "Pablo";
		IClient owner = new ClientStub(firstName,ANY_LAST_NAME,ANY_PHONE_NUMBER,ANY_ID);
		Dog dog = new Dog(ANY_NAME, ANY_BREED, owner);
		
		//Act
		final String ACTUAL_VALUE = dog.getOwnerFirstName();
		final String EXPECTED_VALUE = firstName;
		
		
		//Assert
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateDog_getOwnerLastName_returnGoodOwnerLastName() {
		//Arrange
		String lastName = "Picasso";
		IClient owner = new ClientStub(ANY_FIRST_NAME,lastName,ANY_PHONE_NUMBER,ANY_ID);
		Dog dog = new Dog(ANY_NAME, ANY_BREED, owner);
		
		//Act
		final String ACTUAL_VALUE = dog.getOwnerLastName();
		final String EXPECTED_VALUE = lastName;
		
		
		//Assert
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateDog_getOwnerPhoneNumber_returnGoodOwnerPhoneNumber() {
		//Arrange
		String phoneNumber = "418-444-4444";
		IClient owner = new ClientStub(ANY_FIRST_NAME,ANY_LAST_NAME,phoneNumber,ANY_ID);
		Dog dog = new Dog(ANY_NAME, ANY_BREED, owner);
		
		//Act
		final String EXPECTED_VALUE = phoneNumber;
		final String ACTUAL_VALUE = dog.getOwnerPhoneNumber();
		
		
		//Assert
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateDog_getOwnerId_returnGoodOwnerId() {
		
		//Arrange
		int clientId = 15;
		IClient owner = new ClientStub(ANY_FIRST_NAME,ANY_LAST_NAME,ANY_PHONE_NUMBER,clientId);
		Dog dog = new Dog(ANY_NAME, ANY_BREED, owner);
		
		//Act
		final int EXPECTED_VALUE = clientId;
		final int ACTUAL_VALUE = dog.getOwnerId();
		
		
		//Assert
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateDog_setName_returnsChangedName() {
		//Arrange
		String secondName = "pitou";
		Dog dog = new Dog(ANY_NAME, ANY_BREED, ANY_OWNER);
		
		//Act
		dog.setName(secondName);
		
		//Assert
		final String ACTUAL_VALUE = dog.getName();
		final String EXPECTED_VALUE = secondName;
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateDog_setBreed_returnsChangedBreed() {
		//Arrange
		String secondBreed = "Mastiff";
		Dog dog = new Dog(ANY_NAME, ANY_BREED, ANY_OWNER);
		
		//Act
		dog.setBreed(secondBreed);
		
		//Assert
		final String EXPECTED_VALUE = secondBreed;
		final String ACTUAL_VALUE = dog.getBreed();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
}
