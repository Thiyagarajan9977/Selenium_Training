package Dropdown;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Drop_Down {
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium_Training\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@title='English (UK)']")).click();
		
		
		//click create account
		
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		
		WebElement month = driver.findElement(By.id("month"));
				
		Select s = new Select(month);
		s.selectByIndex(2);
		
		s.selectByValue("4");
		
		s.selectByVisibleText("Dec");
		
		List<WebElement> options = s.getOptions();
		
		for (int i = 0; i < options.size(); i++) {
			
			WebElement each = options.get(i);
			
			System.out.println(each.getText());					
		}
		
		TakesScreenshot tk = (TakesScreenshot)driver;
		File a = tk.getScreenshotAs(OutputType.FILE);		
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\Selenium_Training\\Utilities\\screenshrtos.png"+System.nanoTime());
		FileUtils.copyFile(a, f);		
		System.out.println("Done");		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		
		WebElement year = driver.findElement(By.id("year"));
		Select s1 = new Select(year);
		s.selectByValue("2018");
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
