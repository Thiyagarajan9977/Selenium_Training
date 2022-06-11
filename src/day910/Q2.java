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

public class Q2 {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement search = driver.findElement(By.id("inputValEnter"));
		search.sendKeys("iphone 7", Keys.ENTER);

		WebElement iphone = driver.findElement(By.xpath("//img[contains(@title,'iPhone 7 Soft Silicon Cases O4U - Blu')]"));
		iphone.click();
		
		String parID = driver.getWindowHandle();
		System.out.println(parID);

		// All ID
		Set<String> allID = driver.getWindowHandles();
		System.out.println(allID);

		for (String eachID : allID) {
			if (!parID.equals(eachID)) {
				driver.switchTo().window(eachID);
			}
		}
		
		Thread.sleep(3000);
		WebElement price = driver.findElement(By.xpath("//span[contains(text(),'buy now')]"));
		price.click();
		
		WebElement pay = driver.findElement(By.xpath("(//span[contains(text(),'Rs. 251')])[2]"));
		System.out.println(pay);
		

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day910\\Q2.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		driver.quit();

	}
}
