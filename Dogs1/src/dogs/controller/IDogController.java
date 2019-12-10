package dogs.controller;

import java.util.List;

import DTO.CreateDogDTO;
import DTO.DeleteDogDTO;
import DTO.DisplayDogDTO;
import DTO.UpdateDogDTO;

public interface IDogController extends IController {
	public void showDisplayDogsView();
	public void showAddDogsView();
	public void addDog(CreateDogDTO dto);
	public void getDogMatchId(String id);
	public void saveDogChanges(UpdateDogDTO dto);
	public void deleteDog(DeleteDogDTO dto);
	public void removeDog(DeleteDogDTO dto);
	public List<DisplayDogDTO> getDogList();
	public void getDogMatchBreed(String breed);
	
}
