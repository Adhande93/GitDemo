package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	//we are creating the objects for the webElement of the login page
	
	WebDriver driver;
	
	private By text=By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By menuBar=By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	private By login=By.cssSelector("a[href*='sign_in']");
	
	//this is Constructor we r using to use the driver object from another class so that we can declare this in object of this
	//class in the HomePage class--- this is all to solve(avoid) NullPointerException
	public landingPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getTitle() {
		return driver.findElement(text);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement getMenuBar() {
		return driver.findElement(menuBar);
	}

		
	
	
}
