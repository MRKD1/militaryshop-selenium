package testovi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CompanyInfoTest.class, DataCheckTest.class, EditAccountTest.class, LogInTest.class,
		PerformanceTest.class, PriceTest.class, ProductsTest.class, SearchTest.class, SignUpTest.class,
		SizeSelectorTest.class, WishlistTest.class })
public class AllTests {

}
