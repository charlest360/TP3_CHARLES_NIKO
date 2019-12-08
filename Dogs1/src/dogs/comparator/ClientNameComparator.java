package dogs.comparator;

import java.util.Comparator;

import DTO.DisplayClientDTO;

public class ClientNameComparator implements Comparator<DisplayClientDTO>{

	@Override
	public int compare(DisplayClientDTO client1, DisplayClientDTO client2) {  
		return client1.LAST_NAME.compareTo(client2.LAST_NAME);  
	}  

}
