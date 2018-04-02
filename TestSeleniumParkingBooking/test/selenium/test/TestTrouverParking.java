package selenium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.log.Messages;

public class TestTrouverParking {
	private static WebDriver driver;

	/**
	 * System Property that should be set to stop selenium searching for
	 * ChromeDriver.
	 */
	private static final String SYSTEM_PROPERTY = Messages.getString("chrome_driver");

	/**
	 * Driver location, the full path name to the executable for ChromeDriver
	 */
	private static final String DRIVER_LOCATION = Messages.getString("chrome_path");

	/**
	 * The setup method run before any @Test methods within the class. This
	 * methods role is to check that the WebDriver executable is on the system
	 * and then to instantiate a WebDriver instance, before setting the size of
	 * the browser window and an implicit wait of 2 seconds, which allows
	 * WebDriver 2 seconds to search through the DOM of the web page to find the
	 * element if they are not immediately available.
	 */
	@BeforeClass
	public static void setup() {
		File driverLocation = new File(DRIVER_LOCATION);
		if (!driverLocation.exists()) {
			fail(Messages.getString("no_executable"));
		}
		System.setProperty(SYSTEM_PROPERTY, DRIVER_LOCATION);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1024, 868));
	}

	/**
	 * The teardown method is used to quit the webdriver, (closes browser).
	 */
	@AfterClass
	public static void cleanup() {
		driver.quit();
	}

	/**
	 * Test to open the web page, assert that the page title is correct and to
	 * save a screenshot of the opened web page.
	 */

	@Test
	public void testOpenWebPage() {
		driver.get(Messages.getString("project_address"));
		assertEquals(Messages.getString("project_homepage_title"), driver.getTitle());
		createScreenshot("screenshot_wordpress.png");
	}

	/**
	 * Test to open the web page, assert that the page title click on trouver
	 * parking
	 */
	@Test
	public void testTrouverParking() {
		driver.get(Messages.getString("project_address"));
		assertEquals(Messages.getString("project_homepage_title"), driver.getTitle());
		try {
			driver.findElement(By.xpath("//a[@href='trouverParking.jsp']")).click();
			Thread.sleep(9000);
			assertEquals(Messages.getString("project_trouver_title"), driver.getTitle());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Log In Test Pass");
	}

	/**
	 * Test to open the web page, assert that the page title click on trouver
	 * parking, fill all and click on submit
	 */
	@Test
	public void testTrouverParkingRemplirChamps() {
		driver.get(Messages.getString("project_address"));
		assertEquals(Messages.getString("project_homepage_title"), driver.getTitle());
		try {
			attendre(200);
			driver.findElement(By.xpath("//a[@href='trouverParking.jsp']")).click();
			attendre(300);
			assertEquals(Messages.getString("project_trouver_title"), driver.getTitle());
			// Effacer les valeurs par défaut
			driver.findElement(By.name("ville")).clear();
			driver.findElement(By.name("adresse")).clear();
			driver.findElement(By.name("prix")).clear();
			// Ajout dans les champs
			driver.findElement(By.name("ville")).sendKeys("Angers");
			driver.findElement(By.name("adresse")).sendKeys("Parking Moliere");
			driver.findElement(By.name("prix")).sendKeys("2");
			attendre(300);
			/**
			 * TODO A finir : ajouter id ou name au bouton submit
			 */

			driver.findElement(By.linkText("Valider")).click();
			// driver.findElement(By.xpath("//a[@type='submit']")).click();
			// driver.findElement(By.xpath("//input[@type='submit'")).click();
			attendre(300);

			// Test nom de la page: Payer sa réservation
			assertEquals(Messages.getString("project_payer_title"), driver.getTitle());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Helper method that will try to create a screenshot of the browser's
	 * window's current contents. If the screenshot can be created, this method
	 * will save it as a PNG image with the given filename.
	 * 
	 * @param filename
	 *            String representing the filename of the PNG image to be saved.
	 * @since version 1.1
	 */
	private void createScreenshot(String filename) {
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			ImageIO.write(ImageIO.read(screenshot), "PNG", new File(filename));
		} catch (IOException ioe) {
			fail("Could not save screenshot: " + ioe.getMessage());
		}
	}

	private void attendre(int number) throws InterruptedException {
		Thread.sleep(number * 10);
	}
}
