package dogs.model;

import java.util.HashMap;
import java.util.Map;

public class DogRepository {
	
	private Map<Integer,IDog> dogList = new HashMap<Integer,IDog>();
	
	
	public void addDog(IDog dog) {
		this.dogList.put(dog.getId(), dog);
	}
	
	
	
	public IDog getDog(Integer id) {
		return this.dogList.get(id);
	}
	
	public Map<Integer,IDog> getDogList() {
		return this.dogList;
	}
}
