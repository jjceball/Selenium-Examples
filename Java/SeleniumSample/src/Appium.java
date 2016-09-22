package com.saucelabs.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Appium 
{
	static WebDriver driver;
	static DesiredCapabilities capabilities;
	static WebElement searchBar;
	
	@Before
	public void TestSetup() throws InterruptedException, MalformedURLException
	{
		// New capabilities
		capabilities = new DesiredCapabilities();
				
		// Requires change here if using a different device
		capabilities.setCapability("deviceName", "Galaxy S6 edge");
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("platformName", "Android");
				 
		//Create a RemoteWebDriver, the default port for Appium is 4723
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
		// Navigate to Google for start
		driver.navigate().to("http://www.google.com/");
		        
		// Find SearchBar
		searchBar = driver.findElement(By.name("q"));
	}
	
	@After
	public void Cleanup() 
	{
        	//Close the browser
        	driver.quit();
	}
	
	@Test
	public void StringTest() 
	{
		// Enter Test String and submit
        	searchBar.sendKeys("Testing Selenium!");
        	searchBar.submit();	
	}
	
	@Test
	public void Twitter() throws InterruptedException
	{
		// Enter Twitter String and submit
        	searchBar.sendKeys("Twitter");
        	searchBar.submit();

        	// Twitter link 
        	WebElement twitter = driver.findElement(By.linkText("Log in"));
        	twitter.click();

        	// Enter email field
        	WebElement email = driver.findElement(By.name("session[username_or_email]"));
        	email.sendKeys("seleniumtesterjay@gmail.com");

        	// Enter password field
        	WebElement pass = driver.findElement(By.name("session[password]"));
        	pass.sendKeys("SeleniumTester24");

        	// Submit login
        	WebElement login = driver.findElement(By.id("signupbutton"));
        	login.submit();
        
        	// Select Icon
        	WebElement icon = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[5]/a"));
        	icon.click();
        
        	// Select profile 
        	WebElement profile = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/main/div/a[1]"));
        	profile.click();

        	Thread.sleep(2000);

        	// Following 
        	WebElement following = driver.findElement(By.cssSelector("._1A98klV2, ._3OpVsglB, ._2mYajcSS"));
        	following.click();
        	Thread.sleep(1000);

        	// NFL
        	WebElement nfl = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div[2]/div/div[2]/div/div/section/div/div/div/div/div/div[2]/div/div/div/div[2]/div/a"));
        	nfl.click();
        	Thread.sleep(1500);
        	File nflprofile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	try 
        	{
			FileUtils.copyFile(nflprofile, new File("C:/Users/jceballos/Documents/Screenshots/Java/1_Twitter1.jpg"));
		} 
        	catch (IOException e1) 
        	{
			e1.printStackTrace();
		}

        	// Back home 
        	WebElement globalhome = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[1]/a"));
        	globalhome.click();

        	Thread.sleep(1000);
        
        	// Back to Icon
        	icon = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[5]/a"));
        	icon.click();

        	// Select profile 
        	profile = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/main/div/a[1]"));
        	profile.click();

        	Thread.sleep(1000);

        	// Notifications 
        	WebElement notifications = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[2]/a"));
        	notifications.click();
        	Thread.sleep(1000);
        	File notificationsscreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	try 
        	{
			FileUtils.copyFile(notificationsscreen, new File("C:/Users/jceballos/Documents/Screenshots/1_Twitter2.jpg"));
		} 
        	catch (IOException e1) 
        	{
			e1.printStackTrace();
		}

        	// DMs 
        	WebElement dms = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[3]/a"));
        	dms.click();
        	Thread.sleep(2000);
        	File dmsscreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	try 
        	{
			FileUtils.copyFile(dmsscreen, new File("C:/Users/jceballos/Documents/Screenshots/1_Twitter3.jpg"));
		} 
        	catch (IOException e1) 
        	{
			e1.printStackTrace();
		}

        	// Search for Lakers
        	WebElement searchicon = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[4]/a"));
        	searchicon.click();
        	WebElement searchbar = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/main/div/form/div/div/div[1]/input"));
        	searchbar.sendKeys("Lakers");
        	searchbar.submit();
        	Thread.sleep(1000);
        	File lakersscreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	try 
        	{
			FileUtils.copyFile(lakersscreen, new File("C:/Users/jceballos/Documents/Screenshots/2_Twitter5.jpg"));
		} 
        	catch (IOException e1) 
        	{
			e1.printStackTrace();
		}

        	// Back home
        	globalhome = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[1]/a"));
        	globalhome.click();
        	Thread.sleep(1000);

        	// Find tweet
        	WebElement newTweet = driver.findElement(By.className("_21klZNE9"));
	 	newTweet.click();

        	// Enter tweet
        	WebElement tweet = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/main/div/div[3]/div[2]/div/span/textarea"));
        	tweet.sendKeys("This is automation writing this tweet!");

        	// Submit tweet 
        	WebElement subTweet = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/main/div/div[2]/div/div[3]/div/button"));
        	subTweet.click();

        	Thread.sleep(2000);

        	// Take File
        	File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	try 
        	{
			FileUtils.copyFile(image, new File("C:/Users/jceballos/Documents/Screenshots/2_Twitter6.jpg"));
		} 
        	catch (IOException e) 
        	{
			e.printStackTrace();
		}

        	Thread.sleep(1000);

        	// Options 
        	WebElement options = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[5]/a"));
        	options.click();

        	// Logout
        	WebElement logout = driver.findElement(By.xpath("//*[@id='react-root']/div[1]/div/div/main/div/a[6]"));
        	logout.click();
	}
	
	@Test
	public void Instagram() throws InterruptedException
	{
		 // Find Instagram link and submit
        	searchBar.sendKeys("Instagram");
        	searchBar.submit();

        	// Link text
        	WebElement linkText = driver.findElement(By.linkText("Instagram"));
        	linkText.click();
        	Thread.sleep(1000);

        	// ExampleSignup
        	WebElement email = driver.findElement(By.name("email"));
        	email.sendKeys("seleniumtesterjay@gmail.com");
        	WebElement fullname = driver.findElement(By.name("fullName"));
        	fullname.sendKeys("Selenium Tester");
        	WebElement username = driver.findElement(By.name("username"));
        	username.sendKeys("automatedseleniumtester");
        	WebElement password = driver.findElement(By.name("password"));
        	password.sendKeys("SeleniumTester24");
        	Thread.sleep(500);

        	// Login Button
        	WebElement login1 = driver.findElement(By.className("_k6cv7"));
        	login1.click();

        	// Username field
        	username = driver.findElement(By.name("username"));
        	username.sendKeys("seleniumtesterjay");

        	// Password field
        	password = driver.findElement(By.name("password"));
        	password.sendKeys("SeleniumTester24");

        	// Second login button
        	WebElement login2 = driver.findElement(By.className("_rz1lq"));
        	login2.click();

        	Thread.sleep(1000);

        	// First Like button 
        	WebElement like = driver.findElement(By.cssSelector("._ebwb5,._1tv0k"));
        	like.click();

        	// Explore 
        	WebElement explore = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div[2]/div[1]/div/div[2]/a"));
        	explore.click();
        	Thread.sleep(1000);
        	File explorescreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	try 
        	{
			FileUtils.copyFile(explorescreen, new File("C:/Users/jceballos/Documents/Screenshots/2_Instagram1.jpg"));
		} 
        	catch (IOException e4) 
        	{
			e4.printStackTrace();
		}

        	// Notifications 
        	WebElement notifications = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div[2]/div/div/div[3]/a"));
        	notifications.click(); // Open
        	Thread.sleep(500);
        	explore = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div[2]/div/div/div[2]/a"));
        	explore.click();

        	// Search for #AOA
        	WebElement searchbar = driver.findElement(By.xpath("//*[@id='react-root']/section/main/div/div/div/input"));
	 	searchbar.sendKeys("#AOA");
        	Thread.sleep(500);
        	searchbar.sendKeys(Keys.ENTER);
        	Thread.sleep(3000);
        	File AOA = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	try 
        	{
			FileUtils.copyFile(AOA, new File("C:/Users/jceballos/Documents/Screenshots/2_Instagram2.jpg"));
		} 
        	catch (IOException e3) 
        	{
			e3.printStackTrace();
		}

        	// Profile                                     
        	WebElement profile = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div[2]/div[1]/div/div[4]/a"));
        	profile.click();
        	Thread.sleep(1000);

        	// First post 
        	WebElement firstpost = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/div/div[1]/div/a"));
        	firstpost.click();
        	Thread.sleep(1000);
        	File post = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	try 
        	{
			FileUtils.copyFile(post, new File("C:/Users/jceballos/Documents/Screenshots/2_Instagram3.jpg"));
		} 
        	catch (IOException e2) 
        	{
			e2.printStackTrace();
		}
        	driver.navigate().back(); // Go back to the Profile page.

        	// Followers
        	WebElement followers = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/ul/li[2]/a"));
	 	followers.click();
        	Thread.sleep(500);
        	driver.navigate().back();

        	// Following
        	WebElement following = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/ul/li[3]/a"));
        	following.click();
        	Thread.sleep(1000);

        	// GFriend profile
        	WebElement gfriend = driver.findElement(By.linkText("gfriendofficial"));
        	gfriend.click();
        	Thread.sleep(1000);

        	// Unfollow                            
        	WebElement follow = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[2]/div[3]/span/button"));
        	follow.click();

        	Thread.sleep(1000);

        	Assert.assertEquals(true, driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[1]/img")).isDisplayed());

        	// Take File
        	File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	try 
        	{
			FileUtils.copyFile(image, new File("C:/Users/jceballos/Documents/Screenshots/2_Instagram4.jpg"));
		} 
        	catch (IOException e1) 
        	{
			e1.printStackTrace();
		}

        	// Follow 
        	follow.click();

        	// Back to Profile (Need new element to avoid stale element exception)
        	WebElement userprofile = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div[2]/div[1]/div/div[4]/a"));
        	userprofile.click();

        	// Following
	 	following = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/ul/li[3]/a"));
        	following.click();
        	Thread.sleep(500);

        	// Seolhyun profile
        	WebElement seolhyun = driver.findElement(By.linkText("sh_9513"));
        	seolhyun.click();
        	Thread.sleep(1000);

        	// Unfollow                          
	 	follow = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[2]/div[3]/span/button"));
        	follow.click();

        	Thread.sleep(500); 

        	Assert.assertEquals(true, driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[1]/img")).isDisplayed());

        	// Take File
        	File seolscreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	try 
        	{
			FileUtils.copyFile(seolscreen, new File("C:/Users/jceballos/Documents/Screenshots/2_Instagram5.jpg"));
		} 
        	catch (IOException e) 
        	{
			e.printStackTrace();
		}

        	// Follow 
        	follow.click();

        	// Back to Profile (Need new element to avoid stale element exception)
        	userprofile = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div[2]/div[1]/div/div[4]/a"));
        	userprofile.click();

        	// Three dots 
        	WebElement threedots = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/button"));
        	threedots.click();

        	// Logout
        	WebElement logout = driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[4]/button"));
        	logout.click();
	}
}
