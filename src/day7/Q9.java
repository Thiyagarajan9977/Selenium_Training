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

public class Q9 {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement close = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		close.click();

		Thread.sleep(6000);
		
		WebElement txtpass = driver.findElement(By.name("q"));
		
		js.executeScript("arguments[0].setAttribute('value', 'motorolo')", txtpass);
		js.executeScript("return arguments[0].getAttribute('value')", txtpass);		
		
		/*WebElement txtpass = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		Thread.sleep(4000);
		
		js.executeScript("return arguments[0].getAttribute('value')", txtpass);		
		
		System.out.println("Done2");

		Thread.sleep(6000);
		WebElement search = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		js.executeScript("arguments[0].click()", search);

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File desc = new File("D:\\se\\Selenium\\Day7\\Q9.PNG");
		FileUtils.copyFile(src, desc);

		driver.quit();*/
	}

}
