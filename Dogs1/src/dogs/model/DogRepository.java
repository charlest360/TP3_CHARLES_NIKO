package dogs.model;

import java.util.HashMap;
import java.util.Map;

public class DogRepository {
	
	private Map<Integer,IDog> dogList = new HashMap<Integer,IDog>();
	
	
	public void addDog(IDog dog) {
		this.dogList.put(dog.getId(), dog);
	}
	
	public Map<Integer,IDog> getDogList() {
		return this.dogList;
	}
}
