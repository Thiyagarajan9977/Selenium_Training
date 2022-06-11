package Windows_Handling;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Windows_Handle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium_Training\\Drivers\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//closebutton
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

		//phonesearch
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Iphone");

		//searchclick
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		System.out.println("FirstTitle :" + driver.getTitle());

		
		//iphoneselection
		WebElement iphone = driver.findElement(By.xpath("//div[text()='APPLE iPhone 11 (Black, 64 GB)']"));
		iphone.click();

		// String old = driver.getWindowHandle();

		Set<String> setlist = driver.getWindowHandles();

		for (String newlist : setlist) {

			driver.switchTo().window(newlist);
		}

		Thread.sleep(3000);

		WebElement add = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));

		add.click();

		System.out.println("Final " + driver.getTitle());

		Set<String> all = driver.getWindowHandles();

		ArrayList<String> s = new ArrayList<String>(all);
		
		
		

	}

}
