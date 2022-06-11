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

public class Q9 {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement login = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		login.click();

		WebElement enteremail = driver.findElement(By.xpath("//input[@class='_2IX_2- _2LYh3d VJZDxU']"));
		enteremail.sendKeys("9791889978");

		WebElement enterpass = driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
		enterpass.sendKeys("123456");
		
		login.click();
		TakesScreenshot tk = (TakesScreenshot) driver;
		Thread.sleep(2000);
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("./Day3\\Q9.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		System.out.println("Page Opened");
		driver.quit();
	}
}
