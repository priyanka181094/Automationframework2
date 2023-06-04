package com.githubpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mock2 {
	
	
	
	@Parameters("browser")
	@Test(dataProvider="getdata")
	public void createacacount(String firstname,String lastname,String mailid,String password,String date,String month,String year,String browser) throws InterruptedException
	{
		
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("Chrome"))
		  {
			  //WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		  }
		  else
		  {
			  //WebDriverManager.edgedriver().setup();
			  	driver=new EdgeDriver();
		  }
		  
		driver.manage().window().maximize();
		  
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		

	driver.get("https://www.facebook.com/reg");
	
	//login
	
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
	driver.findElement(By.xpath("//input[@ aria-label='Mobile number or email address']")).sendKeys(mailid);
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
////
	WebElement tt=driver.findElement(By.name("reg_email_confirmation__"));
	wait.until(ExpectedConditions.visibilityOf(tt));
	
	tt.sendKeys(mailid);
	
	
	driver.findElement(By.xpath("//input[@aria-label='New password']")).sendKeys(password);
	//birthday
	WebElement wbdate=driver.findElement(By.xpath("//span[@data-type='selectors']//select[@name='birthday_day']"));
	Select s=new Select(wbdate);
	s.selectByValue(date);
	
	
	WebElement wbmon=driver.findElement(By.xpath("//span[@data-type='selectors']//select[@name='birthday_month']"));
	
	
	
	Select s1=new Select(wbmon);
	s1.selectByVisibleText(month);
	
	WebElement wbyear=driver.findElement(By.xpath("//select[@name='birthday_year']"));
	Select s2=new Select(wbyear);
	s2.selectByVisibleText(year);
	
	driver.findElement(By.xpath("//span[@data-name='gender_wrapper']//label[text()='Female']/following-sibling::input[@name='sex']")).click();
	//for signup
	driver.findElement(By.xpath("//title[@id='pageTitle']"));
	
	
	
	}
	
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][]obj=new Object[2][7];
		obj[0][0]="Priyanka";
		obj[0][1]="Roy";
		obj[0][2]="proy12@gmail.com";
	
		obj[0][3]="pri@18";
		obj[0][4]="18";
		obj[0][5]="Jan";
		obj[0][6]="1994";
		
		
		
		obj[1][0]="Suman";
		obj[1][1]="Das";
		obj[1][2]="sdas456@gmail.com";
		
		obj[1][3]="sou@156";
		obj[1][4]="15";
		obj[1][5]="Jul";
		obj[1][6]="1998";
		return obj;
	}
		
		
			
	
	
	

}

