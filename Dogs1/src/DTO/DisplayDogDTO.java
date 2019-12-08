package DTO;

import dogs.model.IDog;

public class DisplayDogDTO {
	public final int ID;
	public final String NAME;
	public final String BREED;
	
	public DisplayDogDTO(IDog dog) {
		this.ID = dog.getId();
		this.NAME = dog.getName();
		this.BREED = dog.getBreed();
	}
}
