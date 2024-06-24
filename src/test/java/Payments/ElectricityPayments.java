package Payments;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ElectricityPayments 
{
	WebDriver driver;
	private String zoom_out_script;
	
	@BeforeTest
	public void electricity()
	{
		System.out.println("Hello Boss do you want to check this month current Bill ? ");
		
	}

	@Test(priority = 0)
	public void browserinitiation()
	{
		/*
		 		Any error in testng installation goto help > install new software > put the below link in workwith:
		 		https://testng.org/testng-eclipse-update-site/
				
				
				WebDriver driver;
		
				//Setting system properties of ChromeDriver 
				System.setProperty("webdriver.chrome.driver", "D:\\BStackDemo\\chromedriver.exe");
		
				//Creating an object of ChromeDriver
				driver = new ChromeDriver();
		
				//launching the specified URL 
				driver.get("https://bstackdemo.com/");WebDriver driver;
		
				//Setting system properties of ChromeDriver 
				System.setProperty("webdriver.chrome.driver", "D:\\BStackDemo\\chromedriver.exe");
		
				//Creating an object of ChromeDriver
				driver = new ChromeDriver();
		
				//launching the specified URL 
				driver.get("https://bstackdemo.com/");
		
		
		 */	
		driver = new ChromeDriver();
		driver.get("https://payments.billdesk.com/MercOnline/CPDCLAPPGController");
		driver.manage().window().maximize();
		
		
	}
	
	@Test(priority = 1)
	
	public void billdetails() throws InterruptedException
	{
		
		System.out.println("Enter the Service number : \n");
		System.out.println("Press 1 for '4455202001917' \nPress 2 for '4411142028230'");
		
		int a;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your preference : ");
		a = scan.nextInt();
		System.out.println("you have entered : "+a);
		
		switch(a)
		{
			case 1: System.out.println("Selected Service number is 4455202001917");
					Thread.sleep(4000);
					
					WebElement textbox = driver.findElement(By.xpath("//*[@id='txtCustomerID']"));
					textbox.click();
					textbox.sendKeys("4455202001917");
					System.out.println("Enter the Capcha and select a key and click on enter");
					Scanner sc = new Scanner(System.in);
					 sc.nextInt();
					driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/input")).click();
					
					
			
			case 2: System.out.println("Selected Service number is 4411142028230");
					WebElement textbox1 = driver.findElement(By.xpath("//*[@name='txtCustomerID']"));
					Thread.sleep(4000);
					textbox1.click();
					textbox1.sendKeys("4411142028230");
					System.out.println("Enter the Capcha and enter a integer key and click on enter");
					Scanner nis = new Scanner(System.in);
					nis.nextInt();
					driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/input")).click();
					
		}
		
	}
	
	
	
	@Test(priority = 2)
	public void bill()
	{
		String sno = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/table/tbody/tr[1]")).getText();
		String CName = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/table/tbody/tr[3]")).getText();
		String div = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/table/tbody/tr[4]")).getText();
		String Arrear = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/table/tbody/tr[6]")).getText();
		String Current = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/table/tbody/tr[7]")).getText();
		String ACD = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/table/tbody/tr[8]")).getText();
		String Reconnection = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/table/tbody/tr[9]")).getText();
		String Billdate = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/table/tbody/tr[10]")).getText();
		String Duedate = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/table/tbody/tr[11]")).getText();
		String disconnectiondate = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/table/tbody/tr[12]")).getText();
		String advancepayment = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/table/tbody/tr[13]")).getText();


		System.out.println(sno);
		System.out.println(CName);
		System.out.println(div);
		System.out.println(Arrear);
		System.out.println(Current);
		System.out.println(ACD);
		System.out.println(Reconnection);
		System.out.println(Billdate);
		System.out.println(Duedate);
		System.out.println(disconnectiondate);
		System.out.println(advancepayment);

	}
	
	@Test(priority = 3)
	public void screenshot() throws IOException, InterruptedException
	{
		((JavascriptExecutor)driver).executeScript("document.body.style.zoom='80%'");
		
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		
		//File DestFile=new File("./AutomationSelenium/Screenshots/screenshot1.jpg");
		//Copy file at destination
		FileUtils.copyFile(SrcFile, new File("./Screenshots/s2.jpg"));
		  System.out.println("Screenshot taken and saved successfully.");
		  
		  Thread.sleep(9000);
		
	}
	
	@AfterTest
	public void Quit() 
	{
		  driver.quit();
		
	}
}
