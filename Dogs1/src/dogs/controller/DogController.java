package dogs.controller;

import java.util.ArrayList;
import java.util.List;
import DTO.CreateDogDTO;
import DTO.DisplayDogDTO;
import dogs.model.Dog;
import dogs.model.DogRepository;
import dogs.model.IDog;
import dogs.view.DisplayDogView;
import dogs.view.AddDogView;



public class DogController extends Controller implements IDogController {

	private DogRepository dogRepository;
	
	public DogController(DogRepository dogRepository) {
		this.dogRepository = dogRepository;
	}
	
	public void showDisplayDogsView() {
		super.showView(new DisplayDogView(this));
	}
	
	public void showAddDogsView() {
		super.showView(new AddDogView(this));
	}
	
	public void addDog(CreateDogDTO dto) {
		IDog dog = new Dog(dto);
		this.dogRepository.addDog(dog);	
	}
	
	/*public void addListener(IDogListener listener) {
        this.repository.addListener(listener);
    }*/
	
	public List<DisplayDogDTO> getDogList() { 
		List<DisplayDogDTO> list = new ArrayList<DisplayDogDTO>();
		
		this.dogRepository.getDogList().forEach((integer,dog)-> {
			list.add(new DisplayDogDTO(dog));
		});
		
		return list;
	}

	
		
	
	
}
