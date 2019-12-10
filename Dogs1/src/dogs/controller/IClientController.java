package dogs.controller;

import java.util.List;

import DTO.CreateClientDTO;
import DTO.DisplayClientDTO;
import DTO.UpdateClientDTO;

public interface IClientController extends IController {

	public List<DisplayClientDTO> getClientList();
	
	public void showDisplayClientByNameView();
	
	public void showDisplayClientByPhoneView();
	
	public void showAddClientsView();

	public List<DisplayClientDTO> getClientListByName();
	
	public List<DisplayClientDTO> getClientListByPhoneNumber();

	public void addClient(CreateClientDTO dto);

	public void getClientMatchId(String id);
	
	public void getClientMatchName(String name);
	
	public void saveClientChanges(UpdateClientDTO dto);

	
	
	
	
}
