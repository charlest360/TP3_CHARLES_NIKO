package DTO;

public class UpdateDogDTO {
	public final String NAME;
	public final String BREED;
	public final int ID;
	public final int OWNER_ID;
	
	public UpdateDogDTO(int id,String name,String breed,int ownerId) {
		this.ID = id;
		this.NAME = name;
		this.BREED = breed;
		this.OWNER_ID = ownerId;
		
	}
}
