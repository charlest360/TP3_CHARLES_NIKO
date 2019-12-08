package dogs.controller;

import java.util.ArrayList;
import java.util.List;
import DTO.CreateDogDTO;
import DTO.DisplayDogDTO;
import dogs.model.Dog;
import dogs.model.DogRepository;
import dogs.view.DisplayDogView;
import dogs.view.DogView;



public class DogController extends Controller implements IDogController {

	private DogRepository dogRepository;
	
	public DogController(DogRepository dogRepository) {
		this.dogRepository = dogRepository;
	}
	
	public void showDisplayDogsView() {
		super.showView(new DisplayDogView(this));
	}
	
	public void showAddDogsView() {
		super.showView(new DogView(this));
	}
	
	public void addDog(CreateDogDTO dto) {
		Dog dog = new Dog(dto.name,dto.breed);
		
		this.dogRepository.addDog(dog);	
	}
	
	/*public void addListener(IDogListener listener) {
        this.repository.addListener(listener);
    }*/
	
	public List<DisplayDogDTO> getDogList() { // inspiré de http://zetcode.com/java/hashmapiterate/
		List<DisplayDogDTO> list = new ArrayList<DisplayDogDTO>();
		
		this.dogRepository.getDogList().forEach((integer,dog)-> {
			list.add(new DisplayDogDTO(dog));
		});
		
		return list;
	}

	
		
	
	
}
