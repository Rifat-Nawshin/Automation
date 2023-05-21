package testCases;

import java.lang.reflect.Member;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Package1.Login;

public class FillUpForm extends Login{

	
	
	
	@Test
	
	public void Fillupform() throws InterruptedException {
		
		Thread.sleep(7000);
		driver.findElement(By.xpath(locators.getProperty("Addemployeebutton"))).click();
		Thread.sleep(5000);
		
		
		//fillup the form
		
		driver.findElement(By.cssSelector(locators.getProperty("Salutations"))).click();
		
		List <WebElement> salutations  = driver.findElements(By.cssSelector(locators.getProperty("Salutaionsvalue")));
		
		for(WebElement sa: salutations) {
			if(sa.getText().equals(Values.getProperty("SalutationString"))) {
				
				sa.click();
				break;
			}
			
		}
		
		
		//driver.findElement(By.xpath("//mat-option/span[text()='Mrs.']")).click();
		driver.findElement(By.cssSelector(locators.getProperty("Firstname"))).sendKeys(Values.getProperty("firstnameString"));
		driver.findElement(By.cssSelector(locators.getProperty("Lastname"))).sendKeys(Values.getProperty("lastnameString"));
		JavascriptExecutor js =(JavascriptExecutor) driver;
		//scroldown
		WebElement na = driver.findElement(By.cssSelector(locators.getProperty("Designation")));
		js.executeScript("arguments[0].scrollIntoView(true)", na);
		na.sendKeys(Values.getProperty("Designationvalue"));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(locators.getProperty("Email"))).sendKeys(Values.getProperty("userEmailString"));
	    driver.findElement(By.cssSelector(locators.getProperty("Genderdropdown"))).click();
		driver.findElement(By.xpath(locators.getProperty("Genderfemaleselectior"))).click();
		
		//dropdown list for selecting Date picker
		
		driver.findElement(By.xpath(locators.getProperty("Dateofbirth"))).click();
		Thread.sleep(2000);
		
		
		
		while(true) {
			
			String year = driver.findElement(By.xpath(locators.getProperty("Dateofyear"))).getText();
			if(year.equals(Values.getProperty("month"))) 
			{
				break ;
			}
			
			else
			{
				driver.findElement(By.xpath(locators.getProperty("Yearsidearrow"))).click();
				
			}
		}
		
		List <WebElement>  dates = driver.findElements(By.xpath(locators.getProperty("Date")));
		
		for(WebElement alldates:dates) {
			if (alldates.getText().equals(Values.getProperty("Day"))) {
				
				alldates.click();
				break;
			}
			
			
		}
		
		
		
		
		//driver.findElement(By.cssSelector("input#mat-input-13")).sendKeys("9/9/1999");
		//driver.findElement(By.xpath("//div[text()='5']")).click();
		driver.findElement(By.cssSelector(locators.getProperty("phonedropdon"))).click();
		driver.findElement(By.xpath(locators.getProperty("PhoneBangaldesh"))).click();
		driver.findElement(By.cssSelector(locators.getProperty("TelephoneNumberFiled"))).sendKeys(Values.getProperty("userPhoneString"));
		
		Thread.sleep(6000);
		driver.findElement(By.cssSelector(locators.getProperty("DepartmentDropdown"))).click();
		
		//dropdown list for selecting Basic
		
		List <WebElement> datas = driver.findElements(By.cssSelector(locators.getProperty("Departmentdropdownvalues")));
		
		for(WebElement data:datas) {
			if (data.getText().equals(Values.getProperty("department"))) {
				
				data.click();
				break;
				
			}
			
			
		}
		
		
		
		
	    //driver.findElement(By.xpath("//span[text()='BASIC']")).click();
		     
	    // scroldown
		WebElement BC= driver.findElement(By.xpath(locators.getProperty("ContinueButton")));
		js.executeScript("arguments[0].scrollIntoView(true)", BC);
		BC.click();
		Thread.sleep(2000);
		
		//Verify assertion
		String AR =driver.findElement(By.xpath(locators.getProperty("SuccessfullCreated"))).getText();
		
		//String expectedResut = "Created Employee Successfully";
		Assert.assertEquals(AR, Values.getProperty("StringexpectedResut"), "Failed");
		System.out.println("Member created");
		Thread.sleep(6000);
	}
	
	
	
}

