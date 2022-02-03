package testNG_Pkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_MultipleBrowsers {

	@Test(dataProvider = "data")
	public void test(String br) throws InterruptedException
	{
		System.out.println(br);
		WebDriver driver = null;
		
		if (br.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (br.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\TestingBatch_7AM\\Automation\\Jars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (br.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\TestingBatch_7AM\\Automation\\Jars\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if (br.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\TestingBatch_7AM\\Automation\\Jars\\msedgedriver.exe");
			driver = new EdgeDriver();
			
		}
		
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(180));
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//img[@src='images/admin_but_03.jpg']")).click();
		
		driver.close();	
	}
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] br = new Object[4][1];
		
		br[0][0] = "Firefox";
		
		br[1][0] = "Chrome";
		
		br[2][0] = "Edge";
		
		br[3][0] = "IE";
		
		return br;
		
		
	}
}
