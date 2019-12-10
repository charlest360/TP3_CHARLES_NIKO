package dogs.model;

public class DogStub implements IDog {
	
	
	private int id;
	private String name;
	private String breed;

	public DogStub(int id,String name,String breed) {
		this.id = id;
		this.name = name;
		this.breed = breed;
	}
	
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBreed() {
		return this.breed;
	}

	@Override
	public void setBreed(String breed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getOwnerId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getOwnerFirstName() {
		return "";
	}

	@Override
	public String getOwnerLastName() {
		return "";
	}

	@Override
	public String getOwnerPhoneNumber() {
		return "";
	}

}
