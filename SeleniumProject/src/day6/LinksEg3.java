package day6;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinksEg3 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
	
		driver.get("http://primusbank.qedgetech.com/sitemap.html");
		
		List<WebElement> links = driver.findElements(By.xpath("//table[@id='Table_011']//a"));
		
		System.out.println(links.size());
		
		for (int i = 0; i < links.size(); i++) 
		{
			String lname = links.get(i).getText();
			System.out.println(lname);
			
			links.get(i).click();
			Thread.sleep(3000);
			System.out.println(driver.getTitle()+"---"+driver.getCurrentUrl());	
			
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("D:\\TestingBatch_7AM\\Workspace\\SeleniumProject\\src\\com\\SeleniumProject\\screenshots\\"+lname+".jpg"));

			
			driver.navigate().back();			
			links = driver.findElements(By.xpath("//table[@id='Table_011']//a"));
		}

	}

}
