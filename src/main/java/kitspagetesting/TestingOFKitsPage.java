package kitspagetesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basetest.Basetest;
import utility.ReuseableCode;



public class TestingOFKitsPage extends Basetest {

	// add kit and add extra purchase item , purchase the kit, enter card details ,
	// payment and order submit
	@Test
	public void purchaseKitAndPayment() throws InterruptedException {
		ReuseableCode reuse = new ReuseableCode(driver);
		reuse.reuseableCodeForPurchaseKitAndPayment();
        reuse.reuseableCodeForPayment();
//	 
	}
	
//register kit and save
	public void registerExistingKit() throws InterruptedException {
		ReuseableCode reuse = new ReuseableCode(driver);
		reuse.reuseableCodeForRegisterExistingKit();

	}
	
// add kit and payement by pay on account
	public void addKitAndPayOnAccount() throws InterruptedException {

		ReuseableCode reuse = new ReuseableCode(driver);
		reuse.reuseableCodeForPurchaseKitAndPayment();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement payonaccount = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Pay On Account']")));
		payonaccount.click();

		WebElement dashboardbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Dashboard')]")));
		dashboardbutton.click();

	}

	public void addNewLocationKitSection() throws InterruptedException {

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
		WebElement addnewlocation = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='new_location']")));
		addnewlocation.click();

		WebElement locationname = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='location_name']")));
		locationname.sendKeys("uttarpradesh");

		WebElement address = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='location_address']")));
		address.sendKeys("mirjapur up india");

		WebElement suburban = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='location_suburban']")));
		suburban.sendKeys("urban");

		WebElement state = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='location_state']")));
		state.sendKeys("uttarpradesh");

		WebElement postalcode = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='location_code']")));
		postalcode.sendKeys("175018");

		WebElement selectlocation = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Select Location']")));
		selectlocation.click();

	}
	
	public void searchKitByNameAndLocation() throws InterruptedException {

		loginApplication();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement kitbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Kits')]")));
		kitbutton.click();

		WebElement alltabledata = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='kit-index']")));

		List<WebElement> rows = alltabledata.findElements(By.tagName("tr"));

		// Lop through each row and perform the search
		for (WebElement row : rows) {
			// Get Kit Name
			WebElement kitNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]")));
			String kitName = kitNameElement.getText();

			// Get Location
			WebElement locationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[3]")));
			String location = locationElement.getText();

			// Wait for the Kit Name field to be visible, then enter the Kit Name
			WebElement kitNameField = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));
			kitNameField.clear();
			kitNameField.sendKeys(kitName);

			// Wait for the Location dropdown to be visible, then select the Location
			WebElement locationDropdownElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='location_id']")));
			Select locationDropdown = new Select(locationDropdownElement);
			locationDropdown.selectByVisibleText(location);

			// Wait for the Search button to be clickable, then click it
			WebElement searchButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='filter']")));
			searchButton.click();
			Thread.sleep(2000);
		}
	}

	// created new kit by existing review and start with new review => added kit =>
	// save => marked as Completed
	
	public void addNewKitAndNewReviewAfterThatMarkedCompleted() throws InterruptedException {

		ReuseableCode reuse = new ReuseableCode(driver);
		reuse.reuseableCodeForRegisterExistingKit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement kitbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Kits')]")));
		kitbutton.click();

		// Wait for the Search button to be clickable, then click it
		WebElement reviewbutton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='btn btn-success text-light btn-sm']")));
		reviewbutton.click();

		// Wait for the Search button to be clickable, then click it
		WebElement StartWithNewReview = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='modal fade show']//a[@class='btn btn-success text-light'][normalize-space()='Start with new Review']")));
		StartWithNewReview.click();

		// Wait for the Search button to be clickable, then click it
		WebElement kitdetails = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='accordion-button kits-index-table p-20 collapsed']")));
		kitdetails.click();

		WebElement ConformingGauzeBandage25mmActualQuantity = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[4]/input[1]")));
		ConformingGauzeBandage25mmActualQuantity.click();
		ConformingGauzeBandage25mmActualQuantity.sendKeys("15");

		WebElement ConformingGauzeBandage25mmOrderQuantity = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[5]/input[1]")));
		ConformingGauzeBandage25mmOrderQuantity.click();
		ConformingGauzeBandage25mmOrderQuantity.sendKeys("5");

		WebElement SaveQuantities = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save Kit Quantities']")));
		SaveQuantities.click();

		WebElement MarkAsCompleted = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Mark Completed']")));
		MarkAsCompleted.click();

	}

	// created new kit by existing review and start with new review => added kit =>
	// save => finish and payment
	
	public void addNewKitAndNewReviewAfterPayment() throws InterruptedException {

		ReuseableCode reuse = new ReuseableCode(driver);
		reuse.reuseableCodeForRegisterExistingKit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement kitbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Kits')]")));
		kitbutton.click();

		// Wait for the Search button to be clickable, then click it
		WebElement reviewbutton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='btn btn-success text-light btn-sm']")));
		reviewbutton.click();

		// Wait for the Search button to be clickable, then click it
		WebElement StartWithNewReview = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='modal fade show']//a[@class='btn btn-success text-light'][normalize-space()='Start with new Review']")));
		StartWithNewReview.click();

		// Wait for the Search button to be clickable, then click it
		WebElement kitdetails = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='accordion-button kits-index-table p-20 collapsed']")));
		kitdetails.click();

		WebElement ConformingGauzeBandage25mmActualQuantity = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[4]/input[1]")));
		ConformingGauzeBandage25mmActualQuantity.click();
		ConformingGauzeBandage25mmActualQuantity.sendKeys("15");

		WebElement ConformingGauzeBandage25mmOrderQuantity = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[5]/input[1]")));
		ConformingGauzeBandage25mmOrderQuantity.click();
		ConformingGauzeBandage25mmOrderQuantity.sendKeys("5");

		WebElement SaveQuantities = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save Kit Quantities']")));
		SaveQuantities.click();

		WebElement finishReviewAndPlaceOrder = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Finish')]")));

		// Create an instance of Actions class
		Actions actions = new Actions(driver);
		actions.moveToElement(finishReviewAndPlaceOrder).perform();
		finishReviewAndPlaceOrder.click();

		reuse.reuseableCodeForPayment();

	}

	public void addNewKitAndNewReviewAndAfterThatCancle() throws InterruptedException {

		ReuseableCode reuse = new ReuseableCode(driver);
		reuse.reuseableCodeForRegisterExistingKit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement kitbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Kits')]")));
		kitbutton.click();

		// Wait for the Search button to be clickable, then click it
		WebElement reviewbutton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='btn btn-success text-light btn-sm']")));
		reviewbutton.click();

		// Wait for the Search button to be clickable, then click it
		WebElement StartWithNewReview = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='modal fade show']//a[@class='btn btn-success text-light'][normalize-space()='Start with new Review']")));
		StartWithNewReview.click();

		WebElement canclebutton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='delete-review']")));
		canclebutton.click();

		WebElement confirmcanclebutton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='confirm']")));
		confirmcanclebutton.click();

	}
