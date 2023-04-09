package javaTester;

import java.util.Random;

public class Topic_03_Random_Number {

	public static void main(String[] args) {
		Random rand  = new Random();
		System.out.println(rand.nextFloat());
		System.out.println(rand.nextInt(9999));
		System.out.println(rand.nextLong());

	}

}
