package DTO;

public class UpdateClientDTO implements IClientModificationDTO{
	
	public final int ID;
	public final String FIRST_NAME;
	public final String LAST_NAME;
	public final String PHONE_NUMBER;
	
	public UpdateClientDTO(int id,String firstName,String lastName,String phoneNumber) {
		this.ID = id;
		this.FIRST_NAME = firstName;
		this.LAST_NAME = lastName;
		this.PHONE_NUMBER = phoneNumber;
	}
}
