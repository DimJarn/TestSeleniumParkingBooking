package selenium.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * JUnit 4 test suite for checking the install of selenium and the related
 * webdrivers.
 * <ul>
 * <li>ChromeDriver
 * <li>FirefoxDriver
 * <li>PhantomJS
 * <li>SafariDriver
 * </ul>
 * 
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ TestTrouverParking.class, TestAnnulerParking.class,
	TestPayerParking.class, TestChambreHotel.class })
public class SeleniumIntroductionTestSuite {

}
