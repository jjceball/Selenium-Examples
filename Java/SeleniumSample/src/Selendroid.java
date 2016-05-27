import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
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

public class Selendroid 
{
	static WebDriver driver;
	static WebElement search;
	
	@Before 
	public void TestSetup() throws InterruptedException
	{
		//Launching the mobile browser
		driver = new RemoteWebDriver(DesiredCapabilities.android());

        // And now use this to visit Google
        driver.navigate().to("http://www.google.com");
        
        // Wait for the website to load
        Thread.sleep(2000);
        
        // Find the text input element by its name
        search = driver.findElement(By.id("sb_ifc0"));
	}
	
	@After
	public void Cleanup()
	{
		//Close the browser
        driver.quit();
	}
	
	@Test
	public void Facebook() throws InterruptedException
	{
		// Enter Facebook String and submit
        search.sendKeys("Facebook");
        search.submit();

        // Facebook link element
        WebElement facebook = driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/h3/a[1]"));
        facebook.click();

        // Enter email field
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("seleniumtesterjay@gmail.com");

        // Enter password field
        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("SeleniumTester24");

        // Submit credentials
        WebElement login = driver.findElement(By.id("loginbutton"));
        login.submit();

        Thread.sleep(1000);

        // Search for Nike
        WebElement searchbar = driver.findElement(By.name("q"));
        searchbar.sendKeys("Nike");
        searchbar.submit();

        Thread.sleep(2000);

        driver.navigate().refresh();

        WebElement pages = driver.findElement(By.xpath("//*[@id='u_0_u']/div/div/div/ul/li[6]"));
        pages.click();

        Thread.sleep(1000);

        // Nike page 
        WebElement nike = driver.findElement(By.className("_gll"));
        nike.click();

        // Sleep thread
        Thread.sleep(2500);

        Assert.assertEquals(true, driver.findElement(By.xpath("//*[@id='fbPageFinchProfilePic']/a/img")).isDisplayed());

        // Take profile File
        File screennike = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(screennike, new File("C:/Users/jceballos/Documents/Screenshots/1_Facebook1.jpg"));
		} 
        catch (IOException e1) 
        {
			e1.printStackTrace();
		}

        // Try Catch block for File
        try
        {
            // Select profile element
            WebElement profile = driver.findElement(By.className("_2s25"));
            profile.click();

            Thread.sleep(2000);

            // Take File
            File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(image, new File("C:/Users/jceballos/Documents/Screenshots/1_Facebook2.jpg"));
        }
        catch (Exception e)
        {
            System.out.println(e);
            Assert.fail("Failed with Exception: " + e);
        }
        
        // Select dropdown menu
        WebElement drop = driver.findElement(By.id("userNavigationLabel"));
        drop.click(); // Open dropdown
        drop.click(); // Close dropdown

        // Back home 
        WebElement home = driver.findElement(By.xpath("//*[@id='blueBarDOMInspector']/div[1]/div/div/div/div[1]/div[1]/h1/a"));
        home.click();

        Thread.sleep(2500);

