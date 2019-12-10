package dogs.model;

import org.junit.Assert;
import org.junit.Test;

import model.mock.ClientStub;

public class ClientRepositoryTest {
	final private String ANY_FIRST_NAME = "Charles";
	final private String ANY_LAST_NAME = "Tremblay";
	final private String ANY_PHONE_NUMBER = "Tremblay";
	final private int ANY_ID = 10;
	
	
	@Test
	public void GIVEN_ClientRepository_WHEN_addingClient_THEN_TheClientIsAdded() {
		
		//Arrange
		IClient client = new ClientStub(ANY_FIRST_NAME,ANY_LAST_NAME,ANY_PHONE_NUMBER,ANY_ID);
		ClientRepository repository = new ClientRepository();
		
		//Act
		repository.addClient(client);
		
		//Assert
		final IClient ACTUAL_CLIENT = repository.getClientList().get(client.getId());
		final IClient EXPECTED_ClIENT = client;
		
		Assert.assertEquals(EXPECTED_ClIENT, ACTUAL_CLIENT);
	}
	
	
}
