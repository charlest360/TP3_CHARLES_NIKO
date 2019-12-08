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
	
	private ClientRepository clientRepository;
	
	public ClientController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public void showDisplayClientByNameView() {
		super.showView(new DisplayClientView(this));
	}
	
	public void showDisplayClientByPhoneView() {
		super.showView(new DisplayClientByPhoneView(this));
	}
	
	public void showAddClientsView() {
		super.showView(new AddClientView(this));
	}
	
	public void addClient(CreateClientDTO dto) {
		this.validateFormInput(dto);
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

	
	public void showAddClientConfirmationView() {
		super.showView(new AddClientConfirmationView(this));
		
	}
	
	private void showClientErrorView(String errorMessage) {
		super.showView(new ClientErrorMessageView(this,errorMessage));
		
	}

	private void validateFormInput(CreateClientDTO clientDTO) {
		
		if(clientDTO.FIRST_NAME.length() <2) {
			this.showClientErrorView(FIRST_NAME_ERROR);
		}
		else if(clientDTO.LAST_NAME.length() <2) {
			this.showClientErrorView(LAST_NAME_ERROR);
		}
		else if(clientDTO.PHONE_NUMBER.length() <12) {
			this.showClientErrorView(PHONE_ERROR);
		}
		else {
			IClient client = new Client(clientDTO);
			this.clientRepository.addClient(client);	
			this.showAddClientConfirmationView();
		}
		
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
	
	
}
