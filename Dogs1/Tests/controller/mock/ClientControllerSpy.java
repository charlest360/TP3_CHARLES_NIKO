package controller.mock;

import java.util.List;

import DTO.CreateClientDTO;
import DTO.DisplayClientDTO;
import DTO.UpdateClientDTO;
import dogs.controller.IClientController;

public class ClientControllerSpy implements IClientController {
	

	
	public boolean showDisplayClientByNameViewWasCalled = false;
	
	public boolean showDisplayClientByPhoneViewWasCalled = false;
	
	public boolean showAddClientsViewWasCalled = false;

	public boolean getClientMatchIdWasCalled = false;
	
	public boolean getClientMatchNameWasCalled = false;
	
	

	@Override
	public void showDisplayClientByNameView() {
		this.showDisplayClientByNameViewWasCalled=true;
	}

	@Override
	public void showDisplayClientByPhoneView() {
		this.showDisplayClientByPhoneViewWasCalled=true;
	}

	@Override
	public void showAddClientsView() {
		this.showAddClientsViewWasCalled=true;
	}

	

	@Override
	public void getClientMatchId(String id) {
		this.getClientMatchIdWasCalled=true;
	}

	@Override
	public void getClientMatchName(String name) {
		this.getClientMatchNameWasCalled=true;
	}
	
	//Non-utilisées par les tests actuels
	
	@Override
	public List<DisplayClientDTO> getClientList() {
		return null;
	}

	@Override
	public void saveClientChanges(UpdateClientDTO dto) {
		
	}
	
	@Override
	public List<DisplayClientDTO> getClientListByName() {
		return null;
	}

	@Override
	public List<DisplayClientDTO> getClientListByPhoneNumber() {
		return null;
	}

	@Override
	public void addClient(CreateClientDTO dto) {
		
	}
	

}
