package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resource.base;

public class HomePage extends base {
	
	public WebDriver driver;//created local copy for parallel execution

	public static  Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void Initialise() throws IOException
	{
		//below method returns a driver 
				driver=initialiseDriver();
				
				
	}
	
	@Test(dataProvider="getData")
	public void landingtoHomePage(String email,String Pwd,String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		
		LandingPage l=new LandingPage(driver);
	//	l.login().click();
		LoginPage lp=l.login();
		
	//	LoginPage lp=new LoginPage(driver);
		lp.Email().sendKeys(email);
		lp.Password().sendKeys(Pwd);
	//	System.out.println(text);
		log.info(text);
		
		lp.LoginClick().click();
		
		ForgotPassword fp=lp.forgotPwd();
		fp.Email().sendKeys("xxx");
		fp.sendInstructions().click();
		

	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		//0th row
				data[0][0]="unrestricted@qw.com";
				data[0][1]="1234";
				data[0][2]="unrestricted user";
		
				
		//1st row		
				data[1][0]="restricted@qw.com";
				data[1][1]="5678";
				data[1][2]="restricted user";
				
				return data;
	}
}
