package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ InventoryManagerTest.class, SalableProductTest.class, StoreFrontTest.class })
public class AllTests {

}
