package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass
{
	public static String GetPropertyFileData(String key) throws IOException 
	{FileInputStream file = new FileInputStream("C:\\Users\\RSPL\\eclipse-workspace\\SwagLab\\PropertyFile.Properties");
	Properties p =new Properties();
	p.load(file);
	String value = p.getProperty(key);
	return value;

	}
	public static String GetTestData(int RowNo,int CellNo) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\RSPL\\eclipse-workspace\\SwagLab\\TestData\\SwagLab_TestData.xlsx");
		String value = WorkbookFactory.create(file).getSheet("Sheet1").getRow(RowNo).getCell(CellNo).getStringCellValue();
		return value;
	}
	public static void captureSS(WebDriver driver,int TCIDNumer) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\RSPL\\eclipse-workspace\\SwagLab\\FailedScreenShot\\"+TCIDNumer+ ".png");
		FileHandler.copy(src, dest);		
	}


}
