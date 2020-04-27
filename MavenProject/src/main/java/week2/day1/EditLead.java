package week2.day1;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.PackageSpecificMethods;

public class EditLead extends PackageSpecificMethods {
	ChromeDriver driver;
	@Test
	public  void runEditLead() throws InterruptedException
	{
	    driver.findElementByLinkText("Leads").click();
	    driver.findElementByXPath("//a[text()='Find Leads']").click();
	    driver.findElementByXPath("//span[text()='Name and ID']").click();
	    driver.findElementByXPath("//div[@class='x-form-item x-tab-item']/following::input[1]").sendKeys("jay");
	    driver.findElementByXPath("//button[text()='Find Leads']").click();
	    Thread.sleep(2000);
	    driver.findElementByXPath("//table[@class='x-grid3-row-table']//tr[1]/td[1]//a").click();
	    String title1 = driver.getTitle();
	    System.out.println(title1);
	    driver.findElementByXPath("//a[text()='Edit']").click();
	    WebElement name = driver.findElementById("updateLeadForm_companyName");
	    name.clear();
	    name.sendKeys("cts");
	    driver.findElementByXPath("//input[@class='smallSubmit']").click();
	  
	    
	     
	   
	    
	 
	     
	    	


		

	}
	

}
