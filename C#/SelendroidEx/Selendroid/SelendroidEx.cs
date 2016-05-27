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
        public void Facebook()
        {
            // Enter Facebook String and submit
            searchBar.SendKeys("Facebook");
            searchBar.Submit();

            // Facebook link element
            IWebElement facebook = driver.FindElement(By.XPath("//*[@id='rso']/div[1]/div/div/h3/a[1]"));
            facebook.Click();

            // Enter email field
            IWebElement email = driver.FindElement(By.Id("email"));
            email.SendKeys("seleniumtesterjay@gmail.com");

            // Enter password field
            IWebElement pass = driver.FindElement(By.Id("pass"));
            pass.SendKeys("SeleniumTester24");

            // Submit credentials
            IWebElement login = driver.FindElement(By.Id("loginbutton"));
            login.Submit();

            Thread.Sleep(1000);

            // Search for Nike
            IWebElement search = driver.FindElement(By.Name("q"));
            search.SendKeys("Nike");
            search.Submit();

            Thread.Sleep(2000);

            driver.Navigate().Refresh();

            IWebElement pages = driver.FindElement(By.XPath("//*[@id='u_0_u']/div/div/div/ul/li[6]"));
            pages.Click();

            Thread.Sleep(1000);

            // Nike page 
            IWebElement nike = driver.FindElement(By.ClassName("_gll"));
            nike.Click();

            // Sleep thread
            Thread.Sleep(2500);

            Assert.AreEqual(true, driver.FindElement(By.XPath("//*[@id='fbPageFinchProfilePic']/a/img")).Displayed);

            // Take profile screenshot
            Screenshot screennike = ((ITakesScreenshot)driver).GetScreenshot();
            screennike.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/1_Facebook1.jpg", ImageFormat.Jpeg);

            // Try Catch block for screenshot
            try
            {
                // Select profile element
                IWebElement profile = driver.FindElement(By.ClassName("_2s25"));
                profile.Click();

                Thread.Sleep(2000);

                // Take screenshot
                Screenshot image = ((ITakesScreenshot)driver).GetScreenshot();
                image.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/1_Facebook2.jpg", ImageFormat.Jpeg);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                Assert.Fail("Failed with Exception: " + e);
            }

            // Select dropdown menu
            IWebElement drop = driver.FindElement(By.Id("userNavigationLabel"));
            drop.Click(); // Open dropdown
            drop.Click(); // Close dropdown

            // Back home 
            IWebElement home = driver.FindElement(By.XPath("//*[@id='blueBarDOMInspector']/div[1]/div/div/div/div[1]/div[1]/h1/a"));
            home.Click();

            Thread.Sleep(2500);

            // Messages
            IWebElement messages = driver.FindElement(By.XPath("//*[@id='navItem_217974574879787']/a/div/span"));
            messages.Click();
            Thread.Sleep(1500);
            Screenshot messagescreen = ((ITakesScreenshot)driver).GetScreenshot();
            messagescreen.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/1_Facebook3.jpg", ImageFormat.Jpeg);
        }

        [TestMethod]
        public void Twitter()
        {
            // Enter Twitter String and submit
            searchBar.SendKeys("Twitter");
            searchBar.Submit();

            // Twitter link 
            IWebElement twitter = driver.FindElement(By.LinkText("Twitter"));
            twitter.Click();

            // Login button
            IWebElement login1 = driver.FindElement(By.ClassName("js-login"));
            login1.Click();

            // Enter email field
            IWebElement email = driver.FindElement(By.Name("session[username_or_email]"));
            email.SendKeys("seleniumtesterjay@gmail.com");

            // Enter password field
            IWebElement pass = driver.FindElement(By.Name("session[password]"));
            pass.SendKeys("SeleniumTester24");

            // Uncheck remember me
            IWebElement remember = driver.FindElement(By.Name("remember_me"));
            remember.Click();

            // Submit login
            IWebElement login = driver.FindElement(By.ClassName("js-submit"));
            login.Submit();

            // Select profile 
            IWebElement profile = driver.FindElement(By.XPath("//*[@id='page-container']/div[1]/div[1]/div/div[1]/div/a"));
            profile.Click();

            Thread.Sleep(1000);

            // Following 
            IWebElement following = driver.FindElement(By.XPath("//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[2]/a"));
            following.Click();

            // NFL
            IWebElement nfl = driver.FindElement(By.XPath("//*[@id='stream-item-user-19426551']/div/div/div[2]/div/div/a"));
            nfl.Click();
            Thread.Sleep(2500);
            Screenshot nflprofile = ((ITakesScreenshot)driver).GetScreenshot();
            nflprofile.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/2_Twitter1.jpg", ImageFormat.Jpeg);

            // Back home 
            IWebElement globalhome = driver.FindElement(By.Id("global-nav-home"));
            globalhome.Click();

            Thread.Sleep(1000);

            // Back to profile 
            profile = driver.FindElement(By.XPath("//*[@id='page-container']/div[1]/div[1]/div/div[1]/div/a"));
            profile.Click();

            Thread.Sleep(1000);

            // Likes 
            IWebElement likes = driver.FindElement(By.XPath("//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[3]/a"));
            likes.Click();
            Thread.Sleep(1000);

            // Moments 
            IWebElement moments = driver.FindElement(By.ClassName("moments"));
            moments.Click();
            Thread.Sleep(2000);
            Screenshot momentsscreen = ((ITakesScreenshot)driver).GetScreenshot();
            momentsscreen.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/2_Twitter2.jpg", ImageFormat.Jpeg);

            // Notifications 
            IWebElement notifications = driver.FindElement(By.ClassName("notifications"));
            notifications.Click();
            Thread.Sleep(2000);
            Screenshot notificationsscreen = ((ITakesScreenshot)driver).GetScreenshot();
            notificationsscreen.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/2_Twitter3.jpg", ImageFormat.Jpeg);

            // DMs 
            IWebElement dms = driver.FindElement(By.ClassName("dm-nav"));
            dms.Click();
            Thread.Sleep(2000);
            Screenshot dmsscreen = ((ITakesScreenshot)driver).GetScreenshot();
            dmsscreen.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/2_Twitter4.jpg", ImageFormat.Jpeg);
            // Close DM
            IWebElement closedm = driver.FindElement(By.ClassName("DMActivity-close"));
            closedm.Click();

            // Search for Lakers
            IWebElement search = driver.FindElement(By.Id("search-query"));
            search.SendKeys("Lakers");
            search.Submit();
            Thread.Sleep(1000);
            IWebElement lakers = driver.FindElement(By.XPath("//*[@id='stream-item-user-20346956']/div/div/div[2]/div/div/a"));
            lakers.Click();
            Thread.Sleep(1000);
            Screenshot lakersscreen = ((ITakesScreenshot)driver).GetScreenshot();
            lakersscreen.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/2_Twitter5.jpg", ImageFormat.Jpeg);

            // Back home to profile
            globalhome = driver.FindElement(By.Id("global-nav-home"));
            globalhome.Click();
            Thread.Sleep(1000);
            profile = driver.FindElement(By.XPath("//*[@id='page-container']/div[1]/div[1]/div/div[1]/div/a"));
            profile.Click();
            Thread.Sleep(2000);

            // Find tweet
            IWebElement newTweet = driver.FindElement(By.Id("global-new-tweet-button"));
            newTweet.Click();

            // Enter tweet
            IWebElement tweet = driver.FindElement(By.Id("tweet-box-global"));
            tweet.SendKeys("This is automation writing this tweet!");

            // Submit tweet 
            IWebElement subTweet = driver.FindElement(By.XPath("//*[@id='global-tweet-dialog-dialog']/div[2]/div[4]/form/div[2]/div[2]/button"));
            subTweet.Click();

            Thread.Sleep(2000);

            // Take screenshot
            Screenshot image = ((ITakesScreenshot)driver).GetScreenshot();
            image.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/2_Twitter6.jpg", ImageFormat.Jpeg);

            Thread.Sleep(1000);

            driver.Navigate().Refresh();

            // Favorite/Unfavorite Tweets
            IWebElement heart = driver.FindElement(By.ClassName("HeartAnimation"));
            heart.Click();

            // Dropdown 
            IWebElement drop = driver.FindElement(By.Id("user-dropdown-toggle"));
            drop.Click();

            // Logout
            IWebElement logout = driver.FindElement(By.Id("signout-button"));
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

            // ExampleSignup
            IWebElement email = driver.FindElement(By.Name("email"));
            email.SendKeys("seleniumtesterjay@gmail.com");
            IWebElement fullname = driver.FindElement(By.Name("fullName"));
            fullname.SendKeys("Selenium Tester");
            IWebElement username = driver.FindElement(By.Name("username"));
            username.SendKeys("automatedseleniumtester");
            IWebElement password = driver.FindElement(By.Name("password"));
            password.SendKeys("SeleniumTester24");
            Thread.Sleep(1000);

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

            Thread.Sleep(2000);

            // First Like button 
            IWebElement like = driver.FindElement(By.CssSelector("._ebwb5,._1tv0k"));
            like.Click();

            // Explore 
            IWebElement explore = driver.FindElement(By.XPath("//*[@id='react-root']/section/nav/div/div/div/div[2]/div[1]/a"));
            explore.Click();
            Thread.Sleep(5000);
            Screenshot explorescreen = ((ITakesScreenshot)driver).GetScreenshot();
            explorescreen.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/3_Instagram1.jpg", ImageFormat.Jpeg);

            // Notifications 
            IWebElement notifications = driver.FindElement(By.XPath("//*[@id='react-root']/section/nav/div/div/div/div[2]/div[2]/a"));
            notifications.Click(); // Open
            Thread.Sleep(2000);
            notifications = driver.FindElement(By.XPath("//*[@id='react-root']/section/nav/div/div/div/div[2]/div[2]/div/div/div[1]"));
            notifications.Click(); // Close

            // Search for #AOA
            IWebElement search = driver.FindElement(By.XPath("//*[@id='react-root']/section/nav/div/div/div/div[1]/input"));
            search.SendKeys("#AOA");
            Thread.Sleep(1000);
            search.SendKeys(Keys.Enter);
            Thread.Sleep(3000);
            Screenshot AOA = ((ITakesScreenshot)driver).GetScreenshot();
            AOA.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/3_Instagram2.jpg", ImageFormat.Jpeg);

            // Profile                                     
            IWebElement profile = driver.FindElement(By.XPath("//*[@id='react-root']/section/nav/div/div/div/div[2]/div[3]/a"));
            profile.Click();
            Thread.Sleep(3000);

            // First post 
            IWebElement firstpost = driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/div/div[1]/div/a"));
            firstpost.Click();
            Thread.Sleep(3000);
            Screenshot post = ((ITakesScreenshot)driver).GetScreenshot();
            post.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/3_Instagram3.jpg", ImageFormat.Jpeg);
            IWebElement closepost = driver.FindElement(By.ClassName("_3eajp"));
            closepost.Click();

            // Followers
            IWebElement followers = driver.FindElement(By.ClassName("_m2soy"));
            followers.Click();
            Thread.Sleep(1000);

            // Exit popup
            IWebElement x = driver.FindElement(By.ClassName("_3eajp"));
            x.Click();

            // Following
            IWebElement following = driver.FindElement(By.ClassName("_c26bu"));
            following.Click();
            Thread.Sleep(1000);

            // GFriend profile
            IWebElement gfriend = driver.FindElement(By.LinkText("gfriendofficial"));
            gfriend.Click();
            Thread.Sleep(2500);

            // Unfollow                            
            IWebElement follow = driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/span[2]/button"));
            follow.Click();

            Thread.Sleep(1000);

            Assert.AreEqual(true, driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/header/div[1]/img")).Displayed);

            // Take screenshot
            Screenshot image = ((ITakesScreenshot)driver).GetScreenshot();
            image.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/3_Instagram4.jpg", ImageFormat.Jpeg);

            // Follow 
            follow.Click();

            // Back to Profile (Need new element to avoid stale element exception)
            IWebElement userprofile = driver.FindElement(By.XPath("//*[@id='react-root']/section/nav/div/div/div/div[2]/div[3]/a"));
            userprofile.Click();

            // Following
            following = driver.FindElement(By.ClassName("_c26bu"));
            following.Click();
            Thread.Sleep(1000);

            // Seolhyun profile
            IWebElement seolhyun = driver.FindElement(By.LinkText("sh_9513"));
            seolhyun.Click();
            Thread.Sleep(2500);

            // Unfollow                          
            follow = driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/span[2]/button"));
            follow.Click();

            Thread.Sleep(1000);

            Assert.AreEqual(true, driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/header/div[1]/img")).Displayed);

            // Take screenshot
            Screenshot seolscreen = ((ITakesScreenshot)driver).GetScreenshot();
            seolscreen.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/3_Instagram5.jpg", ImageFormat.Jpeg);

            // Follow 
            follow.Click();

            // Back to Profile (Need new element to avoid stale element exception)
            userprofile = driver.FindElement(By.XPath("//*[@id='react-root']/section/nav/div/div/div/div[2]/div[3]/a"));
            userprofile.Click();

            // Three dots 
            IWebElement threedots = driver.FindElement(By.XPath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/button"));
            threedots.Click();

            // Logout
            IWebElement logout = driver.FindElement(By.XPath("/html/body/div[2]/div/div[2]/div/div/ul[1]/li/button"));
            logout.Click();
        }

        [TestMethod]
        public void LinkedIn()
        {
            // Enter LinkedIn String and submit
            searchBar.SendKeys("LinkedIn");
            searchBar.Submit();

            // Find first link returned by Google and select
            IWebElement linkedin = driver.FindElement(By.LinkText("LinkedIn: World's Largest Professional Network"));
            linkedin.Click();

            // Example Signup
            IWebElement firstname = driver.FindElement(By.Id("first-name"));
            firstname.SendKeys("Selenium");
            IWebElement lastname = driver.FindElement(By.Id("last-name"));
            lastname.SendKeys("Tester");
            IWebElement joinemail = driver.FindElement(By.Id("join-email"));
            joinemail.SendKeys("seleniumtesterjay@gmail.com");
            IWebElement joinpass = driver.FindElement(By.Id("join-password"));
            joinpass.SendKeys("SeleniumTester24");

            // Login 
            IWebElement email = driver.FindElement(By.Id("login-email"));
            email.SendKeys("seleniumtesterjay@gmail.com");
            IWebElement password = driver.FindElement(By.Id("login-password"));
            password.SendKeys("SeleniumTester24");
            IWebElement submit = driver.FindElement(By.Name("submit"));
            submit.Submit();

            // Sleep thread
            Thread.Sleep(1000);

            // User Profile 
            IWebElement profiledrop = driver.FindElement(By.XPath("//*[@id='main-site-nav']/ul/li[2]/a"));
            profiledrop.Click();
            Thread.Sleep(1000);
            IWebElement viewprofile = driver.FindElement(By.XPath("//*[@id='top-card']/div/div[1]/div[2]/div[2]/div[2]/a"));
            viewprofile.Click();

            // Sleep thread
            Thread.Sleep(3000);

            Assert.AreEqual(true, driver.FindElement(By.XPath("//*[@id='control_gen_3']/img")).Displayed);

            // Take profile screenshot
            Screenshot profile = ((ITakesScreenshot)driver).GetScreenshot();
            profile.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/4_LinkedIn1.jpg", ImageFormat.Jpeg);

            // Jay Profile
            IWebElement jayprofile = driver.FindElement(By.XPath("//*[@id='connection-282336451']/strong/span/strong/a"));
            jayprofile.Click();

            // Sleep thread
            Thread.Sleep(3000);

            Assert.AreEqual(true, driver.FindElement(By.Id("name")).Displayed);

            // Take screenshot
            Screenshot image = ((ITakesScreenshot)driver).GetScreenshot();
            image.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/4_LinkedIn2.jpg", ImageFormat.Jpeg);

            // Head back home
            IWebElement home = driver.FindElement(By.XPath("//*[@id='main-site-nav']/ul/li[1]/a"));
            home.Click();
            Thread.Sleep(1000);

            // Apple company 
            IWebElement search = driver.FindElement(By.Id("main-search-box"));
            search.SendKeys("Apple");
            search.SendKeys(Keys.Enter);
            Thread.Sleep(1000);
            IWebElement apple = driver.FindElement(By.XPath("//*[@id='results']/li[2]/div/h3/a"));
            apple.Click();
            // Sleep thread
            Thread.Sleep(3000);
            // Take screenshot
            Screenshot apppro = ((ITakesScreenshot)driver).GetScreenshot();
            apppro.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/4_LinkedIn3.jpg", ImageFormat.Jpeg);
        }

        [TestMethod]
        public void Google()
        {
            // Enter Google String and submit
            searchBar.SendKeys("Gmail");
            searchBar.Submit();

            // Find first link returned by Google
            IWebElement gmail = driver.FindElement(By.LinkText("Google Accounts: Sign in"));
            gmail.Click();

            // Log In
            IWebElement email = driver.FindElement(By.Id("Email"));
            email.SendKeys("seleniumtesterjay@gmail.com");
            email.Submit();
            IWebElement password = driver.FindElement(By.Id("Passwd"));
            password.SendKeys("SeleniumTester24");
            IWebElement checkbox = driver.FindElement(By.Id("PersistentCookie"));
            checkbox.Click();
            password.Submit();

            Thread.Sleep(500);

            driver.Navigate().GoToUrl("http://mail.google.com");

            Thread.Sleep(2000);

            Screenshot gmail1 = ((ITakesScreenshot)driver).GetScreenshot();
            gmail1.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/5_1Gmail.jpg", ImageFormat.Jpeg);

            // Drive 
            IWebElement menu = driver.FindElement(By.XPath("//*[@id='gbwa']/div[1]/a"));
            menu.Click();
            IWebElement drive = driver.FindElement(By.XPath("//*[@id='gb49']/span[1]"));
            drive.Click();
            Thread.Sleep(2000);

            driver.SwitchTo().Window(driver.WindowHandles[0]).Close(); // Close gmail tab
            driver.SwitchTo().Window(driver.WindowHandles[0]); // Back to Drive tab 
            Screenshot drive1 = ((ITakesScreenshot)driver).GetScreenshot();
            drive1.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/5_2Drive.jpg", ImageFormat.Jpeg);

            Thread.Sleep(2000);

            // Maps 
            menu = driver.FindElement(By.XPath("//*[@id='gbwa']/div[1]/a")); // Avoids stale element exception 
            menu.Click();
            IWebElement maps = driver.FindElement(By.XPath("//*[@id='gb8']/span[1]"));
            maps.Click();
            Thread.Sleep(2000);

            // Switch to Drive tab and close 
            driver.SwitchTo().Window(driver.WindowHandles[0]).Close(); // Close drive tab
            driver.SwitchTo().Window(driver.WindowHandles[0]); // Back to Maps tab 
            Thread.Sleep(2000);
            Screenshot maps1 = ((ITakesScreenshot)driver).GetScreenshot();
            maps1.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/5_3Maps1.jpg", ImageFormat.Jpeg);

            // Search for LA 
            IWebElement mapsearch = driver.FindElement(By.Id("searchboxinput"));
            mapsearch.SendKeys("Los Angeles");
            mapsearch.SendKeys(Keys.Enter);
            Thread.Sleep(5000);
            IWebElement sidepanel = driver.FindElement(By.XPath("//*[@id='pane']/div/div[3]/button"));
            sidepanel.Click();

            // Zoom in 
            IWebElement zoomin = driver.FindElement(By.XPath("//*[@id='zoom']/div/button[1]"));
            zoomin.Click();
            zoomin.Click();
            // Zoom out 
            IWebElement zoomout = driver.FindElement(By.XPath("//*[@id='zoom']/div/button[2]"));
            zoomout.Click();
            zoomout.Click();

            // Images panel 
            IWebElement imagepanel = driver.FindElement(By.XPath("//*[@id='runway-expand-button']/div/div/button[2]/div[1]/div"));
            imagepanel.Click(); // Open
            sidepanel.Click(); // Open side panel

            // Screenshot regular map
            Screenshot maps2 = ((ITakesScreenshot)driver).GetScreenshot();
            maps2.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/5_3Maps2.jpg", ImageFormat.Jpeg);
            imagepanel.Click(); // Close

            // Open Google menu 
            IWebElement dropmenu = driver.FindElement(By.XPath("//*[@id='omnibox']/div[1]/div[1]/button"));
            dropmenu.Click();
            Thread.Sleep(500);
            IWebElement earth = driver.FindElement(By.XPath("//*[@id='settings']/div/div[2]/div/ul[1]/li[1]/div/button[1]"));
            earth.Click();
            Thread.Sleep(2000);
            sidepanel.Click(); // Close side panel 
            Thread.Sleep(1000);
            // Screenshot earth map
            Screenshot maps3 = ((ITakesScreenshot)driver).GetScreenshot();
            maps3.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/5_3Maps3.jpg", ImageFormat.Jpeg);

            sidepanel.Click(); // Open side panel
            dropmenu.Click(); // Open menu 
            earth.Click(); // Disable earth setting 
            dropmenu.Click(); // Open menu again 
            Thread.Sleep(500);
            IWebElement traffic = driver.FindElement(By.XPath("//*[@id='settings']/div/div[2]/div/ul[1]/li[2]/button"));
            traffic.Click();
            Thread.Sleep(2000);
            sidepanel.Click(); // Close side panel
            Thread.Sleep(1000);
            // Screenshot traffic map
            Screenshot maps4 = ((ITakesScreenshot)driver).GetScreenshot();
            maps4.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/5_3Maps4.jpg", ImageFormat.Jpeg);

            // Directions
            sidepanel.Click(); // Open side panel 
            Thread.Sleep(500);
            dropmenu.Click(); // Open menu
            traffic.Click(); // Disable traffic setting
            IWebElement directions = driver.FindElement(By.XPath("//*[@id='pane']/div/div[1]/div/div[1]/button[2]"));
            directions.Click();
            IWebElement startpoint = driver.FindElement(By.XPath("//*[@id='sb_ifc51']/input"));
            startpoint.SendKeys("San Diego");
            startpoint.SendKeys(Keys.Enter);
            Thread.Sleep(2000);
            sidepanel.Click(); // Close side panel
            Thread.Sleep(1000);
            // Screenshot trip map
            Screenshot maps5 = ((ITakesScreenshot)driver).GetScreenshot();
            maps5.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/5_3Maps5.jpg", ImageFormat.Jpeg);
        }

        [TestMethod]
        public void Youtube()
        {
            // Enter Youtube String and submit
            searchBar.SendKeys("Youtube");
            searchBar.Submit();

            // Find first link returned by Google and select
            IWebElement youtube = driver.FindElement(By.LinkText("YouTube"));
            youtube.Click();

            // Try Catch block for Avengers screenshot
            try
            {
                // 1. Avengers Query
                IWebElement avengesearch = driver.FindElement(By.Name("search_query"));
                avengesearch.SendKeys("Avengers");
                avengesearch.Submit();

                Thread.Sleep(1000);

                // Take screenshot
                Screenshot list = ((ITakesScreenshot)driver).GetScreenshot();
                list.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT1_Avengers.jpg", ImageFormat.Jpeg);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                Assert.Fail("Failed with Exception: " + e);
            }

            // 2. Ironman Query
            IWebElement ironsearch = driver.FindElement(By.Name("search_query"));
            ironsearch.Clear();
            ironsearch.SendKeys("Iron Man");
            ironsearch.Submit();

            Thread.Sleep(1000);

            Screenshot ironman = ((ITakesScreenshot)driver).GetScreenshot();
            ironman.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT2_Ironman.jpg", ImageFormat.Jpeg);

            // 3. Batman Query
            IWebElement batsearch = driver.FindElement(By.Name("search_query"));
            batsearch.Clear();
            batsearch.SendKeys("Batman");
            batsearch.Submit();

            Thread.Sleep(1000);

            Screenshot batman = ((ITakesScreenshot)driver).GetScreenshot();
            batman.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT3_Batman.jpg", ImageFormat.Jpeg);

            // 4. Green Lantern Query
            IWebElement greensearch = driver.FindElement(By.Name("search_query"));
            greensearch.Clear();
            greensearch.SendKeys("Green Lantern");
            greensearch.Submit();

            Thread.Sleep(1000);

            Screenshot greenlantern = ((ITakesScreenshot)driver).GetScreenshot();
            greenlantern.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT4_GreenLantern.jpg", ImageFormat.Jpeg);

            // 5. Spider-Man Query
            IWebElement spidersearch = driver.FindElement(By.Name("search_query"));
            spidersearch.Clear();
            spidersearch.SendKeys("Spider-Man");
            spidersearch.Submit();

            Thread.Sleep(1000);

            Screenshot spiderman = ((ITakesScreenshot)driver).GetScreenshot();
            spiderman.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT5_Spiderman.jpg", ImageFormat.Jpeg);

            // 6. Skyrim Query
            IWebElement skysearch = driver.FindElement(By.Name("search_query"));
            skysearch.Clear();
            skysearch.SendKeys("Skyrim");
            skysearch.Submit();

            Thread.Sleep(1000);

            Screenshot skyrim = ((ITakesScreenshot)driver).GetScreenshot();
            skyrim.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT6_Skyrim.jpg", ImageFormat.Jpeg);

            // 7. Grand Theft Auto Query
            IWebElement gtasearch = driver.FindElement(By.Name("search_query"));
            gtasearch.Clear();
            gtasearch.SendKeys("Grand Theft Auto");
            gtasearch.Submit();

            Thread.Sleep(1000);

            Screenshot gta = ((ITakesScreenshot)driver).GetScreenshot();
            gta.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT7_GTA.jpg", ImageFormat.Jpeg);

            // 8. Assassin's Creed Query
            IWebElement assassinsearch = driver.FindElement(By.Name("search_query"));
            assassinsearch.Clear();
            assassinsearch.SendKeys("Assassin's Creed");
            assassinsearch.Submit();

            Thread.Sleep(1000);

            Screenshot assassinscreed = ((ITakesScreenshot)driver).GetScreenshot();
            assassinscreed.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT8_Assassin's Creed.jpg", ImageFormat.Jpeg);

            // 9. Dallas Cowboys
            IWebElement dallassearch = driver.FindElement(By.Name("search_query"));
            dallassearch.Clear();
            dallassearch.SendKeys("Dallas Cowboys");
            dallassearch.Submit();

            Thread.Sleep(1000);

            Screenshot cowboys = ((ITakesScreenshot)driver).GetScreenshot();
            cowboys.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT9_DallasCowboys.jpg", ImageFormat.Jpeg);

            // 10. Los Angeles Lakers       
            IWebElement lakerssearch = driver.FindElement(By.Name("search_query"));
            lakerssearch.Clear();
            lakerssearch.SendKeys("Los Angeles Lakers");
            lakerssearch.Submit();

            Thread.Sleep(1000);

            Screenshot lakers = ((ITakesScreenshot)driver).GetScreenshot();
            lakers.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT10_LALakers.jpg", ImageFormat.Jpeg);

            // 11. Zedd
            IWebElement zeddsearch = driver.FindElement(By.Name("search_query"));
            zeddsearch.Clear();
            zeddsearch.SendKeys("Zedd");
            zeddsearch.Submit();

            Thread.Sleep(1000);

            Screenshot zedd = ((ITakesScreenshot)driver).GetScreenshot();
            zedd.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT11_Zedd.jpg", ImageFormat.Jpeg);

            // 12. Porter Robinson  
            IWebElement portersearch = driver.FindElement(By.Name("search_query"));
            portersearch.Clear();
            portersearch.SendKeys("Porter Robinson");
            portersearch.Submit();

            Thread.Sleep(1000);

            Screenshot porter = ((ITakesScreenshot)driver).GetScreenshot();
            porter.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT12_Porter.jpg", ImageFormat.Jpeg);

            // 13. Seven Lions  
            IWebElement sevensearch = driver.FindElement(By.Name("search_query"));
            sevensearch.Clear();
            sevensearch.SendKeys("Seven Lions");
            sevensearch.Submit();

            Thread.Sleep(1000);

            Screenshot sevenlions = ((ITakesScreenshot)driver).GetScreenshot();
            sevenlions.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT13_SevenLions.jpg", ImageFormat.Jpeg);

            // 14. Pierce The Veil 
            IWebElement piercesearch = driver.FindElement(By.Name("search_query"));
            piercesearch.Clear();
            piercesearch.SendKeys("Pierce The Veil");
            piercesearch.Submit();

            Thread.Sleep(1000);

            Screenshot ptv = ((ITakesScreenshot)driver).GetScreenshot();
            ptv.SaveAsFile("C:/Users/jceballos/Documents/Visual Studio 2013/Projects/SeleniumEx/Screenshots/Youtube/6_YT14_PTV.jpg", ImageFormat.Jpeg);

            // Back home 
            IWebElement homepage = driver.FindElement(By.XPath("//*[@id='logo-container']/span"));
            homepage.Click();
        }
    }
}
