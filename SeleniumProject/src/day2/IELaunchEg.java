package day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IELaunchEg {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.ie.driver", "D:\\TestingBatch_7AM\\Automation\\Jars\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://twitter.com");

	}

}
