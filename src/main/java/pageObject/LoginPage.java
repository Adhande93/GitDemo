package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	//objects of Login Page i.e userid and password
	
	WebDriver driver;
	
	By email=By.id("user_email");
	By password=By.id("user_password");
	By submit=By.cssSelector("[type='submit']");
	
	By errorMessage=By.xpath("//div[contains(text(),'Invalid email or password.')]");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);		
	}
	
	public WebElement getpassword() {
		return driver.findElement(password);
	}
	
	public WebElement submitButton() {
		return driver.findElement(submit);
	}
	
	public WebElement errorLogin() {
		return driver.findElement(errorMessage);
	}
	
	
	

}
