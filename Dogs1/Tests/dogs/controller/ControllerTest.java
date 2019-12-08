package dogs.controller;


import static org.junit.Assert.assertTrue;
import org.junit.Test;
import dogs.model.IViewSpy;

	public class ControllerTest {
		
		/*@Before
		public void setUpSomething() {
			//ANY_GRAND_CHALET = new GrandChalet();
		}*/
		
		@Test 
		public void GIVEN_aIViewAndControllerChildren_WHEN_callingShowViewInController_THEN_displayIsCalledInView() {		
			//Arrange
			IViewSpy view = new IViewSpy();
			Controller controller = new ControllerDummy();
			//Act
			controller.showView(view);
			
			//Assert
			final boolean HAS_DISPLAY_BEEN_CALLED = view.hasDisplayBeenCalled();
			
			assertTrue(HAS_DISPLAY_BEEN_CALLED);
			
		}
}
