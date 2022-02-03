package day8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownEg2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
	
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		WebElement country = driver.findElement(By.name("country"));
		
		Select s = new Select(country);
		
		List<WebElement> options = s.getOptions();
		
		System.out.println(options.size());
		
		for (int i = 0; i < options.size(); i++) 
		{
//			String prop = options.get(i).getAttribute("value");
//			s.selectByValue(prop);
			
			s.selectByIndex(i);
			
			String name = options.get(i).getText();
			System.out.println(i+"---"+name);
			
		}
		
	}

}
