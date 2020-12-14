package Resource;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {

	public static WebDriver driver;
	
	public static WebDriver initializeDriver() throws IOException {
		
		System.out.println("hello");

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.Chrome.driver", "chromedriver.exe");
		String destinationFile = System.getProperty("user.dir");
		System.out.println(destinationFile);
		System.out.println("hello 1");
		
		driver = new ChromeDriver(options);
		
		System.out.println(driver);
		
	
	return driver;
}
}