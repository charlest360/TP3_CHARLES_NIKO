package dogs.model;

import java.util.HashMap;
import java.util.Map;

public class DogRepository {
	
	private Map<Integer,Dog> dogList = new HashMap<Integer,Dog>();
	
	
	public void addDog(Dog dog) {
		this.dogList.put(dog.getId(), dog);
	}
	
	
	
	public Dog getDog(Integer id) {
		return this.dogList.get(id);
	}
	
	public Map<Integer,Dog> getDogList() {
		return this.dogList;
	}
}
