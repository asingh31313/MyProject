package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseHRclass;

public class PomLogin extends BaseHRclass {

	// object repository
	
	@FindBy(name="username")  // driver.findelement(By.)
	WebElement Username;
	@FindBy(name="password") WebElement Password;
	
	// initiate page elements
	
	public PomLogin () {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void typeusername(String name) {
		Username.sendKeys(name);			
	}
	
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}	
	
	public String verify() {
		return driver.getTitle();	}
}
