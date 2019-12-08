package DataSeed;

import dogs.model.Client;
import dogs.model.ClientRepository;
import dogs.model.Dog;
import dogs.model.DogRepository;
import dogs.model.IClient;
import dogs.model.IDog;

public class DataSeeder {
	
	
	
	
	public static void AddInitialDogsAndClients(DogRepository dogRepository,ClientRepository clientRepository ) {
		
		IDog dog1 = new Dog("Bobby","Corgi");
		IDog dog2 = new Dog ("Cyrice","Boxer");
		IDog dog3 = new Dog("Sylvie","Beagle");
		IDog dog4 = new Dog ("Sam","Shih tzu");
		IDog dog5 = new Dog("Niko","Mastiff");
		IDog dog6 = new Dog("Charles","Border collie");
		
		dogRepository.addDog(dog1);
		dogRepository.addDog(dog2);
		dogRepository.addDog(dog3);
		dogRepository.addDog(dog4);
		dogRepository.addDog(dog5);
		dogRepository.addDog(dog6);
		
		IClient client1 = new Client("Aobby", "Bvoine", "418-123-4567");
		IClient client2 = new Client("Pyrice", "Caradis", "418-123-1234");
		IClient client3 = new Client("Aylvie", "Slain", "418-987-6543");
		IClient client4 = new Client("Dam", "Sufresne", "418-666-6666");
		IClient client5 = new Client("Giko", "Nallant", "418-000-0150");
		IClient client6 = new Client("Tharles", "Cremblay", "418-884-4848");
		
		clientRepository.addClient(client1);
		clientRepository.addClient(client2);
		clientRepository.addClient(client3);
		clientRepository.addClient(client4);
		clientRepository.addClient(client5);
		clientRepository.addClient(client6);
	}
}
