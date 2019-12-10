package dogs.model;

import java.util.HashMap;
import java.util.Map;

public class DogRepository implements IDogRepository {
	
	private Map<Integer,IDog> dogList = new HashMap<Integer,IDog>();
	
	
	public void addDog(IDog dog) {
		this.dogList.put(dog.getId(), dog);
	}
	
	public Map<Integer,IDog> getDogList() {
		return this.dogList;
	}

	public void removeDog(int dogId) {
		this.dogList.remove(dogId);
	}
}
