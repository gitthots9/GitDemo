package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	WebDriver driver;
	
	private By emailId=By.id("user_email");
	private By sendMeinstructions=By.cssSelector("input[type='submit']");

	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	public WebElement Email()
	{
		return driver.findElement(emailId);
	}
	
	
	public  WebElement sendInstructions()
	{
		return driver.findElement(sendMeinstructions);
	}
}
	

