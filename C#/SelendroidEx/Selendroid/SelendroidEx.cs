using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using System.Threading;
using OpenQA.Selenium.Interactions;
using OpenQA.Selenium.Remote;
using OpenQA.Selenium.Chrome; // to use googlechrome browser
using OpenQA.Selenium.Support;
using OpenQA.Selenium.Support.UI;
using System.Drawing.Imaging;

namespace Selendroid
{
    [TestClass]
    public class SelendroidEx
    {
        private TouchCapableRemoteWebDriver driver;
        IWebElement searchBar;

        [TestInitialize]
        public void TestSetup()
        {
            var caps = DesiredCapabilities();
            driver = new TouchCapableRemoteWebDriver(new Uri("http://localhost:4444/wd/hub") , caps);
            Thread.Sleep(2000);

            // Navigate to Google for start
            driver.Navigate().GoToUrl("http://www.google.com");

            // Find SearchBar
            searchBar = driver.FindElement(By.Name("q"));
        }

        private static DesiredCapabilities DesiredCapabilities()
        {
            DesiredCapabilities caps = OpenQA.Selenium.Remote.DesiredCapabilities.Android();
            return caps;
        }

        [TestCleanup]
        public void Cleanup()
        {
            // Close WebDriver
            driver.Quit();
        }

        [TestMethod]
        public void StringTest()
        {
            // Enter Test String and submit
            searchBar.SendKeys("Testing Selenium!");
            searchBar.Submit();
        }

        [TestMethod]
        public void Twitter()
        {
            // Enter Twitter String and submit
            searchBar.SendKeys("Twitter");
            searchBar.Submit();

            // Twitter login 
            IWebElement twitter = driver.FindElement(By.LinkText("Log in"));
            twitter.Click();

            // Enter email field
            IWebElement email = driver.FindElement(By.Name("session[username_or_email]"));
            email.SendKeys("seleniumtesterjay@gmail.com");

            // Enter password field
            IWebElement pass = driver.FindElement(By.Name("session[password]"));
            pass.SendKeys("SeleniumTester24");

            // Submit login
            IWebElement login = driver.FindElement(By.Id("signupbutton"));
            login.Submit();

            // Select Icon 
            IWebElement icon = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[5]/a"));
            icon.Click();

            // Select profile
            IWebElement profile = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/main/div/a[1]"));
            profile.Click();

            Thread.Sleep(2000);

            // Following                                                
            IWebElement following = driver.FindElement(By.CssSelector("._1A98klV2, ._3OpVsglB, ._2mYajcSS"));
            following.Click();

            // NFL
            IWebElement nfl = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div[2]/div/div[2]/div/div/section/div/div/div/div/div/div[2]/div/div/div/div[2]/div/a"));
            nfl.Click();
            Thread.Sleep(1500);
            Screenshot nflprofile = ((ITakesScreenshot)driver).GetScreenshot();
            nflprofile.SaveAsFile("C:/Users/jceballos/Documents/Screenshots/1_Twitter1.jpg", ImageFormat.Jpeg);

            // Back home 
            IWebElement globalhome = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[1]/a"));
            globalhome.Click();

            Thread.Sleep(1000);

            // Back to Icon                   
            icon = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[5]/a"));
            icon.Click();

            // Select profile                    
            profile = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/main/div/a[1]"));
            profile.Click();

            Thread.Sleep(1000);

            // Notifications 
            IWebElement notifications = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[2]/a"));
            notifications.Click();
            Thread.Sleep(1000);
            Screenshot notificationsscreen = ((ITakesScreenshot)driver).GetScreenshot();
            notificationsscreen.SaveAsFile("C:/Users/jceballos/Documents/Screenshots/1_Twitter2.jpg", ImageFormat.Jpeg);

            // DMs 
            IWebElement dms = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[3]/a"));
            dms.Click();
            Thread.Sleep(2000);
            Screenshot dmsscreen = ((ITakesScreenshot)driver).GetScreenshot();
            dmsscreen.SaveAsFile("C:/Users/jceballos/Documents/Screenshots/1_Twitter3.jpg", ImageFormat.Jpeg);

            // Search for Lakers
            IWebElement searchicon = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[4]/a"));
            searchicon.Click();
            IWebElement search = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/main/div/form/div/div/div[1]/input"));
            search.SendKeys("Lakers");
            search.Submit();
            Thread.Sleep(1000);                               
            Screenshot lakersscreen = ((ITakesScreenshot)driver).GetScreenshot();
            lakersscreen.SaveAsFile("C:/Users/jceballos/Documents/Screenshots/1_Twitter4.jpg", ImageFormat.Jpeg);

            // Back home to profile
            globalhome = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[1]/a"));
            globalhome.Click();
            Thread.Sleep(1000);

            // Find tweet   _3tixQkQf
            IWebElement newTweet = driver.FindElement(By.ClassName("_21klZNE9"));
            newTweet.Click();

            // Enter tweet
            IWebElement tweet = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/main/div/div[3]/div[2]/div/span/textarea"));
            tweet.SendKeys("This is automation writing this tweet!!!");

            // Submit tweet 
            IWebElement subTweet = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/main/div/div[2]/div/div[3]/div/button"));
            subTweet.Click();

            Thread.Sleep(2000);

            // Take screenshot
            Screenshot image = ((ITakesScreenshot)driver).GetScreenshot();
            image.SaveAsFile("C:/Users/jceballos/Documents/Screenshots/1_Twitter5.jpg", ImageFormat.Jpeg);

            Thread.Sleep(1000);

            // Options                                         
            IWebElement options = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/header/div/div/nav/div/div/div[5]/a"));
            options.Click();

            // Logout
            IWebElement logout = driver.FindElement(By.XPath("//*[@id='react-root']/div[1]/div/div/main/div/a[6]"));
            logout.Click();
        }

