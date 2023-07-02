package Actitime.testscript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Actitime.elementRepositary.HomeLocators;
import Actitime.genericLib.BaseClass;
import Actitime.genericLib.CommonUtility;
import Actitime.genericLib.DataUtility;
@Listeners(Actitime.genericLib.ListenerImplementation.class)
public class CustomerCreation extends BaseClass {
	@Parameters({"customername"})
  @Test(groups={"system"})
	//public void createCustomer(String customername) throws IOException
	public void createCustomer() throws EncryptedDocumentException, IOException
	{
		
		int num=cu.getRandomNum(1000);
		String customername=du.getDataFromExcelsheet("Sheet2", 1, 1);
		customername=customername+num;
		
		HomeLocators hl=new HomeLocators(driver);
		hl.gotoTaskpage();
		//driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.cssSelector(".title.ellipsis")).click();
		driver.findElement(By.className("createNewCustomer")).click();
		
		driver.findElement(By.className("newNameField")).sendKeys(customername);
		driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys("testing");
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".titleEditButtonContainer>.title"),customername));
		WebElement pathh=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title"));
		cu.explicitWait(driver, pathh, customername);
		
		String actualcustomername=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title")).getText();
		//System.out.println(actualcustomername);
		SoftAssert sa=new SoftAssert();
		AssertJUnit.assertEquals(customername,actualcustomername );
		sa.assertAll();
		Reporter.log(actualcustomername,true);

	}

}
