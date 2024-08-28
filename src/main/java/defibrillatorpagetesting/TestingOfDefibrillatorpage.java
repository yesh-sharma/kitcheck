package defibrillatorpagetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basetest.Basetest;

public class TestingOfDefibrillatorpage extends Basetest {
	@Test
	public void purchaseKitAndPayment() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		loginApplication();
		WebElement defibrillator = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Defibrillator']")));

		defibrillator.click();

		WebElement AddDefibrillator = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='manage-kit-btn add-btn text-success cursor-pointer center py-6']")));

		AddDefibrillator.click();

		WebElement AddDefibrillatorName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='defibrillator_name']")));

		AddDefibrillatorName.sendKeys("heart machine");

		WebElement Location = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='def_location']")));

		Location.click();
		Select select = new Select(Location);

		// Example index, starts from 0
		select.selectByIndex(2);

		WebElement BrandName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='brand']")));

		BrandName.click();

		Select select1 = new Select(BrandName);

		// Example index, starts from 0
		select1.selectByIndex(1);

		WebElement ModelNumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='model']")));

		ModelNumber.click();

		Select select2 = new Select(ModelNumber);
         Thread.sleep(2000);
		// Example index, starts from 0
		select2.selectByIndex(1);
		
		Thread.sleep(2000);
		
		WebElement ExpiryDate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pad_expiry']")));

		ExpiryDate.sendKeys("05/12/2025");

		WebElement LotNumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lot_number']")));

		LotNumber.sendKeys("23761");

		WebElement SerialNumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='serial_number']")));

		SerialNumber.sendKeys("12");

//		WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
//
//		Email.sendKeys("yesh@123gmail.com");
//
//		WebElement PhoneNumber = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phone_number']")));
//
//		PhoneNumber.sendKeys("70128223761");

		WebElement SaveButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save']")));

		SaveButton.click();

	}

}