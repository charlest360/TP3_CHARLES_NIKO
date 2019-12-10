package dogs.model;

public class DogSpy implements IDog {
	
	
	private int id;

	
	public boolean hasSetNameBeenCalled = false;
	public boolean hasSetBreedBeenCalled = false;

	public DogSpy(int id,String name,String breed) {
		this.id = id;
		
	}
	
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setName(String name) {
		this.hasSetNameBeenCalled = true;
		
	}

	@Override
	public void setBreed(String breed) {
		this.hasSetBreedBeenCalled = true;
		
	}
	
	//Méthodes non-nécessaires à coder pour les tests
	
	@Override
	public int getOwnerId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getOwnerFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOwnerLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOwnerPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}
	


	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getBreed() {
		return null;
	}

}