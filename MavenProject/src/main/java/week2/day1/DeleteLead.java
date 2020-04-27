package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteLead {
	@Test
	public void runDeleteLead() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementByName("PASSWORD").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
	    driver.findElementByLinkText("CRM/SFA").click();
	    driver.findElementByLinkText("Leads").click();
	    driver.findElementByXPath("//a[text()='Find Leads']").click();
	    driver.findElementByXPath("//span[text()='Phone']").click();
	    driver.findElementByXPath("//input[@name='phoneAreaCode']").sendKeys("9");
	    driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("029179");
	    driver.findElementByXPath("//button[text()='Find Leads']").click();
	    Thread.sleep(2000);
	    driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
	    WebElement elesrc = driver.findElementByXPath(("(//span[@class='tabletext'])[3]"));
	    String text = elesrc.getText();
	    System.out.println(text);
	    String leadId = text.replaceAll("\\D", "");
	    System.out.println(leadId);
	    driver.findElementByXPath("//a[@class='subMenuButtonDangerous']").click();
	    driver.findElementByXPath("//a[text()='Find Leads']").click();
	    driver.findElementByXPath("//div[@class='x-form-item x-tab-item']//input").sendKeys(leadId);
	    driver.findElementByXPath("//button[text()='Find Leads']").click();
	    Thread.sleep(2000);
	    WebElement elemsg = driver.findElementByXPath("//div[@class='x-paging-info']");
	    String msg = elemsg.getText();
	    System.out.println(msg);
	    
	    
	    
	    
	    
	    
	}
	
}
