package PageobjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class qaClickHomePage {
	public WebDriver driver;
	
	public qaClickHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	}
			
		By Title = By.xpath("//*[@class='text-center']/h2");
		By NavigationPane = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
		
	public WebElement Title() {
		return driver.findElement(Title);
	}
	
	
	public WebElement NavigationPane() {
		return driver.findElement(NavigationPane);
}
		
	
}
