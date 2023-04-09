package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Web_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_WebElement() {
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		WebElement emailTxt = driver.findElement(By.id("Email"));
		WebElement passwordTxt = driver.findElement(By.id("Password"));
		
		WebElement element = driver.findElement(By.className(""));
		// dùng cho các textbox/textare/dropdown (Editable)
		
		element.clear();
		element.sendKeys();
		element.getAttribute("placeholder");
		
		//GUI:  verify color/font size/ location/ position/...
		element.getCssValue("background-color");
		
		// vị trí của element so với webpage
		Point point = element.getLocation();
		point.x = 231;
		// kích thước của element
		Dimension di = element.getSize();
		di.getHeight();
		
		// kết hợp của location và size
		element.getRect();
		//chụp hình khi TCs 
		element.getScreenshotAs(OutputType.FILE);
		element.getScreenshotAs(OutputType.BYTES);
		element.getScreenshotAs(OutputType.BASE64);
		
		//  lấy tên thẻ HTML -> Truyền vào 1 locator 
		element.getTagName();
		String emailTagName = driver.findElement(By.cssSelector("#Email")).getTagName();
		driver.findElement(By.xpath("//" + emailTagName + "[@id='email']"));

		// lấy text từ error msg/ success msg/ label/ header ...
		// khi value cần lấy nằm bên ngoài attribute thì dùng gettext()
		// khi value cần lấy nằm bên trong attribute thì dùng getattribute()
		element.getText();
		
		// Verify element có hiển thị/ hay ko
		// Phạm vi: tất cả 
		element.isDisplayed();
		element.isEnabled();
		Assert.assertTrue(element.isDisplayed());
		Assert.assertFalse(element.isEnabled());
		// radio button/ checkbox
		element.isSelected();
 
		// Các element nằm trong thẻ Form
		// Tương ứng với hành vi của enduser là 
		element.submit();
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