//kit add -review kit-add another kit for review - delete the added kit and try to delete last one kit -tlast kit should not ne delted -atleast one kit be there 

	public void addNewKitAndNewReviewAndAfterThatAddNewKitForReviewInThatReviewAndDeleteTheReview() throws InterruptedException {

		ReuseableCode reuse = new ReuseableCode(driver);
		reuse.reuseableCodeForRegisterExistingKit();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement kitbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Kits')]")));
		kitbutton.click();

		// Wait for the Search button to be clickable, then click it
		WebElement reviewbutton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='btn btn-success text-light btn-sm']")));
		reviewbutton.click();

		// Wait for the Search button to be clickable, then click it
		WebElement StartWithNewReview = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='modal fade show']//a[@class='btn btn-success text-light'][normalize-space()='Start with new Review']")));
		StartWithNewReview.click();

		WebElement AddNewKitForReview = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[normalize-space()='Add new kit to review']")));
		AddNewKitForReview.click();

		WebElement SelectKIt = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='new_kit_id']")));

		Select select = new Select(SelectKIt);
		select.selectByIndex(2); // Selects the third option (index starts at 0)

		WebElement AddKitToReview = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add kit to review']")));
		AddKitToReview.click();

		WebElement selectdeletekit = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='accordion-button kits-index-table p-20 collapsed']")));
		selectdeletekit.click();

		WebElement Id = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("button[class='accordion-button kits-index-table p-20']")));
		
		String elementText = Id.getText();
		;
		System.out.println("Text inside the button: " + elementText);
		
		
		
		String[] parts = elementText.split("\\|");

        // The first part contains "#180 ", so we need to trim and remove the "#"
        String id = parts[0].trim().substring(1);
        
        // Print the extracted ID
        System.out.println("Extracted ID: " + id);
		

        WebElement deleteId = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//div[@id='collapseOne" + id + "']//button[@class='btn border-success review-edit-icon delete-review-product-btn px-2 py-1']")));

        
        deleteId.click();
        
        
        // Click the button
       
		WebElement confirmdelete = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[normalize-space()='confirm']")));
		confirmdelete.click();
		
            Thread.sleep(5000);
		
		//delete last one 
		
		
		WebElement selectdeletekit2 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='accordion-button kits-index-table p-20 collapsed']")));
		selectdeletekit2.click();

		WebElement Id2 = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("button[class='accordion-button kits-index-table p-20']")));
		
		String elementText2 = Id2.getText();
		;
		System.out.println("Text inside the button: " + elementText2);
		
		
		
		String[] parts2 = elementText2.split("\\|");

        // The first part contains "#180 ", so we need to trim and remove the "#"
        String id2 = parts2[0].trim().substring(1);
        
        // Print the extracted ID
        System.out.println("Extracted ID: " + id2);
		

        WebElement deleteId2 = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//div[@id='collapseOne" + id2 + "']//button[@class='btn border-success review-edit-icon delete-review-product-btn px-2 py-1']")));

        // Click the button
        deleteId2.click();
        
        

		WebElement confirmdelete2 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[normalize-space()='confirm']")));
		confirmdelete2.click();

	}

}