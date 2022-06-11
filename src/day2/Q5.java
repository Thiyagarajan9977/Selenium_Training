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

public class Q5 {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://netbanking.hdfcbank.com/ ");

		WebElement iframe = driver.findElement(By.xpath("//frame[@name='login_page']"));
		driver.switchTo().frame(iframe);

		WebElement userid = driver.findElement(By.xpath("//input[@name='fldLoginUserId']"));
		userid.sendKeys("26272097");

		WebElement con = driver.findElement(By.xpath("(//img[@alt='continue'])[1]"));
		con.click();

		WebElement password = driver.findElement(By.xpath("//input[@name='fldPassword']"));
		password.sendKeys("password");

		WebElement chk = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		chk.click();

		WebElement conclick = driver.findElement(By.xpath("(//img[@alt='Login'])[1]"));
		conclick.click();

		Thread.sleep(3000);
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);

		File des = new File("./Day2\\Q5.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		System.out.println("Page Opened");
		driver.quit();
	}
}
