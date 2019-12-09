package dogs.model;

import org.junit.Assert;
import org.junit.Test;

import dogs.model.Breed;
import dogs.model.Dog;

public class DogTest {
	
	private String Name = "toto";
	private String breed = "Beagle";
	private String firstName = "Charle";
	private String lastName = "Tremblay";
	private String telephoneNumber = "(418) 123-4567";
	private IClient owner = new Client(firstName, lastName, telephoneNumber);
	
	@Test
	public void GivenClient_WhenCreatingClient_ThanTheClientNumberIncrease() {
		Dog dog = new Dog(Name, breed, owner);
		final int EXPECTED_VALUE = dog.getId() + 1;
		
		Dog dog1 = new Dog(Name, breed, owner);
		final int ACTUAL_VALUE = dog1.getId();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateDog_getName_returnGoodName() {
		
		Dog dog = new Dog(Name, breed, owner);
		final String EXPECTED_VALUE = Name;
		final String ACTUAL_VALUE = dog.getName();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateDog_getBreed_returnGoodBreed() {
		
		Dog dog = new Dog(Name, breed, owner);
		final String EXPECTED_VALUE = breed;
		final String ACTUAL_VALUE = dog.getBreed();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateDog_getOwnerFirstName_returnGoodOwnerFirstName() {
		
		Dog dog = new Dog(Name, breed, owner);
		final String EXPECTED_VALUE = firstName;
		final String ACTUAL_VALUE = dog.getOwnerFirstName();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateDog_getOwnerLastName_returnGoodOwnerLastName() {
		
		Dog dog = new Dog(Name, breed, owner);
		final String EXPECTED_VALUE = lastName;
		final String ACTUAL_VALUE = dog.getOwnerLastName();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateDog_getOwnerPhoneNumber_returnGoodOwnerPhoneNumber() {
		
		Dog dog = new Dog(Name, breed, owner);
		final String EXPECTED_VALUE = telephoneNumber;
		final String ACTUAL_VALUE = dog.getOwnerPhoneNumber();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateDog_setName_returnChangedName() {
		
		String secondName = "pitou";
		Dog dog = new Dog(Name, breed, owner);
		
		dog.setName(secondName);
		final String EXPECTED_VALUE = secondName;
		final String ACTUAL_VALUE = dog.getName();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateDog_setBreed_returnChangedBreed() {
		
		String secondBreed = "Mastiff";
		Dog dog = new Dog(Name, breed, owner);
		
		dog.setBreed(secondBreed);
		final String EXPECTED_VALUE = secondBreed;
		final String ACTUAL_VALUE = dog.getBreed();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
}
