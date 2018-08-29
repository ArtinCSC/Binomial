
/** 
 * The program to determine the coefficients of expanded form of (aX+bY)^n.
 * Artin Malekian
 * Homework 6 
 * 31 July 2016
 */
import java.util.Scanner;

public class Homework6 {

	public static void main(String[] args) {
		String response;

		Scanner input = new Scanner(System.in);
		do {
			System.out.println("What are the coefficients of X and Y? ");
			int x = input.nextInt();
			int y = input.nextInt();
			System.out.println("What are the value of n?");

			int expon = input.nextInt();
			Binomial coef = new Binomial(x, y, expon);
			System.out.println(coef);

			System.out.println(" Do you want to continue? y/n");
			response = input.next();
		} while (response.equalsIgnoreCase("y"));
		System.out.println("Goodbye");
	}
}
