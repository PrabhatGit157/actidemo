package Actitime.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Actitime.elementRepositary.LoginLocators;

public class BaseClass 
{
	public WebDriver driver;
	public DataUtility du=new DataUtility();
	public CommonUtility cu=new CommonUtility();
	public static WebDriver listernerdriver;
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void launchBrowser(String browser)
	//public void launchBrowser()
	{
		if(browser.equals("chrome"))
		{
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(opt);
		}
		else if(browser.equals("Edge"))
		{
		EdgeOptions opt=new EdgeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver=new EdgeDriver(opt);
		listernerdriver=driver;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Parameters({"username","password","url"})
	@BeforeMethod(alwaysRun=true)
	//public void login(String username,String password,String url) throws IOException
	public void login() throws IOException
	{
		//fetch the data from properties file
		driver.get(du.getDataFromProperties("url"));
		//driver.findElement(By.id("username")).sendKeys(du.getDataFromProperties("username"));
		//driver.findElement(By.name("pwd")).sendKeys(du.getDataFromProperties("password"));
		
		//fetch the data from TestNg.xml file
		//driver.get(url);
		//driver.findElement(By.id("username")).sendKeys(username);
		//driver.findElement(By.name("pwd")).sendKeys(password);
		
		//for POM process
		LoginLocators ll=new LoginLocators(driver);
		ll.loginApp(du.getDataFromProperties("username"), du.getDataFromProperties("password"));
		
		//driver.findElement(By.id("loginButton")).click();
	}
	@AfterMethod(alwaysRun=true)
	public void logout()
	{
		driver.findElement(By.id("logoutLink")).click();
	}
	@AfterClass(alwaysRun=true)
	public void closeBrowser()
	{
		driver.quit();
	}
    
}
