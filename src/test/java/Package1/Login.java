package Package1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import javax.activation.DataSource;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;



public class Login {
	
	public ChromeOptions options = new ChromeOptions();
	
	public static WebDriver driver; 
	
	public static Properties locators = new Properties();
	
	public static FileInputStream fis;
	
	public static Properties Values = new Properties();
	
	public static FileInputStream fis2;
	
	//String month ="MARCH 2014";
	//String Day = "12";
	//String department = "BASIC";
	//String userEmailString ="automateuser@gmail.com" ;
	//String userPhoneString= "1789 876543";
	//String salutationString = "Mrs.";
	//String firstnameString = "Automate";
	//String lastnameString = "User";
	
	
	
	
	
	
	@BeforeSuite
	
	public void getUrl() throws IOException {
		
		if (driver==null) {
			
			
		fis = new FileInputStream("D:\\Eclipse\\JAVA PROJECTS\\Delta\\src\\test\\resources\\Properties\\Locators.properties");
		locators.load(fis);
		
		fis2 = new FileInputStream("D:\\Eclipse\\JAVA PROJECTS\\Delta\\src\\test\\resources\\Properties\\Values");
		Values.load(fis2);
		
		}
		
	//ChromeOptions options = new ChromeOptions();	
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://stage-delta.selise.biz/login");
	driver.manage().window().maximize();
	
	}
	
	/*@Feature("Login")
	@Story("Logi with credentials")
	@Description("Login with test credentials and change the language to English")
	
	@Test(priority=1)
	public void login() throws InterruptedException {
		
		driver.findElement(By.cssSelector("input[placeholder='E-Mail-Adresse']")).sendKeys("selisetest.delta@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Passwort']")).sendKeys("2wsxXSW@sd");
		//Thread.sleep(10000);
		driver.findElement(By.cssSelector("mat-select#mat-select-0")).click();
		driver.findElement(By.xpath("//mat-option/span[text()='Englisch']")).click();
		
		driver.findElement(By.cssSelector("button[class='submit-button legacy-bold mat-raised-button mat-button-base mat-primary']")).click();
		Thread.sleep(5000);
		
	}*/
	
	/*@Feature("Directory")
	@Story("Clcik on directory")
	@Description("Go to directory module for adding employee")
	
	@Test(priority=2)
	public void clcikDirectory() throws InterruptedException {
		
		//driver.findElement(By.linkText("Verzeichnis")).click();
		
		driver.findElement(By.xpath("//span[text()='Directory']")).click();
		//driver.findElement(By.xpath("//span[normalize-space()='Verzeichnis']")).click();
		
		
		Thread.sleep(8000);
		
	}
	
	@Feature("Add member")
	@Story("Add memebr")
	@Description("Add member by fill up hte form & scrolldown the form ")
	
	@Test(priority=3)
	
	public void addEmployee() throws InterruptedException {
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("//span[text()='Add Employee']")).click();
		//Thread.sleep(5000);
		
		//clcik on cancel button
		//driver.findElement(By.xpath("//span[text()=' Cancel ']")).click();
		
		//fillup the form
		
		driver.findElement(By.cssSelector("mat-select#mat-select-2")).click();
		
		List <WebElement> salutations  = driver.findElements(By.cssSelector("span.mat-option-text"));
		
		for(WebElement sa: salutations) {
			if(sa.getText().equals(salutationString)) {
				
				sa.click();
				break;
			}
			
		}
		
		
		//driver.findElement(By.xpath("//mat-option/span[text()='Mrs.']")).click();
		driver.findElement(By.cssSelector("input#mat-input-9")).sendKeys(firstnameString);
		driver.findElement(By.cssSelector("input#mat-input-10")).sendKeys(lastnameString);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		//scroldown
		WebElement na = driver.findElement(By.cssSelector("input#mat-input-11"));
		js.executeScript("arguments[0].scrollIntoView(true)", na);
		na.sendKeys("QA");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#mat-input-12")).sendKeys(userEmailString);
	    driver.findElement(By.cssSelector("mat-select#mat-select-3")).click();
		driver.findElement(By.xpath("//span[text()='Female']")).click();
		
		//dropdown list for selecting Date picker
		
		driver.findElement(By.xpath("//*[@id=\"employeeForm\"]/form/mat-form-field[4]/div/div[1]/div[4]/mat-datepicker-toggle/button")).click();
		Thread.sleep(2000);
		
		
		
		while(true) {
			
			String year = driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[1]")).getText();
			if(year.equals(month)) 
			{
				break ;
			}
			
			else
			{
				driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[2]")).click();
				
			}
		}
		
		List <WebElement>  dates = driver.findElements(By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr/td"));
		
		for(WebElement alldates:dates) {
			if (alldates.getText().equals(Day)) {
				
				alldates.click();
				break;
			}
			
			
		}
		
		
		
		
		//driver.findElement(By.cssSelector("input#mat-input-13")).sendKeys("9/9/1999");
		//driver.findElement(By.xpath("//div[text()='5']")).click();
		driver.findElement(By.cssSelector("button.dropbtn.btn")).click();
		driver.findElement(By.xpath("//span[text()='Bangladesh ']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Telephone Number Private']")).sendKeys(userPhoneString);
		
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("mat-select#mat-select-4")).click();
		
		//dropdown list for selecting Basic
		
		List <WebElement> datas = driver.findElements(By.cssSelector("span.mat-option-text"));
		
		for(WebElement data:datas) {
			if (data.getText().equals(department)) {
				
				data.click();
				break;
				
			}
			
			
		}
		
		
		
		
	    //driver.findElement(By.xpath("//span[text()='BASIC']")).click();
		     
	    // scroldown
		WebElement BC= driver.findElement(By.xpath("//span[text()=' Continue ']"));
		js.executeScript("arguments[0].scrollIntoView(true)", BC);
		BC.click();
		Thread.sleep(2000);
		
		//Verify assertion
		String AR =driver.findElement(By.xpath("//span[text()='Created Employee Successfully']")).getText();
		
		String expectedResut = "Created Employee Successfully";
		Assert.assertEquals(AR, expectedResut);
		//System.out.println(Ra);
		Thread.sleep(6000);
	}*/
	
