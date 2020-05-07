package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import PageobjectRepo.LoginPage;
import Resources.Base;

@RunWith(Cucumber.class)
public class stepDefinition extends Base {


	@Given("^initialize the browser and launch the \"([^\"]*)\"$")
	public void initialize_the_browser_and_launch_the(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver = InvokeBrowser(arg1);
			
	}

	@When("^user loggs in with \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void user_loggs_in_with_and_Password(String arg1, String arg2) throws Throwable {
	
		LoginPage login = new LoginPage(driver);
		String Uname = getproperties("username");
		String Password = getproperties("Password");
		login.UserName().sendKeys(arg1);
		login.Continue().click();
		login.Password().sendKeys(arg2);
		login.Login().click();
	
	}

	@Then("^user should be able to login successfully \"([^\"]*)\"$")
	public void user_should_be_able_to_login_successfully(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	
		System.out.println("user Loggedin successfully");
	}
}