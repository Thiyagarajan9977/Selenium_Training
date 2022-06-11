package day8;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q3 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement alertclick = driver.findElement(By.xpath("//a[@href='#Textbox']"));
		alertclick.click();

		WebElement cnfmalert = driver.findElement(By.xpath("//button[@onclick='promptbox()']"));
		cnfmalert.click();
		
		Alert ca = driver.switchTo().alert();
		System.out.println(ca.getText());
		ca.sendKeys("Thiyagu");
		ca.accept();
				
		Thread.sleep(3000);

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day8\\Q3.png");
		FileUtils.copyFile(src, des);

		driver.quit();

	}

}
