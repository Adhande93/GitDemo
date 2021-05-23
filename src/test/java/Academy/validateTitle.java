package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.landingPage;
import resources.base;

public class validateTitle extends base{
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		//initializeDriver is a Method which is coming from another class because we r extending(inheritance)
				driver=initializeDriver();
				log.info("driver initialize");
				driver.get(prop.getProperty("url"));
				log.info("validating Menu Bar on Home Page");
	}
	
	@Test
	public void basePageNavigation() {
					
		landingPage l=new landingPage(driver);		
		String act_text=l.getTitle().getText();		
		Assert.assertEquals(act_text, "FEATURED COURSEs", "Text does not match");
		
		Assert.assertTrue(l.getMenuBar().isDisplayed());
		log.info("Menu bar displayed succesfully");
					
	}
	
	@AfterTest
	public void Teardown() {
		driver.close();
	}
	
	
}
