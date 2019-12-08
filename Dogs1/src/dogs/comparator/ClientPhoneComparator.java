package dogs.comparator;

import java.util.Comparator;

import DTO.DisplayClientDTO;

public class ClientPhoneComparator implements Comparator<DisplayClientDTO>{

	@Override
	public int compare(DisplayClientDTO client1, DisplayClientDTO client2) {  
		
		//String phone1 = client1.PHONE_NUMBER.replace("-", "");
		
		
		/*if(client1.PHONE_NUMBER==client2.PHONE_NUMBER)   {
			return 0;  
		}
		else if(client1.PHONE_NUMBER>client2.PHONE_NUMBER) {  
			return 1;  
		}
		else  
			return -1;  
		}  */
		
		return client1.PHONE_NUMBER.compareTo(client2.PHONE_NUMBER);
	}  

}
