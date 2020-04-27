package day3.week1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hpStore {
public static void main(String[] args) throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(options);
	WebDriverWait wait = new WebDriverWait(driver,30);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//Go to hp store
	driver.get("https://store.hp.com/in-en/");
	Actions builder = new Actions(driver);
	//Mouseover on Laptops
	Thread.sleep(2000);
	WebElement elesrc = driver.findElementByXPath("(//span[text()='Laptops'])[1]");
	builder.moveToElement(elesrc)
	.perform();
	Thread.sleep(2000);
	driver.findElementByXPath("(//span[text()='Pavilion'])[1]").click();
	driver.findElementByXPath("(//span[text()='Processor'])[2]").click();
	driver.findElementByXPath("(//dl[@role='tablist'])[2]/dd[1]/div/div/ol/li[1]").click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='item'])[17]")));
	driver.findElementByXPath("(//li[@class='item'])[17]").click();
	Thread.sleep(3000);
	WebElement elesrc1 = driver.findElementById("sorter");
	Select option = new Select(elesrc1);
    option.selectByValue("price_asc");
    Thread.sleep(2000);
    driver.findElementByXPath("(//span[@class='product-image-container'])[1]/span/img").click();
    Thread.sleep(2000);
    String text = driver.findElementByXPath("//span[@class='base']").getText();
    System.out.println("The name of product" +text);
    String text2 = driver.findElementByXPath("//div[@class='product-info-price']/div/span/span[1]/span").getText();
    System.out.println("The price is" +text2);
    Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Add to Cart']")));
    driver.findElementByXPath("//button[@title='Add to Cart']").click();
    Thread.sleep(2000);
    driver.findElementByXPath("//button[@data-role='closeBtn']").click();
    driver.findElementByXPath("//a[@class='action showcart']").click();
    driver.findElementByXPath("//span[text()='View and edit cart']").click();
    driver.findElementByXPath("//input[@name='pincode']").sendKeys("600052");
    Thread.sleep(2000);
    driver.findElementByXPath("//button[text()='check']").click();
    String text3 = driver.findElementByXPath("//span[@data-th='Subtotal']").getText();
    String text4 = driver.findElementByXPath("//td[@data-th='Order Total']/strong/span").getText();
    if(text3.equals(text4))
    {
    	driver.findElementById("sendIsCAC").click();
    }
    else
    {
    	System.out.println("its not equal");
    }
    driver.findElementById("customer-email").sendKeys("kaviyavasu76@gmail.com");
    driver.findElementByXPath("(//input[@name='firstname'])[1]").sendKeys("kavuya");
    driver.findElementByXPath("//input[@name='lastname']").sendKeys("vasu");
    driver.findElementByXPath("(//input[@name='telephone'])[1]").sendKeys("9840816684");
    driver.findElementByXPath("(//input[contains(@name,'street')])[1]").sendKeys("M.A.Nagar,Redhills");
    Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Place Order'])[3]")));
    driver.findElementByXPath("(//span[text()='Place Order'])[3]").click();
    
    
    
	
	

}
}