	/*@Feature("UAM")
	@Story("Go back to UAM")
	@Description("verifying datas ")
	
	@Test(priority=4)
	public void verifydata() throws InterruptedException {
		
	driver.get("https://stage-delta.selise.biz/employee/b74611be-a5f3-2e16-66ef-8a0e42c99416/directory/generalinformation");	
	
	Thread.sleep(6000);
	
	
		
	//verify email
	String getEmail = driver.findElement(By.xpath("//*[@id=\"general-information\"]/div[3]/div[5]/div[2]")).getText();
	
	//System.out.println(l);
	
	if (getEmail.equals(userEmailString))
		
		{System.out.println("Email id matched");}
	else 
		{System.out.println("Matched Not  found");}
	
	//verify department
	 String getDepartment = driver.findElement(By.xpath("//div[@class='general-information-section']//div[@class='py-8'][5]//div[normalize-space()][2]")).getText();
	
	  
	   //System.out.println(getDepartment);
	   
	   if (getDepartment.equals(department))
			
			System.out.println("Departament matched");
		else 
			System.out.println("Department not matched");
	
	
	
	//verify phone number
	String getPhone = driver.findElement(By.xpath("//*[@id=\"general-information\"]/div[3]/div[2]/div[2]/app-call-note3cx/span")).getText();
	//System.out.println(getPhone);
	
   if (getPhone.contains(userPhoneString))
		
		{System.out.println("Phone number matched");}
	else 
		{System.out.println("Phone number not found");}
   
 
   
   
   //verfy the display name
   
   String getdiplayname = driver.findElement(By.xpath("//div[@class='name mr-16']")).getText();
   
   //System.out.println(getdiplayname);
   //System.out.println(displaynameString);
	
  /* if (getdiplayname.equals(firstnameString +lastnameString +))
		
		System.out.println("first name matched");
	else 
		System.out.println("displayname not matched");*/
   
   //if (getdiplayname.contains(firstnameString))
		
		//System.out.println("dispaly name matched");
	//else 
		//System.out.println("display name not matched");
   
   //Assert.assertEquals(getdiplayname, firstnameString );
   

	//}
	
	
   
	//Assert.assertEquals(l, userEmailString, "Email id matched");
	
	//String  actualTelephone = driver.findElement(By.xpath("//*[@id=\"general-information\"]/div[3]/div[2]/div[2]/app-call-note3cx/span")).getText();
	
	//System.out.println(actualTelephone);
	
	//Assert.assertEquals(actualTelephone, expectedtelephone);
	
	//Assert.assertEquals(false, null)	
		
	
	
	//@Feature("UAM")
	//@Story("Go back to UAM")
	//@Description("Search by name in UAM search box ")
	
	//@Test(priority=4)
	
	//public void clickUam() throws InterruptedException {
	
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//span[text()='User Management']")).click();
		//driver.findElement(By.xpath("//span[text()='UAM']")).click();
		
		//Thread.sleep(3000);
		//search by display name
		//driver.findElement(By.xpath("//input[@placeholder=\"Search display name\"]")).click();
		//driver.findElement(By.xpath("//input[@placeholder=\"Search display name\"]")).sendKeys("Sa");
		
	//}
	
	
	
}
