package controller.mock;

import java.util.List;

import DTO.CreateDogDTO;
import DTO.DeleteDogDTO;
import DTO.DisplayDogDTO;
import DTO.UpdateDogDTO;
import dogs.controller.IDogController;

public class DogControllerSpy implements IDogController{
	
	public boolean showDisplayDogsViewWasCalled = false;
	public boolean showAddDogsViewWasCalled=false;
	public boolean getDogMatchIdWasCalled=false;
	public boolean getDogMatchBreedWasCalled=false;

	@Override
	public void showDisplayDogsView() {
		this.showDisplayDogsViewWasCalled = true;	
	}

	@Override
	public void showAddDogsView() {
		this.showAddDogsViewWasCalled = true;
		
	}
	
	@Override
	public void getDogMatchBreed(String breed) {
		this.getDogMatchBreedWasCalled = true;
		
	}
	
	@Override
	public void getDogMatchId(String id) {
		this.getDogMatchIdWasCalled = true;
		
	}

	@Override
	public void addDog(CreateDogDTO dto) {
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

	

}
