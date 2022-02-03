package day8;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitwaitEg {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.amazon.in/");
		
//		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(180));
			
		WebElement deals = driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/51jKifqW4XL._SX3000_.jpg']"));
		
	    JavascriptExecutor je = (JavascriptExecutor)driver;
	    je.executeScript("arguments[0].click();", deals);
		
//		driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/51jKifqW4XL._SX3000_.jpg']")).click();

	}

}
