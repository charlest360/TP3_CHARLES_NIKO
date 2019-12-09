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
	public List<DisplayDogDTO> getDogList();
	public void showDogMatchId(String id);
	public void SaveDogChanges(UpdateDogDTO dto);
	public void DeleteDog(DeleteDogDTO dto);
	public void RemoveDog(DeleteDogDTO dto);
	
}
