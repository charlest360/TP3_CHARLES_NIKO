package dogs.comparator;

import java.util.Comparator;

import DTO.DisplayDogDTO;

public class DogNameComparator implements Comparator<DisplayDogDTO> {

	@Override
	public int compare(DisplayDogDTO dog1, DisplayDogDTO dog2) {
		// TODO Auto-generated method stub
		return dog1.NAME.compareTo(dog2.NAME); 
	}

}
