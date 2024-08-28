package basetest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.ConfigReader;

public class Basetest {
    public WebDriver driver;
    ConfigReader config = new ConfigReader(); // Instance of ConfigReader

    @BeforeMethod
    public void setUp() {
        // Get the browser value from the properties file
    	
    	
    	String browser = System.getProperty("browser") !=null ? System.getProperty("browser") : config.getProperty("browser");
       // String browser = config.getProperty("browser");

        // Initialize the driver based on the browser value
        if (browser.equalsIgnoreCase("chrome")) {
           
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
           
            driver = new EdgeDriver();
        }else if (browser.equalsIgnoreCase("safari")) {
           
            driver = new SafariDriver();

        }
        else {
            throw new IllegalArgumentException("Browser " + browser + " is not supported.");
        }

        driver.manage().deleteAllCookies();
       driver.manage().window().maximize();
  

        PageFactory.initElements(driver, this);
    }

    public void loginApplication() throws InterruptedException {
        driver.get("https://staging.kitcheck.com.au/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement loginbutton = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
        loginbutton.click();

        WebElement useremail = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@id='email']")));

        useremail.sendKeys("yesh@zasyasolutions.com");
        WebElement passwordEle = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@id='password']")));

        passwordEle.sendKeys("Yesh255198@");
        WebElement submitbutton = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[@id='refer_button']")));

        submitbutton.click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
