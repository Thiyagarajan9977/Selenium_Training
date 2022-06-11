package day910;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.interactions.Actions;

public class Q1 {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);Actions a = new Actions(driver);

		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("iphone X", Keys.ENTER);

		WebElement iphone = driver.findElement(By.xpath("//img[contains(@alt,'Samsung Galaxy A10s')]"));		
		a.contextClick(iphone).perform();

		Robot r = new Robot();
		
		Thread.sleep(4000);

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(4000);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(4000);

		String parID = driver.getWindowHandle();

		// All ID
		Set<String> allID = driver.getWindowHandles();

		for (String eachID : allID) {
			if (!parID.equals(eachID)) {
				driver.switchTo().window(eachID);
			}
		}				
		Thread.sleep(2000);
		WebElement price = driver.findElement(By.xpath("(//span[contains(text(),'$151.00')])[3]"));
		String text = price.getText();
		System.out.println(text);

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day10\\Q1.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		//driver.quit();

	}
}
