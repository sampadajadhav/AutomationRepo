package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public static WebDriver driver	;
	public static String currentDir = System.getProperty("user.dir");

	public static String getproperties(String Key) throws IOException {
		Properties PS= new Properties();
        System.out.println("Current dir using System:" +currentDir);
        FileInputStream FIS = new FileInputStream(currentDir+"\\src\\main\\java\\Resources\\DataBase.properties");
        PS.load(FIS);
        String Value = PS.getProperty(Key);
        return Value;
	}
		
	public static WebDriver InvokeBrowser(String URL) throws IOException {

		String browser = getproperties("Browser");
		//String browser = System.getProperty("browser");
        
        if(browser.contains("chrome")) 
        {
   	   //For Chrome browser
            System.setProperty("webdriver.chrome.driver", currentDir+"\\Drivers\\chromedriver.exe");
            ChromeOptions CO =new ChromeOptions();
            if(browser.contains("headless"))
            {
            CO.addArguments("headless");
            }
            driver =new ChromeDriver(CO);
            driver.get(URL);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
        }
        else if (browser.equalsIgnoreCase("IE"))
        {
        	   //For IE  browser
            System.setProperty("webdriver.ie.driver", currentDir+"\\Drivers\\IEDriverServer.exe");
            driver =new InternetExplorerDriver();
            driver.get(URL);
            //driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
     	   //For IE  browser
            System.setProperty("webdriver.gecko.driver",  currentDir+"\\Drivers\\geckodriver.exe");
            driver =new FirefoxDriver();
            driver.get(URL);
            //driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        }
        return driver;
	}

	public static void CloseBrowser() {
		WebDriver driver = null;

		driver.close();
	}

	public static void getScreenshotsonfailure(String results) throws IOException {
		WebDriver driver = null;

		File SRC = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SRC, new File( currentDir+"\\logs\\Screenshots\\"+results+"ScreenShots.png"));
		
	}

}
