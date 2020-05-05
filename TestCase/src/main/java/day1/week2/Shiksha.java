package day1.week2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shiksha {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaviy\\Downloads\\chromedriver_win32 (1)/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		options.merge(cap);
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://studyabroad.shiksha.com/");
		Actions builder = new Actions(driver);
		//Mouse over on colleges
		WebElement elesrc = driver.findElementByXPath("(//label[text()='Colleges '])[1]");
		builder.moveToElement(elesrc).perform();
		Thread.sleep(2000);
		//click Ms
		driver.findElementByXPath("//a[text()='MS in Computer Science &Engg']").click();
		//select GRE
		driver.findElementByXPath("//p[text()='GRE']").click();
		Thread.sleep(2000);
		//select exam score
		WebElement elesrc1 = driver.findElementByXPath("(//select[@name='examsScore[]'])[1]");
		Select option = new Select(elesrc1);
		option.selectByVisibleText("300 & below");
		Thread.sleep(2000);
		//click fees as 10 lakh
		driver.findElementByXPath("//p[text()='Max 10 Lakhs']").click();
		Thread.sleep(2000);
		//click usa
		driver.findElementByXPath("//a[text()='USA']/../../span").click();
		//select low to high 1st year fees
		WebElement element = driver.findElementById("categorySorter");
		Select option1 = new Select(element);
		option1.selectByVisibleText("Low to high 1st year total fees");
		Thread.sleep(4000);
		List<WebElement> collegeList = driver.findElementsByXPath("//div[@class='uni-course-details flLt']");
		int size = collegeList.size();
		System.out.println(size);
		for(int i=0;i<size;i++)
		{
			String attribute1 = driver.findElementByXPath("(//div[@class='uni-course-details flLt'])[" +(i+1)+ "]/div[3]/p[1]/span").getAttribute("class");
			String attribute2 = driver.findElementByXPath("(//div[@class='uni-course-details flLt'])[" +(i+1)+ "]/div[3]/p[2]/span").getAttribute("class");
			String attribute3 = driver.findElementByXPath("(//div[@class='uni-course-details flLt'])[" +(i+1)+ "]/div[3]/p[3]/span").getAttribute("class");
			if(attribute1.equalsIgnoreCase("tick-mark")&& (attribute2.equalsIgnoreCase("tick-mark"))&& (attribute3.equalsIgnoreCase("tick-mark")))
			{
					Thread.sleep(2000);
					WebElement ele1 = driver.findElementByXPath("(//div[@class='uni-course-details flLt'])[" +(i+1)+ "]");
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", ele1);
					driver.findElementByXPath("(//p[text()='Add to compare'])[" +(i+1)+ "]").click();
				}
			}
		Thread.sleep(2000);
		driver.findElementByXPath("(//a[@class='add-tag-title'])[1]").click();
		driver.findElementByXPath("//strong[text()='Compare Colleges >']").click();
		driver.findElementByXPath("//strong[text()='2021']/../../span").click();
		driver.findElementByXPath("//div[@class='sp-frm selectCountryField signup-fld invalid  focused']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//label[@for='USA_BifRaw']").click();
		driver.findElementByXPath("//strong[text()='Masters']/../../span").click();
		driver.findElementByXPath("//div[text()='Preferred Course']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//li[text()='MS']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[text()='All specializations']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//li[text()='Computer Science & Engineering']");
		driver.findElementById("signup").click();
		Thread.sleep(2000);
		List<WebElement> errormsgs = driver.findElementsByXPath("//div[@class='helper-text']");
	     for (WebElement warnmsg : errormsgs) {
	 
	    		 System.out.println(warnmsg.getText());
	    	 }
			
		
	     
	     driver.close();
		
		
}

}