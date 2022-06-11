package day2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q910 {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("http://adactinhotelapp.com/");

		WebElement txtuserid = driver.findElement(By.id("username"));
		txtuserid.sendKeys("Testuser");
		
		WebElement txtpwd = driver.findElement(By.id("password"));
		txtpwd.sendKeys("password");
		
		Thread.sleep(3000);
		TakesScreenshot tk = (TakesScreenshot)driver;
		
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		
		File des = new File("./Day2\\Q910.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");

		System.out.println("Page Opened");
		
		driver.quit();
	}

}
