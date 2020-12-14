package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//nav//ul//li//span[contains(text(),'SHOP')]")
	private WebElement shop;

	@FindBy(xpath = "//h2[contains(text(),'All Products')]")
	private WebElement allproductlabe;

	@FindBy(xpath = "//ul/li[@class='item']")
	private List<WebElement> productlist;
	
	////ul/li[@class='item'][2]//div[2]

	@FindBy(xpath = "//div[@id='product-options-wrapper']//div//div//label//span[contains(text(),'Color')]")
	private WebElement color;
	
	@FindBy(xpath = "//span[contains(text(),'Size')]")
	private WebElement size;
	
	@FindBy(xpath="//button[@id='product-addtocart-button']")
	private WebElement addtocart;

	public WebElement getAddtocart() {
		return addtocart;
	}

	public WebElement getSize() {
		return size;
	}

	@FindBy(xpath = "//li[@data-role='product-item']//div//div[@class='product-item-details']")
	private WebElement itemname;

	@FindBy(xpath = "//div[@id='minicart-content-wrapper']")
	private WebElement minicart;
	
	
	@FindBy(css="#top-cart-btn-checkout")
	private WebElement checkout;

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getItemname() {
		return itemname;
	}

	public WebElement getMinicart() {
		return minicart;
	}

	public WebElement getColor() {
		return color;
	}

	public WebDriver getDriver() {
		return driver;
	}

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public HomePage() {
		super();
	}

	public WebElement getShop() {
		return shop;
	}

	public WebElement getAllproductlabe() {
		return allproductlabe;
	}

	public List<WebElement> getProductlist() {
		return productlist;
	}

}
