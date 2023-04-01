package webdriver;

public class Topic_04_And_Or {

	public static void main(String[] args) {
		boolean statusA;
		boolean statusB;
		
		//And - &&
		statusA = true;
		statusB = false;
		System.out.println("Result = " + (statusA && statusB));
		
		statusA = false;
		statusB = true;
		System.out.println("Result = " + (statusA && statusB));
		
		//Or - ||
		statusA = true;
		statusB = false;
		System.out.println("Result = " + (statusA || statusB));

	}

}