        // Messages
        WebElement messages = driver.findElement(By.xpath("//*[@id='navItem_217974574879787']/a/div/span"));
        messages.click();
        Thread.sleep(1500);
        File messagescreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(messagescreen, new File("C:/Users/jceballos/Documents/Screenshots/1_Facebook3.jpg"));
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Twitter() throws InterruptedException
	{
		// Enter Twitter String and submit
        search.sendKeys("Twitter");
        search.submit();

        // Twitter link 
        WebElement twitter = driver.findElement(By.linkText("Twitter"));
        twitter.click();

        // Login button
        WebElement login1 = driver.findElement(By.className("js-login"));
        login1.click();

        // Enter email field
        WebElement email = driver.findElement(By.name("session[username_or_email]"));
        email.sendKeys("seleniumtesterjay@gmail.com");

        // Enter password field
        WebElement pass = driver.findElement(By.name("session[password]"));
        pass.sendKeys("SeleniumTester24");

        // Uncheck remember me
        WebElement remember = driver.findElement(By.name("remember_me"));
        remember.click();

        // Submit login
        WebElement login = driver.findElement(By.className("js-submit"));
        login.submit();

        // Select profile 
        WebElement profile = driver.findElement(By.xpath("//*[@id='page-container']/div[1]/div[1]/div/div[1]/div/a"));
        profile.click();

        Thread.sleep(1000);

        // Following 
        WebElement following = driver.findElement(By.xpath("//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[2]/a"));
        following.click();

        // NFL
        WebElement nfl = driver.findElement(By.xpath("//*[@id='stream-item-user-19426551']/div/div/div[2]/div/div/a"));
        nfl.click();
        Thread.sleep(2500);
        File nflprofile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(nflprofile, new File("C:/Users/jceballos/Documents/Screenshots/2_Twitter1.jpg"));
		} 
        catch (IOException e1) 
        {
			e1.printStackTrace();
		}

        // Back home 
        WebElement globalhome = driver.findElement(By.id("global-nav-home"));
        globalhome.click();

        Thread.sleep(1000);

        // Back to profile 
        profile = driver.findElement(By.xpath("//*[@id='page-container']/div[1]/div[1]/div/div[1]/div/a"));
        profile.click();

        Thread.sleep(1000);

        // Likes 
        WebElement likes = driver.findElement(By.xpath("//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[3]/a"));
        likes.click();
        Thread.sleep(1000);

