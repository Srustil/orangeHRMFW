package script;

import base.BaseTest;
import io.qameta.allure.Allure;
import page.LoginPage;
import utils.ConfigUtil;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;

public class OrangeHRMLoginTestGrid {

    WebDriver driver;

    @BeforeClass
    public void setup() throws Exception
    {
//    	try {
//
//    	DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setBrowserName("chrome");
//
//        driver = new RemoteWebDriver(
//            new URL("http://192.168.196.1:1234/wd/hub"), caps
//        );
//    } catch (Exception e) {
//        e.printStackTrace(); // or log to report
//        Assert.fail("WebDriver setup failed: " + e.getMessage());
//    }
    
    	

    	    try {
    	    	
    	            ChromeOptions options = new ChromeOptions();
    	            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    	        }
    	     catch (Exception e) {
    	    	Allure.addAttachment("Driver Init Error", e.getMessage());
    	        Assert.fail("WebDriver setup failed: " + e.getMessage());
    	    }

    }

    @Test
    public void testLogin() {
    	try {
    	LoginPage loginPage = new LoginPage(driver); // If not already instantiated elsewhere

        loginPage.enterUsername(ConfigUtil.getProperty("username"));
        loginPage.enterPassword(ConfigUtil.getProperty("password"));
        loginPage.clickLogin();
    	}
    	catch(Exception e)
    	{
    		Allure.addAttachment("webelement issue", e.getMessage());

    	}

        // Add diagnostic logging or assertions here
        System.out.println("Login test completed on Grid");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
