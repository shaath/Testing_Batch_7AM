package testNG_Pkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrimusBankLogin_TestNG {

	public WebDriver driver;
	
	@BeforeClass
	public void Launch_Br()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@BeforeMethod
	public void Launch_App()
	{
		driver.get("http://primusbank.qedgetech.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(180));
	}
	
	@Test
	public void Login() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
	}
	
	@AfterMethod
	public void Logout() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src='images/admin_but_03.jpg']")).click();
	}
	
	@AfterClass
	public void Close()
	{
		driver.close();
	}
}
