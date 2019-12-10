package dogs.model;

import java.util.HashMap;
import java.util.Map;

public class DogRepositorySpy implements IDogRepository {

	private Map<Integer,IDog> dogList = new HashMap<Integer,IDog>();
	
	public boolean hasAddDogBeenCalled =false;
	public boolean hasRemoveDogBeenCalled =false ;
	
	public DogRepositorySpy() {
		
	}
	
	public DogRepositorySpy(IDog dog) {
		this.dogList.put(dog.getId(), dog);
	}
	
	//Fonctions implémentées
	@Override
	public void addDog(IDog dog) {
		this.hasAddDogBeenCalled =true;
	}

	@Override
	public Map<Integer, IDog> getDogList() {
		return this.dogList;
	}
	
	@Override
	public void removeDog(int id) {
		this.hasRemoveDogBeenCalled = true;
		
	}
	

	
}
