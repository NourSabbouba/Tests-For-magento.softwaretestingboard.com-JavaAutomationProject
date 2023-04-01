import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Random;

public class SetUp {
	
  WebDriver driver;
  SoftAssert MyAssertion;
  JavascriptExecutor js;
  Random rand;
  
  @BeforeTest
   public void setUp( ) {
	  ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");  
		 driver = new ChromeDriver(options);
		 
		 MyAssertion = new SoftAssert();
		 
		 js = (JavascriptExecutor) driver;
		 
		 rand = new Random();
	    driver.get("https://magento.softwaretestingboard.com/");

		driver.manage().window().maximize();
  }
  
  
  @AfterTest
  public void Finish () throws InterruptedException {
      Thread.sleep(5000);
	  driver.close();	  
  }
  
  
}
