/**
 * @author Lazar Lazarov
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Problem3 {

	public static int containsAlphabet(String input1) {
		int n = 26;
		String[] input = input1.split("");
		ArrayList<String> fillWithAlphabet = new ArrayList<String>();
		String[] theAlphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i",
				"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
				"v", "w", "x", "y", "z" };
		for (int i = 0; i < theAlphabet.length; i++) {
			fillWithAlphabet.add(theAlphabet[i]);
		}
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < fillWithAlphabet.size(); j++) {
				if (input[i].equalsIgnoreCase(fillWithAlphabet.get(j))) {
					fillWithAlphabet.remove(j);
					n--;
				}
			}
		}
		return n;
	}

	public static String smallestSubstringContainingTheAlphabet(String input) {
		int x = 26;
		outerloop: for (int i = 0; i < input.length() - 26 + 1; i++) {
			int z = 0;
			for (int j = 0; j < input.length() - 26 + (1 - i); j++) {
				if (z + x <= input.length()
						&& containsAlphabet((input.substring(z, z + x))) == 0) {
					System.out.println("The smallest sub string is : "
							+ input.substring(z, z + x));
					break outerloop;
				} else if (z + x <= input.length()
						&& containsAlphabet((input.substring(z, z + x))) != 0
						&& z + containsAlphabet((input.substring(z, z + x))) < input
								.length() - 26 + 1) {
					z = z + containsAlphabet((input.substring(z, z + x)));
				} // else if(z+x > input.length() ){ // &&
					// z+containsAlphabet((input.substring(z, z + x)))>
					// input.length() - 26 + 1) {
					// System.out.println("There is no such sub string ");
				// }
				else {
					z++;
				}
			}
			x++;
		}
		return input;
	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		smallestSubstringContainingTheAlphabet("aaaaaabcdefghijklmnopqrstuvwxyz");
		smallestSubstringContainingTheAlphabet("abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn");

		System.out.println("The program was execfuted for: "
				+ (System.currentTimeMillis() - start) + " milliseconds.");

	}
}
