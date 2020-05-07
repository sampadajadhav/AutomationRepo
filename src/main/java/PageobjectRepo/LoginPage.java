package PageobjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	private By UserName = By.id("ap_email");
	private By Password = By.id("ap_password");
	private By Continue = By.id("continue");
	private By Login  	= By.id("signInSubmit");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement UserName() {
		return driver.findElement(UserName);		
	}
	public WebElement Password() {
		return driver.findElement(Password);
	}
	public WebElement Login() {
		return driver.findElement(Login);		
	}
	
	public WebElement Continue() {
		return driver.findElement(Continue);		
	}

}
