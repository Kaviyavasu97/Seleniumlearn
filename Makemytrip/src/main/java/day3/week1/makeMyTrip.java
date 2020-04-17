package day3.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class makeMyTrip {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Go to make my trip
		driver.get("https://www.makemytrip.com/");
		//click hotels
		driver.findElementByXPath("//span[text()='Hotels']").click();
		//click city
		driver.findElementByXPath("//input[@id='city']").click();
		//Enter city as Goa
		Thread.sleep(2000);
		driver.findElementByXPath("(//input[@type='text'])[2]").sendKeys("Goa");
		Thread.sleep(2000);
		//Select Goa,India
		driver.findElementByXPath("//p[text()='Goa, India']").click();
		//Enter checkin and checkout date
		driver.findElementByXPath("//input[@id='checkin']").click();
		driver.findElementByXPath("(//div[text()='15'])[2]").click();
		driver.findElementByXPath("(//div[text()='20'])[2]").click();
		//click rooms
		driver.findElementByXPath("//input[@id='guest']").click();
		driver.findElementByXPath("//ul[@data-cy='adultCount']/li[2]").click();
		driver.findElementByXPath("(//li[text()='1'])[2]").click();
		//click apply button
		driver.findElementByXPath("//button[text()='APPLY']").click();
		//click search button
		driver.findElementByXPath("//button[text()='Search']").click();
		driver.findElementByXPath("//div[@class='mmBackdrop wholeBlack']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='checkmarkOuter']/label[text()='Baga']")));
		//select baga
		driver.findElementByXPath("//span[@class='checkmarkOuter']/label[text()='Baga']").click();
		//select 5 star
		Thread.sleep(2000);
        driver.findElementByXPath("//label[text()='5 Star']").click();
        driver.findElementByXPath("(//div[@class='makeFlex spaceBetween'])[3]/div").click();
        Set<String> windowslist = driver.getWindowHandles();
        List<String> allWindows = new ArrayList<String>();
        allWindows.addAll(windowslist);
        driver.switchTo().window(allWindows.get(1));
        //get hotel name
        String text = driver.findElementById("detpg_hotel_name").getText();
        System.out.println("The hotel name is"+ text);
        driver.findElementByXPath("(//span[text()='MORE OPTIONS'])[1]").click();
        // select 3 months plan
        driver.findElementByXPath("//tr[2]/td[6]").click();
        driver.findElementByXPath("//span[@class='close']").click();
        driver.findElementByXPath("//a[text()='BOOK THIS NOW']").click();
        driver.findElementByXPath("//span[@class='close']");
        //get total payable amount
        String text2 = driver.findElementById("revpg_total_payable_amt").getText();
        System.out.println("Total payable amount");
        driver.quit();
	}
	

}
