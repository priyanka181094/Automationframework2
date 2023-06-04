package com.githubpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Mock1 {
	
	
	@Parameters("browser")
	
@Test(groups="SmokeSuite")
	public void olympic(String browser) throws EncryptedDocumentException, IOException
	{
	
	

	 
//	  String BROWSER=System.getProperty("browser");
//	  String URL=System.getProperty("url");
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
	
	
	driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
	driver.findElement(By.xpath("//button[text()='Yes, I am happy']")).click();
	WebElement wb=driver.findElement(By.xpath("//span[@class='styles__TextContent-sc-1yhswdi-0 kKitTj']"));
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView()",wb);
	//countires
	List<WebElement>allcountries=driver.findElements(By.xpath("//div[@data-cy='table-content']//span[@data-cy='country-name']"));
	//gold medals
	List<WebElement>allgolds=driver.findElements(By.xpath("//div[@data-cy='table-content']//div[@title='Gold']"));
	//silver
	List<WebElement>allsilver=driver.findElements(By.xpath("//div[@data-cy='table-content']//div[@title='Silver']"));
	//bronze
	List<WebElement>allbronze=driver.findElements(By.xpath("//div[@data-cy='table-content']//div[@title='Bronze']"));
	//totalmedals
	List<WebElement>alltotal=driver.findElements(By.xpath("//div[@data-cy='table-content']//div[contains(@data-medal-id,'total')]"));
	
	
	//to write the result in excel
		FileInputStream fis=new FileInputStream("C:\\Users\\Priyanka Ghosh\\OneDrive\\Desktop\\Olympic.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet2");
		
	for(int i=0;i<5;i++)
	{
		
		String countryname=allcountries.get(i).getText();
		String gold=allgolds.get(i).getText();
		String silver=allsilver.get(i).getText();
		String bronze=allbronze.get(i).getText();
		String total=alltotal.get(i).getText();
		
		//for excel
		Row row=sh.createRow(i);
		row.createCell(0).setCellValue(countryname);
		row.createCell(1).setCellValue(gold);
		row.createCell(2).setCellValue(silver);
		row.createCell(3).setCellValue(bronze);
		row.createCell(4).setCellValue(total);
		//to write in console
		String result=allcountries.get(i).getText()+".."+allgolds.get(i).getText()+".."+allsilver.get(i).getText()+".."+allbronze.get(i).getText()+".."+alltotal.get(i).getText();
		System.out.println(result);
	}
	FileOutputStream fos=new FileOutputStream("C:\\Users\\Priyanka Ghosh\\OneDrive\\Desktop\\Olympic.xlsx");
	book.write(fos);
	fos.flush();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	

}
}
