import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class setup 
{
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		// Tells the System where the Chrome and IE Drivers are
		System.setProperty("webdriver.chrome.driver", "C:/Users/jceballos/Downloads/Automation/chromedriver.exe");	
		System.setProperty("webdriver.ie.driver", "C:/Users/jceballos/Downloads/Automation/IEDriverServer.exe");

		// Chrome Options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		// Initialize chrome browser
		driver = new ChromeDriver(options);
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.google.com");
        
        	// Wait for the website to load
        	Thread.sleep(2000);
        
        	//Close the browser
        	driver.close();
        	driver.quit();
	}
}
