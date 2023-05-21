package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Package1.Login;

public class GeneralInfoVerify extends Login {

	
	@Test
	public void verifydata() throws InterruptedException {
		
	driver.get("https://stage-delta.selise.biz/employee/b74611be-a5f3-2e16-66ef-8a0e42c99416/directory/generalinformation");	
	
	Thread.sleep(6000);
	
	
		
	//verify email
	String getEmail = driver.findElement(By.xpath(locators.getProperty("getemail"))).getText();
	
	Assert.assertEquals(getEmail, Values.getProperty("userEmailString"), "Failed");
	
	System.out.println("Email matched");
	

	//verify department
	 String getDepartment = driver.findElement(By.xpath(locators.getProperty("gtdepartment"))).getText();
	
	 Assert.assertEquals(getDepartment, Values.getProperty("department"), "Failed");
	   System.out.println("Department matched");
	   
	   //if (getDepartment.equals(Values.getProperty("department")))
			
			//System.out.println("Departament matched");
		//else 
			//System.out.println("Department not matched");
	
	
	
	//verify phone number
	String getPhone = driver.findElement(By.xpath(locators.getProperty("getphone"))).getText();
	//System.out.println(getPhone);
	
   if (getPhone.contains(Values.getProperty("userPhoneString")))
		
		{System.out.println("Phone number matched");}
	else 
		{System.out.println("Phone number not found");}
   
 
   
   
   //verfy the display name
   
   String getDiplayname = driver.findElement(By.xpath(locators.getProperty("getdisplayname"))).getText();
   if (getDiplayname.equals(Values.getProperty("Displayname")))
		
	{System.out.println("Display name matched");}
  else 
	{System.out.println("Display name not matched");}
	
	
}
	
}
