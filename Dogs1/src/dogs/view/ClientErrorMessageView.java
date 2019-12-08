package dogs.view;

import dogs.controller.IClientController;

public class ClientErrorMessageView extends ErrorMessageView {

	public ClientErrorMessageView(IClientController controller, String errorMessage) {
		super(controller, errorMessage);
	}
}
