package day7;

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

public class Q3 {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// TypeCasting
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement accept = driver.findElement(By.xpath("//a[contains(text(),'ACCEPT')]"));
		accept.click();

		WebElement recent = driver.findElement(By.xpath("//span[contains(text(),'Selenium Training Benefit')]"));
		js.executeScript("arguments[0].scrollIntoView(true)", recent);
		System.out.println(recent.getText());
		
		Thread.sleep(2000);

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day7\\Q03.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		driver.quit();

	}

}
