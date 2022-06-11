package day3;

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
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		searchbox.sendKeys("Thiyagarajan");

		WebElement clickbox = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		clickbox.sendKeys("Rajasudhakar");

		WebElement clicklogin = driver.findElement(By.xpath("//textarea[contains(@class,'form-control')]"));
		clicklogin.sendKeys("Address");

		WebElement email = driver.findElement(By.xpath("//input[contains(@type,'email')]"));
		email.sendKeys("tyagu089@gmail.com");

		WebElement phone = driver.findElement(By.xpath("//input[contains(@type,'tel')]"));
		phone.sendKeys("9791889978");

		WebElement pwd = driver.findElement(By.xpath("//input[contains(@id,'firstpassword')]"));
		pwd.sendKeys("123456789");

		WebElement pwd2 = driver.findElement(By.xpath("//input[contains(@id,'secondpassword')]"));
		pwd2.sendKeys("123456789");

		WebElement submit = driver.findElement(By.xpath("//button[contains(@id,'submitbtn')]"));
		submit.click();

		TakesScreenshot tk = (TakesScreenshot) driver;
		Thread.sleep(2000);
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("./Day3\\Q3.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		System.out.println("Page Opened");
		driver.quit();
	}
}
