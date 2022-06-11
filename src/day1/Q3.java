package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Q3 {

	public static void main(String[] args) {

		System.out.println("IE  Brower Launching");

		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\IEDriverServer.exe");

		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://www.greenstechnologys.com/");

		String cu = driver.getCurrentUrl();
		System.out.println(cu);

		String t = driver.getTitle();
		System.out.println(t);

		driver.quit();

	}

}
