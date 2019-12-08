package dogs.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DTO.CreateClientDTO;
import DTO.DisplayClientDTO;
import dogs.comparator.ClientNameComparator;
import dogs.comparator.ClientPhoneComparator;
import dogs.model.Client;
import dogs.model.ClientRepository;
import dogs.model.IClient;
import dogs.view.DisplayClientView;

public class ClientController extends Controller implements IClientController {

	private ClientRepository clientRepository;
	
	public ClientController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public void showDisplayClientsView() {
		super.showView(new DisplayClientView(this));
	}
	
	/*public void showAddClientsView() {
		super.showView(new AddClientsView(this));
	}*/
	
	public void addClient(CreateClientDTO dto) {
		IClient client = new Client(dto);
		this.clientRepository.addClient(client);	
	}
	
	/*public void addListener(IDogListener listener) {
        this.repository.addListener(listener);
    }*/
	
	public List<DisplayClientDTO> getClientList() { 
		List<DisplayClientDTO> list = new ArrayList<DisplayClientDTO>();
		
		this.clientRepository.getClientList().forEach((integer,client)-> {
			list.add(new DisplayClientDTO(client));
		});
		
		return list;
	}
	
	public List<DisplayClientDTO> getClientListByName() { 
		List<DisplayClientDTO> list = getClientList();
		
		Collections.sort(list,new ClientNameComparator());
		
		return list;
	}
	
	public List<DisplayClientDTO> getClientListByPhoneNumber() { 
		List<DisplayClientDTO> list = getClientList();
		
		Collections.sort(list,new ClientPhoneComparator());
		
		return list;
	}
	
	
}
