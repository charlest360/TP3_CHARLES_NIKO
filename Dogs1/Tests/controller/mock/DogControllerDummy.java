package controller.mock;

import java.util.List;

import DTO.CreateDogDTO;
import DTO.DeleteDogDTO;
import DTO.DisplayDogDTO;
import DTO.UpdateDogDTO;
import dogs.controller.IDogController;

public class DogControllerDummy implements IDogController {

	@Override
	public void showDisplayDogsView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAddDogsView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDog(CreateDogDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDogMatchId(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveDogChanges(UpdateDogDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDog(DeleteDogDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeDog(DeleteDogDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DisplayDogDTO> getDogList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getDogMatchBreed(String breed) {
		// TODO Auto-generated method stub
		
	}

}
