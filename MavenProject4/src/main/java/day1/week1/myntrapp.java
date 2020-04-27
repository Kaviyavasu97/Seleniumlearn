package day1.week1;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class myntrapp {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//1.open url
		driver.get("http://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//2.mouse over on women
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[text()='Women']"))
		.pause(2000)
		//3.click jackets and coats
		.click(driver.findElementByXPath("//a[text()='Jackets & Coats']"))
		.perform();
		String str = driver.findElementByClassName("title-count").getText();
		String text = str.replaceAll("\\D", "");
		//totalno of jackets and coats
		int totalno = Integer.parseInt(text);
		String jackets = driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();
		String jack = jackets.replaceAll("\\D", "");
		int jacketcount = Integer.parseInt(jack);
		System.out.println(jacketcount);
		String coats = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		String coat = coats.replaceAll("\\D", "");
		int coatscount = Integer.parseInt(coat);
		System.out.println(coatscount);
		int categorycount = jacketcount+coatscount;
		//checking whether it is equal
		if(totalno==categorycount)
		{
			System.out.println("Its matching");
			
		}
		//select coats
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		//to click more
		driver.findElementByXPath("//div[@class='brand-more']").click();
		//to type mango
		driver.findElementByXPath("//input[@placeholder='Search brand']").sendKeys("Mango");
		Thread.sleep(2000);
		driver.findElementByXPath("//label[@class=' common-customCheckbox']").click();
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		Thread.sleep(2000);
	    List <WebElement> brandslist = driver.findElementsByXPath("//div[@class='product-productMetaInfo']/h3");
	    for(WebElement brandName : brandslist)
	    {
	    	String brandtext = brandName.getText();
	    	if(brandtext.equals("Mango"))
	    	{
	    		int c=0;
	    	   c=c+1;
	    	}
      	
	    }
	    Thread.sleep(2000);
	    WebElement elesrc = driver.findElementByXPath("//div[@class='sort-sortBy']");
		builder.moveToElement(elesrc).perform();
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		List<WebElement> productprice = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
		Thread.sleep(2000);
	    String proprice1 = productprice.get(0).getText();
		System.out.println(proprice1);
		WebElement ele1 = driver.findElementByXPath("//img[@alt='MANGO Women Orange Solid Double-Breasted Longline Overcoat']");
		builder.moveToElement(ele1).perform();
		driver.findElementByXPath("//span[text()='Shop after lockdown']").click();
		driver.close();
		
	    
		
		
		
		

		
		
		
		
		

		
		
        
		
	}

}
