package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q2 {

	public static void main(String[] args) {

		System.out.println("chrome Brower Launching");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.greenstechnologys.com/");
		driver.get("http://gmail.com/");
		driver.get("http://www.flipkart.com/");
		driver.get("http://greenstech.in/selenium-course-content.html");

		String cu = driver.getCurrentUrl();
		System.out.println(cu);

		String t = driver.getTitle();
		System.out.println(t);

		driver.quit();

	}

}
