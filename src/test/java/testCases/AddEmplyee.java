package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Package1.Login;
import io.qameta.allure.Feature;

public class AddEmplyee extends Login {

	@Test
	public void addemplyee() throws InterruptedException {
		
	       driver.findElement(By.xpath(locators.getProperty("DirectoryButton"))).click();
			
			//driver.findElement(By.linkText("Verzeichnis")).click();
			
			
			//driver.findElement(By.xpath("//span[normalize-space()='Verzeichnis']")).click();
			
			
			Thread.sleep(8000);
			
		}
		
		
}
	

	
	
	
	

