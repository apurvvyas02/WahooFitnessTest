package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PlaceOrder extends HomePage{


	
	@FindBy(xpath="//div[@id='customer-email-error']")
	private WebElement valmsg;
	
	@FindBy(xpath="//div[@class='checkout-block']//input[@type='email']")
	private WebElement email;
	
	@FindBy(xpath="//div[@id='shipping-new-address-form']//input[@name='firstname']")
	private WebElement firstname;
	
	@FindBy(xpath="//div[@id='shipping-new-address-form']//input[@name='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="//div[@id='shipping-new-address-form']//input[@name='street[0]']")
	private WebElement address;
	
	@FindBy(xpath="//div[@id='shipping-new-address-form']//input[@name='city']")
	private WebElement city;
	
	@FindBy(xpath="//div[@id='shipping-new-address-form']//input[@name='postcode']")
	private WebElement postalcode;
	
	@FindBy(xpath="//div[@id='shipping-new-address-form']//input[@name='telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//table[contains(@class,'amcheckout-shipping-methods')]/tbody/tr[2]//input[@type='radio']")
	private WebElement expressshipping;
	
	@FindBy(xpath="//iframe[contains(@name,'privateStripeFrame')]")
	private WebElement iframe;
	
	@FindBy(xpath="//input[@name='cardnumber']")
	private WebElement cardnumber;
	
	@FindBy(xpath="//input[@name='exp-date']")
	private WebElement expirydate;

	@FindBy(xpath="//input[@name='cvc']")
	private WebElement cvc;
	
	@FindBy(xpath="//div[@class='checkout-block']//div[@class='payment-methods']//div//button")
	private WebElement placeorder;
	
	
	public PlaceOrder(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public PlaceOrder() {
		super();
	}

	public WebElement getValmsg() {
		return valmsg;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getPostalcode() {
		return postalcode;
	}

	public WebElement getTelephone() {
		return telephone;
	}

	public WebElement getExpressshipping() {
		return expressshipping;
	}

	public WebElement getIframe() {
		return iframe;
	}

	public WebElement getCardnumber() {
		return cardnumber;
	}

	public WebElement getExpirydate() {
		return expirydate;
	}

	public WebElement getCvc() {
		return cvc;
	}

	public WebElement getPlaceorder() {
		return placeorder;
	}
	
	
	
	
	
	
	
	
	
}
