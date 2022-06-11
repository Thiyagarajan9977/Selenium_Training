package day4;
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

public class Q911 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		WebElement userid 	= driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
		userid.sendKeys("9791889978");
		
		String getmobile = userid.getAttribute("value");
		System.out.println(getmobile);
		
		WebElement password= driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
		password.sendKeys("flipkartpassword");

		String getpass = password.getAttribute("value");
		System.out.println(getpass);
		
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("D:\\se\\Selenium\\Day4\\Q911.png");
		FileUtils.copyFile(src, des);
		
		driver.quit();
		
	}
}
