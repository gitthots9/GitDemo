package resource;

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class base {
	
	//declared globally
	public WebDriver driver;
	public Properties prop ;
	
	
	//defining a method for driver initialization 
	public WebDriver initialiseDriver() throws IOException
	{
	//helps in connecting properties file
	prop = new Properties();  
	
	//properties file
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\data.properties");
	
	//connecting
	prop.load(fis);
	//mvn test -Dbrowser=chrome   ---using maven instead of properties file
	String browserName=prop.getProperty("browser");
	
	
	//gets the browser value from properties file
//	String browserName=prop.getProperty("browser");
	System.out.println(browserName);
	
	// .equals to be used and not ==    since we are using getproperty
	if(browserName.contains("chrome"))
	{
		/*
		ChromeOptions options=new ChromeOptions();
		
		if(browserName.contains("headless"))
		{
			options.addArguments("--headless");
		}
		//execute chrome driver
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver(options); */
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver(); 
		
	}
	
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Meenal\\Desktop\\Selenium\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		
	}
	
	else if(browserName.equals("MSEdge"))
	{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Meenal\\Desktop\\Selenium\\edgedriver_win64\\msedgedriver.exe");
		driver=new EdgeDriver();
	}
	
	//driver object is declared globally but it gets lyf only wen it enters the block(chrome/firefox/edge)
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	return driver;
	
	}
	
	
	public String Screenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;  //still this driver is not having life,its lyf is in @Test
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	//	FileHandler.copy(source, new File(destinationFile));
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
		
	}
}

