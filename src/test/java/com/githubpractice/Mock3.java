package com.githubpractice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Mock3 {
	
	
	public WebDriver driver;
	@Test
	//@Parameters("browser")
	public void testing()
	{
		
		String BROWSER=System.getProperty("browser");
		WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("Chrome"))
	  {
		 // WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	  }
	  else
	  {
		  //WebDriverManager.edgedriver().setup();
		  	driver=new EdgeDriver();
	  }
	  
	driver.manage().window().maximize();
	  
	
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	


	driver.get("https://www.google.com/");
	//entergoogle

}
}

