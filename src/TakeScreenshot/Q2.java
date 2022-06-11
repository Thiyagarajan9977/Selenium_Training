package TakeScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q2 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement share = driver.findElement(By.xpath("//div[contains(text(),'Share this page')]"));
		js.executeScript("arguments[0].scrollIntoView(true)", share);

		WebElement latest = driver.findElement(By.xpath("//span[contains(text(),'Latest Tutorials')]"));
		js.executeScript("arguments[0].scrollIntoView(true)", latest);

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day12\\Q2.png");
		FileUtils.copyFile(src, des);

		driver.quit();

	}

}
