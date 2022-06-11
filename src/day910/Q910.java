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

public class Q910 {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement close = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		close.click();

		WebElement search = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		search.sendKeys("mask ", Keys.ENTER);

		WebElement refresh = driver.findElement(By.xpath("//button[@class='_3CGxNR']"));
		refresh.click();
		
		WebElement mask = driver.findElement(By.xpath("//img[contains(@alt,'Nea N95 / KN95 FFP2 5 ')]"));
		mask.click();

		String parID = driver.getWindowHandle();

		Set<String> allID = driver.getWindowHandles();

		for (String eachID : allID) {
			if (!parID.equals(eachID)) {
				driver.switchTo().window(eachID);
			}
		}

		WebElement pin = driver.findElement(By.id("pincodeInputId"));
		pin.sendKeys("600126", Keys.ENTER);
		
		Thread.sleep(5000);

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day10\\Q10.png");
		FileUtils.copyFile(src, des);
		
		Thread.sleep(4000);

		driver.quit();
	}
}
