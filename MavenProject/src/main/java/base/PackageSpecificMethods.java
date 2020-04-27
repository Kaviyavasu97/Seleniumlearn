package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class PackageSpecificMethods {
	public ChromeDriver driver;
	@Parameters({"url","uname","pwd"})
	@BeforeMethod
	public void run(String url,String username,String password)
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys(username);
		driver.findElementByName("PASSWORD").sendKeys(password);
		driver.findElementByClassName("decorativeSubmit").click();
	    String title = driver.getTitle();
	    System.out.println(title);
	    driver.findElementByLinkText("CRM/SFA").click();


	}
	@AfterMethod
	public void after()
	{
		driver.close();
	}
	@DataProvider
	public String[][] sendData()
	{
		String[][] data = new String[3][3];
		data[0][0]="google";
		data[0][1]="kaviya";
		data[0][2]="vasu";
		
		data[1][0]="Amazon";
		data[1][1]="Naveen";
		data[1][2]="en";
		
		data[2][0]="CTS";
		data[2][1]="Dhivya";
		data[2][2]="Raman";
		return data;
		
		
		
		
	
		
	}

}
