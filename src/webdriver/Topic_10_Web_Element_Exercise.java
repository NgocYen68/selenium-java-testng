package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Web_Element_Exercise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	// Khai báo biến global
	By emailTxt = By.id("mail");
	By ageUnder18Radio = By.cssSelector("#under_18");
	By educationTextArea = By.cssSelector("#edu");
	By nameUer5Text = By.xpath("//h5[text()='Name: User5']");
	By passwordTxt = By.cssSelector("#disable_password");
	By biographyTxtArea = By.cssSelector("#bio");
	By developmentCheckbox = By.cssSelector("#development");
	
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	//@Test
	public void TC_01() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
	
		// Textbox
		if(driver.findElement(emailTxt).isDisplayed()) {
			driver.findElement(emailTxt).sendKeys("Automation Testing");
			System.out.println("Email textbox is displayed");
		}
		else {
			System.out.println("Email textbox is not displayed");
		}
		
		// Textarea
		if(driver.findElement(educationTextArea).isDisplayed()) {
			driver.findElement(educationTextArea).sendKeys("Automation Testing");
			System.out.println("Education textbox is displayed");
		}
		else {
			System.out.println("Education textbox is not displayed");
		}
		
		// Radio button
		if(driver.findElement(ageUnder18Radio).isDisplayed()) {
			driver.findElement(ageUnder18Radio).sendKeys("Automation Testing");
			System.out.println("Radio button textbox is displayed");
		}
		else {
			System.out.println("Radio button textbox is not displayed");
		}
	}
	

	//@Test
	public void TC_02_Enabled() {

		driver.get("https://automationfc.github.io/basic-form/index.html");
		// PasswordTextbox
		if(driver.findElement(passwordTxt).isEnabled()) {
			driver.findElement(passwordTxt).sendKeys("Automation Testing");
			System.out.println("Password textbox is enabled");
		}
		else {
			System.out.println("Password textbox is not enabled");
		}
		
		// Biography textarea
		
		if(driver.findElement(biographyTxtArea).isEnabled()) {
			driver.findElement(biographyTxtArea).sendKeys("Automation Testing");
			System.out.println("Biography textbox is enabled");
		}
		else {
			System.out.println("Biography textbox is not enabled");
		}

	}

	//@Test
	public void TC_03_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// Verify radio button is deselected
		Assert.assertFalse(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertFalse(driver.findElement(developmentCheckbox).isSelected());
		// Click on radio button
		driver.findElement(ageUnder18Radio).click();
		driver.findElement(developmentCheckbox).click();
		// Verify radio button is selected
		Assert.assertTrue(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertTrue(driver.findElement(developmentCheckbox).isSelected());
	}
	
	@Test
		public void TC_03_MailChimp() {
			driver.get("https://login.mailchimp.com/signup/");
			driver.findElement(By.id("email")).sendKeys("Automation@gmai.com");
			By passwordTxt = By.id("new_password");
			By signUpBtn = By.xpath("//button[@id='create-account-enabled']");
			
			driver.findElement(passwordTxt).sendKeys("abc");
			sleepInSecond(3);
			 
			
			// Verify lowcase
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
			
			
			driver.findElement(passwordTxt).clear();
			driver.findElement(passwordTxt).sendKeys("ABC");
			sleepInSecond(3);
			 
			
			// Verify Upercase
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
			
			
		}
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}