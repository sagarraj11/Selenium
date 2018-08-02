package org.example.PNCSelenium;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SourceTestPage.BadaClass;
import utility.WebDriverFactory;

public class Login 
{
	
	private WebDriver driver;
  @Test
  public void login() 
  {
	/*  driver.findElement(By.name("mercuryregister.php")).clear();
	  driver.findElement(By.name("REGISTER")).click();
	  driver.findElement(By.name("firstName")).clear();
	  driver.findElement(By.name("firstName")).sendKeys("Bablu");
	  driver.findElement(By.name("lastName")).clear();
	  driver.findElement(By.name("lastName")).sendKeys("Kumar");
	  driver.findElement(By.name("phone")).clear();
	  driver.findElement(By.name("phone")).sendKeys("8898858519");
	  driver.findElement(By.name("userName")).clear();
	  driver.findElement(By.name("userName")).sendKeys("12ka4");
	  driver.findElement(By.name("address1")).clear();
	  driver.findElement(By.name("address1")).sendKeys("12kafdssdf4");
	  driver.findElement(By.name("address2")).clear();
	  driver.findElement(By.name("address2")).sendKeys("12dfdfka4");
	  driver.findElement(By.name("city")).clear();
	  driver.findElement(By.name("city")).sendKeys("Mumabai");
	  driver.findElement(By.name("login")).click();   */
	  
	  driver.findElement(By.linkText("REGISTER")).click();
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("firstName")));
	  
	  driver.findElement(By.name("firstName")).sendKeys("Chintu");
	  driver.findElement(By.name("lastName")).sendKeys("Chotu");
	 driver.findElement(By.name("phone")).sendKeys("8898858519");
	  driver.findElement(By.id("userName")).sendKeys("chotukaemailid@gamil.com");
	  driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("chotu ka dusra ghar");
	  driver.findElement(By.name("address2")).sendKeys("chotu ka ghar");
	  driver.findElement(By.name("city")).clear();
	  driver.findElement(By.name("city")).sendKeys("Mumabai");
	  
	  
	  Select country = new Select(driver.findElement(By.name("country")));
	  country.selectByVisibleText("INDIA");
	  
	  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user123");
	  driver.findElement(By.cssSelector("input[name='register']")).click();
  }
  
  
  @DataProvider(name="usernameandpassword")
  public String[][] credentials() {
	  return new String[][]{
		  new String[] {"invalidUN", "invalidPW"},
		  new String[] {"PASS", "Word"}
		  
	  };
  }
  
  
  @BeforeTest
  public void beforeTest() 
  {
	  driver = WebDriverFactory.createDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 // driver.navigate().to("http://newtours.demoaut.com/");
	  driver.get("http://newtours.demoaut.com/");
	  PageFactory.initElements(driver, BadaClass.class);
  }
  
  @Test(priority=2,dataProvider="usernameandpassword", description="This TC will run twice")
  
  public void FlightFind(String username, String password) 
  {
	 /*  driver.findElement(By.linkText("REGISTER")).click();
	  driver.findElement(By.name("userName")).clear();
	  driver.findElement(By.name("userName")).sendKeys("invalidUN");
	  driver.findElement(By.name("password")).clear();
	  driver.findElement(By.name("password")).sendKeys("invalidPW");   */
	  driver.findElement(By.linkText("sign-in")).click();
	  
	  
	  BadaClass.uname.clear();
	  BadaClass.uname.sendKeys("invalidUN");
	  BadaClass.pass.clear();
	  BadaClass.pass.sendKeys("invalidPW");
	  BadaClass.login_button.click();
	  driver.navigate().forward();
	  driver.navigate().back();
	Assert.assertEquals("FLIGHT FINDER", driver.getTitle()); 
	  
	  
		  
		  
	  }
	  
	  
	  
	  
  
  
  @AfterTest
  public void afterTest() 
  {
	 
  }

}
