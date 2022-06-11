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

public class Q6 {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.swiggy.com/");

		WebElement txtuserid = driver.findElement(By.xpath("//input[@id='location']"));
		txtuserid.sendKeys("Tambaram");
		
		WebElement findfood = driver.findElement(By.xpath("//span[contains(text(),'FIND FOOD')]"));
		findfood.click();
		
		Thread.sleep(3000);
		TakesScreenshot tk = (TakesScreenshot)driver;
		
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		
		File des = new File("./Day2\\Q6.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");

		System.out.println("Page Opened");
		
		driver.quit();
	}
}
