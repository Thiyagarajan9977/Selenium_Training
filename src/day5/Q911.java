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

public class Q911 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.homedepot.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions a = new Actions(driver);
		
		WebElement Dep= driver.findElement(By.xpath("(//a[@data-id='departmentsFlyout'])[1]"));
		a.moveToElement(Dep).perform();
		
		WebElement heat = driver.findElement(By.xpath("(//a[@title='Heating & Cooling'])[1]"));
		a.moveToElement(heat).perform();
		
		WebElement air = driver.findElement(By.xpath("//a[@title='Air Conditioners']"));
		a.moveToElement(air).perform();
		
		WebElement port = driver.findElement(By.xpath("//a[@title='Portable Air Conditioners']"));
		port.click();
		
		Thread.sleep(2000);
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("D:\\se\\Selenium\\Day5\\Q11.png");
		FileUtils.copyFile(src, des);
		
		driver.quit();
		
	
	}
}
