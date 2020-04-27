package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.PackageSpecificMethods;

public class DuplicateLead extends PackageSpecificMethods {
	ChromeDriver driver;
	@Test
public void  runDuplicateLead()throws InterruptedException
{
    driver.findElementByLinkText("Leads").click();
    driver.findElementByXPath("//a[text()='Find Leads']").click();
    driver.findElementByXPath("//span[text()='Email']").click();
    driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("abc@xyz.com");
    driver.findElementByXPath("//button[text()='Find Leads']").click();
    Thread.sleep(2000);
    driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
 
}
}
