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

public class Q9 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		WebElement usrname = driver.findElement(By.name("keyword"));
		usrname.sendKeys("hp");
		String getvalue = usrname.getAttribute("value");
		System.out.println(getvalue);

		WebElement search = driver.findElement(By.xpath("//span[@class='searchTextSpan']"));
		search.click();

		WebElement pincode = driver.findElement(By.xpath("//input[@class='sd-input']"));
		pincode.sendKeys("600126");
		
		WebElement pinchk = driver.findElement(By.xpath("//button[@class='pincode-check']"));
		pinchk.click();

		Thread.sleep(2000);

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("D:\\se\\Selenium\\Day4\\Q9.png");
		FileUtils.copyFile(src, des);

		WebElement product = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
		product.click();

		System.out.println("Done");
		System.out.println("Page Opened");
		driver.quit();
	}
}