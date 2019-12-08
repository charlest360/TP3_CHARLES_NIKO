package dogs.view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dogs.controller.IWelcomeController;
import util.image.ImageUtil;

public class WelcomeView extends View implements ActionListener {  
	
	private static final String VIEW_TITLE = "Page d'accueil";
	private static final String WELCOME_MESSAGE = "Bienvenue !";
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	
	private static final String VIEW_DOGS_ACTION = "View Dogs";
	private static final String ADD_DOG_ACTION = "Add dog";
	private static final String VIEW_CLIENTS_ACTION = "View Clients";
	private static final String ADD_CLIENT_ACTION = "Add client";
	
	private static final String WELCOME_PICTURE = "../resource/dog.jpg";
	
	private static final String VIEW_DOGS_BUTTON_TEXT = "Afficher les chiens";
	private static final String ADD_DOG_BUTTON_TEXT = "Inscrire un chien";
	private static final String VIEW_CLIENTS_BUTTON_TEXT = "Afficher les clients";
	private static final String ADD_CLIENT_BUTTON_TEXT = "Inscrire un client";
	
	
	private IWelcomeController controller;		
	
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
		
		addButton(actionPanel,VIEW_DOGS_BUTTON_TEXT,VIEW_DOGS_ACTION);
		addButton(actionPanel,ADD_DOG_BUTTON_TEXT,ADD_DOG_ACTION);
		addButton(actionPanel,VIEW_CLIENTS_BUTTON_TEXT,VIEW_CLIENTS_ACTION);
		addButton(actionPanel,ADD_CLIENT_BUTTON_TEXT,ADD_CLIENT_ACTION);
	
	}

	private void addButton(JPanel actionPanel,String textToAdd,String actionCommand) {
		JButton button = new JButton(textToAdd);
		button.addActionListener(this);
		button.setActionCommand(actionCommand);
		actionPanel.add(button);
	}

	public void actionPerformed(ActionEvent arg0) {
		
		//Utilisation de switch plutot que if else pour simplifier l'ajouter de bouttons dans le futur .
		
		switch(arg0.getActionCommand()) {
			
			case VIEW_DOGS_ACTION:
				this.controller.viewDogs();
				break;
				
			case ADD_DOG_ACTION:
				this.controller.addDog();
				break;
				
			case VIEW_CLIENTS_ACTION:
				this.controller.viewClients();
				break;
				
			/*case ADD_CLIENT_ACTION:
				this.controller.addDog();
				break;*/
		  
		}
		
		/*if(arg0.getActionCommand() == VIEW_DOGS_ACTION) {
			this.controller.viewDogs();
		}
		else if(arg0.getActionCommand() == ADD_DOG_ACTION) {
			this.controller.addDog();
		}*/
	}
}
