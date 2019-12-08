package dogs.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DTO.CreateClientDTO;
import DTO.DisplayClientDTO;
import DTO.IClientModificationDTO;
import DTO.UpdateClientDTO;
import dogs.comparator.ClientNameComparator;
import dogs.comparator.ClientPhoneComparator;
import dogs.model.Client;
import dogs.model.ClientRepository;
import dogs.model.IClient;
import dogs.view.AddClientConfirmationView;
import dogs.view.ClientErrorMessageView;
import dogs.view.AddClientView;
import dogs.view.DisplayClientByPhoneView;
import dogs.view.DisplayClientMatchIdView;
import dogs.view.DisplayClientView;

public class ClientController extends Controller implements IClientController {
	
	private final static String FIRST_NAME_ERROR = "Veuillez entrer un prénom valide";
	private final static String LAST_NAME_ERROR = "Veuillez entrer un nom de famille valide";
	private final static String PHONE_ERROR = "Veuillez entrer un numéro de téléphone valide";
	private final static String NO_ID_MATCH_ERROR = "Aucun id de client ne correspond à celui recherché.";
	private final static String NO_NAME_MATCH_ERROR = "Aucun nom de famille de client ne correspond à celui recherché.";
	
	private final static String CLIENT_ADDED_MESSAGE = "Client ajouté avec succès!";
	private final static String CLIENT_EDITED_MESSAGE = "Client édité avec succès!";
	
	
	private ClientRepository clientRepository;
	
	public ClientController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public void showDisplayClientByNameView() {
		super.showView(new DisplayClientView(this,getClientListByName()));
	}
	
	public void showDisplayClientByPhoneView() {
		super.showView(new DisplayClientView(this,getClientListByPhoneNumber()));
	}
	
	public void showAddClientsView() {
		super.showView(new AddClientView(this));
	}
	
	public void addClient(CreateClientDTO dto) {
		
		IClient client = new Client(dto);
		
		if(this.validateFormInput(client)) {
			this.clientRepository.addClient(client);	
			this.showClientConfirmationView(CLIENT_ADDED_MESSAGE);
		}
	}
	
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

	public void showClientConfirmationView(String message) {
		super.showView(new AddClientConfirmationView(this,message));
		
	}
	
	private void showClientErrorView(String errorMessage) {
		super.showView(new ClientErrorMessageView(this,errorMessage));
		
	}

	private boolean validateFormInput(IClient client) {
		boolean isClientValid = false;
		
		if(client.getFirstName().length() <2) {
			this.showClientErrorView(FIRST_NAME_ERROR);
		}
		else if(client.getLastName().length() <2) {
			this.showClientErrorView(LAST_NAME_ERROR);
		}
		else if(client.getPhoneNumber().length() !=12) {
			this.showClientErrorView(PHONE_ERROR);
		}
		else {
			isClientValid =true;	
		}
		return isClientValid;
		
	}

	@Override
	public void showClientMatchId(String id) {
		
		int idNumber =Integer.valueOf(id);
		
		if (this.clientRepository.getClientList().containsKey(idNumber)) {
			DisplayClientDTO clientDTO = new DisplayClientDTO( this.clientRepository.getClientList().get(idNumber));
			super.showView(new DisplayClientMatchIdView(this,clientDTO));
		}
		else {
			this.showClientErrorView(NO_ID_MATCH_ERROR);
		}
	}

	@Override
	public void SaveClientChanges(UpdateClientDTO dto) {
		
		IClient client = new Client(dto);
		
		if(this.validateFormInput(client)) {
			IClient clientToEdit = this.clientRepository.getClientList().get(client.getId());
			
			clientToEdit.setFirstName(dto.FIRST_NAME);
			clientToEdit.setLastName(dto.LAST_NAME);
			clientToEdit.setPhoneNumber(dto.PHONE_NUMBER);
			
			this.showClientConfirmationView(CLIENT_EDITED_MESSAGE);
		}
	}

	@Override
	public void showClientsMatchName(String lastName) {
		
		List<DisplayClientDTO> list = new ArrayList<DisplayClientDTO>();
		
		this.clientRepository.getClientList().forEach((integer,client)-> {
			if(client.getLastName().equals(lastName)) {
				list.add(new DisplayClientDTO(client));
			}
		});
		
		if (list.size()>0) {
			super.showView(new DisplayClientView(this,list));
		}
		else {
			this.showClientErrorView(NO_NAME_MATCH_ERROR);
		}
	}
	
	
}
