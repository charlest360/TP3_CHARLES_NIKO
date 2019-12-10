package model.mock;

import java.util.HashMap;
import java.util.Map;

import dogs.model.IDog;
import dogs.model.IDogRepository;

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