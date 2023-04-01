import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class Tests extends SetUp {
		
	@Test(priority=1)
	public void A_SignUp() throws InterruptedException {
     
	    //Create an Account
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a")).click();
		//Fill Information
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Nour");
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Sab.");		
		driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys("Test@Testing02.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("012ASzxc3456");
		driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys("012ASzxc3456");
		
		//SignUp Button
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
		Thread.sleep(10000);
		
	    //Validation
		String expectedURL ="https://magento.softwaretestingboard.com/customer/account/";
		String actualURL = driver.getCurrentUrl();
		MyAssertion.assertEquals(actualURL, expectedURL);
		MyAssertion.assertAll();
	}
		
	   @Test(priority =2)
       public void B_RandSearch() throws InterruptedException {
		 
	    //HomePage
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a")).click();
	
		String [] Clothes= {"Jacket", "t-shirt", "jeans for men", "jeans for women","pants"};
		
		int RandomNumber= rand.nextInt(0,5);
		String chosenType = Clothes[RandomNumber]; 
		driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(chosenType);
		driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).click();
		Thread.sleep(10000);	
		
	    //Validation
		String displayed = driver.getTitle();
		String expected = String.format("Search results for: '%s'", chosenType);
		System.out.println("                                                ");
		System.out.println("**************** "+displayed+" *****************");
		System.out.println("                                                ");
		MyAssertion.assertEquals(displayed,expected);
		MyAssertion.assertAll();
	}
		
	@Test(priority =3)
	public void C_AddItems() throws InterruptedException {
			
		 //HomePage
		 driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a")).click();		
		 
		//To perform Scroll on application using Selenium		
		js.executeScript("window.scrollBy(0,1600)", "");
		
	     //FirstItem
	    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("3");
	    
	    String [] Sizes= {"166","167","168","169","170"};
	    String [] RtColor = {"50","56","57"}; 
    	   
	    int index = rand.nextInt(0,Sizes.length);
	    int rtcolor = rand.nextInt(0, RtColor.length);
	    
	    String AllSize = Sizes[index];
	    String RT =RtColor[rtcolor];
	    
	    Thread.sleep(2000);
	    WebElement S= driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-"+AllSize+"\"]")); 
	    WebElement RTC=driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-"+RT+"\"]"));
	    S.click();
	    RTC.click();
	    driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]/span")).click();
	    
        ////////////////////  2  ////////////////////
	    
	    driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a")).click();
	    js.executeScript("window.scrollBy(0,1600)", "");
	    
	    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[2]/div/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("2");
	  	    String [] BeColor = {"57","59","60"}; 
	    int becolor = rand.nextInt(0, RtColor.length);
	    String BE = BeColor[becolor];
	    
	    Thread.sleep(2000);
	    WebElement S2= driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-"+AllSize+"\"]")); 
	    WebElement BEC=driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-"+BE+"\"]"));
	    S2.click();
	    BEC.click();
	    driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]/span")).click();
	    
        ////////////////////  3  ////////////////////
	    
	    driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a")).click();
	    js.executeScript("window.scrollBy(0,1600)", "");
	    
	    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]/div/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("4");
	   	    
	    Thread.sleep(2000);
	    WebElement S3= driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-"+AllSize+"\"]")); 
	    WebElement AAC=driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-52\"]"));
	    S3.click();
	    AAC.click();
	    driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]/span")).click();
	    
        ////////////////////    4    ////////////////////
	    
	    driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a")).click();	   
	    js.executeScript("window.scrollBy(0,1600)", "");
	    
	    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("1");
	    
	    String [] HhColor = {"49","52","53"}; 
	    int hhcolor = rand.nextInt(0, HhColor.length);
	    String HH = HhColor[hhcolor];
	    
	    Thread.sleep(2000);
	    WebElement S4= driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-"+AllSize+"\"]")); 
	    WebElement HHC=driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-"+HH+"\"]"));
	    S4.click();
	    HHC.click();
	    driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]/span")).click();
  
        ////////////////////   5   ////////////////////
	    
	    driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a")).click();
	    js.executeScript("window.scrollBy(0,1600)", "");	    
	    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[5]/div/a")).click();	  
	    driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("5");	    
	    driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]/span")).click();
	    Thread.sleep(9000);
	    
       ////////////////////    Validation   ////////////////////
	    
	    String ItemCount = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a/span[2]/span[1]")).getText();
	    System.out.println("Here is the number of items in the cart: "+ItemCount+"");
	    String ExpectedCount = "15";
	    Thread.sleep(2000);	  
	    MyAssertion.assertEquals(ItemCount, ExpectedCount);
	    MyAssertion.assertAll();
	}
	
	@Test(priority =4)
	public void D_CheckOut( ) throws InterruptedException {
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")).click();	
		
		Thread.sleep(10000);
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys("Nour");
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys("Sab.");
		driver.findElement(By.name("street[0]")).sendKeys("Az Zarqa");
		driver.findElement(By.name("city")).sendKeys("Az Zarqa");
		driver.findElement(By.name("postcode")).sendKeys("13112");
		
		Thread.sleep(2000);
		Select selectelement = new Select(driver.findElement(By.name("country_id")));
		//List<WebElement> DropDownOptions= selectelement.getOptions();
		selectelement.selectByVisibleText("Jordan");
		driver.findElement(By.name("telephone")).sendKeys("0359784615");

		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
		Thread.sleep(6000);

	    //Validation
		String expected="$467.00";
		String Price=driver.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[4]/td/strong/span")).getText();
		MyAssertion.assertEquals(Price, expected);
		MyAssertion.assertAll();		
	}

	@Test(priority =5)
	public void E_Placeorder() throws InterruptedException {
		
	    Thread.sleep(4000);
		String expected="$467.00";
		String Price=driver.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[4]/td/strong/span")).getText();
		Thread.sleep(4000);
	    //PlaceOrder
	    driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
	    Thread.sleep(9000);
	
	    ////////////// Validation  ///////////
		MyAssertion.assertEquals(Price, expected);
		MyAssertion.assertAll();
	}
	
	@Test(priority =6)
	public void F_ReOrder() throws InterruptedException {
			
        //LogOut
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")).click();
		
		//LogIn
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Test@Testing02.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("012ASzxc3456");		
		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();

		//ReOrdering
	    for(int i=1 ; i<5; i++){
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")).click();
		js.executeScript("window.scrollBy(0,1600)", "");
		Thread.sleep(9000);
	    driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr/td[6]/a[2]/span")).click();
	    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
	    Thread.sleep(9000);
	    }	 
	    
		//MyAccount
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")).click();
		js.executeScript("window.scrollBy(0,1600)", ""); 
		Thread.sleep(4000);
	
		//Take the Prices
		List<String> Prices = new ArrayList<>();
	  for (int i=1; i<6 ; i++){
	     String Temp = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr["+i+"]/td[4]/span")).getText();
	     Prices.add(Temp);
	   }
	    Thread.sleep(9000);
	    
	    
       //////////////////// Validation   ////////////////////
	    int OrderNum= Prices.size();
	    int ExpectedNum= 5;
	    Thread.sleep(5000);
	    MyAssertion.assertEquals(OrderNum, ExpectedNum);
	    MyAssertion.assertAll();
	}
	
	@Test(priority =7)
	public void G_AssertPrices() throws InterruptedException {
		
		Thread.sleep(6000);	
		//Take the Prices
		List<String> Prices = new ArrayList<>();
	    for (int i=1; i<6 ; i++){
	     String Temp = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr["+i+"]/td[4]/span")).getText();
	     Prices.add(Temp);
	     }
	  
	     Thread.sleep(5000);
	     String expectedPrice= "$467.00";
         boolean Status= false;
          
       //Compare Prices
       Start:   
      for (int i=0; i<5 ;i++) 
	  { 
		 String z= Prices.get(i);
	   if(z.equals(expectedPrice)) {
			 Status=true;
			 continue Start;
		 }
	   else {
		   Status=false;
		   System.out.println(" **************** This Price is "+z+" , and does not equal "+expectedPrice+" **************** ");
		   break;
	   } }
      
     //Validation  
	 MyAssertion.assertEquals(Status, true);
	 MyAssertion.assertAll();
         }	
}
