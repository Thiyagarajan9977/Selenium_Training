package day910;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q8 {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/ ");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement search = driver.findElement(By.id("inputValEnter"));
		search.sendKeys("hand sanitizer",Keys.ENTER);
		
		WebElement san = driver.findElement(By.xpath("//img[contains(@title,'9lives 70%(v/v) Alcohol Based Hand Sanitizer | 600 ')]"));
		san.click();

		String parID = driver.getWindowHandle();
		// driver.switchTo().window(parID);

		Set<String> allID = driver.getWindowHandles();

		for (String eachID : allID) {
			if (!parID.equals(eachID)) {
				driver.switchTo().window(eachID);
			}
		}
		
		WebElement add = driver.findElement(By.xpath("//span[contains(text(),'add to cart')]"));
		add.click();

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day10\\Q8.png");
		FileUtils.copyFile(src, des);

		driver.quit();
	}
}
