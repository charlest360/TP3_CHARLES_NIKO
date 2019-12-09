package dogs.controller;

import java.util.ArrayList;
import java.util.List;
import DTO.CreateDogDTO;
import DTO.DeleteDogDTO;
import DTO.DisplayDogDTO;
import DTO.UpdateDogDTO;
import dogs.model.ClientRepository;
import dogs.model.Dog;
import dogs.model.DogRepository;
import dogs.model.IClient;
import dogs.model.IDog;
import dogs.view.DisplayDogView;
import dogs.view.DogConfirmationMessageView;
import dogs.view.DogErrorMessageView;
import dogs.view.AddDogView;
import dogs.view.ConfirmDeleteView;
import dogs.view.DisplayDogMatchIdView;



public class DogController extends Controller implements IDogController {
	private final static String NO_OWNER_ID_MATCH_ERROR = "Aucun id de client ne corresponds à celui entré";
	private final static String NO_ID_MATCH_ERROR ="Auncun chien ne correspond au id recherché";
	private final static String NAME_ERROR ="Veuillez entrer un nom valide ";
	private final static String BREED_ERROR ="Veuillez entrer une race valide ";
	private final static String DOG_WAS_ADDED_MESSAGE = "Ajout du chien avec succès";
	private final static String DOG_EDITED_MESSAGE = "Chien édité avec succès!";
	private final static String DELETE_DOG_CONFIRMATION = "Suppression du chien avec succès! ";
	
	private DogRepository dogRepository;
	private ClientRepository clientRepository;
	
	public DogController(DogRepository dogRepository,ClientRepository clientRepository) {
		this.dogRepository = dogRepository;
		this.clientRepository = clientRepository;
	}
	
	public void showDisplayDogsView() {
		super.showView(new DisplayDogView(this));
	}
	
	public void showAddDogsView() {
		super.showView(new AddDogView(this));
	}
	
	public void addDog(CreateDogDTO dto) {
		
		if (this.validateDogOwner(dto.OWNER_ID)) {
			
			IClient owner = this.clientRepository.getClientList().get(dto.OWNER_ID) ;
			
			IDog dog = new Dog(dto,owner);
			this.dogRepository.addDog(dog);
			
			this.DogConfirmationMessageView(DOG_WAS_ADDED_MESSAGE);
		}
		
			
	}
	
	public List<DisplayDogDTO> getDogList() { 
		List<DisplayDogDTO> list = new ArrayList<DisplayDogDTO>();
		
		this.dogRepository.getDogList().forEach((integer,dog)-> {
			list.add(new DisplayDogDTO(dog));
		});
		
		return list;
	}
	
	private boolean validateDogOwner(int ownerId) {
		boolean isOwnerValid = false;
		if (this.clientRepository.getClientList().containsKey(ownerId)) {
			isOwnerValid = true;
		}
		else {
			this.DogErrorMessageView(NO_OWNER_ID_MATCH_ERROR);
		}
		return isOwnerValid;
	}

	@Override
	public void showDogMatchId(String id) {
		int idNumber =Integer.valueOf(id);
		
		if (this.dogRepository.getDogList().containsKey(idNumber)) {
			DisplayDogDTO dogDTO = new DisplayDogDTO( this.dogRepository.getDogList().get(idNumber));
			super.showView(new DisplayDogMatchIdView(this,dogDTO));
		}
		else {
			this.DogErrorMessageView(NO_ID_MATCH_ERROR);
		}
		
		
	}
	
	private void DogErrorMessageView(String errorMessage) {
		super.showView(new DogErrorMessageView(this,errorMessage));
		
	}
	
	private void DogConfirmationMessageView(String confirmationMessage) {
		super.showView(new DogConfirmationMessageView(this,confirmationMessage));
		
	}

	
	
	@Override
	public void SaveDogChanges(UpdateDogDTO dto) {
		IClient client = this.clientRepository.getClientList().get(dto.OWNER_ID);
		IDog dog = new Dog(dto,client);
		
		if(this.validateFormInput(dog)) {
			IDog dogToEdit = this.dogRepository.getDogList().get(dto.ID);
			
			dogToEdit.setName(dto.NAME);
			dogToEdit.setBreed(dto.BREED);
			
			
			this.DogConfirmationMessageView(DOG_EDITED_MESSAGE);
		}
	}
	
	
		

	private boolean validateFormInput(IDog dog) {
		
		boolean isDogValid = false;
		
		if(dog.getName().length() <Dog.MINIMUM_CHARS_IN_NAME) {
			this.DogErrorMessageView(NAME_ERROR);
		}
		else if(dog.getBreed().length() <Dog.MINIMUM_CHARS_IN_BREED) {
			this.DogErrorMessageView(BREED_ERROR);
		}
		
		else {
			isDogValid =true;	
		}
		return isDogValid;
	}

	@Override
	public void DeleteDog(DeleteDogDTO dto) {
		super.showView(new ConfirmDeleteView(this,dto));
	}

	@Override
	public void RemoveDog(DeleteDogDTO dto) {
		if (this.dogRepository.getDogList().containsKey(dto.ID)) {
			this.dogRepository.getDogList().remove(dto.ID);
		}
		this.DogConfirmationMessageView(DELETE_DOG_CONFIRMATION);
	}

	
	
		
	
	
}
