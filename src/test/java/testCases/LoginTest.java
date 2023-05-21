package testCases;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Package1.Login;

public class LoginTest extends Login {

	@Test
	
	public void login() throws InterruptedException {
		

		driver.findElement(By.cssSelector(locators.getProperty("UserEmail"))).sendKeys(Values.getProperty("Useremail"));
		driver.findElement(By.cssSelector(locators.getProperty("UserPassword"))).sendKeys(Values.getProperty("Password"));
		//Thread.sleep(10000);
		driver.findElement(By.cssSelector(locators.getProperty("Dropdown"))).click();
		driver.findElement(By.xpath(locators.getProperty("Dropdownvalue"))).click();
		
		driver.findElement(By.cssSelector(locators.getProperty("loginButton"))).click();
		Thread.sleep(5000);
		
	}
	
	
}
