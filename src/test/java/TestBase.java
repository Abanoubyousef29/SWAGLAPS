import drivers.DriverFactory;
import drivers.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

    WebDriver driver;

    @BeforeTest()
    @Parameters("browserName")
    public void openHomePage(@Optional("defaultBrowser") String browserName) {
        driver = DriverFactory.getNewInstance(browserName);
        DriverHolder.setDriver(driver);

        driver.get("https://www.saucedemo.com/v1/");
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
