package dogs.comparator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import DTO.DisplayClientDTO;
import dogs.model.IClient;
import model.mock.ClientStub;

public class ClientPhoneComparatorTest {
	private final String ANY_STRING = "a string";
	private final int ANY_INT = 10;
	
	@Test
	public void GIVEN_twoClientsWithSamePhoneNb_WHEN_comparingThem_THEN_compareReturnsZero() {
		//Arrange
		String phoneNb = "418-999-9999";
		
		IClient client1 = new ClientStub(ANY_STRING,ANY_STRING,phoneNb,ANY_INT);
		IClient client2 = new ClientStub(ANY_STRING,ANY_STRING,phoneNb,ANY_INT);
		
		ClientPhoneComparator comparator = new ClientPhoneComparator();
		
		
		//Act
		final int ACTUAL_RESULT =comparator.compare(new DisplayClientDTO(client1), new DisplayClientDTO(client2));
		final int EXPECTED_RESULT = 0;
		//Assert
		
		assertEquals(EXPECTED_RESULT, ACTUAL_RESULT);
	}
	
	@Test
	public void GIVEN_firstCLientWithPhoneNbBeforePhoneNbOfSecondClient_WHEN_comparingThem_THEN_compareReturnsNegativeInt() {
		//Arrange
		String phoneNb1 = "418-123-4567";
		String phoneNb2 = "418-987-6543";
				
		IClient client1 = new ClientStub(ANY_STRING,ANY_STRING,phoneNb1,ANY_INT);
		IClient client2 = new ClientStub(ANY_STRING,ANY_STRING,phoneNb2,ANY_INT);
				
		ClientPhoneComparator comparator = new ClientPhoneComparator();
			
				
		//Act
		final int ACTUAL_RESULT =comparator.compare(new DisplayClientDTO(client1), new DisplayClientDTO(client2));
		final int EXPECTED_RESULT = -1;
		//Assert
				
		assertEquals(EXPECTED_RESULT, Math.signum(ACTUAL_RESULT),0);
	}
	
	@Test
	public void GIVEN_firstCLientWithPhoneNbAfterPhoneNbOfSecondClient_WHEN_comparingThem_THEN_compareReturnsPositiveInt() {
		//Arrange
		String phoneNb1 = "418-111-1119";
		String phoneNb2 = "418-111-1118";
						
		IClient client1 = new ClientStub(ANY_STRING,ANY_STRING,phoneNb1,ANY_INT);
		IClient client2 = new ClientStub(ANY_STRING,ANY_STRING,phoneNb2,ANY_INT);
						
		ClientPhoneComparator comparator = new ClientPhoneComparator();
					
						
		//Act
		final int ACTUAL_RESULT =comparator.compare(new DisplayClientDTO(client1), new DisplayClientDTO(client2));
		final int EXPECTED_RESULT = 1;
		//Assert
						
		assertEquals(EXPECTED_RESULT, Math.signum(ACTUAL_RESULT),0);
	}
}
