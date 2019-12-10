package dogs.model;

public class ClientSpy implements IClient {
	
	public boolean hasSetFirstNameBeenCalled = false;
	public boolean hasSetLastNameBeenCalled = false;
	public boolean hasSetPhoneNumberBeenCalled = false;
	
	private int id;
	
	public ClientSpy(String firstName, String lastName, String phoneNumber, int clientId) {
		this.id = clientId;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFirstName(String firstName) {
		this.hasSetFirstNameBeenCalled = true;
		
	}

	@Override
	public void setLastName(String lastName) {
		this.hasSetLastNameBeenCalled = true;
		
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.hasSetPhoneNumberBeenCalled = true;
		
	}
}
