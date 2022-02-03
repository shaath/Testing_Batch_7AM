package day11;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class MultipleWindowHandlingEg {

	public static void main(String[] args) throws InterruptedException, IOException {
		String prPath = System.getProperty("user.dir");
		System.out.println(prPath);
		
		String dstPath = prPath +"\\src\\com\\SeleniumProject\\screenshots\\TermsOfService.png";
		
		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://gmail.com");
		
		String gmail_wid = driver.getWindowHandle();
//		System.out.println(gmail_wid);

		driver.findElement(By.linkText("Privacy")).click();
		
		Set<String> s = driver.getWindowHandles();
		
		for (String wid : s)
		{
			System.out.println(wid);
			driver.switchTo().window(wid);
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
			if (driver.getTitle().contains("Privacy Policy"))
			{
				WebElement tos = driver.findElement(By.linkText("Terms of Service"));
				tos.click();
				Thread.sleep(5000);
				tos = driver.findElement(By.linkText("Terms of Service"));
				
				File src = tos.getScreenshotAs(OutputType.FILE);			
				FileHandler.copy(src, new File(dstPath));
				break;
			}		
		}
		
		driver.switchTo().window(gmail_wid);
		System.out.println(driver.getTitle());

		driver.quit();
		
	}

}
