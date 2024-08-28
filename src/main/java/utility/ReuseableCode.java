package utility;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basetest.Basetest;
   






public class ReuseableCode extends Basetest{
	  
	
		// TODO Auto-generated constructor stub
	
	public ReuseableCode(WebDriver driver) {
		  this.driver = driver;
		
		
		// TODO Auto-generated constructor stub
	}
	public void reuseableCodeForPurchaseKitAndPayment() throws InterruptedException {

		
	        loginApplication();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement kitbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Kits')]")));
		kitbutton.click();

		WebElement addkitbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='manage-kit-btn add-btn text-success py-6 cursor-pointer center']")));
		addkitbutton.click();
		Thread.sleep(2000);
		WebElement locationbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='kitlocation']")));
		locationbutton.click();
		WebElement selectshimla = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//select[@id='kitlocation']//option[@value='14'][normalize-space()='shimla']")));
		selectshimla.click();
		WebElement kitname = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='kitName']")));

		LocalDateTime currentDateTime = LocalDateTime.now();

		kitname.sendKeys("new kit " + currentDateTime);

		WebElement choosetemplatebutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='template']")));

		choosetemplatebutton.click();

		WebElement choosetemplate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='18']  ")));

		choosetemplate.click();

		WebElement choosekit = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='needsPurchasing']")));

		choosekit.click();

		WebElement purchase = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Purchase')]")));

		purchase.click();

		Thread.sleep(2000);
		WebElement savedetails = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

		savedetails.click();

		WebElement addproduct = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@role='button']")));

		addproduct.click();
		WebElement selectproduct = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='new_product_id']")));

		selectproduct.click();

		WebElement alcohalswabs = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='19']")));

		alcohalswabs.click();

		WebElement addquantity = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Quantity']")));

		addquantity.sendKeys("15");

		WebElement savenewproduct = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Save']")));

		savenewproduct.click();
		Thread.sleep(2000);

		WebElement buykit = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Buy kit']")));

		// Create an instance of Actions class
		Actions actions = new Actions(driver);
		actions.moveToElement(buykit).perform();
		buykit.click();
}
	public void reuseableCodeForRegisterExistingKit() throws InterruptedException {
	
        loginApplication();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement kitbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Kits')]")));
		kitbutton.click();

		WebElement addkitbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='manage-kit-btn add-btn text-success py-6 cursor-pointer center']")));
		addkitbutton.click();

		WebElement locationbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='kitlocation']")));
		locationbutton.click();
		WebElement selectshimla = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//select[@id='kitlocation']//option[@value='14'][normalize-space()='shimla']")));
		selectshimla.click();

		WebElement kitname = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='kitName']")));

		LocalDateTime currentDateTime = LocalDateTime.now();

		kitname.sendKeys("new kit " + currentDateTime);

		WebElement choosetemplatebutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='template']")));

		choosetemplatebutton.click();

		WebElement choosetemplate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='18']  ")));

		choosetemplate.click();

		WebElement choosekit = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='needsPurchasing']")));

		choosekit.click();

		WebElement savedetails = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

		savedetails.click();

		WebElement addproduct = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@role='button']")));

		addproduct.click();
		WebElement selectproduct = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='new_product_id']")));

		selectproduct.click();

		WebElement alcohalswabs = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='19']")));

		alcohalswabs.click();

		WebElement addquantity = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Quantity']")));

		addquantity.sendKeys("20");

		WebElement savenewproduct = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Save']")));

		savenewproduct.click();
		Thread.sleep(2000);

		WebElement savekit = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-success save-product']")));

		// Create an instance of Actions class
		Actions actions = new Actions(driver);
		actions.moveToElement(savekit).perform();
		savekit.click();

	}
	
	
	
	public void reuseableCodeForPayment() throws InterruptedException {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement paymentbutton = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Pay with Card']")));

		paymentbutton.click();

		WebElement iframeElement = driver.findElement(By.cssSelector(".stripe_checkout_app"));
		driver.switchTo().frame(iframeElement);

		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));

		email.sendKeys("yesh@zasyasolutions.com");

		WebElement cardnumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='card_number']")));

		for (int i = 0; i < 5; i++) {
 
			
			cardnumber.sendKeys("4242");
			Thread.sleep(1000);

		}

		WebElement expirydate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cc-exp']")));

		expirydate.sendKeys("07");

		expirydate.sendKeys("28");
		WebElement cvvnumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cc-csc']")));

		cvvnumber.sendKeys("656");

		WebElement paybutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='iconTick']")));

		paybutton.click();
	
	
	
	
	}
}