package TestPackage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageobjectRepo.qaClickHomePage;
import Resources.Base;

public class QAClickHomePageTest extends Base {
	private static Logger log = LogManager.getLogger(QAClickHomePageTest.class.getName());


	@BeforeTest
	public void OpenBrowserAndHitURL() throws IOException {
		String URL = getproperties("QACLICKURL");
		driver = InvokeBrowser(URL);
		log.info("Browser Opened successfully");
	}

	@Test
	public void VerifyTitletext() throws IOException {

		qaClickHomePage HmPage = new qaClickHomePage(driver);
		String ExpectedTitle = getproperties("Title");
		System.out.println(ExpectedTitle);
		System.out.println(HmPage.Title().getText());
		Assert.assertTrue(HmPage.Title().getText().equalsIgnoreCase(ExpectedTitle));
		Assert.assertTrue(HmPage.NavigationPane().isDisplayed());
		log.trace("Title "+" displayed successfully" );
		log.info("Test Passed");
		
	}

	@AfterTest
	public void teardown() {
		log.info("Browser closed successfully");
		CloseBrowser();

	}
}
