package day2;

import java.io.File;
import java.io.IOException;

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
		driver.manage().window().maximize();

		driver.get("http://demo.automationtesting.in/Register.html");

		WebElement txtuserid = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		txtuserid.sendKeys("Testuser");

		WebElement txtlast = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		txtlast.sendKeys("Textlastname");

		WebElement txtadd = driver.findElement(By.xpath("//textarea[contains(text(),'')]"));
		txtadd.sendKeys("Address");

		WebElement txtemail = driver.findElement(By.xpath("//input[@type='email']"));
		txtemail.sendKeys("thiyaguji@yahoo.com");

		WebElement txttel = driver.findElement(By.xpath("//input[@type='tel']"));
		txttel.sendKeys("9791889978");

		WebElement txtpwd = driver.findElement(By.xpath("//input[contains(@id,'firstpassword')]"));
		txtpwd.sendKeys("firstpassword");

		WebElement txtpwd2 = driver.findElement(By.xpath("//input[contains(@id,'secondpassword')]"));
		txtpwd2.sendKeys("secondpassword");

		System.out.println("All the text field entered");

		Thread.sleep(3000);
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("./Day2\\Q9.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		System.out.println("Page Opened");
		driver.quit();
	}
}
