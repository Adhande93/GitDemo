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

public class HomePage extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		//initializeDriver is a Method which is coming from another class because we r extending(inheritance)
		driver=initializeDriver();
		log.info("driver initialized successfully");
				
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password)  {

		//we r providing URL here cause for multiple data in @dataprovider will have to open browser multiple times n @BeforeTest will 
		//open it only once
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
				
		landingPage l=new landingPage(driver);		
		//		String act_text=l.getTitle().getText();		//This is declared in validateTitle class
		//		Assert.assertEquals(act_text, "FEATURED COURSES", "Text does not match");
		l.getLogin().click();

		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getpassword().sendKeys(password);
		lp.submitButton().click();

		String text=lp.errorLogin().getText();
		Assert.assertEquals(text, "Invalid email or password.", "Invalid credential");
		log.info("Entering invalid email and password");
		

	}

	@AfterTest
	public void Teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[1][2];

		data[0][0]="";
		data[0][1]="";

		//		data[1][0]="a@gmail.com";
		//		data[1][1]="mdlfl";

		return data;



	}

}
