package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseKeyborsdEg {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://facebook.com");

		WebElement em = driver.findElement(By.id("email"));
		
		Actions act = new Actions(driver);
		
//		act.click(em).perform();
//		Thread.sleep(5000);
//		act.sendKeys(Keys.chord("Sharat")).perform();
//		Thread.sleep(5000);
//		act.doubleClick(em).perform();
		
		act.click(em).sendKeys(Keys.chord("Sharat")).build().perform();
		Thread.sleep(5000);
		act.doubleClick(em).perform();
	}

}
