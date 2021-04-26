package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage {

	public WebDriver driver;
	
//	By searchBox=By.name("search_query");
	By pageHeading=By.cssSelector("p.info-account");
	
//	By popup=By.xpath("//button[contains(text(),'NO THANKS')]");
//	private By forgotPassword=By.cssSelector("[href*='password/new']");
	
	public portalHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}


	
/*	public WebElement popUpClose()
	{
		return driver.findElement(popup);
	}
*/	
	/*
	public WebElement getSearchBox()
	{
		return driver.findElement(searchBox);
	}
	*/
	
	public WebElement getPageheading()
	{
		return driver.findElement(pageHeading);
	}
	
	
/*	public ForgotPassword forgotPwd()
	{
		driver.findElement(forgotPassword).click();
	//	ForgotPassword fp=new ForgotPassword(driver);
	//	return fp;
		
		return new ForgotPassword(driver);
	} */
}
