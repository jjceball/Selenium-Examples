using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support;
using OpenQA.Selenium.Support.UI;

namespace SeleniumCSharpSetup
{
    [TestClass]
    public class WebDrive
    {
        IWebDriver driver;
        IWait<IWebDriver> wait;

        [TestInitialize]
        public void TestSetup()
        {
            // Chrome Driver options
            ChromeOptions options = new ChromeOptions();
            options.AddArgument("--start-maximized");
            options.AddArgument("--disable-notifications");

            // Create new WebDriver (path, options)
            driver = new ChromeDriver(@"C:\Users\jceballos\Documents\Visual Studio 2013\Projects\SeleniumCSharpSetup", options);

            // Set implicit wait
            driver.Manage().Timeouts().ImplicitlyWait(TimeSpan.FromSeconds(10));

            // Create WaitDriver
            IWait<IWebDriver> wait = new WebDriverWait(driver, TimeSpan.FromSeconds(5));
        }

        [TestCleanup]
        public void Cleanup()
        {
            // Close WebDriver
            driver.Close();
            driver.Quit();
        }

        [TestMethod]
        public void Google()
        {
            // Navigate to Google for start
            driver.Navigate().GoToUrl("http://www.google.com/");
        }
    }
}
