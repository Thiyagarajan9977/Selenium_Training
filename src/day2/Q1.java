package day2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1 {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();	
		
		WebElement txtusername = driver.findElement(By.id("email"));
		
		txtusername.sendKeys("thiyaguji@yahoo.com");
		
		WebElement txtpassword = driver.findElement(By.id("pass"));
		
		txtpassword.sendKeys("123456789@");
		
		TakesScreenshot tk = (TakesScreenshot)driver;
		
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		
		WebElement txtbutton = driver.findElement(By.name("login"));
			
		txtbutton.click();	
		
		File des = new File("./Day2\\Q1.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");

		System.out.println("Page Opened");
		
		driver.quit();
	}

}
