package webdriver;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Web_Browser {
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
		driver.manage().window().maximize();
		
		// Tương tác với Browser sẽ thông qua biến WebDriver driver 
		// Tương tác với Elemrnt sẽ thông qua biến WebElement element
	}

	@Test
	public void TC_01() {
		// >=2: Nó sẽ đóng tab/browser mà nó đang đứng 
		driver.close();
		// không quan tâm bao nhiêu tab/ browser => Nó close browser    
		driver.getPageSource();
		
		WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='email']"));
		emailTextBox.clear();
		emailTextBox.sendKeys("yenle@gmail.com");
		// Tìm nhiều elements 
		List <WebElement> checkboxes = driver.findElements(By.xpath(""));
		
		// Lấy source page 
		driver.getPageSource();
		
		// Lấy ra Id của Window/Tab mà driver đang đứng (active) 
		String loginWindowId = driver.getWindowHandle();
		
		// Lấy ra Id của tất cả Window/Tab
		Set<String> WindowIds = driver.getWindowHandles();
		
		Options opt = driver.manage();
		// Login thành công -> Lưu lại 
		opt.getCookies();
		
		// Test case khác -> Set cookie vào lại -> Không cần phải login vào 
		
		opt.logs();
		
		Timeouts time = opt.timeouts();
		
		// Khoảng thời gian chờ cho element xuất trong vòng x 
		time.implicitlyWait(5, TimeUnit.SECONDS);
		time.implicitlyWait(5000, TimeUnit.MILLISECONDS);
		// Khoảng thời gian chờ cho page load trong vòng x 
		time.pageLoadTimeout(5, TimeUnit.SECONDS);
		// Khoảng thời gian chờ cho 1 đoạn script được thực thi xong
		time.setScriptTimeout(5, TimeUnit.SECONDS);
		
		Window win = opt.window();
		win.fullscreen();
		win.maximize();
		
		// Test UI: font/ size
		win.setPosition(null);
		win.setSize(null);
		
		Navigation nav = driver.navigate();
		nav.back();
		nav.refresh();
		nav.forward();
		
		TargetLocator tar = driver.switchTo();
		// Web driver API
		tar.alert();
		tar.frame("");
		tar.window("");
		
		
	}
	

	@Test
	public void TC_02() {

	}

	@Test
	public void TC_03() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}