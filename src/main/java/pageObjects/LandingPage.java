package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver driver;
	
//	private By signIn=	By.cssSelector("i.fa.fa-lock.fa-lg");
	private By signIn=By.cssSelector("a.login");
	
	private By title=	By.cssSelector("div.text-center");
	private By navBar=	By.cssSelector("ul.nav.navbar-nav.navbar-right");
	private By header=By.cssSelector("div[class*='video-banner'] h3");
	
	//for pop-up in qaclickacademy.com
	By popup=By.xpath("//button[text()='NO THANKS']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	public LoginPage login()
	{
		

	driver.findElement(signIn).click();;
	LoginPage lp=new LoginPage(driver);
	return lp;
	
	}
	
	public WebElement getTitle()
	{
		
	
	return driver.findElement(title);
	
	}
	
	public WebElement getNavigationBar()
	{
		
	System.out.println("trying to navigate");
	return driver.findElement(navBar);
	
	}
	
	//for pop-up in qaclickacademy.com
	public int getpopUpSize()
	{
		
	return driver.findElements(popup).size();
	
	}
	//for pop-up in qaclickacademy.com
	public WebElement getpopUp()
	{
		
		return driver.findElement(popup);
	
	}
	
	
	
	public WebElement getHeader()
	{
		
	System.out.println("validating Header");
	return driver.findElement(header);
	
	}
}
