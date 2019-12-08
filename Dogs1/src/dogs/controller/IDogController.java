package dogs.controller;

import java.util.List;

import DTO.CreateDogDTO;
import DTO.DisplayDogDTO;

public interface IDogController extends IController {
	public void showDisplayDogsView();
	public void showAddDogsView();
	public void addDog(CreateDogDTO dto);
	public List<DisplayDogDTO> getDogList();
}
