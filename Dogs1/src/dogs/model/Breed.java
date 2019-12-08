package dogs.model;

public enum Breed {
	CORGI("Corgi"), 
	BOXER("Boxer"), 
	BEAGLE("Beagle"), 
	SHIH_TZU("Shih tzu"), 
	MASTIFF("Mastiff"), 
	BORDER_COLLIE("Border collie"); 
 
	
	private String name;
	
	private Breed(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}

