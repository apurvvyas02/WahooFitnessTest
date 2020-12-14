package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Resource.Base;

public class UpdateCart extends HomePage {
	
	

	@FindBy(xpath = "//ol[@id='mini-cart']/li[1]//a[contains(@class,'delete')]")
	private WebElement deleteElement;

	@FindBy(xpath = "//div[@class='modal-inner-wrap']//button[contains(@class,'action-primary')]")
	private WebElement confirmPopup;

	@FindBy(xpath = "//div[@class='actions']//div//a[contains(@class,'viewcart')]")
	private WebElement viewCart;

	@FindBy(xpath = "//table[@id='shopping-cart-table']//tr//input[@data-role='cart-item-qty']")
	private WebElement quantity;

	@FindBy(xpath = "//button[@name='update_cart_action']")
	private WebElement updateCart;

	@FindBy(xpath = "//button[@data-role='proceed-to-checkout']")
	private WebElement checkOut;

	public UpdateCart(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public UpdateCart() {
		super();
	}

	public WebElement getViewCart() {
		return viewCart;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getUpdateCart() {
		return updateCart;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public WebElement getDeleteElement() {
		return deleteElement;
	}

	public WebElement getConfirmPopup() {
		return confirmPopup;
	}

}
