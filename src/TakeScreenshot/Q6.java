package TakeScreenshot;

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

public class Q6 {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		

		WebElement login = driver.findElement(By.xpath("(//span[contains(text(),'Login')])[2]"));
		login.click();
		
		WebElement enteremail = driver.findElement(By.xpath("//input[@class='_2IX_2- _2LYh3d VJZDxU']"));
		enteremail.sendKeys("9791889978");

		WebElement enterpass = driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
		enterpass.sendKeys("123456");
		
		Thread.sleep(5000);

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day12\\Q6.png");
		FileUtils.copyFile(src, des);

		driver.quit();

	}

}
