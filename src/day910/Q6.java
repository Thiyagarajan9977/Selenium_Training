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

public class Q6 {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://greenstech.in/selenium-course-content.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement course = driver.findElement(By.xpath("//h2[contains(text(),'Framework Test Papers')]"));
		course.click();

		WebElement python = driver.findElement(By.xpath("//a[contains(text(),' JUNIT')]"));
		python.click();

		String parID = driver.getWindowHandle();
		// driver.switchTo().window(parID);

		Set<String> allID = driver.getWindowHandles();

		for (String eachID : allID) {
			if (!parID.equals(eachID)) {
				driver.switchTo().window(eachID);
			}
		}

		WebElement question = driver.findElement(By.tagName("pre"));
		String text = question.getText();
		int q = text.indexOf("QUESTION 1");
		int q1 = text.indexOf("QUESTION 2");
		System.out.println(q);
		System.out.println(q1);

		for (int i = 1343; i < 1515; i++) {
			System.out.print(text.charAt(i));
		}

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day10\\Q6.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		driver.quit();

	}
}
