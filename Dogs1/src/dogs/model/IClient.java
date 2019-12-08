package dogs.model;

public interface IClient {
	
	public int getId();
	public String getFirstName();
	public String getLastName();
	public String getPhoneNumber();
	
	public void setFirstName(String firstName);
	public void setLastName(String lastName);
	public void setPhoneNumber(String phoneNumber);
}
