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

public class Q4 {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		WebElement searchbox = driver.findElement(By.id("firstName"));
		searchbox.sendKeys("Thiyagarajan");

		WebElement clickbox = driver.findElement(By.id("lastName"));
		clickbox.sendKeys("Rajasudhakar");

		WebElement clicklogin = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
		clicklogin.sendKeys("tyagu089@gmail.com");

		WebElement phone = driver.findElement(By.xpath("//input[contains(@id,'userNumber')]"));
		phone.sendKeys("9791889978");

		WebElement submit = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		submit.sendKeys("Address");

		WebElement submit1 = driver.findElement(By.xpath("//button[@id='submit']"));
		submit1.click();

		TakesScreenshot tk = (TakesScreenshot) driver;
		Thread.sleep(2000);
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("./Day3\\Q4.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		System.out.println("Page Opened");
		driver.quit();
	}
}
