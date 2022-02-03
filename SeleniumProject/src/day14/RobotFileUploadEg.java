package day14;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RobotFileUploadEg {

	public static void main(String[] args) throws InterruptedException, AWTException {
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
		
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", up);
		
		Thread.sleep(3000);
		
		//Copying the path too clipboard
		StringSelection sel=new StringSelection("C:\\Users\\SharatChandra\\Desktop\\JenkinsLandingScreen.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		
		Robot r = new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(3000);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
