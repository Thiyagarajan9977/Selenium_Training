package day910;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q4 {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://greenstech.in/selenium-course-content.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement sel = driver.findElement(By.xpath("//h2[contains(text(),'Selenium Test Paper')]"));
		sel.click();

		WebElement dayten = driver.findElement(By.xpath("//a[contains(text(),' DAY 10 TASK')]"));
		dayten.click();

		System.out.println(driver.getCurrentUrl());

		String parID = driver.getWindowHandle();

		// All ID
		Set<String> allID = driver.getWindowHandles();

		for (String eachID : allID) {
			if (!parID.equals(eachID)) {
				driver.switchTo().window(eachID);
			}
		}
		Thread.sleep(4000);

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day10\\Q4.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		driver.quit();

	}
}
