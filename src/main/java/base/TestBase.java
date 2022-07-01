package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utlities.Constants;
import utlities.TestData;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class TestBase {
    public static WebDriver driver;
    public TestData testDataReader;

    // Download from chrome
    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        chromePrefs.put("profile.default.content_settings.popups", 0);
        options.addArguments("--window-size=1024x768");
        return options;
    }

    // Download from FireFox
    public static FirefoxOptions firefoxOption() {
        FirefoxOptions option = new FirefoxOptions();
        option.setAcceptInsecureCerts(true);
        option.addPreference("browser.download.folderList", 2);
        option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
        option.addPreference("browser.download.manager.showWhenStarting", false);
        option.setCapability("resolution", "1024x768");
        return option;
    }

    @BeforeSuite
    @Parameters({"browser"})
    public void openDriver(@Optional("firefox") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            // WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver(chromeOption());
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOption());
        }
        //driver.manage().window().setPosition(new Point(0, 0));
        //driver.manage().window().setSize(new Dimension(1024,768));
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com/index.php");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testDataReader = new TestData(Constants.ExcelFilePath, Constants.SheetName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();

    }

}
