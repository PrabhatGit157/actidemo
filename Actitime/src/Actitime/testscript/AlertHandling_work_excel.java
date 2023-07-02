package Actitime.testscript;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Actitime.genericLib.BaseClass;
import Actitime.genericLib.CommonUtility;
import Actitime.genericLib.DataUtility;

public class AlertHandling_work_excel extends BaseClass {
  @Test(groups={"smoke"})
	public void AlertHandle() throws IOException, InterruptedException 
	{
		
		
		driver.findElement(By.cssSelector(".popup_menu_button_settings ")).click();
		driver.findElement(By.linkText("Types of Work")).click();
		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		driver.findElement(By.name("name")).sendKeys(du.getDataFromExcelsheet("Sheet2", 1, 1));
		driver.findElement(By.xpath("//input[@value='      Cancel      ']")).click();
		Thread.sleep(2000);
		String expectedmsg="Are you sure you want to cancel";
		String msg=cu.getMsgFromAlert(driver);
		
		//System.out.println(msg);
		cu.alertCancel(driver);
		cu.SoftPartial(msg, expectedmsg);
		Reporter.log(msg,true);
		
	}

}
