package day2;

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

public class Q4 {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://infinity.icicibank.com/corp/Login.jsp");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement txtuserid = driver.findElement(By.name("DUMMY1"));
		txtuserid.click();

		WebElement findElement = driver.findElement(By.name("AuthenticationFG.USER_PRINCIPAL"));
		findElement.sendKeys("Testing");

		WebElement findElement2 = driver.findElement(By.name("AuthenticationFG.ACCESS_CODE"));
		findElement2.sendKeys("Testpwd");

		WebElement findElement3 = driver.findElement(By.id("VALIDATE_CREDENTIALS1"));
		findElement3.click();

		Thread.sleep(3000);
		TakesScreenshot tk = (TakesScreenshot) driver;

		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);

		File des = new File("./Day2\\Q4.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");

		System.out.println("Page Opened");

		driver.quit();
	}
}