        // Moments 
        WebElement moments = driver.findElement(By.className("moments"));
        moments.click();
        Thread.sleep(2000);
        File momentsscreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(momentsscreen, new File("C:/Users/jceballos/Documents/Screenshots/2_Twitter2.jpg"));
		} 
        catch (IOException e1) 
        {
			e1.printStackTrace();
		}

        // Notifications 
        WebElement notifications = driver.findElement(By.className("notifications"));
        notifications.click();
        Thread.sleep(2000);
        File notificationsscreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(notificationsscreen, new File("C:/Users/jceballos/Documents/Screenshots/2_Twitter3.jpg"));
		} 
        catch (IOException e1) 
        {
			e1.printStackTrace();
		}

        // DMs 
        WebElement dms = driver.findElement(By.className("dm-nav"));
        dms.click();
        Thread.sleep(2000);
        File dmsscreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(dmsscreen, new File("C:/Users/jceballos/Documents/Screenshots/2_Twitter4.jpg"));
		} 
        catch (IOException e1) 
        {
			e1.printStackTrace();
		}
        // Close DM
        WebElement closedm = driver.findElement(By.className("DMActivity-close"));
        closedm.click();

        // Search for Lakers
        WebElement searchbar = driver.findElement(By.id("search-query"));
        searchbar.sendKeys("Lakers");
        searchbar.submit();
        Thread.sleep(1000);
        WebElement lakers = driver.findElement(By.xpath("//*[@id='stream-item-user-20346956']/div/div/div[2]/div/div/a"));
        lakers.click();
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

        // Back home to profile
        globalhome = driver.findElement(By.id("global-nav-home"));
        globalhome.click();
        Thread.sleep(1000);
        profile = driver.findElement(By.xpath("//*[@id='page-container']/div[1]/div[1]/div/div[1]/div/a"));
        profile.click();
        Thread.sleep(2000);

        // Find tweet
        WebElement newTweet = driver.findElement(By.id("global-new-tweet-button"));
        newTweet.click();

        // Enter tweet
        WebElement tweet = driver.findElement(By.id("tweet-box-global"));
        tweet.sendKeys("This is automation writing this tweet!");

        // Submit tweet 
        WebElement subTweet = driver.findElement(By.xpath("//*[@id='global-tweet-dialog-dialog']/div[2]/div[4]/form/div[2]/div[2]/button"));
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

        driver.navigate().refresh();

        // Favorite/Unfavorite Tweets
        WebElement heart = driver.findElement(By.className("HeartAnimation"));
        heart.click();

        // Dropdown 
        WebElement drop = driver.findElement(By.id("user-dropdown-toggle"));
        drop.click();

        // Logout
        WebElement logout = driver.findElement(By.id("signout-button"));
        logout.click();
	}
	
	@Test
	public void Instagram() throws InterruptedException
	{
		 // Find Instagram link and submit
        search.sendKeys("Instagram");
        search.submit();

        // Link text
        WebElement linkText = driver.findElement(By.linkText("Instagram"));
        linkText.click();

        // ExampleSignup
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("seleniumtesterjay@gmail.com");
        WebElement fullname = driver.findElement(By.name("fullName"));
        fullname.sendKeys("Selenium Tester");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("automatedseleniumtester");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SeleniumTester24");
        Thread.sleep(1000);

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

        Thread.sleep(2000);

        // First Like button 
        WebElement like = driver.findElement(By.cssSelector("._ebwb5,._1tv0k"));
        like.click();

        // Explore 
        WebElement explore = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div/div[2]/div[1]/a"));
        explore.click();
        Thread.sleep(5000);
        File explorescreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(explorescreen, new File("C:/Users/jceballos/Documents/Screenshots/3_Instagram1.jpg"));
		} 
        catch (IOException e4) 
        {
			e4.printStackTrace();
		}

        // Notifications 
        WebElement notifications = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div/div[2]/div[2]/a"));
        notifications.click(); // Open
        Thread.sleep(2000);
        notifications = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div/div[2]/div[2]/div/div/div[1]"));
        notifications.click(); // Close

        // Search for #AOA
        WebElement searchbar = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div/div[1]/input"));
        searchbar.sendKeys("#AOA");
        Thread.sleep(1000);
        searchbar.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        File AOA = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(AOA, new File("C:/Users/jceballos/Documents/Screenshots/3_Instagram2.jpg"));
		} 
        catch (IOException e3) 
        {
			e3.printStackTrace();
		}

        // Profile                                     
        WebElement profile = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div/div[2]/div[3]/a"));
        profile.click();
        Thread.sleep(3000);

        // First post 
        WebElement firstpost = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/div/div[1]/div/a"));
        firstpost.click();
        Thread.sleep(3000);
        File post = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(post, new File("C:/Users/jceballos/Documents/Screenshots/3_Instagram3.jpg"));
		} 
        catch (IOException e2) 
        {
			e2.printStackTrace();
		}
        WebElement closepost = driver.findElement(By.className("_3eajp"));
        closepost.click();

        // Followers
        WebElement followers = driver.findElement(By.className("_m2soy"));
        followers.click();
        Thread.sleep(1000);

        // Exit popup
        WebElement x = driver.findElement(By.className("_3eajp"));
        x.click();

        // Following
        WebElement following = driver.findElement(By.className("_c26bu"));
        following.click();
        Thread.sleep(1000);

        // GFriend profile
        WebElement gfriend = driver.findElement(By.linkText("gfriendofficial"));
        gfriend.click();
        Thread.sleep(2500);

        // Unfollow                            
        WebElement follow = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/span[2]/button"));
        follow.click();

        Thread.sleep(1000);

        Assert.assertEquals(true, driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[1]/img")).isDisplayed());

        // Take File
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(image, new File("C:/Users/jceballos/Documents/Screenshots/3_Instagram4.jpg"));
		} 
        catch (IOException e1) 
        {
			e1.printStackTrace();
		}

        // Follow 
        follow.click();

        // Back to Profile (Need new element to avoid stale element exception)
        WebElement userprofile = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div/div[2]/div[3]/a"));
        userprofile.click();

        // Following
        following = driver.findElement(By.className("_c26bu"));
        following.click();
        Thread.sleep(1000);

        // Seolhyun profile
        WebElement seolhyun = driver.findElement(By.linkText("sh_9513"));
        seolhyun.click();
        Thread.sleep(2500);

        // Unfollow                          
        follow = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/span[2]/button"));
        follow.click();

        Thread.sleep(1000); 

        Assert.assertEquals(true, driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[1]/img")).isDisplayed());

        // Take File
        File seolscreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(seolscreen, new File("C:/Users/jceballos/Documents/Screenshots/3_Instagram5.jpg"));
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}

        // Follow 
        follow.click();

        // Back to Profile (Need new element to avoid stale element exception)
        userprofile = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div/div[2]/div[3]/a"));
        userprofile.click();

        // Three dots 
        WebElement threedots = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/button"));
        threedots.click();

        // Logout
        WebElement logout = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/ul[1]/li/button"));
        logout.click();
	}
	
	@Test
	public void LinkedIn() throws InterruptedException
	{
		// Enter LinkedIn String and submit
        search.sendKeys("LinkedIn");
        search.submit();

        // Find first link returned by Google and select
        WebElement linkedin = driver.findElement(By.linkText("LinkedIn: World's Largest Professional Network"));
        linkedin.click();

        // Example Signup
        WebElement firstname = driver.findElement(By.id("first-name"));
        firstname.sendKeys("Selenium");
        WebElement lastname = driver.findElement(By.id("last-name"));
        lastname.sendKeys("Tester");
        WebElement joinemail = driver.findElement(By.id("join-email"));
        joinemail.sendKeys("seleniumtesterjay@gmail.com");
        WebElement joinpass = driver.findElement(By.id("join-password"));
        joinpass.sendKeys("SeleniumTester24");

        // Login 
        WebElement email = driver.findElement(By.id("login-email"));
        email.sendKeys("seleniumtesterjay@gmail.com");
        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("SeleniumTester24");
        WebElement submit = driver.findElement(By.name("submit"));
        submit.submit();

        // Sleep thread
        Thread.sleep(1000);

        // User Profile 
        WebElement profiledrop = driver.findElement(By.xpath("//*[@id='main-site-nav']/ul/li[2]/a"));
        profiledrop.click();
        Thread.sleep(1000);
        WebElement viewprofile = driver.findElement(By.xpath("//*[@id='top-card']/div/div[1]/div[2]/div[2]/div[2]/a"));
        viewprofile.click();

        // Sleep thread
        Thread.sleep(3000);

        Assert.assertEquals(true, driver.findElement(By.xpath("//*[@id='control_gen_3']/img")).isDisplayed());

        // Take profile File
        File profile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(profile, new File("C:/Users/jceballos/Documents/Screenshots/4_LinkedIn1.jpg"));
		} 
        catch (IOException e2) 
        {
			e2.printStackTrace();
		}

        // Jay Profile
        WebElement jayprofile = driver.findElement(By.xpath("//*[@id='connection-282336451']/strong/span/strong/a"));
        jayprofile.click();

        // Sleep thread
        Thread.sleep(3000);

        Assert.assertEquals(true, driver.findElement(By.id("name")).isDisplayed());

        // Take File
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(image, new File("C:/Users/jceballos/Documents/Screenshots/4_LinkedIn2.jpg"));
		} 
        catch (IOException e1) 
        {
			e1.printStackTrace();
		}

        // Head back home
        WebElement home = driver.findElement(By.xpath("//*[@id='main-site-nav']/ul/li[1]/a"));
        home.click();
        Thread.sleep(1000);

        // Apple company 
        WebElement searchbar = driver.findElement(By.id("main-search-box"));
        searchbar.sendKeys("Apple");
        searchbar.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement apple = driver.findElement(By.xpath("//*[@id='results']/li[2]/div/h3/a"));
        apple.click();
        // Sleep thread
        Thread.sleep(3000);
        // Take File
        File apppro = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(apppro, new File("C:/Users/jceballos/Documents/Screenshots/4_LinkedIn3.jpg"));
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Google() throws InterruptedException
	{
		// Enter Google String and submit
        search.sendKeys("Gmail");
        search.submit();

        // Find first link returned by Google
        WebElement gmail = driver.findElement(By.linkText("Google Accounts: Sign in"));
        gmail.click();

        // Log In
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("seleniumtesterjay@gmail.com");
        email.submit();
        WebElement password = driver.findElement(By.id("Passwd"));
        password.sendKeys("SeleniumTester24");
        WebElement checkbox = driver.findElement(By.id("PersistentCookie"));
        checkbox.click();
        password.submit();

        Thread.sleep(500);

        driver.navigate().to("http://mail.google.com");

        Thread.sleep(2000);

        File gmail1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(gmail1, new File("C:/Users/jceballos/Documents/Screenshots/5_1Gmail.jpg"));
		} 
        catch (IOException e6) 
        {
			e6.printStackTrace();
		}
        String parentHandle = driver.getWindowHandle();
        
        // Drive 
        WebElement menu = driver.findElement(By.xpath("//*[@id='gbwa']/div[1]/a"));
        menu.click();
        WebElement drive = driver.findElement(By.xpath("//*[@id='gb49']/span[1]"));
        drive.click();
        Thread.sleep(2000);

        driver.switchTo().window(parentHandle).close(); // Close gmail tab
        File drive1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(drive1, new File("C:/Users/jceballos/Documents/Screenshots/5_2Drive.jpg"));
		} 
        catch (IOException e5) 
        {
			e5.printStackTrace();
		}
        parentHandle = driver.getWindowHandle();
        Thread.sleep(2000);

        // Maps 
        menu = driver.findElement(By.xpath("//*[@id='gbwa']/div[1]/a")); // Avoids stale element exception 
        menu.click();
        WebElement maps = driver.findElement(By.xpath("//*[@id='gb8']/span[1]"));
        maps.click();
        Thread.sleep(2000);

        // Switch to Drive tab and close 
        driver.switchTo().window(parentHandle).close(); // Close drive tab
        Thread.sleep(2000);
        File maps1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(maps1, new File("C:/Users/jceballos/Documents/Screenshots/5_3Maps1.jpg"));
		} 
        catch (IOException e4) 
        {
			e4.printStackTrace();
		}
        
        // Search for LA 
        WebElement mapsearch = driver.findElement(By.id("searchboxinput"));
        mapsearch.sendKeys("Los Angeles");
        mapsearch.sendKeys(Keys.ENTER);
        Thread.sleep(5000); 
        WebElement sidepanel = driver.findElement(By.xpath("//*[@id='pane']/div/div[3]/button"));
        sidepanel.click();

        // Zoom in 
        WebElement zoomin = driver.findElement(By.xpath("//*[@id='zoom']/div/button[1]"));
        zoomin.click(); 
        zoomin.click();
        // Zoom out 
        WebElement zoomout = driver.findElement(By.xpath("//*[@id='zoom']/div/button[2]"));
        zoomout.click();
        zoomout.click();

        // Images panel 
        WebElement imagepanel = driver.findElement(By.xpath("//*[@id='runway-expand-button']/div/div/button[2]/div[1]/div"));
        imagepanel.click(); // Open
        sidepanel.click(); // Open side panel

        // File regular map
        File maps2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(maps2, new File("C:/Users/jceballos/Documents/Screenshots/5_3Maps2.jpg"));
		} 
        catch (IOException e3) 
        {
			e3.printStackTrace();
		}
        imagepanel.click(); // Close

        // Open Google menu 
        WebElement dropmenu = driver.findElement(By.xpath("//*[@id='omnibox']/div[1]/div[1]/button"));
        dropmenu.click();
        Thread.sleep(500);
        WebElement earth = driver.findElement(By.xpath("//*[@id='settings']/div/div[2]/div/ul[1]/li[1]/div/button[1]"));
        earth.click();
        Thread.sleep(2000);
        sidepanel.click(); // Close side panel 
        Thread.sleep(1000);
        // File earth map
        File maps3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(maps3, new File("C:/Users/jceballos/Documents/Screenshots/5_3Maps3.jpg"));
		} 
        catch (IOException e2) 
        {
			e2.printStackTrace();
		}
        
        sidepanel.click(); // Open side panel
        dropmenu.click(); // Open menu 
        earth.click(); // Disable earth setting 
        dropmenu.click(); // Open menu again 
        Thread.sleep(500);
        WebElement traffic = driver.findElement(By.xpath("//*[@id='settings']/div/div[2]/div/ul[1]/li[2]/button"));
        traffic.click();
        Thread.sleep(2000);
        sidepanel.click(); // Close side panel
        Thread.sleep(1000);
        // File traffic map
        File maps4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(maps4, new File("C:/Users/jceballos/Documents/Screenshots/5_3Maps4.jpg"));
		} 
        catch (IOException e1) 
        {
			e1.printStackTrace();
		}

        // Directions
        sidepanel.click(); // Open side panel 
        Thread.sleep(500);
        dropmenu.click(); // Open menu
        traffic.click(); // Disable traffic setting
        WebElement directions = driver.findElement(By.xpath("//*[@id='pane']/div/div[1]/div/div[1]/button[2]"));
        directions.click();
        WebElement startpoint = driver.findElement(By.xpath("//*[@id='sb_ifc51']/input"));
        startpoint.sendKeys("San Diego");
        startpoint.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        sidepanel.click(); // Close side panel
        Thread.sleep(1000);
        // File trip map
        File maps5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(maps5, new File("C:/Users/jceballos/Documents/Screenshots/5_3Maps5.jpg"));
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Youtube() throws InterruptedException
	{
		// Enter Youtube String and submit
        search.sendKeys("Youtube");
        search.submit();

        // Find first link returned by Google and select
        WebElement youtube = driver.findElement(By.linkText("YouTube"));
        youtube.click();

        // Try Catch block for Avengers File
        try
        {
            // 1. Avengers Query
            WebElement avengesearch = driver.findElement(By.name("search_query"));
            avengesearch.sendKeys("Avengers");
            avengesearch.submit();

            Thread.sleep(1000);

            // Take File
            File list = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(list, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT1_Avengers.jpg"));
        }
        catch (Exception e)
        {
        	System.out.println(e);
            Assert.fail("Failed with Exception: " + e);
        }

        // 2. Ironman Query
        WebElement ironsearch = driver.findElement(By.name("search_query"));
        ironsearch.clear();
        ironsearch.sendKeys("Iron Man");
        ironsearch.submit();

        Thread.sleep(1000);

        File ironman = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(ironman, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT2_Ironman.jpg"));
		} 
        catch (IOException e12) 
        {
			e12.printStackTrace();
		}

        // 3. Batman Query
        WebElement batsearch = driver.findElement(By.name("search_query"));
        batsearch.clear();
        batsearch.sendKeys("Batman");
        batsearch.submit();

        Thread.sleep(1000);

        File batman = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(batman, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT3_Batman.jpg"));
		} 
        catch (IOException e11) 
        {
			e11.printStackTrace();
		}

        // 4. Green Lantern Query
        WebElement greensearch = driver.findElement(By.name("search_query"));
        greensearch.clear();
        greensearch.sendKeys("Green Lantern");
        greensearch.submit();

        Thread.sleep(1000);

        File greenlantern = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(greenlantern, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT4_GreenLantern.jpg"));
		} 
        catch (IOException e10) 
        {
			e10.printStackTrace();
		}
        
        // 5. Spider-Man Query
        WebElement spidersearch = driver.findElement(By.name("search_query"));
        spidersearch.clear();
        spidersearch.sendKeys("Spider-Man");
        spidersearch.submit();

        Thread.sleep(1000);

        File spiderman = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(spiderman, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT5_Spiderman.jpg"));
		} 
        catch (IOException e9) 
        {
			e9.printStackTrace();
		}
       
        // 6. Skyrim Query
        WebElement skysearch = driver.findElement(By.name("search_query"));
        skysearch.clear();
        skysearch.sendKeys("Skyrim");
        skysearch.submit();

        Thread.sleep(1000);

        File skyrim = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(skyrim, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT6_Skyrim.jpg"));
		} 
        catch (IOException e8) 
        {
			e8.printStackTrace();
		}

        // 7. Grand Theft Auto Query
        WebElement gtasearch = driver.findElement(By.name("search_query"));
        gtasearch.clear();
        gtasearch.sendKeys("Grand Theft Auto");
        gtasearch.submit();

        Thread.sleep(1000);

        File gta = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(gta, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT7_GTA.jpg"));
		} 
        catch (IOException e7) 
        {
			e7.printStackTrace();
		}

        // 8. Assassin's Creed Query
        WebElement assassinsearch = driver.findElement(By.name("search_query"));
        assassinsearch.clear();
        assassinsearch.sendKeys("Assassin's Creed");
        assassinsearch.submit();

        Thread.sleep(1000);

        File assassinscreed = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(assassinscreed, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT8_Assassin's Creed.jpg"));
		} 
        catch (IOException e6) 
        {
			e6.printStackTrace();
		}
       
        // 9. Dallas Cowboys
        WebElement dallassearch = driver.findElement(By.name("search_query"));
        dallassearch.clear();
        dallassearch.sendKeys("Dallas Cowboys");
        dallassearch.submit();

        Thread.sleep(1000);

        File cowboys = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(cowboys, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT9_DallasCowboys.jpg"));
		} 
        catch (IOException e5) 
        {
			e5.printStackTrace();
		}
       
        // 10. Los Angeles Lakers       
        WebElement lakerssearch = driver.findElement(By.name("search_query"));
        lakerssearch.clear();
        lakerssearch.sendKeys("Los Angeles Lakers");
        lakerssearch.submit();

        Thread.sleep(1000);

        File lakers = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(lakers, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT10_LALakers.jpg"));
		} 
        catch (IOException e4) 
        {
			e4.printStackTrace();
		}
       
        // 11. Zedd
        WebElement zeddsearch = driver.findElement(By.name("search_query"));
        zeddsearch.clear();
        zeddsearch.sendKeys("Zedd");
        zeddsearch.submit();

        Thread.sleep(1000);

        File zedd = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(zedd, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT11_Zedd.jpg"));
		} 
        catch (IOException e3) 
        {
			e3.printStackTrace();
		}
       
        // 12. Porter Robinson  
        WebElement portersearch = driver.findElement(By.name("search_query"));
        portersearch.clear();
        portersearch.sendKeys("Porter Robinson");
        portersearch.submit();

        Thread.sleep(1000);

        File porter = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(porter, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT12_Porter.jpg"));
		} 
        catch (IOException e2) 
        {
			e2.printStackTrace();
		}
       
        // 13. Seven Lions  
        WebElement sevensearch = driver.findElement(By.name("search_query"));
        sevensearch.clear();
        sevensearch.sendKeys("Seven Lions");
        sevensearch.submit();

        Thread.sleep(1000);

        File sevenlions = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(sevenlions, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT13_SevenLions.jpg"));
		} 
        catch (IOException e1) 
        {
			e1.printStackTrace();
		}
       
        // 14. Pierce The Veil 
        WebElement piercesearch = driver.findElement(By.name("search_query"));
        piercesearch.clear();
        piercesearch.sendKeys("Pierce The Veil");
        piercesearch.submit();

        Thread.sleep(1000);

        File ptv = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
			FileUtils.copyFile(ptv, new File("C:/Users/jceballos/Documents/Screenshots/Youtube/6_YT14_PTV.jpg"));
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
    
        // Back home 
        WebElement homepage = driver.findElement(By.xpath("//*[@id='logo-container']/span"));
        homepage.click(); 
	}
}
