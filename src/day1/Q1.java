package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Q1 {
	
	public static void main(String[] args) {
			
		System.out.println("FireFox Brower Launching");
		
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.greenstechnologys.com/");
		driver.get("https://www.facebook.com/");
		driver.get("https://www.amazon.in");
		driver.get("http://greenstech.in/selenium-course-content.html");
		
		String cu = driver.getCurrentUrl();
		System.out.println(cu);
		
		String t = driver.getTitle();
		System.out.println(t);
		
		driver.quit();
		
	}
	

}
