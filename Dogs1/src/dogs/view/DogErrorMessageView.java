package dogs.view;

import dogs.controller.IDogController;

public class DogErrorMessageView extends ErrorMessageView {

	public DogErrorMessageView(IDogController controller, String errorMessage) {
		super(controller, errorMessage);
	}

}
