package dogs.controller;

import java.util.ArrayList;
import java.util.List;
import DTO.CreateDogDTO;
import DTO.DeleteDogDTO;
import DTO.DisplayDogDTO;
import DTO.UpdateDogDTO;
import dogs.model.Dog;
import dogs.model.IClient;
import dogs.model.IClientRepository;
import dogs.model.IDog;
import dogs.model.IDogRepository;
import dogs.view.DisplayDogView;
import dogs.view.DogConfirmationMessageView;
import dogs.view.DogErrorMessageView;
import dogs.view.AddDogView;
import dogs.view.ConfirmDeleteView;
import dogs.view.DisplayDogMatchIdView;



public class DogController extends Controller implements IDogController {
	
	private final static String NO_OWNER_ID_MATCH_ERROR = "Aucun id de client ne corresponds � celui entr�";
	private final static String NO_ID_MATCH_ERROR ="Auncun chien ne correspond au id recherch�";
	private final static String NAME_ERROR ="Veuillez entrer un nom valide ";
	private final static String BREED_ERROR ="Veuillez entrer une race valide ";
	private final static String DOG_WAS_ADDED_MESSAGE = "Ajout du chien avec succ�s";
	private final static String DOG_EDITED_MESSAGE = "Chien �dit� avec succ�s!";
	private final static String DELETE_DOG_CONFIRMATION = "Suppression du chien avec succ�s! ";
	
	private IDogRepository dogRepository;
	private IClientRepository clientRepository;
	
	
	
	//Constructeur
	public DogController(IDogRepository dogRepository,IClientRepository clientRepository) {
		this.dogRepository = dogRepository;
		this.clientRepository = clientRepository;
	}
	
	//Fonctions qui appellent des vues
	
	public void showDisplayDogsView() {
		super.showView(new DisplayDogView(this,this.getDogList()));
	}
	
	public void showAddDogsView() {
		super.showView(new AddDogView(this));
	}
	
	private void DogErrorMessageView(String errorMessage) {
		super.showView(new DogErrorMessageView(this,errorMessage));
		
	}
	
	private void DogConfirmationMessageView(String confirmationMessage) {
		super.showView(new DogConfirmationMessageView(this,confirmationMessage));
		
	}
	
	public void showDogMatchId(DisplayDogDTO dto) {
			super.showView(new DisplayDogMatchIdView(this,dto));
	}
	
	@Override
	public void deleteDog(DeleteDogDTO dto) {
		super.showView(new ConfirmDeleteView(this,dto));
	}
	
	
	//Fonctions ajout et modification chien
	
	public void addDog(CreateDogDTO dto) {
		
		if (this.validateDogOwner(dto.OWNER_ID)) {
			
			IClient owner = this.clientRepository.getClientList().get(dto.OWNER_ID) ;	
			IDog dog = new Dog(dto,owner);
			
			if(this.validateFormInput(dog)) {
				this.dogRepository.addDog(dog);
				this.DogConfirmationMessageView(DOG_WAS_ADDED_MESSAGE);
			}	
	
		}
	}

	@Override
	public void removeDog(DeleteDogDTO dto) {
		if (this.dogRepository.getDogList().containsKey(dto.ID)) {
			this.dogRepository.removeDog(dto.ID);
		}
		this.DogConfirmationMessageView(DELETE_DOG_CONFIRMATION);
	}
	
	@Override
	public void saveDogChanges(UpdateDogDTO dto) {
		IClient client = this.clientRepository.getClientList().get(dto.OWNER_ID);
		IDog dog = new Dog(dto,client);
		
		if(this.validateFormInput(dog)) {
			IDog dogToEdit = this.dogRepository.getDogList().get(dto.ID);
			
			dogToEdit.setName(dto.NAME);
			dogToEdit.setBreed(dto.BREED);
			
			
			this.DogConfirmationMessageView(DOG_EDITED_MESSAGE);
		}
	}
	
	
	
	//Autres
	public void getDogMatchId(String id) {
		validateDogMatchIdDTO(Integer.valueOf(id));
	}
	
	public List<DisplayDogDTO> getDogList() { 
		List<DisplayDogDTO> list = new ArrayList<DisplayDogDTO>();
		
		this.dogRepository.getDogList().forEach((integer,dog)-> {
			list.add(new DisplayDogDTO(dog));
		});
		
		return list;
	}
	
	
	
	
	//Fonctions validation
	
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
	
	private void validateDogMatchIdDTO(int id) {
		
		if (this.dogRepository.getDogList().containsKey(id)) {
			DisplayDogDTO dogDTO = new DisplayDogDTO( this.dogRepository.getDogList().get(id));
			
			this.showDogMatchId(dogDTO);
		}
		else {
			this.DogErrorMessageView(NO_ID_MATCH_ERROR);
		}	
	}

	

	
	
		
	
	
}
