package selenium.wordpress;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import selenium.log.Messages;

@Ignore
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestWithOpera  {


    private static final String SYSTEM_PROPERTY = Messages.getString("chrome_driver"); //$NON-NLS-1$


    private static final String DRIVER_LOCATION = Messages.getString("chrome_path"); //$NON-NLS-1$

    
    /**
     * The setup method run before any @Test methods within the class. This methods role is to check
     * that the WebDriver executable is on the system and then to instantiate a WebDriver instance,
     * before setting the size of the browser window and an implicit wait of 2 seconds, which allows
     * WebDriver 2 seconds to search through the DOM of the web page to find the element if they are
     * not immediately available.
     */
    @BeforeClass
    public static void setup() {
    }

    /**
     * The teardown method is used to quit the webdriver, (closes browser).
     */
    @AfterClass
    public static void cleanup() {
    }
    
    @Test
    public void scenario1aOpenWebPage () {
    }
    
    @Test
    public void scenario2aOpenLogOnPage () {
    }
    
    @Test
    public void scenario2bLogOn () {
    }
    
    @Test
    public void scenario3AddPost () {
    }
    
    @Test
    public void scenario4PublishPost () {
    }
    
    @Test
    public void scenario5ViewPost () {
    }
    
    @Test
    public void scenario6LogOff () {
    }
}
