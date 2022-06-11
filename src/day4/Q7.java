package day4;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q7 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		WebElement googletext = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		googletext.sendKeys("greens velmurugan", Keys.ENTER);

		WebElement access = driver.findElement(By.xpath("(//cite[@class='iUh30 Zu0yb qLRx3b tjvcx'])[1]"));

		Thread.sleep(1000);
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("./Day4\\Q7.png");
		FileUtils.copyFile(src, des);

		access.click();

		System.out.println("Done");
		System.out.println("Page Opened");
		driver.quit();
	}
}