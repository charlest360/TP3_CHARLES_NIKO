package dogs.controller;

import dogs.view.IView;

public abstract class Controller implements IController {
	
	public void showView(IView view) {
		view.display();
	}
}
