package Module_SwagLab_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsLoginPage 
{
@FindBy(xpath="//input[@placeholder='Username']") private WebElement UserName;
@FindBy(xpath= "//input[@placeholder='Password']") private WebElement Password;
@FindBy(xpath="//input[@id='login-button']") private WebElement LoginButton;
@FindBy(xpath="//h3[@data-test='error']") private WebElement error;

public SwagLabsLoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void inpSwaglabLoginPageUsername(String username) 
{
	UserName.sendKeys(username);
	
}
public void inpSwaglabLoginPagePassword(String password) 
{
Password.sendKeys(password);	
}
public void ClickSwaglabLoginPageLoginButton() 
{
	LoginButton.click();
	
}
public void verifySwaglabLoginPageErrorMessege() 
{
	boolean messege = error.isDisplayed();
	if(messege==true)
	{
		System.out.println(error.getText()+"  "+"is showing");
	}
	else
	{
		System.out.println(error.getText()+"  "+"is not showing");
	}
	
}

}
