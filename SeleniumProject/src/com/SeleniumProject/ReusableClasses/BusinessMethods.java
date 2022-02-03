package com.SeleniumProject.ReusableClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BusinessMethods extends GenericMethods{

	public String url = "http://orangehrm.qedgetech.com";
	public String u = "Admin", p = "Qedge123!@#";
	public String expval, actval;
	public FileInputStream fi;
	public Properties pr;
	public String prPath = System.getProperty("user.dir")+"\\src\\com\\SeleniumProject\\ObjectRepository\\orgHRM.properties";
	//Launch
	
	public String orgLaunch(String url) throws IOException
	{
		fi = new FileInputStream(prPath);
		pr = new Properties();
		pr.load(fi);
		
		expval = "LOGIN";
		brLaunch("firefox");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(180));
		driver.get(url);
		driver.manage().window().maximize();
		
		actval = driver.findElement(By.id(pr.getProperty("login"))).getAttribute("value");
		
		if (expval.equals(actval)) {
			return "Pass";
		}else{
			return "Fail";
		}
	}
	
	//Login
	public String orgLogin(String u, String p)
	{
		expval = "welcome";
		
		driver.findElement(By.id(pr.getProperty("username"))).sendKeys(u);
		driver.findElement(By.id(pr.getProperty("password"))).sendKeys(p);
		driver.findElement(By.id(pr.getProperty("login"))).click();
		
		waitforElementEnabled(driver.findElement(By.partialLinkText("Welcome")), 180);
		
		actval = driver.findElement(By.partialLinkText("Welcome")).getAttribute("id");
		
		if (expval.equals(actval)) {
			return "Pass";
		}else{
			return "Fail";
		}
	}
	
	//Logout
	public String orgLogout()
	{
		expval = "LOGIN";
		
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		actval = driver.findElement(By.id("btnLogin")).getAttribute("value");
		
		if (expval.equals(actval)) {
			return "Pass";
		}else{
			return "Fail";
		}
	}
	
	//Close
	public void orgClose()
	{
		driver.close();
	}
	
	//EmpReg
	public String orgEmpReg(String f, String l, String eid)
	{
		expval = f+" "+l;
		
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		driver.findElement(By.id("firstName")).sendKeys(f);
		driver.findElement(By.id("lastName")).sendKeys(l);
		driver.findElement(By.id("employeeId")).clear();
		driver.findElement(By.id("employeeId")).sendKeys(eid);
		driver.findElement(By.id("btnSave")).click();
		
		actval = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		
		if (expval.equals(actval)) {
			return "Pass";
		}else{
			return "Fail";
		}
	}
	
	//UserReg
	public String orgUserReg(String ename, String uname, String pwd) throws InterruptedException
	{
		expval = uname;
		boolean flag = false;
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();
		
		driver.findElement(By.id("btnAdd")).click();
		
		driver.findElement(By.id("systemUser_employeeName_empName")).clear();
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(ename);
		driver.findElement(By.id("systemUser_userName")).sendKeys(uname);
		driver.findElement(By.id("systemUser_password")).sendKeys(pwd);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pwd);
		Thread.sleep(5000);
		driver.findElement(By.id("btnSave")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		for (int i = 0; i < rows.size(); i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			actval = cols.get(1).getText();
			
			if (expval.equalsIgnoreCase(actval)) {
				flag = true;
				break;
			}
		}
		
		if (flag == true)  
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
}
