package day5;

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
import org.openqa.selenium.interactions.Actions;

public class Q915 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Actions a = new Actions(driver);

		WebElement signin = driver.findElement(By.xpath("(//span[@class='nav-line-1 nav-progressive-content'])[2]"));
		a.moveToElement(signin).perform();
		WebElement signin2 = driver.findElement(By.xpath("(//a[text()='Start here.'])[1]"));
		signin2.click();
		WebElement name = driver.findElement(By.id("ap_customer_name"));
		name.sendKeys("Thiyagarajan");
		WebElement phne = driver.findElement(By.id("ap_phone_number"));
		phne.sendKeys("9791889978");
		WebElement email = driver.findElement(By.id("ap_email"));
		email.sendKeys("tyagu089@gmail.com");
		WebElement pwd = driver.findElement(By.id("ap_password"));
		pwd.sendKeys("123456@rT");
		Thread.sleep(2000);
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("D:\\se\\Selenium\\Day5\\Q15.png");
		FileUtils.copyFile(src, des);
		driver.quit();

	}
}
