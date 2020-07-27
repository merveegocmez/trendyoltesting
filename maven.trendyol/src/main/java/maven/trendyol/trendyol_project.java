package maven.trendyol;

import java.util.List;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class trendyol_project {
	
	@Test
	public void testLogs() throws InterruptedException{
		
		//DisableNotifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver" , "C:\\seleniumjava\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.trendyol.com");
		String URL = driver.getCurrentUrl();
	    if(URL.contains("https://www.trendyol.com"))
	    {
	        System.out.println("TRUE " + URL);

	    }else
	    {
	        System.out.println("FALSE " + URL );
	        
}
       
        driver.get("https://www.trendyol.com/login");
        Thread.sleep(5000);
        
        WebElement username=driver.findElement(By.id("fEmailx"));
        WebElement password=driver.findElement(By.id("LoginModel_Password"));
        WebElement login = driver.findElement(By.id ("loginSubmitButton"));
       
        username.sendKeys("trendyolexample@gmail.com");
        password.sendKeys("trendyoltest123");
        login.click();
        
      
        String actualUrl="https://www.trendyol.com/login";
        String expectedUrl= driver.getCurrentUrl();
        
        Assert.assertEquals(expectedUrl,actualUrl);
        
        if(URL.contains("https://www.trendyol.com"))
       
        {
            System.out.println("Test passed");
        }
        else
        {
            System.out.println("Test failed");
        }
        
    	 
    		driver.get("https://www.trendyol.com");
    		WebElement elem = driver.findElement(By.xpath("//*[@id='auto-complete-app']/div/div[1]/input"));
    		elem.sendKeys(new String[]{"bilgisayar"});
    		elem.sendKeys(Keys.ENTER);
    		

    	

    	//selectRandomProduct

		    List<WebElement> allProducts = driver.findElements(By.xpath("//*[@id=\'search-app\']/div/div/div[2]//img"));
		    Random rand = new Random();
		    int randomProduct = rand.nextInt(allProducts.size());
		    allProducts.get(randomProduct).click();

		
		//addCart
		    
		    WebElement addCartRandomProduct = driver.findElement(By.className("add-to-bs"));
		    addCartRandomProduct.click();
		    
		  //inDetailPrice

		    WebElement inDetailPrice = driver.findElement(By.className("prc-slg"));
		    	String keepInDetailPrice = inDetailPrice.getAttribute("innerHTML");
		    System.out.println(keepInDetailPrice);
		    System.out.println("inDetailPrice tamamlandý");
		    
		    
		 //goBasket
		    
		    driver.get("https://www.trendyol.com/sepetim#/basket");
		    System.out.println("goBasket tamamlandý");
		    
		 //inBasketPrice
		    
		    WebElement inBasketPrice = driver.findElement(By.className("total-price"));
		    String keepInBasketPrice = inBasketPrice.getAttribute("innerHTML");
		    System.out.print(keepInBasketPrice);
		    System.out.println("keepInBasketPrice tamamlandý");
	
	
		   
		    
		    String keepInDetailPrice_real = keepInDetailPrice.replaceAll("[^0-9]","");
		    
		    String keepInBasketPrice_real = keepInBasketPrice.replaceAll("[^0-9]","");
		    
		    int keepInDetailPrice_int = Integer.parseInt(keepInDetailPrice_real);
		    int keepInBasketPrice_int = Integer.parseInt(keepInBasketPrice_real);
		    
		    if(keepInDetailPrice_int == keepInBasketPrice_int) {
		    	
		    	System.out.println("Fiyatlar eþit");
		    	
		    }else {
		    	System.out.println("Fiyatlar eþit deðil");
		    }
		    
		    //add1More
		    
		    Thread.sleep(5000);
		    
		    WebElement add1MoreProduct = driver.findElement(By.xpath("//*[@id=\'partial-basket\']/div/div[2]/div[2]/div[3]/div[1]/div/button[2]"));
		    add1MoreProduct.click();
		    
		    Thread.sleep(5000);
		    
		    WebElement howManyProduct = driver.findElement(By.className("counter-content"));
		    String howManyProduct_real = howManyProduct.getAttribute("value");
		    
		    int howManyProduct_real_int = Integer.parseInt(howManyProduct_real);
		    
		    if(howManyProduct_real_int == 2) {
		    	System.out.println("ürün 2 tane");
		    }else {
		    	System.out.println("ürün 2 tane deðil");
		    }
		  
		    
		    Thread.sleep(5000);
		  
		    
		    WebElement deleteProduct = driver.findElement(By.xpath("//*[@id=\'partial-basket\']/div/div[2]/div[2]/div[3]/button"));
		    deleteProduct.click();
		    
		    Thread.sleep(5000);
		    
		    WebElement deleteProductOkay = driver.findElement(By.className("btn-remove"));
		    deleteProductOkay.click();
		    
		    
		    Thread.sleep(5000);
		    
		    WebElement basketFree = driver.findElement(By.xpath("//*[@id=\"basketNoProductPage\"]/div[2]/div/div[1]/p/span"));
		    String basketText = basketFree.getText();
		    

		    if(basketText.length() > 0) {
		    	System.out.println("Sepet boþ");
		    }else {
		    	System.out.println("Sepet boþ deðil");
		    }
    	 
		
    		
    	}

}

