package JavaScript_executor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Js_executor {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium_Training\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement changlang = driver.findElement(By.xpath("//a[@title='English (UK)']"));
		changlang.click();
		
		WebElement username = driver.findElement(By.id("email"));
		js.executeScript("arguments[0].setAttribute('value','thiyagu')", username);
		
		WebElement pass = driver.findElement(By.id("pass"));
		js.executeScript("arguments[0].setAttribute('value','12345678')", pass);
		
		Object ob = js.executeScript("return arguments[0].getAttribute('value')", username);
		
		Object pa = js.executeScript("return arguments[0].getAttribute('value')", pass);
		
		String p =(String)pa; 
		
		System.out.println(p);
		
		String s = (String)ob;
		
		System.out.println(s);		
	}
}
