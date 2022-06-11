package day5;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Q9 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://greenstech.in/selenium-course-content.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions a = new Actions(driver);
		
		WebElement course = driver.findElement(By.xpath("//div[@title='Courses']"));
		a.moveToElement(course).perform();
		
		WebElement rpa = driver.findElement(By.xpath("//div[@title='RPA']"));
		a.moveToElement(rpa).perform();
		
		WebElement blueprism = driver.findElement(By.xpath("//span[contains(text(),'Blue Prism Certification Training')]"));
		blueprism.click();				
		
		Thread.sleep(2000);
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("D:\\se\\Selenium\\Day5\\Q9.png");
		FileUtils.copyFile(src, des);
		
		driver.quit();
		
	
	}
}
