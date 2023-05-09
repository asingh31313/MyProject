package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.BaseHRclass;
import POM.PomLogin;
import testdata.Excelsheet;

public class LoginTestcases extends BaseHRclass{
	
	PomLogin Log;
	
	public LoginTestcases() {		
		super();		
	}	
	@BeforeMethod
	public void initsetup() {
		initiate();	
		//screenshots("Login");
		Log = new PomLogin();
	}
	
	@Test(priority=1)
	public void Title() {
		
		String actual = Log.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "OrangeHRM");		
	}	
	@DataProvider
	public Object[][] details() {
		Object result[][] = Excelsheet.readdata("Sheet1");
		return result;		
	}
	
	@Test(priority=2, dataProvider="details")
	public void login(String name, String password) throws InterruptedException  {
		Thread.sleep(2000);
		Log.typeusername(name);
		Log.typepassword(password);
		Thread.sleep(2000);
	}	
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}	
}
