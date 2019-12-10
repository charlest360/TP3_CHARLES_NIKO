package dogs.model;


import org.junit.Assert;
import org.junit.Test;

public class ClientTest {
		
	private String ANY_FIRST_NAME = "Charles";
	private String ANY_LAST_NAME = "Tremblay";
	private String ANY_PHONE_NUMBER = "(418) 123-4567";
	
	@Test
	public void GIVEN_client_WHEN_creatingClient_THEN_theClientNumberIncrease() {
		//Arrange	
		Client client = new Client(ANY_FIRST_NAME, ANY_LAST_NAME, ANY_PHONE_NUMBER);
		
		//Act
		Client client1 = new Client(ANY_FIRST_NAME, ANY_LAST_NAME, ANY_PHONE_NUMBER);
	
		//Assert
		final int ACTUAL_VALUE = client1.getId();
		final int EXPECTED_VALUE = client.getId() + 1;
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
		
	@Test
	public void CreateClient_getFirstName_returnGoodFirstName() {
		//Arrange
		String firstName = "Gary";
		Client client = new Client(firstName, ANY_LAST_NAME, ANY_PHONE_NUMBER);
		
		//Act
		final String EXPECTED_VALUE = firstName;
		final String ACTUAL_VALUE = client.getFirstName();
		
		//Assert	
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
		
	@Test
	public void CreateClient_getLastName_returnGoodLastName() {
		//Arrange
		String lastName = "Picasso";
		Client client = new Client(ANY_FIRST_NAME, lastName, ANY_PHONE_NUMBER);
		
		//Act
		final String EXPECTED_VALUE = lastName;
		final String ACTUAL_VALUE = client.getLastName();
		
		//Assert	
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
		
		@Test
		public void CreateClient_getPhoneNumber_returnGoodPhoneNumber() {
			//Arrange
			String phoneNumber = "418-444-4444";
			Client client = new Client(ANY_FIRST_NAME, ANY_LAST_NAME, phoneNumber);
			
			//Act
			final String ACTUAL_VALUE = client.getPhoneNumber();
			final String EXPECTED_VALUE = phoneNumber;
			
			//Assert
			Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
		}
		
		@Test
		public void CreateClient_setFirstName_returnChangedPhoneNumber() {
			//Arrange
			String secondName = "Niko";
			Client client = new Client(ANY_FIRST_NAME, ANY_LAST_NAME, ANY_PHONE_NUMBER);
			
			//Act
			client.setFirstName(secondName);
			
			//Assert
			final String EXPECTED_VALUE = secondName;
			final String ACTUAL_VALUE = client.getFirstName();
			
			Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
		}
		
		@Test
		public void CreateClient_setLastName_returnChangedPhoneNumber() {
			//Arrange
			String secondName = "Gallant";
			Client client = new Client(ANY_FIRST_NAME, ANY_LAST_NAME, ANY_PHONE_NUMBER);
			
			//Act
			client.setLastName(secondName);
			
			//Assert
			final String EXPECTED_VALUE = secondName;
			final String ACTUAL_VALUE = client.getLastName();
			
			Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
		}
		
		@Test
		public void CreateClient_setPhoneNumber_returnChangedPhoneNumber() {
			//Arrange
			String secondPhoneNumber = "418-123-4567";
			Client client = new Client(ANY_FIRST_NAME, ANY_LAST_NAME, ANY_PHONE_NUMBER);
			
			//Act
			client.setPhoneNumber(secondPhoneNumber);
			
			//Assert
			final String EXPECTED_VALUE = secondPhoneNumber;
			final String ACTUAL_VALUE = client.getPhoneNumber();
			
			Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
		}
		
		
}

