package day6;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class Q8 {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Robot r = new Robot();
		Actions a = new Actions(driver);
		
		WebElement close = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		close.click();
		
		WebElement login = driver.findElement(By.xpath("//a[@class='_1_3w1N']"));
		login.click();
		
		WebElement email = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
		email.sendKeys("Thiyagarajan");
		
		a.doubleClick(email).perform();
			
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
		
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.click();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		String ret = pass.getAttribute("value");
		System.out.println(ret);		
			
			TakesScreenshot tk = (TakesScreenshot) driver;
			File src = tk.getScreenshotAs(OutputType.FILE);
			System.out.println(src);
			File des = new File("D:\\se\\Selenium\\Day6\\Q8.png");
			FileUtils.copyFile(src, des);
	}
}
