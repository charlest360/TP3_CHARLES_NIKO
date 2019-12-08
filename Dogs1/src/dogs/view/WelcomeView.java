package dogs.view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dogs.controller.IWelcomeController;
import util.image.ImageUtil;

public class WelcomeView extends View implements ActionListener {  
	
	//Constantes autres
	private static final String VIEW_TITLE = "Page d'accueil";
	private static final String WELCOME_MESSAGE = "Bienvenue !";
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	private static final int NB_OF_COLLUMNS = 2;
	private static final int NB_OF_ROWS = 0;
	private static final String WELCOME_PICTURE = "../resource/dog.jpg";
	//Actions
	private static final String VIEW_DOGS_ACTION = "View Dogs";
	private static final String ADD_DOG_ACTION = "Add dog";
	private static final String VIEW_CLIENTS_BY_NAME_ACTION = "View Clients By Name";
	private static final String VIEW_CLIENTS_BY_PHONE_ACTION = "View Clients By Phone";
	private static final String ADD_CLIENT_ACTION = "Add client";
	private static final String SEARCH_CLIENT_BY_ID_ACTION = "Search Client By Id";
	private static final String SEARCH_CLIENT_BY_NAME_ACTION = "Search Client By Name";
	private static final String SEARCH_DOG_BY_ID_ACTION = "Search Dog By Id";
	//Textes boutons
	private static final String SEARCH_DOG_MATCH_ID_BUTTON_TEXT ="Rechercher un chien par id";
	private static final String SEARCH_CLIENT_MATCH_ID_BUTTON_TEXT ="Rechercher un client par id";
	private static final String SEARCH_CLIENT_MATCH_NAME_BUTTON_TEXT ="Rechercher un client par son nom de famille";
	private static final String VIEW_DOGS_BUTTON_TEXT = "Afficher les chiens";
	private static final String ADD_DOG_BUTTON_TEXT = "Inscrire un chien";
	private static final String VIEW_CLIENTS_BY_NAME_BUTTON_TEXT = "Afficher les clients triés par Nom";
	private static final String VIEW_CLIENTS_BY_PHONE_BUTTON_TEXT = "Afficher les clients triés par Téléphone";
	private static final String ADD_CLIENT_BUTTON_TEXT = "Inscrire un client";
	
	//Controller
	private IWelcomeController controller;		
	
	//Champs de texte
	private JTextField idClient;
	private JTextField nomClient;
	private JTextField idDog;
	
	public WelcomeView(IWelcomeController controller) {
		super(controller, VIEW_TITLE,DEFAULT_SIZE);
		
		this.controller = controller;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUpComponents();
        
	}
	
	public void display() {
		this.setVisible(true);
	}
	
	private void setUpComponents() {
		this.setUpWelcomePanel();
		this.setUpActionPanel();
	}

	private void setUpWelcomePanel() {
		JPanel welcomePanel = new JPanel();
		this.add(welcomePanel, BorderLayout.CENTER);  // CENTER -> par défaut

		welcomePanel.setLayout(new BorderLayout());   // Strategy pattern: le gestionnaire de mise en forme		
		addWelcomePicture(welcomePanel);		
		addWelcomeMessage(welcomePanel);		
	}

	private void addWelcomeMessage(JPanel welcomePanel) {
		JLabel welcomeMessage = new JLabel(WELCOME_MESSAGE, SwingConstants.CENTER);
		welcomePanel.add(welcomeMessage, BorderLayout.NORTH);
	}

	private void addWelcomePicture(JPanel welcomePanel) {
		ImageIcon image = ImageUtil.getImageIcon(this, WELCOME_PICTURE);
		JLabel welcomePicture = new JLabel(image);		
		welcomePanel.add(welcomePicture, BorderLayout.CENTER);   // CENTER -> par défaut
	}

	private void setUpActionPanel() {
		JPanel actionPanel = new JPanel();
		this.add(actionPanel,BorderLayout.SOUTH);
		actionPanel.setLayout(new GridLayout(NB_OF_ROWS,NB_OF_COLLUMNS));
		
		this.addAllButtonsAndTextFields(actionPanel);
	}
	
	private void addAllButtonsAndTextFields(JPanel actionPanel) {
		
		this.idClient = new JTextField();
		this.nomClient = new JTextField();
		this.idDog = new JTextField();
		
		actionPanel.add(this.idClient);
		this.addButton(actionPanel,SEARCH_CLIENT_MATCH_ID_BUTTON_TEXT,SEARCH_CLIENT_BY_ID_ACTION);
		
		actionPanel.add(this.nomClient);
		this.addButton(actionPanel,SEARCH_CLIENT_MATCH_NAME_BUTTON_TEXT,SEARCH_CLIENT_BY_NAME_ACTION);
		
		actionPanel.add(this.idDog);
		this.addButton(actionPanel,SEARCH_DOG_MATCH_ID_BUTTON_TEXT,SEARCH_DOG_BY_ID_ACTION);
		
		this.addButton(actionPanel,VIEW_CLIENTS_BY_NAME_BUTTON_TEXT,VIEW_CLIENTS_BY_NAME_ACTION);
		this.addButton(actionPanel,VIEW_CLIENTS_BY_PHONE_BUTTON_TEXT,VIEW_CLIENTS_BY_PHONE_ACTION);
		
		this.addButton(actionPanel,VIEW_DOGS_BUTTON_TEXT,VIEW_DOGS_ACTION);
		this.addButton(actionPanel,ADD_DOG_BUTTON_TEXT,ADD_DOG_ACTION);
		this.addButton(actionPanel,ADD_CLIENT_BUTTON_TEXT,ADD_CLIENT_ACTION);
	}

	private void addButton(JPanel actionPanel,String textToAdd,String actionCommand) {
		JButton button = new JButton(textToAdd);
		button.addActionListener(this);
		button.setActionCommand(actionCommand);
		actionPanel.add(button);
	}

	public void actionPerformed(ActionEvent arg0) {
		
		switch(arg0.getActionCommand()) {
			
			case VIEW_DOGS_ACTION:
				this.controller.viewDogs();
				break;
				
			case ADD_DOG_ACTION:
				this.controller.addDog();
				break;
				
			case VIEW_CLIENTS_BY_NAME_ACTION:
				this.controller.viewClientsByName();
				break;
				
			case VIEW_CLIENTS_BY_PHONE_ACTION:
				this.controller.viewClientsByPhone();
				break;
			
			case ADD_CLIENT_ACTION:
				this.controller.addClient();
				break;
			
			case SEARCH_CLIENT_BY_ID_ACTION:
				this.controller.searchClientById(this.idClient.getText());
				break;
				
			case SEARCH_CLIENT_BY_NAME_ACTION:
				this.controller.searchClientByName(this.nomClient.getText());
				break;
				
			case SEARCH_DOG_BY_ID_ACTION:
				this.controller.searchDogById(this.idDog.getText());
				break;
		}
		
	}
}
