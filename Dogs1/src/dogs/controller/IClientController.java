package dogs.controller;

import java.util.List;

import DTO.DisplayClientDTO;

public interface IClientController extends IController {

	public List<DisplayClientDTO> getClientList();
	
	public void showDisplayClientsView();
}
