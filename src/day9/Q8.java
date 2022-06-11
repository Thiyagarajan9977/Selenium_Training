package day9;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Q8 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Selenium2\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// **********Select refname = new Select(Webelement elment);************
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("testthiyag");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("BCFK21");
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		WebElement loc = driver.findElement(By.id("location"));
		Select s = new Select(loc);
		s.selectByValue("Melbourne");
		WebElement hols = driver.findElement(By.id("hotels"));
		Select s1 = new Select(hols);
		s1.selectByVisibleText("Hotel Sunshine");
		WebElement room = driver.findElement(By.id("room_type"));
		Select s2 = new Select(room);
		s2.selectByValue("Double");
		WebElement rooms = driver.findElement(By.id("room_nos"));
		Select s3 = new Select(rooms);
		s3.selectByIndex(3);
		WebElement date1 = driver.findElement(By.id("datepick_in"));
		date1.sendKeys("10/07/2021");
		WebElement date2 = driver.findElement(By.id("datepick_out"));
		date2.sendKeys("10/08/2021");
		WebElement aroom = driver.findElement(By.id("adult_room"));
		Select s4 = new Select(aroom);
		s4.selectByIndex(2);
		WebElement croom = driver.findElement(By.id("child_room"));
		Select s5 = new Select(croom);
		s5.selectByIndex(2);
		WebElement sub = driver.findElement(By.id("Submit"));
		sub.click();
		WebElement rad = driver.findElement(By.id("radiobutton_0"));
		rad.click();
		WebElement contin = driver.findElement(By.id("continue"));
		contin.click();
		WebElement fname = driver.findElement(By.id("first_name"));
		fname.sendKeys("Thiyagarajan");
		WebElement lname = driver.findElement(By.id("last_name"));
		lname.sendKeys("Rajasudhakar");
		WebElement add = driver.findElement(By.id("address"));
		add.sendKeys("Madambakkam");
		WebElement cc = driver.findElement(By.id("cc_num"));
		cc.sendKeys("9876123456784321");
		WebElement cct = driver.findElement(By.id("cc_type"));
		Select s6 = new Select(cct);
		s6.selectByIndex(1);
		WebElement ccmon = driver.findElement(By.id("cc_exp_month"));
		Select s7 = new Select(ccmon);
		s7.selectByIndex(8);
		WebElement ccyear = driver.findElement(By.id("cc_exp_year"));
		Select s8 = new Select(ccyear);
		s8.selectByIndex(11);
		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		cvv.sendKeys("519");
		WebElement book = driver.findElement(By.id("book_now"));
		book.click();
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("D:\\se\\Selenium\\Day9\\Q8.png");
		FileUtils.copyFile(src, des);

		driver.quit();
	}
}
