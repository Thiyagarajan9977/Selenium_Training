package Windows_Handling;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Windows_Training {
		
		public static void main(String[] args)  {
			
			System.setProperty("webdriver.gecko.driver", 
					"C:\\Users\\Admin\\eclipse-workspace\\Selenium_Training\\Drivers\\geckodriver.exe");
			
			WebDriver driver = new FirefoxDriver();
			driver.get("http://leafground.com/pages/Window.html");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			WebElement home = driver.findElement(By.id("home"));
			home.click();
			
			String oldwin = driver.getWindowHandle();
			
			Set<String> allwin = driver.getWindowHandles();
			
			for (String newallwin : allwin) {
				
				driver.switchTo().window(newallwin);				
			}
			
			System.out.println("new window opened");
			
			System.out.println(driver.getTitle());
			
			WebElement edit = driver.findElement(By.xpath("//h5[text()='Edit']"));
			edit.click();
			
			driver.close();
			
			driver.switchTo().window(oldwin);
			
			WebElement openMultiwin = driver.findElement(By.xpath("//button[@onclick='openWindows()']"));
			openMultiwin.click();
			
			Set<String> Mulallwin = driver.getWindowHandles();		
			
			System.out.println("Number of Windows Opened : " +Mulallwin.size());
			
			
			WebElement dontclose = driver.findElement(By.id("color"));
			dontclose.click();
			
			Set<String> dontmultiwindow = driver.getWindowHandles();
			
			for (String all : dontmultiwindow) {
				
				if (!all.equals(oldwin)) {
					
					driver.switchTo().window(all);
					
					driver.close();					
				}				
			}
			
		}		
	}
