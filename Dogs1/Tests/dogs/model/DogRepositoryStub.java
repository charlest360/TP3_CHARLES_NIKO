package dogs.model;

import java.util.HashMap;
import java.util.Map;

public class DogRepositoryStub implements IDogRepository {

	private Map<Integer,IDog> dogList = new HashMap<Integer,IDog>();
	
	public DogRepositoryStub() {
		
	}
	
	public DogRepositoryStub(IDog dog) {
		this.addDog(dog);
	}
	
	@Override
	public void addDog(IDog dog) {
		this.dogList.put(dog.getId(),dog);
	}

	@Override
	public Map<Integer, IDog> getDogList() {
		return this.dogList;
	}
	
	@Override
	public void removeDog(int id) {
		this.dogList.remove(id);
	}
}