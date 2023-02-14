package LibraryFiles;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
public WebDriver driver;
@Parameters("BrowserName")

public void LaunchBrowser() throws EncryptedDocumentException, IOException 
{System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSPL\\eclipse-workspace\\SwagLab\\Browser\\chromedriver.exe");	
driver = new ChromeDriver();
driver.navigate().to("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
Reporter.log("launch Browser", true);

}
public void LaunchBrowser1(String BrowserName) throws EncryptedDocumentException, IOException 
{	driver = null;
	if(BrowserName.equals("chrome")) 
	{
	driver = new ChromeDriver();
	}
	else if(BrowserName.equals("firefox"))
	{
		driver = new FirefoxDriver();
	}
	else if(BrowserName.equals("edge"))
	{
	driver  =new EdgeDriver();
	}
driver.navigate().to("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
Reporter.log("launch Browser", true);

}
@AfterClass	
public void CloseBrowser() throws IOException 
{	
	
	driver.quit();
	Reporter.log("Browser close", true);
}

}
