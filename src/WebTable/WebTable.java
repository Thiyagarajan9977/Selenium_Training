package WebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTable {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium_Training\\Drivers\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/*
		 * Web Element table = driver.findElement(By.tagName("table")); String tab =
		 * table.getText(); Dimension size = table.getSize();
		 * 
		 * System.out.println("The Size of the table is : " +" " +size);
		 * System.out.println("The Size of the table " +tab);
		 */

		List<WebElement> tables = driver.findElements(By.tagName("tr"));
		int tablesize = tables.size();
		System.out.println(tablesize);

		for (int i = 0; i < tables.size(); i++) {

			WebElement value = tables.get(i);

			for (int j = 0; j < args.length; j++) {

				List<WebElement> tdata = driver.findElements(By.tagName("r=td"));

				WebElement tda = tdata.get(j);

				String tdatatext = tda.getText();

				System.out.println(tdatatext);
			}

		}

		driver.close();

	}

}
