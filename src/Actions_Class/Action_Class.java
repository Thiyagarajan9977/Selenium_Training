package Actions_Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_Class {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium_Training\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://greenstech.in/selenium-course-content.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions a = new Actions(driver);
		
		WebElement course = driver.findElement(By.xpath("//div[@title='Courses']"));
		a.moveToElement(course).perform();
		
		Thread.sleep(1000);
		
		WebElement softTest = driver.findElement(By.xpath("//div[@title='Software Testing']"));
		a.moveToElement(softTest).perform();
		
		Thread.sleep(1000);
		
		WebElement courselect = driver.findElement(By.xpath("//span[text()='Selenium Certification Training']"));
		courselect.click();
		
		System.out.println("working fine");
		
		driver.quit();		
	}

}
