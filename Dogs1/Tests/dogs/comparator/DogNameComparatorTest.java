package dogs.comparator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import DTO.DisplayDogDTO;
import dogs.model.IDog;
import model.mock.DogStub;

public class DogNameComparatorTest {
	private final String ANY_STRING = "a string";
	private final int ANY_INT = 10;
	
	@Test
	public void GIVEN_twoDogsWithSameName_WHEN_comparingThem_THEN_compareReturnsZero() {
		//Arrange
		String name = "Canelle";
		
		IDog Dog1 = new DogStub(ANY_INT,name,ANY_STRING);
		IDog Dog2 = new DogStub(ANY_INT,name,ANY_STRING);
		
		DogNameComparator comparator = new DogNameComparator();
		
		
		//Act
		final int ACTUAL_RESULT =comparator.compare(new DisplayDogDTO(Dog1), new DisplayDogDTO(Dog2));
		final int EXPECTED_RESULT = 0;
		//Assert
		
		assertEquals(EXPECTED_RESULT, ACTUAL_RESULT);
	}
	
	@Test
	public void GIVEN_firstDogWithNameBeforeNameOfSecondDog_WHEN_comparingThem_THEN_compareReturnsNegativeInt() {
		//Arrange
		String name1 = "Fido";
		String name2 = "Milo";
				
		IDog Dog1 = new DogStub(ANY_INT,name1,ANY_STRING);
		IDog Dog2 = new DogStub(ANY_INT,name2,ANY_STRING);
				
		DogNameComparator comparator = new DogNameComparator();
			
				
		//Act
		final int ACTUAL_RESULT =comparator.compare(new DisplayDogDTO(Dog1), new DisplayDogDTO(Dog2));
		final int EXPECTED_RESULT = -1;
		//Assert
				
		assertEquals(EXPECTED_RESULT, Math.signum(ACTUAL_RESULT),0);
	}
	
	@Test
	public void GIVEN_firstDogWithNameAfterNameOfSecondDog_WHEN_comparingThem_THEN_compareReturnsPositiveInt() {
		//Arrange
		String name1 = "Molly";
		String name2 = "Max";
						
		IDog Dog1 = new DogStub(ANY_INT,name1,ANY_STRING);
		IDog Dog2 = new DogStub(ANY_INT,name2,ANY_STRING);
						
		DogNameComparator comparator = new DogNameComparator();
					
						
		//Act
		final int ACTUAL_RESULT =comparator.compare(new DisplayDogDTO(Dog1), new DisplayDogDTO(Dog2));
		final int EXPECTED_RESULT = 1;
		//Assert
						
		assertEquals(EXPECTED_RESULT, Math.signum(ACTUAL_RESULT),0);
	}
}
