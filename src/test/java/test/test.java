package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module_SwagLab_Login.SwagLabsLoginPage;
import Module_SwagLab_Login.SwaglabHomepage;
import Module_SwagLab_Menu.SwaglabMenupage;

public class test extends BaseClass 
{	int TCIDNumer;
	@BeforeClass
	public void lb() throws EncryptedDocumentException, IOException 
	{	
		LaunchBrowser();
	}
	@BeforeMethod
	public void Login() throws IOException 
	{
	SwagLabsLoginPage login = new SwagLabsLoginPage(driver);
	login.inpSwaglabLoginPageUsername(UtilityClass.GetPropertyFileData("UserName"));
	login.inpSwaglabLoginPagePassword(UtilityClass.GetPropertyFileData("Password"));
	login.ClickSwaglabLoginPageLoginButton();
	Reporter.log("login ",true);
	}
	@Test
	public void VerifyLogo() throws EncryptedDocumentException, IOException, InterruptedException 
	{ TCIDNumer = 402;
		WebElement addTocart = driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[1]"));
		String ActText = addTocart.getText();
		String expectedText = UtilityClass.GetTestData(0, 0);
		Assert.assertEquals(ActText,expectedText,"failed");
		Thread.sleep(2000);
		Reporter.log("logo verfication fail", true);
		
		
	}
	@AfterMethod
	public void logout(ITestResult result) throws IOException 
	{	System.out.println("result for test"+result.getStatus());
		if(result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver, TCIDNumer);
		}
		SwaglabHomepage home = new SwaglabHomepage(driver);
		home.clickSwaglabHomePageMenuButton();
		SwaglabMenupage menu = new SwaglabMenupage(driver);
		menu.clickSwaglabMenuPageLogoutButton();
		Reporter.log("logout",true);
	}
}

