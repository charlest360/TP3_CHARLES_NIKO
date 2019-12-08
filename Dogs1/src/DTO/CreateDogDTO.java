package DTO;

public class CreateDogDTO {
	public final String NAME;
	public final String BREED;
	public final int OWNER_ID;
	
	public CreateDogDTO(String name,String breed,int ownerId) {
		this.NAME = name;
		this.BREED = breed;
		this.OWNER_ID = ownerId;
	}
	
}
