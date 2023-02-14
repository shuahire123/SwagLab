package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import LibraryFiles.UtilityClass;
import Module_SwagLab_Login.SwagLabsLoginPage;

public class test22 
{	@Test
	public void name() throws IOException 
	{	WebDriver driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	SwagLabsLoginPage login = new SwagLabsLoginPage(driver);
	login.inpSwaglabLoginPageUsername(UtilityClass.GetPropertyFileData("UserName"));
	login.inpSwaglabLoginPagePassword(UtilityClass.GetPropertyFileData("Password"));
	login.ClickSwaglabLoginPageLoginButton();
	Reporter.log("login ",true);	
	WebElement addTocart = driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[1]"));
	addTocart.click();	
	String ActText = addTocart.getText();
		System.out.println(ActText);
		
	}

}
