package week2.day1;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrainName {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://erail.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement src = driver.findElementById("txtStationFrom");
		src.clear();
		 src.sendKeys("MAS",Keys.TAB);
		WebElement des = driver.findElementById("txtStationTo");
		des.clear();
		des.sendKeys("CST",Keys.TAB);
		if(driver.findElementById("chkSelectDateOnly").isSelected())
		{
			driver.findElementById("chkSelectDateOnly").click();
			driver.findElementById("chkSelectDateOnly").click();

			
		}
		driver.findElementByXPath("//input[@value='Get Trains']").click();
		WebElement eleTable = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']");
		List<WebElement> allRows = eleTable.findElements(By.tagName("tr"));
		for(int i=0;i<allRows.size();i++)
		{
			List<WebElement> allCols = allRows.get(i).findElements(By.tagName("td"));
		
			WebElement Train = allCols.get(1);
			String TrainName = Train.getText();
			System.out.println(TrainName);
		}
			
			
			
			
			
		
			
			
			}
		
		
		
	}


