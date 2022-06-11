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

public class Q3 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.greenstech.in/selenium-course-content.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		WebElement gettxt0 = driver.findElement(By.xpath("(//h6[contains(text(),'Greens Technology ')])[1]"));
		String text0 = gettxt0.getText();
		System.out.println(text0);

		WebElement gettxt = driver.findElement(By.xpath("//span[contains(text(),'No:11,')]"));
		String text = gettxt.getText();
		System.out.println(text);

		WebElement gettxt1 = driver.findElement(By.xpath("//span[contains(text(),'First Street,')]"));
		String text1 = gettxt1.getText();
		System.out.println(text1);

		WebElement gettxt2 = driver.findElement(By.xpath("//span[contains(text(),'padmanabha Nagar,')]"));
		String text2 = gettxt2.getText();
		System.out.println(text2);

		WebElement gettxt3 = driver.findElement(By.xpath("//span[contains(text(),'Adyar,')]"));
		String text3 = gettxt3.getText();
		System.out.println(text3);

		WebElement gettxt4 = driver.findElement(By.xpath("//span[contains(text(),'Chennai-600 020.')]"));
		gettxt4.getText();

		Thread.sleep(3000);
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("./Day4\\Q3.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		System.out.println("Page Opened");
		driver.quit();

	}
}
