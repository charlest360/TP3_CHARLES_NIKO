package DTO;

import dogs.model.IDog;

public class DisplayDogDTO {
	public final int ID;
	public final String NAME;
	public final String BREED;
	public final int OWNER_ID;
	public final String OWNER_FIRST_NAME;
	public final String OWNER_LAST_NAME;
	public final String OWNER_PHONE_NUMBER;
	
	public DisplayDogDTO(IDog dog) {
		this.ID = dog.getId();
		this.NAME = dog.getName();
		this.BREED = dog.getBreed();
		this.OWNER_ID = dog.getOwnerId();
		this.OWNER_FIRST_NAME = dog.getOwnerFirstName();
		this.OWNER_LAST_NAME = dog.getOwnerLastName();
		this.OWNER_PHONE_NUMBER = dog.getOwnerPhoneNumber();
	}
}
