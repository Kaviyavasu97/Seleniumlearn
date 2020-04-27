package day3.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Honda {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaviy\\Downloads\\chromedriver_win32 (1)/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//go to honda.com
		driver.get("https://www.honda2wheelersindia.com/");
		driver.findElementByXPath("//button[text()='×']").click();
		//click on scooters and select dio
		driver.findElementById("link_Scooter").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//img[@src='/assets/images/thumb/dioBS6-icon.png']").click();
		//click specifications
		driver.findElementByXPath("//a[text()='Specifications']").click();
		//mouse over on engine
		Thread.sleep(2000);
	    Actions builder = new Actions(driver);
	    WebElement ele1 = driver.findElementByXPath("//a[text()='ENGINE']");
	    builder.moveToElement(ele1)
	    .perform();
	    Thread.sleep(2000);
	    //get displacement value of dio
	    String text1 = driver.findElementByXPath("(((//ul[@class='tab_content'])[2]/li)[3]/span)[2]").getText();
	    System.out.println(text1);
	    String diodisplacement = text1.replaceAll("cc", " ");
	    float f1=Float.parseFloat(diodisplacement);  
	    //go to scooter
	    driver.findElementById("link_Scooter").click();
	    //click activa 125
	    driver.findElementByXPath("//img[@src='/assets/images/thumb/activa-125new-icon.png']").click();
	    driver.findElementByXPath("//a[text()='Specifications']").click();
	  //mouse over on engine
	    Thread.sleep(2000);
	    Actions builder1 = new Actions(driver);
	    WebElement ele2 = driver.findElementByXPath("//a[text()='ENGINE']");
	    builder.moveToElement(ele2)
	    .perform();
	    Thread.sleep(2000);
	    //get displacement of activa 125
	    String text2 = driver.findElementByXPath("(((//ul[@class='tab_content'])[2]/li)[3]/span)[2]").getText();
	    System.out.println(text2);
	    String activadisplacement = text2.replaceAll("cc", " ");
	    float f2=Float.parseFloat(activadisplacement);  
	    if(f1>f2)
	    {
	    	System.out.println("dio has better displacement");
	    }
	    else
	    {
	    	System.out.println("Activa 125 has better displacement");
	        
	    }
	    //click faq
	    driver.findElementByXPath("(//a[text()='FAQ'])[1]").click();
	    Thread.sleep(2000);
	    driver.findElementByXPath("//a[text()='Activa 125 BS-VI']").click();
	    Thread.sleep(2000);
	    //click vechile price
	    driver.findElementByXPath("(//a[@data-toggle='tab'])[6]").click();
	    Thread.sleep(2000);
	    //to get text from dropdown
	    WebElement elesrc = driver.findElementByXPath("(//select[@name='ModelID'])[6]");
	    Select option = new Select(elesrc);
	    WebElement dropdown = option.getFirstSelectedOption();
	    String attribute = dropdown.getText();
	    //to check text contains activa125
	    if(attribute.contains("Activa 125"))
	    {
	    	System.out.println("Activa 125 is selected");
	    }
	    else
	    {
	    	System.out.println("Activa 125 is not  selected");
	    }
	    driver.findElementByXPath("(//button[text()='Submit'])[6]").click();
	    Thread.sleep(2000);
	    driver.findElementByXPath("//a[text()='Click here to know the price of Activa 125 BS-VI.']").click();
	    //Switch to new window
	    Set<String> windows = driver.getWindowHandles();
	    List<String> windowsls = new ArrayList<String>();
	    windowsls.addAll(windows);
	    driver.switchTo().window(windowsls.get(1));
	    //Select tamilnadu
	    WebElement dropdn = driver.findElementByXPath("//select[@name='StateID']");
	    Select Option = new Select(dropdn);
	    Option.selectByVisibleText("Tamil Nadu");
	    //Select city
	    WebElement dropdn2 = driver.findElementByXPath("//select[@name='CityID']");
	    Select  Option1 = new Select(dropdn2);
	    Option1.selectByVisibleText("Chennai");
	    //click search
	    driver.findElementByXPath("//button[text()='Search']").click();
	    Thread.sleep(2000);
	    Map<String,String> map = new HashMap<String,String>();
	    String Model1 = driver.findElementByXPath("//tbody[@style='background-color:white']/tr[1]/td[2]").getText();
	    String value1 = driver.findElementByXPath("//tbody[@style='background-color:white']/tr[1]/td[3]").getText();
	    map.put(Model1, value1);
	    String Model2 = driver.findElementByXPath("//tbody[@style='background-color:white']/tr[2]/td[1]").getText();
	    String value2 = driver.findElementByXPath("//tbody[@style='background-color:white']/tr[2]/td[2]").getText();
	    map.put(Model2, value2);
	    String Model3 = driver.findElementByXPath("//tbody[@style='background-color:white']/tr[3]/td[1]").getText();
	    String value3 = driver.findElementByXPath("//tbody[@style='background-color:white']/tr[3]/td[2]").getText();
	    map.put(Model3, value3);
	    for(Entry<String,String> eachMap:map.entrySet())
	    {
	    	System.out.println(eachMap.getKey()+"    "+eachMap.getValue());
	    	System.out.println();
	    }
	    driver.quit();
	   
	    
	
	    
		
		
		
	}

}
