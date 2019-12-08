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
}
