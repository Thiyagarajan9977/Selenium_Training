package TakeScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.greenstechnologys.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement Porur = driver.findElement(By.xpath("//span[contains(text(),'Greens Technologies Porur')]"));
		js.executeScript("arguments[0].scrollIntoView(true)", Porur);		
		List<WebElement> porurtag = driver.findElements(By.tagName("p"));
		int size = porurtag.size();
		System.out.println(size);
		
		WebElement a = porurtag.get(9);		
		String text = a.getText();
		System.out.println(text);

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day12\\Q1.png");
		FileUtils.copyFile(src, des);

		driver.quit();

	}

}
