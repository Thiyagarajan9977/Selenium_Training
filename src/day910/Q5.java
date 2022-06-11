package day910;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Q5 {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.greenstechnologys.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Actions a = new Actions(driver);
		Robot r = new Robot();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement course = driver.findElement(By.xpath("//a[contains(text(),'COURSES')]"));
		a.moveToElement(course).perform();

		WebElement python = driver.findElement(By.xpath("(//span[contains(text(),'Python')])[1]"));
		python.click();

		WebElement pass = driver.findElement(By.xpath("(//button[contains(text(),'Explore Curriculum')])[2]"));
		js.executeScript("arguments[0].scrollIntoView(true)", pass);

		WebElement exp = driver.findElement(By.xpath("(//button[contains(text(),'Explore Curriculum')])[2]"));
		a.contextClick(exp).perform();

		Thread.sleep(2000);

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		String parID = driver.getWindowHandle();
		//driver.switchTo().window(parID);

		Set<String> allID = driver.getWindowHandles();	

		for (String eachID : allID) {
			if (!parID.equals(eachID)) {
				driver.switchTo().window(eachID);
			}
			}

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day10\\Q5.png");
		FileUtils.copyFile(src, des);
		System.out.println("Done");
		driver.quit();

	}
}
