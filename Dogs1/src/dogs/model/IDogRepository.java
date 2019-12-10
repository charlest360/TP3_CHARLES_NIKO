package dogs.model;

import java.util.Map;

public interface IDogRepository {
	public void addDog(IDog dog);
	
	public Map<Integer,IDog> getDogList();

	public void removeDog(int iD);
}	
