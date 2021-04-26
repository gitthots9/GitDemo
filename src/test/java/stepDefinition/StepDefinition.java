package stepDefinition;

import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resource.base;

public class StepDefinition extends base {



@Given("^Initialise the browser with chrome$")
public void initialise_the_browser_with_chrome() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver=initialiseDriver();
}

@Given("^navigate to \"([^\"]*)\" Site$")
public void navigate_to_Site(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.get(arg1);
}


@Given("^click on login link in homepage to land on secure sign in page$")
public void click_on_login_link_in_homepage_to_land_on_secure_sign_in_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	//for pop-up in qaclickacademy.com--applicable for dis only
	LandingPage l=new LandingPage(driver);
	if(l.getpopUpSize()>0)
	{
		l.getpopUp().click();
	}
	
	LoginPage lp=l.login();
	lp.LoginClick().click();
}


@When("^user enters (.+) and (.+) and logs in$")
public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
	LoginPage lp=new LoginPage(driver);
	lp.Email().sendKeys(username);
	lp.Password().sendKeys(password);
	lp.LoginClick().click();
	
	//second values in login.feature are wrong--script will fail--to chk have given
}



@Then("^verify that user is successfully logged in$")
public void verify_that_user_is_successfully_logged_in() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    portalHomePage p=new portalHomePage(driver);
 //   Assert.assertTrue(p.getSearchBox().isDisplayed());;
      Assert.assertTrue(p.getPageheading().isDisplayed());
}

@And("^close the browser$")
public void close_the_browser() throws Throwable {
    driver.quit();
}


}
