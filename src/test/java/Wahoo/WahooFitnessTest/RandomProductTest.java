package Wahoo.WahooFitnessTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Resource.Base;
import pageObjects.HomePage;

public class RandomProductTest extends Base {

	@BeforeSuite
	public void navigationtoHomePage() throws IOException, InterruptedException {

		// 1. Launch the website
		driver = initializeDriver();
		driver.get("https://eu.wahoofitness.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title:" + title);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Click on Shop and wait until products are loaded
		HomePage hp = new HomePage(driver);
		System.out.println("Shop:" + hp.getShop());
		hp.getShop().click();
		Thread.sleep(1000);
		System.out.println("After Sleep1:");

		List<WebElement> prodList = hp.getProductlist();
		int prodListSize = prodList.size();
		String finalOutput = selectProduct(hp, prodListSize, prodList);
		System.out.println("Final Output Select Product1:" + finalOutput);
		System.out.println("\n");
		driver.navigate().back();

		finalOutput = selectProduct(hp, prodListSize, prodList);
		System.out.println("Final Output Select Product2:" + finalOutput);
		System.out.println("\n");

		
		/*
		 * finalOutput = removeItem(); System.out.println("Final Output Remove Item:" +
		 * finalOutput); System.out.println("\n"); finalOutput = viewAndEditCart();
		 * System.out.println("Final Output View Cart:" + finalOutput);
		 * System.out.println("\n"); enterBillingInfo();
		 */

	}

	// Select random Product
	public String selectProduct(HomePage hp, int prodListSize, List<WebElement> prodList)
			throws IOException, InterruptedException {
		String prodName = "";
		int index = -1;
		String actionText = "";
		boolean availableItemFound = false;
		String optionsVal = "";
		String finalOutput = "";
		WebElement actionElement;
		WebElement actionElement1;
		WebElement actionElement2;
		Thread.sleep(1000);
		System.out.println("In select product");
		for (int i = 0; i < prodListSize; i++) {
			index = (int) Math.floor(Math.random() * (prodListSize - 1 + 1)) + 1;
			
			prodName = prodList.get(index).getText();
			finalOutput += " Select product with index:" + index + " is:" + prodName;
			System.out.println(finalOutput);
			index++;
			actionElement = driver
					.findElement(By.xpath("//ul/li[@class='item'][" + index + "]//div[@class='actions']"));
			actionElement1 = actionElement.findElement(By.className("button-hover"));
			actionElement2 = actionElement1.findElement(By.tagName("span"));
			actionText = actionElement2.getAttribute("innerHTML");

			finalOutput += " This product is :" + actionText;
			if (!actionText.equals("Out of Stock")) {
				availableItemFound = true;
				break;
			}
		}
		finalOutput += " Click on element with index:" + index;
		if (availableItemFound) {
			driver.findElement(By.xpath("//ul/li[@class='item'][" + index + "]/div[1]/a")).click();
			Thread.sleep(1000);
			// Scenario to handle color and Size
			try {
				if (hp.getSize().isDisplayed()) {
					finalOutput += " Size is displayed";
					Select s = new Select(driver.findElement(By.id("attribute231")));
					List<WebElement> options = s.getOptions();
					for (int i = 1; i < options.size(); i++) {
						if (options.get(i).isEnabled()) {
							optionsVal = options.get(i).getText();
							finalOutput += " Selected Size Option is:" + optionsVal;
							options.get(i).click();
							break;
						}
					}
				}
			} catch (NoSuchElementException ex) {
				System.out.println("Size not found");
			}
			try {
				if (hp.getColor().isDisplayed()) {
					finalOutput += " Color is displayed";
					Select s = new Select(driver.findElement(By.id("attribute92")));
					List<WebElement> options = s.getOptions();
					for (int i = 1; i < options.size(); i++) {
						if (options.get(i).isEnabled()) {
							optionsVal = options.get(i).getText();
							finalOutput += " Selected Color Option is:" + optionsVal;
							options.get(i).click();
							break;
						}
					}
				}
			} catch (NoSuchElementException ex) {
				System.out.println("Color not found");
			}
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", hp.getAddtocart());
			//hp.getAddtocart().click();
			Thread.sleep(1000);
			boolean micart = hp.getMinicart().isEnabled();
			if (micart)
				finalOutput += " Minicart displayed";

		}
		return finalOutput;
	}

	
}
