package day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniummethodsEg {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
	
		driver.get("https://google.com");

//		System.out.println(driver.getTitle());
		
//		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getPageSource());
				
	}

}
