package Actitime.testscript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Actitime.genericLib.BaseClass;

public class DropdownHandle extends BaseClass
{
	@Test(groups={"smoke","system"})
	public void DDhandle()
	{
		driver.findElement(By.cssSelector(".popup_menu_button.popup_menu_button_settings ")).click();
		driver.findElement(By.xpath("//div[text()='Manage system settings & configure actiTIME']/..")).click();
		WebElement dd=driver.findElement(By.id("userGroupNamingCodeSelect"));
		String loc="Location";
		cu.ddSelectbyvisibletext(dd, loc);
		WebElement text=driver.findElement(By.id("FormModifiedTextCell"));
		String expected="MODIFICATIONS";
		String actual=text.getText();
		//System.out.println(text.getText());
		Assert.assertTrue(actual.contains(expected));
		Reporter.log(actual,true);
		
		
	}

}
