package DTO;

import dogs.model.IClient;

public class DisplayClientDTO {
	public final int ID;
	public final String FIRST_NAME;
	public final String LAST_NAME;
	public final String PHONE_NUMBER;
	
	public DisplayClientDTO(IClient client) {
		this.ID = client.getId();
		this.FIRST_NAME = client.getFirstName();
		this.LAST_NAME = client.getLastName();
		this.PHONE_NUMBER = client.getPhoneNumber();
	}
}
