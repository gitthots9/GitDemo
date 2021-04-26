package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	
//	private By emailId=By.id("user_email");
//	private By password=By.cssSelector("input[type='password']");
//	private By loginbutton=By.cssSelector("input[value='Log In']");
	private By emailId=By.id("email");
	private By password=By.cssSelector("input[type='password']");
	private By loginbutton=By.id("SubmitLogin");
	
	
	
	
//	By popup=By.xpath("//button[contains(text(),'NO THANKS')]");
	private By forgotPassword=By.cssSelector("[href*='password/new']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	public WebElement Email()
	{
		return driver.findElement(emailId);
	}
	
	public WebElement Password()
	{
		return driver.findElement(password);
	}
	
/*	public WebElement popUpClose()
	{
		return driver.findElement(popup);
	}
*/	
	public WebElement LoginClick()
	{
		return driver.findElement(loginbutton);
	}
	
	public ForgotPassword forgotPwd()
	{
		driver.findElement(forgotPassword).click();
	//	ForgotPassword fp=new ForgotPassword(driver);
	//	return fp;
		
		return new ForgotPassword(driver);
	}
}
