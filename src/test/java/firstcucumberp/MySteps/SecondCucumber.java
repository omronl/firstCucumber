package firstcucumberp.MySteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Reusable_Methods.MyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;




public class SecondCucumber {
	
	WebDriver driver = MyDriver.getDriver("Chrome");
	
	@And("Click to Etsy logo")
	public void click_to_Etsy_logo() throws InterruptedException {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
		WebElement element = driver.findElement(By.xpath("//span[@class='etsy-icon wt-display-block wt-fill-orange wt-nudge-r-3 wt-nudge-t-1 logo-dimensions']"));
		
           element.click();
		
		;
		
		
		
	   
	}
	
	  @And("Click to any item again")
	   public void click_to_any_item_again() throws InterruptedException {
		  
		  Thread.sleep(3000);
		  
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/ul/li[2]/a/div[1]/div/div[1]/div/div/div/img[2]")).click();
		
		
		
		
		
	   	}

	@And("Click to add cart again")
	public void click_to_add_cart_again() throws InterruptedException {
		
		
		
		String winHandleBefore = driver.getWindowHandle();
	    for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	    }
		
	   
	    driver.findElement(By.xpath("//textarea[@id='personalization-input']")).sendKeys("Hello");
	    
	    
	    
	    Select s1 = new Select(driver.findElement(By.xpath("//select[@data-buy-box-select='quantity']")));
	    
	    s1.selectByIndex(2);
	    
	    driver.findElement(By.xpath("//div[@class='btn-text']")).click();
	    
	    
	   Select s2 = new Select(driver.findElement(By.xpath("//select[@id='inventory-variation-select-0']")));
	   
	   s2.selectByIndex(1);
	   
	   Thread.sleep(3000);
	   
	   
	   driver.findElement(By.xpath("//div[@class='btn-text']")).click();
	    
	   
	}

	
	
	
	}

	

	


