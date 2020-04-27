package week2.day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.PackageSpecificMethods;

public class Login extends PackageSpecificMethods {
	@Test(dataProvider = "sendData")
	public void runLogin(String cName,String fName,String lName)
	{
	    driver.findElementByLinkText("Leads").click();
	    driver.findElementByLinkText("Create Lead").click();
	    driver.findElementById("createLeadForm_companyName").sendKeys(cName);
	    driver.findElementById("createLeadForm_firstName").sendKeys(fName);
	    driver.findElementById("createLeadForm_lastName").sendKeys(lName);
	    WebElement eleSource = driver.findElementById("createLeadForm_dataSourceId");
	    Select obj = new Select(eleSource);
	    obj.selectByVisibleText("Cold Call");
	    WebElement elesource1 = driver.findElementById("createLeadForm_industryEnumId");
	    Select obj2 = new Select(elesource1);
	    obj2.selectByValue("IND_AEROSPACE");
	    WebElement findElementById = driver.findElementById("createLeadForm_currencyUomId");
	    Select obj3 = new Select(findElementById);
	    List<WebElement> options = obj3.getOptions();
	    int size = options.size();
	    obj3.selectByIndex(size-1);
	    for (WebElement eachOption : options) {
	    	System.out.println(eachOption.getText());
			
		}
	    
	    
	   
		
	}

}
