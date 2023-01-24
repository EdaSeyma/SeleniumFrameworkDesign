package seleniumframeworktest.tests.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import seleniumframeworktest.tests.pageobjects.LandingPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;
    public WebDriver initializedDriver() throws IOException {
        Properties prop=new Properties();
        FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\seleniumframeworktest\\tests\\resources\\GlobalData.properties");
        prop.load(fis);
        String browserName=prop.getProperty("browser");
        
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            //firefox
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            //edge
            System.setProperty("webdriver.edge.driver","edge.exe");
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod
    public LandingPage launchApplication() throws IOException {
         driver =initializedDriver();
         landingPage = new LandingPage(driver);
         landingPage.goTo();
         return landingPage;
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
