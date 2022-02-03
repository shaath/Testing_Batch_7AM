package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrghrmLogin_Logout_Close {

	public static void main(String[] args) throws InterruptedException {
//		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "D:\\TestingBatch_7AM\\Automation\\Jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://orangehrm.qedgetech.com");
		
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");		
		
//		username.click();
//		Thread.sleep(5000);
//		username.clear();
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Qedge123!@#");
//		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.name("Submit")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("Welcome")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();
		
//		driver.close();
		driver.quit();

	}

}
