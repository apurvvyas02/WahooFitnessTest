package Wahoo.WahooFitnessTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Resource.Base;
import pageObjects.PlaceOrder;

public class CheckoutTest extends Base {
	
	@Test
	public void placeOrder() throws InterruptedException {

		
	
		PlaceOrder p = new PlaceOrder(driver);
		WebElement dynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOf(p.getPlaceorder()));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", dynamicElement);
		System.out.println("place order clicked from place order");
		
		
		Thread.sleep(1500);
		WebElement validation = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOf(p.getValmsg()));

	
		
		String validationmessage = validation.getText();
		System.out.println("*************  " + validationmessage);

		assertEquals(validationmessage, "This is a required field.");
	}
	@Test
	public void enterBillingInfo() throws InterruptedException {

		Thread.sleep(1000);
		PlaceOrder p = new PlaceOrder(driver);
		WebElement dynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOf(p.getEmail()));
		dynamicElement.sendKeys("someone@whocares.com");

		p.getFirstname().sendKeys("Test");
		p.getLastname().sendKeys("Tester");
		p.getAddress().sendKeys("Comandante Izarduy 67, Barcelona  08940");
		p.getCity().sendKeys("Barcelona");

		Select s = new Select(driver.findElement(By.name("country_id")));
		s.selectByValue("ES");

		Select s1 = new Select(driver.findElement(By.name("region_id")));
		s1.selectByValue("139");
		p.getPostalcode().sendKeys("08001");
		p.getTelephone().sendKeys("5555555555");

		WebElement shippingElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(p.getExpressshipping()));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", shippingElement);

		WebElement iframeElement = p.getIframe();

		driver.switchTo().frame(iframeElement);

		p.getCardnumber().sendKeys("4111111111111111");
		p.getExpirydate().sendKeys("0824");
		p.getCvc().sendKeys("111");

		driver.switchTo().defaultContent();

		WebElement placeOrderElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(p.getPlaceorder()));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", placeOrderElement);
		
//		String valmessage = driver.findElement(By.xpath("//div[@data-role='checkout-messages']//div[@data-ui-id='checkout-cart-validationmessages-message-error']")).getText();
//		assertEquals("Your card was declined. Your request was in live mode, but used a known test card.", valmessage);
	}

}
