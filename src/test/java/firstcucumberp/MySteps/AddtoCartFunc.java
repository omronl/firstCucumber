package firstcucumberp.MySteps;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Reusable_Methods.MyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class AddtoCartFunc {

	
	
	 WebDriver driver;

@Given("Go to website")
public void go_to_website() {
	
	
	  System.setProperty("webdriver.chrome.driver", "/Users/omeronal/Documents/selenium dependencies/drivers/chromedriver");

       driver = MyDriver.getDriver("Chrome");

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.manage().window().maximize();
      
      driver.get("https://www.etsy.com/");
      
}


@And("Type in the search tab {string}")
public void type_in_the_search_tab(String string) {
  
	driver.findElement(By.xpath("//input[@data-id='search-query']")).sendKeys("Teddy Bear");
	
	
}

@And("Click on search tab")
public void click_on_search_tab() {
	driver.findElement(By.xpath("//button[@value='Search']")).click();
}

@And("Click on any item")
public void click_on_any_item() {
   
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[4]/div[2]/div[3]/div/ul/li[1]/div/a/div[1]/div/div[1]/div/div/div/img")).click();
	
	
}

@And("Click on add to cart")
public void click_on_add_to_cart() throws InterruptedException {
	
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

@Then("I m as a user need to see card page")
public void i_m_as_a_user_need_to_see_card_page() {
	
}
@And("Click on remove")
public void click_on_remove() {
	
	driver.findElement(By.xpath("//a[@rel='remove']")).click();
    
}

@Then("Verify no item in cart")
public void verify_no_item_in_cart() {
	
	
	String expected = "Your cart is empty.";
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	WebElement actuallWeb = driver.findElement(By.xpath("//div[@class='h2 text-headline-smaller pt-xs-2 pb-xs-2']"));
	
	
	wait.until(ExpectedConditions.textToBePresentInElement(actuallWeb, "Your cart is empty."));
	
	String actuall =actuallWeb.getText().toString();
	
	
	System.out.println("----------------->  "+actuall);
	
     Assert.assertEquals(actuall, expected);
	
	
    
}

    

}
