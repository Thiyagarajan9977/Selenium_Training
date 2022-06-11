package Alert_Interface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Alert {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium_Training\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		
		WebElement btnsimple = driver.findElement(By.name("alert"));
		btnsimple.click();
		
		Thread.sleep(1000);
				
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		
		driver.switchTo().alert().accept();
		
		WebElement confirm = driver.findElement(By.name("confirmation"));
		confirm.click();
		
		String text1 = driver.switchTo().alert().getText();
		System.out.println(text1);
		
		driver.switchTo().alert().dismiss();
		
		WebElement prompt = driver.findElement(By.name("prompt"));
		prompt.click();
				
		driver.switchTo().alert().sendKeys("Prompted");
		
		driver.switchTo().alert().accept();	
		
		WebElement upload = driver.findElement(By.name("upload"));		
		upload.sendKeys("C:\\Users\\Admin\\Desktop\\wp1.txt");
		
		System.out.println("File Uploaded sucessfully");
		
		
	}

}
