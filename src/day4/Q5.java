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

public class Q5 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.greenstechnologys.com/");

		driver.manage().deleteAllCookies();
		
		WebElement gettxt0 = driver.findElement(By.xpath("//p[contains(text(),' Training ')][1]"));
		String text0 = gettxt0.getText();
		System.out.println(text0);
		

		Thread.sleep(3000);
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("./Day4\\Q5.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		System.out.println("Page Opened");
		driver.quit();
	}
}