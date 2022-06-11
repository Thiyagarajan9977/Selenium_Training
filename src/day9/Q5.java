package day9;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Q5 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// **********Select refname = new Select(Webelement elment);************

		WebElement create = driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]"));
		create.click();
		WebElement date = driver.findElement(By.id("day"));
		Select s = new Select(date);
		List<WebElement> li = s.getOptions();
		int total = li.size();
		System.out.println("The overall value....." + total);
		for (int i = 0; i < li.size(); i++) {
			WebElement overall = li.get(i);
			if (total % 2 == 0) {
				System.out.println(overall.getText());
			}
			total = total - 1;
		}

	}
}
