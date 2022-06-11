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

public class Q912 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.shopclues.com/wholesale.html ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		WebElement searchplace = driver.findElement(By.id("autocomplete"));
		searchplace.sendKeys("Watches");
		
		WebElement search= driver.findElement(By.xpath("//a[@class='srch_action btn orange']"));
		search.click();
		
		WebElement select = driver.findElement(By.xpath("(//img[@onclick='homePageTracking(this);'])[2]"));
		select.click();
		
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("D:\\se\\Selenium\\Day4\\Q912.png");
		FileUtils.copyFile(src, des);
		
		driver.quit();
		
	}
}
