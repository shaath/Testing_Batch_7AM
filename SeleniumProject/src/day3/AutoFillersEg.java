package day3;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoFillersEg {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.id("src")).sendKeys("Ko");
		
		Thread.sleep(5000);
		
		List<WebElement> cities = driver.findElements(By.xpath("//section[@id='search']//li"));		
		
		System.out.println(cities.size());
		
		for (int i = 0; i < cities.size(); i++) 
		{
			String name = cities.get(i).getText();
			System.out.println(name);
			
			if (name.equalsIgnoreCase("Kota(Rajasthan)")) {
				cities.get(i).click();
				break;
			}
		}
	}

}
