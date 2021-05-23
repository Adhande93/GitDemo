package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	//initializeDriver is a method whose return type is WebDriver
	public WebDriver initializeDriver() throws IOException {

		prop=new Properties();					//System.getProperty("user.dir")+
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.Properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		prop.getProperty("url");
		
		//if we use browserName==chrome it will throw NullPointerException
		if(browserName.equals("chrome")) {					//C:\\JAR1\\drivers\\chromedriver_win32
			System.setProperty("webdriver.chrome.driver","C:\\JAR1\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\\\JAR1\\\\drivers\\\\geckodriver-v0.21.0-win64\\\\GeckoDriver.exe");
			driver =new FirefoxDriver();
		}
		else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\JAR1\\drivers\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
