package Reusable_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {

	
	private static WebDriver driver;
	 

	public static WebDriver getDriver(String browser) {
		
	if(driver==null) {	
		
		if(browser.equals("Chrome")) {
			driver= new ChromeDriver();
			
		}else if(browser.equals("FireFox")) {
			
			driver= new FirefoxDriver();
			
		}
	}
		return driver;
	
	}
	
}
