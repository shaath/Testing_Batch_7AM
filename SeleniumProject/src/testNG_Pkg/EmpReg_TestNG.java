package testNG_Pkg;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmpReg_TestNG extends TestNGMaster {

	@Test(dataProvider = "data")
	public void orgEmpreg(String f, String l, String eid)
	{
		System.out.println(f +"---"+l+"---"+eid);
		expval = f+" "+l;
		
		gm.driver.findElement(By.linkText("PIM")).click();
		gm.driver.findElement(By.linkText("Add Employee")).click();
		
		gm.driver.findElement(By.id("firstName")).sendKeys(f);
		gm.driver.findElement(By.id("lastName")).sendKeys(l);
		gm.driver.findElement(By.id("employeeId")).clear();
		gm.driver.findElement(By.id("employeeId")).sendKeys(eid);
		gm.driver.findElement(By.id("btnSave")).click();
		
		actval = gm.driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		
		Assert.assertEquals(expval, actval, "Employee Registration Failed");
	}
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] x = new Object[4][3];
		
		x[0][0] = "Nidish";
		x[0][1] = "G";
		x[0][2] = "NG57482";
		
		x[1][0] = "Siva";
		x[1][1] = "S";
		x[1][2] = "SS54783";
		
		x[2][0] = "Srinu";
		x[2][1] = "K";
		x[2][2] = "SK85479";
		
		x[3][0] = "Ram";
		x[3][1] = "N";
		x[3][2] = "RN85476";
		
		return x;
	}
}
