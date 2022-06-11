package day9;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Q9 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// **********Select refname = new Select(Webelement elment);************

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("testthiyag");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("BCFK21");

		WebElement login = driver.findElement(By.id("login"));
		login.click();

		WebElement room = driver.findElement(By.id("room_type"));
		Select s2 = new Select(room);
		List<WebElement> all = s2.getOptions();
		
		for (int i = 0; i < all.size(); i++) {
			
			WebElement val = all.get(i);
			System.out.println(val.getText());
		}
		
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		
		File des = new File("D:\\se\\Selenium\\Day9\\Q9.png");
		FileUtils.copyFile(src, des);

		driver.quit();
	}
}
