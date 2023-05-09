package BasePackage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.Timeutils;
public class BaseHRclass {

	public static Properties prop = new Properties();
	public static WebDriver driver;
	
	//Step 1: create constructor of class
	public BaseHRclass() {
		
		try {
		FileInputStream file = new FileInputStream("E:\\Java Workspace\\HR\\src\\test\\java\\Environmentvariables\\Config.properties");
			prop.load(file);
		}
	
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch(IOException a) {
			a.printStackTrace();
		}
	}
		// Step 2:
		
		public static void initiate() {
			
		String browsername = prop.getProperty("browser");
		
		if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			
			driver = new FirefoxDriver();  }
		else if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(op);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Timeutils.timepage,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));	
		}
		public static void screenshots(String Filename) { // for taking screenshot
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			FileUtils.copyFile(file, new File("E:\\Java Workspace\\HR\\src\\test\\java\\screenshots\\Screenshots" + Filename + ".jpg"));
		}
			catch (IOException e) {
				e.printStackTrace();
			}
}
}