package dogs.controller;


import static org.junit.Assert.assertTrue;
import org.junit.Test;

import controller.mock.ControllerDummy;
import dogs.model.ViewSpy;

	public class ControllerTest {
		
		@Test 
		public void GIVEN_aIViewAndControllerChildren_WHEN_callingShowViewInController_THEN_displayIsCalledInView() {		
			//Arrange
			ViewSpy view = new ViewSpy();
			Controller controller = new ControllerDummy();
			//Act
			controller.showView(view);
			
			//Assert
			final boolean HAS_DISPLAY_BEEN_CALLED = view.hasDisplayBeenCalled();
			
			assertTrue(HAS_DISPLAY_BEEN_CALLED);
			
		}
}
