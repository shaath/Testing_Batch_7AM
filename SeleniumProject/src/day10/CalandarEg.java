package day10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalandarEg {

	public static void main(String[] args) throws InterruptedException {
		
		String date = "17-June-2022";
		String[] arrSplit = date.split("-");
		String exp_day = arrSplit[0];
		System.out.println(exp_day);
		String exp_month_year = arrSplit[1]+" "+arrSplit[2];
		System.out.println(exp_month_year);
		
		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.cleartrip.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.className("closeit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[name()='svg' and @fill='currentColor']")).click();
		
		String act_month_year = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]/div")).getText();
		
		while(!exp_month_year.equalsIgnoreCase(act_month_year))
		{
			driver.findElement(By.xpath("//*[name()='svg' and @data-testid='rightArrow']")).click();
			act_month_year = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]/div")).getText();
		}
		
		
		List<WebElement> days = driver.findElements(By.xpath("(//div[@class='DayPicker-Body'])[1]//div[contains(@class,'DayPicker-Day')]"));
		System.out.println(days.size());
		
		for (int i = 0; i < days.size(); i++) {
			
			String dName = days.get(i).getText();
			System.out.println(dName);
			
			if (dName.equals(exp_day)) 
			{
				days.get(i).click();
				break;
			}
		}
		
	}

}
