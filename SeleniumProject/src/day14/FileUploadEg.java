package day14;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUploadEg {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://orangehrm.qedgetech.com");
		
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");		
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Qedge123!@#");
		driver.findElement(By.name("Submit")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		Thread.sleep(3000);
		
		WebElement up = driver.findElement(By.id("photofile"));
		
//		up.sendKeys("C:\\Users\\SharatChandra\\Desktop\\JenkinsLandingScreen.png");
		
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", up);
		
		Thread.sleep(3000);
		
//		Runtime.getRuntime().exec("C:\\Users\\SharatChandra\\Desktop\\FileUploadEg1.exe");
		Runtime.getRuntime().exec("C:\\Users\\SharatChandra\\Desktop\\FileUploadEg2.exe");
	}

}
