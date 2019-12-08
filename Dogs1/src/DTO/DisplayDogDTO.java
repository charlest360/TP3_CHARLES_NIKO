package DTO;

import dogs.model.Dog;

public class DisplayDogDTO {
	public final int id;
	public final String name;
	public final String breed;
	
	public DisplayDogDTO(Dog dog) {
		this.id = dog.getId();
		this.name = dog.getName();
		this.breed = dog.getBreed();
	}
}
