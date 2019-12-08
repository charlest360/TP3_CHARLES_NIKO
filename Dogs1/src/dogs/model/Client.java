package dogs.model;

import DTO.CreateClientDTO;

public class Client implements IClient {
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
	
	public int getId() {
		return this.id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
}
