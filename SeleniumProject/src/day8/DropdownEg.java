package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownEg {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
	
		driver.get("https://echoecho.com/htmlforms11.htm");
		Thread.sleep(5000);
//		WebElement drop = driver.findElement(By.name("mydropdown"));
		
		Select s = new Select(driver.findElement(By.name("mydropdown")));
		
		s.selectByIndex(2);
		Thread.sleep(5000);
		s.selectByValue("Milk");
		Thread.sleep(5000);
		s.selectByVisibleText("Old Cheese");
		Thread.sleep(5000);
		

	}

}
