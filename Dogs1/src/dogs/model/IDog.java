package dogs.model;

public interface IDog {

	public int getId();
	
	public String getName() ;
	
	public void setName(String name) ;
		
	public String getBreed() ;
	
	public void setBreed(String breed) ;
	
	
	public int getOwnerId() ;
	public String getOwnerFirstName() ;
	public String getOwnerLastName() ;
	public String getOwnerPhoneNumber() ;

}
