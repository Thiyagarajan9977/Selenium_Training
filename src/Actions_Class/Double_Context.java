package Actions_Class;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Double_Context {

	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium_Training\\Drivers\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Actions a = new Actions(driver);

		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("thiyagarajan");

		a.doubleClick(username).perform();

		Robot r = new Robot();

		a.contextClick(username).perform();

		for (int i = 1; i <= 4; i++) {

			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		a.contextClick(username).perform();

		for (int i = 1; i <= 6; i++) {

			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
