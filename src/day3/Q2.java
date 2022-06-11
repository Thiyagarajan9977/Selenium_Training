package day3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q2 {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		

		WebElement searchbox = driver.findElement(By.xpath("//input[@name='email']"));
		searchbox.sendKeys("thiyaguji@yahoo.com");

		WebElement clickbox = driver.findElement(By.xpath("//input[@name='pass']"));
		clickbox.sendKeys("9345030174@Fbrt");
		TakesScreenshot tk = (TakesScreenshot) driver;
		Thread.sleep(2000);
		File src = tk.getScreenshotAs(OutputType.FILE);
		
		WebElement clicklogin = driver.findElement(By.xpath("//button[@name='login']"));
		clicklogin.click();
		
		System.out.println(src);
		File des = new File("./Day3\\Q2.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		System.out.println("Page Opened");
		driver.quit();
		
	}
}
	