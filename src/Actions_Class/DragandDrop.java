package Actions_Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium_Training\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions a = new Actions(driver);
		
		WebElement src = driver.findElement(By.xpath("//a[text()=' BANK ']"));
		WebElement des = driver.findElement(By.id("bank"));
		a.dragAndDrop(src, des).build().perform();
		
		WebElement src1 = driver.findElement(By.xpath("//li[@id='credit0']//following::li[@id='fourth']"));
		
		WebElement des1 = driver.findElement(By.xpath("//ol[@class='field13 ui-droppable ui-sortable']//following::li[@class='placeholder'][last()-2]"));
				
		a.clickAndHold(src1).release(des1).build().perform();
		
		Thread.sleep(2000);
	}
}
