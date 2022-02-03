package com.SeleniumProject.ReusableClasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.dataloader.annotations.VisibleForTesting;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

	public WebDriver driver;
	public GenericMethods gm;
	public void brLaunch(String brName)
	{
		if (brName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (brName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\TestingBatch_7AM\\Automation\\Jars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (brName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "D:\\TestingBatch_7AM\\Automation\\Jars\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if (brName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\TestingBatch_7AM\\Automation\\Jars\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}
	
	
	public void screenshot(String name) throws IOException
	{
		String prPath = System.getProperty("user.dir");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(prPath+"\\src\\com\\SeleniumProject\\screenshots\\"+name+".png"));

	}
	
	public void waitforElement(WebElement ele, int maxTime)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTime));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitforElementEnabled(WebElement ele, int maxTime)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTime));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void  eleClick(WebElement ele)
	{
		gm = new GenericMethods();
		gm.waitforElement(ele, 180);
		ele.click();
	}
	
	public void eleSendText(WebElement ele, String text)
	{
		gm.waitforElement(ele, 180);
		ele.sendKeys(text);
	}
	
}
