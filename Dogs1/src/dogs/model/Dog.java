package dogs.model;

import DTO.CreateDogDTO;
import DTO.UpdateDogDTO;

public class Dog implements IDog {  
	
	private int id;
	private String name;
	private String breed;  // Idéalement faire une classe Breed (préférer à une enum)
	private IClient owner;
	private static int currentId = 1;
	
	
	public Dog(String name, String breed,IClient owner) {
		//TODO: calculer l'id --> un no unique pour identifier un chien
		this.name = name;
		this.breed = breed;
		this.id = currentId;
		this.owner = owner;
		
		currentId++;
		
	}
	
	public Dog(CreateDogDTO dto, IClient owner) {
		this(dto.NAME,dto.BREED,owner);
	}

	public Dog(UpdateDogDTO dto, IClient owner) {
		this(dto.NAME,dto.BREED,owner);
	}

	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed =breed;
	}
	
	public int getOwnerId() {
		return this.owner.getId();
	}
	
	public String getOwnerFirstName() {
		return this.owner.getFirstName();
	}
	
	public String getOwnerLastName() {
		return this.owner.getLastName();
	}
	
	public String getOwnerPhoneNumber() {
		return this.owner.getPhoneNumber();
	}

	

}
