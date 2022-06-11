package day4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q8 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebElement usrname	= driver.findElement(By.name("username"));
		usrname.sendKeys("thiyaguji@yahoo.com");
		String getvalue = usrname.getAttribute("value");
		System.out.println(getvalue);
		
		WebElement usrpwd	= driver.findElement(By.name("password"));
		usrpwd.sendKeys("9876543210");
		String getpwd = usrpwd.getAttribute("value");
		System.out.println(getpwd);

	
		Thread.sleep(1000);
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("./Day4\\Q8.png");
		FileUtils.copyFile(src, des);

		System.out.println("Done");
		System.out.println("Page Opened");
		driver.quit();
	}
}