package com.SeleniumProject.POMTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.SeleniumProject.Pages.AdminHomePage;
import com.SeleniumProject.Pages.LoginPage;

public class LoginTC_POM {

	@Test
	public void login() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\TestingBatch_7AM\\Automation/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		driver.get(lp.url);
		
		lp.orgLogin(lp.u, lp.p);
		
		Thread.sleep(5000);
		
		AdminHomePage ap = PageFactory.initElements(driver, AdminHomePage.class);

		ap.welcomeclick();
		ap.logoutclick();
		
		driver.close();
	}
}
