package javaTester;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_02_Data_Type {

	public static void main(String[] args) {
		// I - Kiểu dữ liệu nguyên thuỷ  
		byte bNumber = 127;
		float studenPoint = 9.5f;
		char a = 'A';
		// II - Kiểu dữ liệu tham chiếu 
		// Class
		FirefoxDriver driver = new FirefoxDriver();
		// Interface
		WebElement FirstnameTextbox;
		// String
		String firstname = "Automation FC";
		// Object
		Object people;
		// Array
		String [] studentName = {"", "", ""};
		// Collect: List/Set/ Queue
		List<WebElement> checkboxes = driver.findElements(By.cssSelector(""));
		// Map
		Map<String, Integer> student = new HashMap<>();
		
	}

}
