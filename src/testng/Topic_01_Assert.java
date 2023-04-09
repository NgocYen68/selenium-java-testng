package testng;

import org.testng.Assert;

public class Topic_01_Assert {

	public static void main(String[] args) {

		String fullName = "Automation Testing";
		// Mong đợi 1 điều kiện trả về là đúng
		Assert.assertTrue(fullName.contains("Automation"));
		// Mong đợi 1 điều kiện trả về là đúng
		Assert.assertFalse(fullName.contains("Dev"));
		// Equals
		//Assert.assertEquals(null, null);
	}

}
