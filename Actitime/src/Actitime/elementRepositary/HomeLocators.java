package Actitime.elementRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLocators 
{
 public HomeLocators(WebDriver driver)
 {
	 PageFactory.initElements(driver,this);
 }
    
   @FindBy(id="container_tasks")
   private WebElement tasks;
  
   @FindBy(css=".popup_menu_button_settings ")
   private WebElement settings;
   
   @FindBy(xpath="//div[text()='Manage system settings & configure actiTIME']/..")
   private WebElement generalSettings;
   
   @FindBy(linkText="Types of Work")
   private WebElement typesofWorks;
   
   public WebElement selectTask() 
   {
	  return tasks; 
   }
   
   public WebElement selectsettings()
   {
	   return settings;
   }
   
   public WebElement selectGeneralSetting()
   {
	   return settings;
   }
   
   public WebElement selectTypesofWorks()
   {
	   return typesofWorks;
   }
   
   public void gotoTaskpage()
   {
	   selectTask().click();  
   }
    
   public void gotoGeneralSettingPage()
   {
	   selectsettings().click();
	   selectGeneralSetting().click();
   }
   
   public void gotoTypesOfWorks()
   {
	   selectsettings().click();
	   selectTypesofWorks().click();
	   
   }
}
