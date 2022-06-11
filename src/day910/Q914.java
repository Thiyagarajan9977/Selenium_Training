package day910;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q914 {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://greenstech.in/selenium-course-content.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement search = driver.findElement(By.xpath("//h2[contains(text(),'Framework Test Papers')]"));
		search.click();

		WebElement win = driver.findElement(By.xpath("//a[contains(text(),' TESTNG')]"));
		win.click();

		String parID = driver.getWindowHandle();

		Set<String> allID = driver.getWindowHandles();

		for (String eachID : allID) {
			if (!parID.equals(eachID)) {
				driver.switchTo().window(eachID);
			}
		}

		WebElement tag = driver.findElement(By.tagName("pre"));
		String text2 = tag.getText();
		int a = text2.indexOf("QUESTION 4");
		int b = text2.indexOf("QUESTION 5");
		System.out.println(a);
		System.out.println(b);
		
		for (int i = 2021 ; i < 2214; i++) {
			
			System.out.print(text2.charAt(i));
			
		}
		
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day10\\Q14.png");
		FileUtils.copyFile(src, des);

		Thread.sleep(4000);

		driver.quit();
	}
}
