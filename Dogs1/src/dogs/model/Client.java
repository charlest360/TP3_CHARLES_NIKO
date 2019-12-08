package dogs.model;

import DTO.CreateClientDTO;

import DTO.UpdateClientDTO;

public class Client implements IClient {
	
	public final static int MINIMUM_CHARS_IN_ID = 1;
	public final static int MINIMUM_CHARS_IN_FIRST_NAME = 2;
	public final static int MINIMUM_CHARS_IN_LAST_NAME = 2;
	public final static int NUMBER_CHARS_IN_PHONE_NUMBER = 12;
	
	private static final int DEFAULT_CLIENT_NUMBER_VALUE = 1;
	private static int currentClientNumber = DEFAULT_CLIENT_NUMBER_VALUE;
	
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	public Client(String firstName, String lastName, String phoneNumber, int clientID) {
		this.id = clientID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	public Client(String firstName, String lastName, String telephoneNumber) {
		this(firstName, lastName, telephoneNumber, Client.currentClientNumber);
		Client.currentClientNumber ++;
	}
	
	public Client(Client client) {
		this(client.getFirstName(), client.getLastName(), client.getPhoneNumber(), client.getId());
	}
	
	public Client(CreateClientDTO client) {
		this(client.FIRST_NAME, client.LAST_NAME, client.PHONE_NUMBER);
	}
	
	public Client(UpdateClientDTO client) {
		this(client.FIRST_NAME, client.LAST_NAME, client.PHONE_NUMBER,client.ID);
	}

	public int getId() {
		return this.id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
