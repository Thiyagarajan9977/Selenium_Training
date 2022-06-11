package day9;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Q912 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://output.jsbin.com/osebed/2");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// **********Select refname = new Select(Webelement elment);************

		WebElement fruits = driver.findElement(By.id("fruits"));
		Select s4 = new Select(fruits);
		List<WebElement> loc1 = s4.getOptions();

		int total = loc1.size();

		System.out.println("The overall fruits count..." + loc1.size());

		System.out.println("Select Even Option availble in fruits"); 
		
		for (int i = 1; i < loc1.size(); i++) {

			WebElement ret = loc1.get(i);
			String ret1 = ret.getText();

			if (total % 2 == 0) {
				System.out.println(ret1);
				
			}
			total = total - 1;
		}
			
		boolean multiple = s4.isMultiple();
		System.out.println("Is is Multiple Select : "  +multiple);
		
				
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\se\\Selenium\\Day9\\Q12.png");
		FileUtils.copyFile(src, des);

		driver.quit();
	}
}
