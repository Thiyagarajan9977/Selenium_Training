package BrowserLaunch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium_Training\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		
		WebElement findElement = driver.findElement(By.xpath("//a[@title='English (UK)']"));
		
		System.out.println(findElement.getText());
		
		findElement.click();
				
		System.out.println("Browser Launched Sucessfully");
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		WebElement findElement2 = driver.findElement(By.id("email"));
		findElement2.sendKeys("thiyaguji@yahoo.com");
		
		System.out.println(findElement2.getAttribute("value"));
				
		driver.close();
	}
	
}
