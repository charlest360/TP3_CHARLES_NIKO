package DTO;

public class CreateClientDTO {
	public final String FIRST_NAME;
	public final String LAST_NAME;
	public final String PHONE_NUMBER;
	
	public CreateClientDTO(String firstName,String lastName,String phoneNumber) {
		this.FIRST_NAME = firstName;
		this.LAST_NAME = lastName;
		this.PHONE_NUMBER = phoneNumber;
	}
}
