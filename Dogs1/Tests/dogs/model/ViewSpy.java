package dogs.model;

import dogs.view.IView;

public class ViewSpy implements IView {

	private boolean hasDisplayBeenCalled =false;
	
	@Override
	public void display() {
		this.hasDisplayBeenCalled = true;
	}
	
	public boolean hasDisplayBeenCalled() {
		return this.hasDisplayBeenCalled;
	}
}
