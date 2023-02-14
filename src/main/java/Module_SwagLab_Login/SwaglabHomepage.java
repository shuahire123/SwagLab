package Module_SwagLab_Login;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SwaglabHomepage 
{
	@FindBy(xpath="(//button[@class='btn btn_primary btn_small btn_inventory'])[1]") private WebElement Addtocartbutton;
	@FindBy(xpath="(//button[@class='btn btn_secondary btn_small btn_inventory'])[1]") private WebElement removebutton;
	@FindBy(xpath="(//button[@id='react-burger-menu-btn'])[1]") private WebElement menubutton;
	@FindBy(xpath="(//div[@class='inventory_item_name'])[6]") private WebElement tshirtPurchase;
	
	public SwaglabHomepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	@Test
	public void clickSwaglabHomePageAddtocardButton() 
	{
		Addtocartbutton.click();
		
	}
	@Test
	public void verifySwaglabHomePageRemovebuttonText() throws InterruptedException 
	{
		boolean verify = removebutton.isDisplayed();
		if(verify==true)
		{
			System.out.println("pass"+removebutton.getText());
		}
		else
		{
			System.out.println("fail=  remove text is not pressent");
		}
		Thread.sleep(4000);
		removebutton.click();
		
	}
	@Test
	public void clickSwaglabHomePageMenuButton() 
	{
		menubutton.click();
		
	}
	public void clickSwagLabHimePageTshirt(WebDriver driver) throws InterruptedException
	{
((JavascriptExecutor)driver).executeScript("window.scrollBy(0,700)");
Thread.sleep(4000);
tshirtPurchase.click();
		
		
	}
	
}
