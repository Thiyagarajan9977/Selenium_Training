package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators_Practise {
	
		public static void main(String[] args) {System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium_Training\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//using ID:
		
		WebElement search = driver.findElement(By.id("search_query_top"));
		search.sendKeys("Suite");
		
		// Using Name;
		
		
		
		
		
		
		driver.findElement(By.id("header_logo")).click();
		
		// Using Name:
		
		driver.quit();
		
		}

	
	

}

