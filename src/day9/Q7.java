package day9;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Q7 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// **********Select refname = new Select(Webelement elment);************

		
		WebElement count = driver.findElement(By.name("country"));
		Select s = new Select(count);

		List<WebElement> li = s.getOptions();
		
		System.out.println("The overall value....." +li.size());
		
		for (int i = 0; i < li.size(); i++) {
			WebElement value = li.get(i);
			String val = value.getAttribute("value");
			System.out.println(val);		
			
		}
	}
}
