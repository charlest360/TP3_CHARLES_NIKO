package dogs.comparator;

import java.util.Comparator;

import DTO.DisplayClientDTO;

public class ClientPhoneComparator implements Comparator<DisplayClientDTO>{

	@Override
	public int compare(DisplayClientDTO client1, DisplayClientDTO client2) {  
		return client1.PHONE_NUMBER.compareTo(client2.PHONE_NUMBER);
	}  

}
