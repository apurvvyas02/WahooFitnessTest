package Wahoo.WahooFitnessTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Resource.Base;
import pageObjects.HomePage;
import pageObjects.UpdateCart;

public class RemoveViewEditCartTest extends Base {
	
	
	
	
	@Test(priority=1)
	public void removeItem() throws InterruptedException {
		
		System.out.println("hello");
		UpdateCart u = new UpdateCart(driver);
		System.out.println("U" +u);
		System.out.println("DRIVER "+driver);
		String finalOutput = "";
		Thread.sleep(1000);
		System.out.println("u.getDelElement" +u.getDeleteElement());
		finalOutput += " DeleteElement:" + u.getDeleteElement() + " Is Enabled:" + u.getDeleteElement().isEnabled();
		System.out.println("In Remove Item:" + finalOutput);
		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", u.getDeleteElement());
		
		
		//u.getDeleteElement().click();
		Thread.sleep(1000);
		u.getConfirmPopup().click();
		//return finalOutput;
	}
	
	@Test(priority=2)
	public void viewAndEditCart() throws InterruptedException {
		
		Thread.sleep(1000);
		UpdateCart u = new UpdateCart(driver);
		
		String finalOutput = "";

		finalOutput += " View Cart Enabled:" + u.getViewCart().isEnabled() + " Location:"
				+ u.getViewCart().getLocation();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", u.getViewCart());

		Thread.sleep(2000);
		u.getQuantity().clear();
		u.getQuantity().sendKeys("2");
		u.getUpdateCart().click();

		Thread.sleep(3000);
		WebElement dynamicElement = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.visibilityOf(u.getCheckOut()));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", dynamicElement);

		System.out.println("proceed to checkout is clicked");
		System.out.println(finalOutput);
	
		// driver.findElement(By.xpath("//button[@data-role='proceed-to-checkout']"));
	}

}