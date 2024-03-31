import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.support.PageFactory;
import java.net.MalformedURLException;

public class BaseTest {
    private final DriverFactory driverFactory = new DriverFactory();
    AppiumDriver<?> driver;
    @BeforeAll
    public void  setDriver() throws MalformedURLException {
        driver = driverFactory.setUp(Platform.ANDROID);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}