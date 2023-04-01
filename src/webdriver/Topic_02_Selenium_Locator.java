package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Mở trang register
		driver.get("https://demo.nopcommerce.com/register");
	}

	@Test
	public void TC_01_ID() {
		driver.findElement(By.id("FirstName")).sendKeys("Automation");
	}
	

	@Test
	public void TC_02_Class() {
		// Mở trang 
		driver.get("https://demo.nopcommerce.com/search");
		// Nhập text vào Search 
		driver.findElement(By.className("search-text")).sendKeys("Macbook");
	}

	@Test
	public void TC_03_Name() {
		// Click vào Advance Search checkbox 
		driver.findElement(By.name("advs")).click();
	}
	
	@Test
	public void TC_04_TagName() {
		//Tìm ra bao nhiêu thẻ Input trên màn hình hiện tại 
		System.out.println(driver.findElement(By.tagName("input")).getSize());
	}
	
	@Test
	public void TC_05_LinkText() {
		// đường link lấy tuyệt đối 
		driver.findElement(By.linkText("Addresses")).click();
	}

	@Test
	public void TC_06_PartialLinkText() {
		// đường link lấy  đối 
		driver.findElement(By.partialLinkText("vendor account")).click();;	
	}
	
	@Test
	public void TC_07_Css() {
		driver.get("https://demo.nopcommerce.com/register");
		// 1
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Selenium");
		// 2
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("Locator");
		//3 
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("automation@gmai.com");

	}
	
	@Test
	public void TC_08_XPath() {
		driver.get("https://demo.nopcommerce.com/register");
		// 1
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Selenium");
		// 2
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Locator");
		//3 
		driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input")).sendKeys("automation@gmail.com");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}