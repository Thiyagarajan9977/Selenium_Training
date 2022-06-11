package day3;

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

public class Q911 {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstName']"));
		firstname.sendKeys("Rajasudhakar");

		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastName']"));
		lastname.sendKeys("Thiyagarajan");

		WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
		email.sendKeys("testsamplemailaddress");

		WebElement pwd = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
		pwd.sendKeys("789963@rT");

		WebElement cnfpwd = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
		cnfpwd.sendKeys("789963@rT");

		WebElement next = driver.findElement(By.xpath("(//div[@class='VfPpkd-RLmnJb'])[2]"));
		next.click();

		TakesScreenshot tk = (TakesScreenshot) driver;
		Thread.sleep(2000);
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("./Day3\\Q911.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		System.out.println("Page Opened");
		driver.quit();
	}
}
