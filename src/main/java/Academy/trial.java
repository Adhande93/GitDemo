package Academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class trial {
	
	public WebDriver driver;
	public WebDriver initializingDriver() throws IOException {
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream("F:\\sel-java-learn\\E2EProject\\src\\main\\java\\Academy\\data.Properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);
	
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "path");
		driver=new ChromeDriver();
		}
	else if(browserName.equals("firefox")){
		System.setProperty("webdriver.gecko.driver", "path");
		driver=new FirefoxDriver();
	}
	else if(browserName.equals("IE")){
		System.setProperty("webdriver.ie.driver", "path");
		driver=new InternetExplorerDriver();		
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
	
	}

}
