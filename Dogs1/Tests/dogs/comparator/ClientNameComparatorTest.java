package dogs.comparator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import DTO.DisplayClientDTO;
import dogs.model.IClient;
import model.mock.ClientStub;

public class ClientNameComparatorTest {
	private final String ANY_STRING = "a string";
	private final int ANY_INT = 10;
	
	@Test
	public void GIVEN_twoClientsWithSameName_WHEN_comparingThem_THEN_compareReturnsZero() {
		//Arrange
		String name = "Tremblay";
		
		IClient client1 = new ClientStub(ANY_STRING,name,ANY_STRING,ANY_INT);
		IClient client2 = new ClientStub(ANY_STRING,name,ANY_STRING,ANY_INT);
		
		ClientNameComparator comparator = new ClientNameComparator();
		
		
		//Act
		final int ACTUAL_RESULT =comparator.compare(new DisplayClientDTO(client1), new DisplayClientDTO(client2));
		final int EXPECTED_RESULT = 0;
		//Assert
		
		assertEquals(EXPECTED_RESULT, ACTUAL_RESULT);
	}
	
	@Test
	public void GIVEN_firstCLientWithNameBeforeNameOfSecondClient_WHEN_comparingThem_THEN_compareReturnsNegativeInt() {
		//Arrange
		String name1 = "Gallant";
		String name2 = "Tremblay";
				
		IClient client1 = new ClientStub(ANY_STRING,name1,ANY_STRING,ANY_INT);
		IClient client2 = new ClientStub(ANY_STRING,name2,ANY_STRING,ANY_INT);
				
		ClientNameComparator comparator = new ClientNameComparator();
			
				
		//Act
		final int ACTUAL_RESULT =comparator.compare(new DisplayClientDTO(client1), new DisplayClientDTO(client2));
		final int EXPECTED_RESULT = -1;
		//Assert
				
		assertEquals(EXPECTED_RESULT, Math.signum(ACTUAL_RESULT),0);
	}
	
	@Test
	public void GIVEN_firstCLientWithNameAfterNameOfSecondClient_WHEN_comparingThem_THEN_compareReturnsPositiveInt() {
		//Arrange
		String name1 = "Tremblay";
		String name2 = "Picasso";
						
		IClient client1 = new ClientStub(ANY_STRING,name1,ANY_STRING,ANY_INT);
		IClient client2 = new ClientStub(ANY_STRING,name2,ANY_STRING,ANY_INT);
						
		ClientNameComparator comparator = new ClientNameComparator();
					
						
		//Act
		final int ACTUAL_RESULT =comparator.compare(new DisplayClientDTO(client1), new DisplayClientDTO(client2));
		final int EXPECTED_RESULT = 1;
		//Assert
						
		assertEquals(EXPECTED_RESULT, Math.signum(ACTUAL_RESULT),0);
	}
	
}
