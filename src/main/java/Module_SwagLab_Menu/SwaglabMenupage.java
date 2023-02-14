package Module_SwagLab_Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwaglabMenupage 
{
	@FindBy(xpath="(//a[@id='logout_sidebar_link'])[1]") private WebElement logoutbutton;
	public SwaglabMenupage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void clickSwaglabMenuPageLogoutButton() 
	{
		logoutbutton.click();
	}

}
