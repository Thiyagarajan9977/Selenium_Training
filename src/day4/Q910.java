package day4;

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

public class Q910 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		WebElement close = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		close.click();

		WebElement sendvalue = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		sendvalue.sendKeys("mobiles");

		Thread.sleep(2000);

		WebElement search = driver.findElement(By.xpath("//button[@type='submit']"));
		search.click();

		WebElement retry = driver.findElement(By.xpath("//span[contains(text(),'RETRY')]"));
		retry.click();

		Thread.sleep(2000);

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("D:\\se\\Selenium\\Day4\\Q910.png");
		FileUtils.copyFile(src, des);

		WebElement phoneselect = driver.findElement(By.xpath("(//img[@class='_396cs4 _3exPp9'])[1]"));
		phoneselect.click();

	}
}
