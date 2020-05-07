package TestPackage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageobjectRepo.LoginPage;
import Resources.Base;

public class AmazonLoginTest extends Base {
	
	private static Logger log = LogManager.getLogger(AmazonLoginTest.class.getName());


	@BeforeTest
	public void OpenBrowserAndHitURL() throws IOException {
		String URL = getproperties("AMZNURL");
		driver = InvokeBrowser(URL);
		log.trace("Brwser invoked");
	}

	@Test
	public void VerifySuccessfulLogin() throws IOException {

		LoginPage login = new LoginPage(driver);
		String Uname = getproperties("username");
		String Password = getproperties("Password");
		login.UserName().sendKeys(Uname);
		login.Continue().click();
		login.Password().sendKeys(Password);
		login.Login().click();
		log.info("user Loggedin successfully");

	}

	@AfterTest
	public void teardown() {
		CloseBrowser();
		log.info("brwser closed");
	}
	
}
