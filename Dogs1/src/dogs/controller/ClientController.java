package dogs.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DTO.CreateClientDTO;
import DTO.DisplayClientDTO;
import DTO.UpdateClientDTO;
import dogs.comparator.ClientNameComparator;
import dogs.comparator.ClientPhoneComparator;
import dogs.model.Client;
import dogs.model.IClient;
import dogs.model.IClientRepository;
import dogs.view.AddClientConfirmationView;
import dogs.view.ClientErrorMessageView;
import dogs.view.AddClientView;
import dogs.view.DisplayClientMatchIdView;
import dogs.view.DisplayClientView;

public class ClientController extends Controller implements IClientController {
	
	private final static String FIRST_NAME_ERROR = "Veuillez entrer un pr�nom valide";
	private final static String LAST_NAME_ERROR = "Veuillez entrer un nom de famille valide";
	private final static String PHONE_ERROR = "Veuillez entrer un num�ro de t�l�phone valide";
	private final static String NO_ID_MATCH_ERROR = "Aucun id de client ne correspond � celui recherch�.";
	private final static String NO_NAME_MATCH_ERROR = "Aucun nom de famille de client ne correspond � celui recherch�.";
	private final static String CLIENT_ADDED_MESSAGE = "Client ajout� avec succ�s!";
	private final static String CLIENT_EDITED_MESSAGE = "Client �dit� avec succ�s!";
	
	
	private IClientRepository clientRepository;
	
	public ClientController(IClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	
	//Fonctions qui appellent des vues
	public void showDisplayClientByNameView() {
		super.showView(new DisplayClientView(this,getClientListByName()));
	}
	
	public void showDisplayClientByPhoneView() {
		super.showView(new DisplayClientView(this,getClientListByPhoneNumber()));
	}
	
	public void showAddClientsView() {
		super.showView(new AddClientView(this));
	}
	
	public void showClientConfirmationView(String message) {
		super.showView(new AddClientConfirmationView(this,message));
	}
	
	private void showClientErrorView(String errorMessage) {
		super.showView(new ClientErrorMessageView(this,errorMessage));
	}
	
	private void showClientMatchId(DisplayClientDTO dto) {
		super.showView(new DisplayClientMatchIdView(this,dto));
	}
	
	private void showClientMatchName (List<DisplayClientDTO> list) {
		super.showView(new DisplayClientView(this,list));
	}
	
	//Ajout et modification de client
	
	public void addClient(CreateClientDTO dto) {
		
		IClient client = new Client(dto);
		
		if(this.validateFormInput(client)) {
			this.clientRepository.addClient(client);	
			this.showClientConfirmationView(CLIENT_ADDED_MESSAGE);
		}
	}
	
	@Override
	public void saveClientChanges(UpdateClientDTO dto) {
		
		IClient client = new Client(dto);
		
		if(this.validateFormInput(client)) {
			IClient clientToEdit = this.clientRepository.getClientList().get(client.getId());
			
			clientToEdit.setFirstName(dto.FIRST_NAME);
			clientToEdit.setLastName(dto.LAST_NAME);
			clientToEdit.setPhoneNumber(dto.PHONE_NUMBER);
			
			this.showClientConfirmationView(CLIENT_EDITED_MESSAGE);
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
	
	public void getClientMatchId(String id) {
		this.validateClientMatchIdDTO(Integer.valueOf(id));
	}
	
	public void getClientMatchName(String name) {
		this.validateClientMatchNameDTO(name);
	}

	//Fonctions validation

	private boolean validateFormInput(IClient client) {
		boolean isClientValid = false;
		
		if(client.getFirstName().length() <Client.MINIMUM_CHARS_IN_FIRST_NAME) {
			this.showClientErrorView(FIRST_NAME_ERROR);
		}
		else if(client.getLastName().length() <Client.MINIMUM_CHARS_IN_LAST_NAME) {
			this.showClientErrorView(LAST_NAME_ERROR);
		}
		else if(client.getPhoneNumber().length() !=Client.NUMBER_CHARS_IN_PHONE_NUMBER) {
			this.showClientErrorView(PHONE_ERROR);
		}
		else {
			isClientValid =true;	
		}
		return isClientValid;
		
	}
	
	private void validateClientMatchIdDTO(int id) {
		
		if (this.clientRepository.getClientList().containsKey(id)) {
			DisplayClientDTO clientDTO = new DisplayClientDTO( this.clientRepository.getClientList().get(id));
			
			this.showClientMatchId(clientDTO);
		}
		else {
			this.showClientErrorView(NO_ID_MATCH_ERROR);
		}	
	}
	
	private void validateClientMatchNameDTO(String lastName) {
		
		List<DisplayClientDTO> list = new ArrayList<DisplayClientDTO>();
		
		this.clientRepository.getClientList().forEach((integer,client)-> {
			if(client.getLastName().equals(lastName)) {
				list.add(new DisplayClientDTO(client));
			}
		});
		
		if (list.size()>0) {
			this.showClientMatchName(list);
		}
		else {
			this.showClientErrorView(NO_NAME_MATCH_ERROR);
		}
	}
	
}
