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

public class Q7 {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get("https://www.instagram.com/accounts/login/?hl=en");

		WebElement txtuserid = driver.findElement(By.xpath("//input[@name='username']"));
		txtuserid.sendKeys("testinguserid");

		WebElement txtpwd = driver.findElement(By.xpath("//input[@name='password']"));
		txtpwd.sendKeys("testpassword");

		WebElement login = driver.findElement(By.xpath("(//div[contains(@class,' b')])[1]"));
		login.click();

		Thread.sleep(3000);
		TakesScreenshot tk = (TakesScreenshot) driver;

		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);

		File des = new File("./Day2\\Q7.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");

		System.out.println("Page Opened");

		driver.quit();

	}

}