        [TestMethod]
        public void Instagram()
        {
            // Find Instagram link and submit
            searchBar.SendKeys("Instagram");
            searchBar.Submit();

            // Link text
            IWebElement linkText = driver.FindElement(By.LinkText("Instagram"));
            linkText.Click();

            Thread.Sleep(1000);

            // ExampleSignup
            IWebElement email = driver.FindElement(By.Name("email"));
            email.SendKeys("seleniumtesterjay@gmail.com");
            IWebElement fullname = driver.FindElement(By.Name("fullName"));
            fullname.SendKeys("Selenium Tester");
            IWebElement username = driver.FindElement(By.Name("username"));
            username.SendKeys("automatedseleniumtester");
            IWebElement password = driver.FindElement(By.Name("password"));
            password.SendKeys("SeleniumTester24");
            Thread.Sleep(500);

            // Login Button
            IWebElement login1 = driver.FindElement(By.ClassName("_k6cv7"));
            login1.Click();

            // Username field
            username = driver.FindElement(By.Name("username"));
            username.SendKeys("seleniumtesterjay");

            // Password field
            password = driver.FindElement(By.Name("password"));
            password.SendKeys("SeleniumTester24");

            // Second login button
            IWebElement login2 = driver.FindElement(By.ClassName("_rz1lq"));
            login2.Click();

            Thread.Sleep(1000);

            // First Like button 
            IWebElement like = driver.FindElement(By.CssSelector("._ebwb5,._1tv0k"));
            like.Click();

            // Explore                                         
            IWebElement explore = driver.FindElement(By.XPath("//*[@id='react-root']/section/nav/div/div/div[2]/div[1]/div/div[2]/a"));
            explore.Click();
            Thread.Sleep(1000);
            Screenshot explorescreen = ((ITakesScreenshot)driver).GetScreenshot();
            explorescreen.SaveAsFile("C:/Users/jceballos/Documents/Screenshots/2_Instagram1.jpg", ImageFormat.Jpeg);

            // Notifications 
            IWebElement notifications = driver.FindElement(By.XPath("//*[@id='react-root']/section/nav/div/div/div[2]/div/div/div[3]/a"));
            notifications.Click(); // Open
            Thread.Sleep(500);
            explore = driver.FindElement(By.XPath("//*[@id='react-root']/section/nav/div/div/div[2]/div/div/div[2]/a"));
            explore.Click();

            // Search for #AOA
            IWebElement search = driver.FindElement(By.XPath("//*[@id='react-root']/section/main/div/div/div/input"));
            search.SendKeys("#AOA");
            Thread.Sleep(500);
            search.SendKeys(Keys.Enter);
            Thread.Sleep(3000);
            Screenshot AOA = ((ITakesScreenshot)driver).GetScreenshot();
            AOA.SaveAsFile("C:/Users/jceballos/Documents/Screenshots/2_Instagram2.jpg", ImageFormat.Jpeg);

            // Profile                                     
            IWebElement profile = driver.FindElement(By.XPath("//*[@id='react-root']/section/nav/div/div/div[2]/div[1]/div/div[4]/a"));
            profile.Click();
            Thread.Sleep(1000);

            // First post 
            IWebElement firstpost = driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/div/div[1]/div/a"));
            firstpost.Click();
            Thread.Sleep(1000);
            Screenshot post = ((ITakesScreenshot)driver).GetScreenshot();
            post.SaveAsFile("C:/Users/jceballos/Documents/Screenshots/2_Instagram3.jpg", ImageFormat.Jpeg);
            driver.Navigate().Back(); // Go back to the Profile page. 

            // Followers
            IWebElement followers = driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/ul/li[2]/a"));
            followers.Click();
            Thread.Sleep(500);
            driver.Navigate().Back();

            // Following
            IWebElement following = driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/ul/li[3]/a"));
            following.Click();
            Thread.Sleep(1000);

            // GFriend profile
            IWebElement gfriend = driver.FindElement(By.LinkText("gfriendofficial"));
            gfriend.Click();
            Thread.Sleep(1000);

            // Unfollow                                       
            IWebElement follow = driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/header/div[2]/div[3]/span/button"));
            follow.Click();

            Thread.Sleep(1000);
                                                               
            Assert.AreEqual(true, driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/header/div[1]/img")).Displayed);

            // Take screenshot
            Screenshot image = ((ITakesScreenshot)driver).GetScreenshot();
            image.SaveAsFile("C:/Users/jceballos/Documents/Screenshots/2_Instagram4.jpg", ImageFormat.Jpeg);

            // Follow 
            follow.Click();

            // Back to Profile (Need new element to avoid stale element exception)
            IWebElement userprofile = driver.FindElement(By.XPath("//*[@id='react-root']/section/nav/div/div/div[2]/div[1]/div/div[4]/a"));
            userprofile.Click();

            // Following
            following = driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/ul/li[3]/a"));
            following.Click();
            Thread.Sleep(500);

            // Seolhyun profile
            IWebElement seolhyun = driver.FindElement(By.LinkText("sh_9513"));
            seolhyun.Click();
            Thread.Sleep(1000);

            // Unfollow                          
            follow = driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/header/div[2]/div[3]/span/button"));
            follow.Click();

            Thread.Sleep(500);

            Assert.AreEqual(true, driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/header/div[1]/img")).Displayed);

            // Take screenshot
            Screenshot seolscreen = ((ITakesScreenshot)driver).GetScreenshot();
            seolscreen.SaveAsFile("C:/Users/jceballos/Documents/Screenshots/2_Instagram5.jpg", ImageFormat.Jpeg);

            // Follow 
            follow.Click();

            // Back to Profile (Need new element to avoid stale element exception)
            userprofile = driver.FindElement(By.XPath("//*[@id='react-root']/section/nav/div/div/div[2]/div[1]/div/div[4]/a"));
            userprofile.Click();

            // Three dots 
            IWebElement threedots = driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/button"));
            threedots.Click();

            // Logout
            IWebElement logout = driver.FindElement(By.XPath("/html/body/div[2]/div/div/ul/li[4]/button"));
            logout.Click();
        }
    }
}
