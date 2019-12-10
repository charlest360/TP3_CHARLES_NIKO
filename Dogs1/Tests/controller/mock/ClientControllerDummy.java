package controller.mock;

import java.util.List;

import DTO.CreateClientDTO;
import DTO.DisplayClientDTO;
import DTO.UpdateClientDTO;
import dogs.controller.IClientController;

public class ClientControllerDummy implements IClientController{

	@Override
	public List<DisplayClientDTO> getClientList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showDisplayClientByNameView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showDisplayClientByPhoneView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAddClientsView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DisplayClientDTO> getClientListByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DisplayClientDTO> getClientListByPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addClient(CreateClientDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getClientMatchId(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getClientMatchName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveClientChanges(UpdateClientDTO dto) {
		// TODO Auto-generated method stub
		
	}

}
