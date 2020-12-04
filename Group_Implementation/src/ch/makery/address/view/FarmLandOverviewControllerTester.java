package ch.makery.address.view;
import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

public class FarmLandOverviewControllerTester {

	//https://stackoverflow.com/a/28028662/9295513
	@Before
	public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
	   Field instance = FarmLandOverviewController.class.getDeclaredField("instance");
	   instance.setAccessible(true);
	   instance.set(null, null);
	}
	
	@Test(expected = Throwable.class)
	public void is_singleton_main() {
		//FarmLandOverviewController singleton = new FarmLandOverviewController();
	}
	   

}
