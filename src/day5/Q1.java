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

public class Q1 {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions a = new Actions(driver);
		
		WebElement amount = driver.findElement(By.xpath("(//li[@class='block13 ui-draggable'])[1]"));		
		WebElement Bank = driver.findElement(By.id("credit2"));		
		WebElement Sales = driver.findElement(By.id("credit1"));	
		WebElement debitamount = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));		
		WebElement creditamount = driver.findElement(By.xpath("(//li[@class='placeholder'])[4]"));
		
		WebElement debitaccount = driver.findElement(By.id("bank"));
		WebElement creditaccount = driver.findElement(By.id("loan"));
		
		a.dragAndDrop(amount, debitamount).dragAndDrop(amount, creditamount).build().perform();
		Thread.sleep(2000);
		a.dragAndDrop(Bank, debitaccount).dragAndDrop(Sales, creditaccount).build().perform();
				
		Thread.sleep(2000);
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("D:\\se\\Selenium\\Day5\\Q1.png");
		FileUtils.copyFile(src, des);
		
	
	}
}
