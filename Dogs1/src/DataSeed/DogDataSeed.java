package DataSeed;

import dogs.model.Dog;
import dogs.model.DogRepository;

public class DogDataSeed {
	
	
	
	
	public static void AddInitialDogs(DogRepository repository) {
		
		Dog dog1 = new Dog("Bobby","Corgi");
		Dog dog2 = new Dog ("Cyris","Boxer");
		Dog dog3 = new Dog("Sylvie","Beagle");
		Dog dog4 = new Dog ("Sam","shih tzu");
		Dog dog5 = new Dog("Niko","Mastiff");
		
		repository.addDog(dog1);
		repository.addDog(dog2);
		repository.addDog(dog3);
		repository.addDog(dog4);
		repository.addDog(dog5);
		
		
	}
}
