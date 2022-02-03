package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverEg {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.in/");

		WebElement signIn = driver.findElement(By.id("nav-link-accountList"));
		
		Actions act = new Actions(driver);
		Thread.sleep(5000);
		act.moveToElement(signIn).perform();
		Thread.sleep(5000);
		WebElement pr = driver.findElement(By.xpath("//span[text()='Your Prime Video']"));
		
		act.click(pr).perform();
		
	}

}
