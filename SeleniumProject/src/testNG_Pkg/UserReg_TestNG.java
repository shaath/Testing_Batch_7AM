package testNG_Pkg;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SeleniumProject.ReusableClasses.GenericMethods;

public class UserReg_TestNG extends TestNGMaster{

	@Test
	public void orgUserReg() throws InterruptedException
	{
		expval = uname;
		boolean flag = false;
		gm.driver.findElement(By.linkText("Admin")).click();
		gm.driver.findElement(By.linkText("User Management")).click();
		gm.driver.findElement(By.linkText("Users")).click();
		
		gm.driver.findElement(By.id("btnAdd")).click();
		
		gm.driver.findElement(By.id("systemUser_employeeName_empName")).clear();
		gm.driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(ename);
		gm.driver.findElement(By.id("systemUser_userName")).sendKeys(uname);
		gm.driver.findElement(By.id("systemUser_password")).sendKeys(pwd);
		gm.driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pwd);
		Thread.sleep(5000);
		gm.driver.findElement(By.id("btnSave")).click();
		
		List<WebElement> rows = gm.driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		for (int i = 0; i < rows.size(); i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			actval = cols.get(1).getText();
			
			if (expval.equalsIgnoreCase(actval)) {
				flag = true;
				break;
			}
		}
		
		Assert.assertEquals(true, flag);
	}
}
