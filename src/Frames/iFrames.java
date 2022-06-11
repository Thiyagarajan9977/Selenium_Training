package Frames;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class iFrames {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium_Training\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://letcode.in/test"); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//a[@href='/frame']")).click();
		
		/*
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		
		WebElement frames = driver.findElement(By.xpath("(//a[@class='card-footer-item'])[1]"));
		js.executeAsyncScript("arguments[0].scrollintoView", frames);
		
		*/
		
		/*
		
		List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		
		for (int i = 0; i < findElements.size(); i++) {
			
			System.out.println(findElements.get(i));			
		}
		
		WebElement singleframe = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		driver.switchTo().frame(singleframe);
		
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='text']"));
		WebElement webElement = list.get(0);
		webElement.sendKeys("SingleFrame");
		
		System.out.println("Entered into SingleFrame");
		
		driver.switchTo().parentFrame();
		
		WebElement Innerframe = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
		Innerframe.sendKeys("InnerFrame");
		
		List<WebElement> list2 = driver.findElements(By.xpath("//iframe[@src='SingleFrame.html']"));
		WebElement webElement2 = list2.get(0);
		driver.switchTo().frame(webElement2);
		
		List<WebElement> sendkey = driver.findElements(By.xpath("//input[@type='text']"));
		WebElement sendkey1 = list.get(0);
		
		sendkey1.sendKeys("InnerFrame");*/
		
		
		
	}

}
