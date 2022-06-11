package day3;

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

public class Q6 {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		
		WebElement searchbox = driver.findElement(By.xpath("//div[@id='signin-block']"));
		searchbox.click();
				
		WebElement signin= driver.findElement(By.xpath("//li[@id='signInLink']"));
		signin.click();
		
		WebElement switchwebelement = driver.findElement(By.xpath("(//iframe[@class='modalIframe'])"));
		driver.switchTo().frame(switchwebelement);
		
		WebElement mobile = driver.findElement(By.id("mobileNoInp"));
		mobile.sendKeys("9791889978");
		
		TakesScreenshot tk = (TakesScreenshot) driver;
		Thread.sleep(2000);
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("./Day3\\Q6.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		System.out.println("Page Opened");
		driver.quit();				
	}
}
