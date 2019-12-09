package dogs.model;

import org.junit.Assert;
import org.junit.Test;

public class ClientTest {
	
	private String firstName = "Charle";
	private String lastName = "Tremblay";
	private String telephoneNumber = "(418) 123-4567";
	
	@Test
	public void GivenClient_WhenCreatingClient_ThanTheClientNumberIncrease() {
		
		Client client = new Client(firstName, lastName, telephoneNumber);
		final int EXPECTED_VALUE = client.getId() + 1;
		
		Client client1 = new Client(firstName, lastName, telephoneNumber);
		final int ACTUAL_VALUE = client1.getId();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateClient_getFirstName_returnGoodFirstName() {
		
		Client client = new Client(firstName, lastName, telephoneNumber);
		final String EXPECTED_VALUE = firstName;
		final String ACTUAL_VALUE = client.getFirstName();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateClient_getLastName_returnGoodLastName() {
		
		Client client = new Client(firstName, lastName, telephoneNumber);
		final String EXPECTED_VALUE = lastName;
		final String ACTUAL_VALUE = client.getLastName();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateClient_getPhoneNumber_returnGoodPhoneNumber() {
		
		Client client = new Client(firstName, lastName, telephoneNumber);
		final String EXPECTED_VALUE = telephoneNumber;
		final String ACTUAL_VALUE = client.getPhoneNumber();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateClient_setFirstName_returnChangedPhoneNumber() {
		
		String secondName = "Niko";
		Client client = new Client(firstName, lastName, telephoneNumber);
		
		client.setFirstName(secondName);
		final String EXPECTED_VALUE = secondName;
		final String ACTUAL_VALUE = client.getFirstName();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateClient_setLastName_returnChangedPhoneNumber() {
		
		String secondName = "Gallant";
		Client client = new Client(firstName, lastName, telephoneNumber);
		
		client.setLastName(secondName);
		final String EXPECTED_VALUE = secondName;
		final String ACTUAL_VALUE = client.getLastName();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	@Test
	public void CreateClient_setPhoneNumber_returnChangedPhoneNumber() {
		
		String secondPhoneNumber = "(418) 123-4567";
		Client client = new Client(firstName, lastName, telephoneNumber);
		
		client.setPhoneNumber(secondPhoneNumber);
		final String EXPECTED_VALUE = secondPhoneNumber;
		final String ACTUAL_VALUE = client.getPhoneNumber();
		
		Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
	}
	
	
}
