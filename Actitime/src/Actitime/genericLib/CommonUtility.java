package Actitime.genericLib;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class CommonUtility
{
    
	public int getRandomNum(int range) 
	{
		Random r=new Random();
		int num=r.nextInt(range);
		return num;
	}
   public String getMsgFromAlert(WebDriver driver)
   {
	   Alert alt=driver.switchTo().alert();
	   String msg=alt.getText();
	   return msg;
   }
   public void alertOK(WebDriver driver)
   {
	   Alert alt=driver.switchTo().alert();
	   alt.accept();
   }
   public void alertCancel(WebDriver driver)
   {
	   Alert alt=driver.switchTo().alert();
	   alt.dismiss();
	   
   }
   public void explicitWait(WebDriver driver,WebElement pathh,String name)
   {
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(pathh,name));
   }
   public void ddSelectbyvisibletext(WebElement dd,String vText)
   {
	   Select s=new Select(dd);
	   s.selectByVisibleText(vText);
   }
   public void scrollamt(WebDriver driver,int x,int y)
   {
	   Actions act=new Actions(driver);
	   act.scrollByAmount(x, y).perform();
   }
   public void moveElement(WebDriver driver,WebElement element)
   {
	   Actions act=new Actions(driver);
	   act.moveToElement(element).perform();
   }
   public void rightclick(WebDriver driver,WebElement clik)
   {
	   Actions act=new Actions(driver); 
	   act.contextClick(clik).perform();
   }
   public void SoftPartial(String actual,String expected)
   {
	   SoftAssert sa=new SoftAssert();
	  sa.assertTrue(actual.contains(expected));
	  sa.assertAll();
   }
   
}
