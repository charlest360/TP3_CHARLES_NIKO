package dogs.model;

import DTO.CreateDogDTO;

public class Dog implements IDog {  
	
	private int id;
	private String name;
	private String breed;  // Id�alement faire une classe Breed (pr�f�rer � une enum)
	
	private static int currentId = 0;
	
	
	public Dog(String name, String breed) {
		//TODO: calculer l'id --> un no unique pour identifier un chien
		this.name = name;
		this.breed = breed;
		this.id = currentId;
		
		currentId++;
		
	}
	
	public Dog(CreateDogDTO dogDTO) {
		this(dogDTO.NAME,dogDTO.BREED);
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
		this.breed = breed;
	}

}
