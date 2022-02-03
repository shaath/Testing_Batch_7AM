package testNG_Pkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.SeleniumProject.ReusableClasses.GenericMethods;

public class TestNGMaster {
	public String url = "http://orangehrm.qedgetech.com";
	public String u = "Admin", p = "Qedge123!@#";
	public String expval, actval;
	public FileInputStream fi;
	public Properties pr;
	public String prPath = System.getProperty("user.dir")+"\\src\\com\\SeleniumProject\\ObjectRepository\\orgHRM.properties";
	public GenericMethods gm;
	public String f = "TestNG123", l = "Practice587", eid = "TP475478";
	public String uname = f+l+"123456", ename = f+" "+l, pwd = "Test@9874563210";
	
	@BeforeTest
	public void orgLaunch() throws IOException
	{
		fi = new FileInputStream(prPath);
		pr = new Properties();
		pr.load(fi);
		gm = new GenericMethods();
		
		expval = "LOGIN";
		gm.brLaunch("firefox");
		gm.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(180));
		gm.driver.get(url);
		gm.driver.manage().window().maximize();
		
		actval = gm.driver.findElement(By.id(pr.getProperty("login"))).getAttribute("value");

		Assert.assertEquals(expval, actval, "Launch Failed");
	}
	
	@BeforeClass
	public void orgLogin()
	{
		expval = "welcome";
		
		gm.driver.findElement(By.id(pr.getProperty("username"))).sendKeys(u);
		gm.driver.findElement(By.id(pr.getProperty("password"))).sendKeys(p);
		gm.driver.findElement(By.id(pr.getProperty("login"))).click();
		
		gm.waitforElementEnabled(gm.driver.findElement(By.partialLinkText("Welcome")), 180);
		
		actval = gm.driver.findElement(By.partialLinkText("Welcome")).getAttribute("id");
		
		Assert.assertEquals(expval, actval, "Login Failed");
	}
	
	@AfterClass
	public void orgLogout()
	{
		expval = "LOGIN";
		
		gm.driver.findElement(By.partialLinkText("Welcome")).click();
		gm.driver.findElement(By.linkText("Logout")).click();
		
		actval = gm.driver.findElement(By.id("btnLogin")).getAttribute("value");
		
		Assert.assertEquals(expval, actval, "Logout Failed");
	}
	
	@AfterTest
	public void orgClose()
	{
		gm.driver.close();
	}
}
