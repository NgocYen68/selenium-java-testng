package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Exercise {
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
	}

	@Test
	public void TC_01_Empty_Data() {
		//Action
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		// Verify
//		Assert.assertTrue -> Kiểm tra 1 điều kiện trả về là đúng
//		Assert.assertFalse  -> Kiểm tra 1 điều kiện trả về là 
//		Assert.assertEquals -> Kiểm tra thực tế và mong đợi là như 
	
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
	}
	
	

	@Test
	public void TC_02_Invalid_Email() {
		//Action
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("123@456@678");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@456@678");
		driver.findElement(By.id("txtPassword")).sendKeys("394394");
		driver.findElement(By.id("txtCPassword")).sendKeys("394394");
		driver.findElement(By.id("txtPhone")).sendKeys("09484588485");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
		
	}
		
	@Test
	public void TC_03_Incorrect_Email() {
		//Action
				driver.get("https://alada.vn/tai-khoan/dang-ky.html");
				driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
				driver.findElement(By.id("txtEmail")).sendKeys("John@wick.com");
				driver.findElement(By.id("txtCEmail")).sendKeys("John@wick.net");
				driver.findElement(By.id("txtPassword")).sendKeys("394394");
				driver.findElement(By.id("txtCPassword")).sendKeys("394394");
				driver.findElement(By.id("txtPhone")).sendKeys("09484588485");
				driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
				
				// Verify
				Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}

	@Test
	public void TC_04_Invalid_Password() {
		//Action
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("John@wick.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("John@wick.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123");
		driver.findElement(By.id("txtCPassword")).sendKeys("123");
		driver.findElement(By.id("txtPhone")).sendKeys("09484588485");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");

	}

	@Test
	public void TC_05_Incorrect_Password() {
		//Action
				driver.get("https://alada.vn/tai-khoan/dang-ky.html");
				driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
				driver.findElement(By.id("txtEmail")).sendKeys("John@wick.com");
				driver.findElement(By.id("txtCEmail")).sendKeys("John@wick.com");
				driver.findElement(By.id("txtPassword")).sendKeys("12346777");
				driver.findElement(By.id("txtCPassword")).sendKeys("12344444");
				driver.findElement(By.id("txtPhone")).sendKeys("09484588485");
				driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
				
				// Verify
				Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");

	}
	
	@Test
	public void TC_06_Invalid_Phone() {
		//Action 1
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("John@wick.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("John@wick.com");
		driver.findElement(By.id("txtPassword")).sendKeys("12346777");
		driver.findElement(By.id("txtCPassword")).sendKeys("12346777");
		driver.findElement(By.id("txtPhone")).sendKeys("098765432");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify 1
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
		
		//Action 2
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("098765433322");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify 2
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
		
		//Action 3
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("98765433322");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify 3
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}