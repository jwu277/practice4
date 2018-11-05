package fibonacciTransform;

import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class FibTransform {

    private static int numDoublings = 0;

	/**
	 * Transform a number into a Fibonacci number using at most m steps: Of
	 * these steps, one can be a doubling step, and the other steps increase
	 * the number at hand by adding 1.
	 * 
	 * We are only interested in Fibonacci numbers that can represented as
	 * Integer or int.
	 * 
	 * @param n
	 *            the number to transform to a Fibonacci number, n >= 0
	 * @param m
	 *            the number of transformation steps permitted, m >= 0
	 * @return true if the transformation is possible and false otherwise
	 */
	public static boolean isPossible_onlyOneDoubling(int n, int m) {
	    
        if (n == 0) {
            return true;
        }

        numDoublings = 0;

		return isPossible(n, m) && numDoublings <= 1;

	}

	/**
	 * Transform a number into a Fibonacci number using at most m steps: One can
	 * use any sequence of doubling (*2) or addition (+1) steps as long as the
	 * total number of steps used is no more than m.
	 * 
	 * We are only interested in Fibonacci numbers that can represented as
	 * Integer or int.
	 * 
	 * @param n
	 *            the number to transform to a Fibonacci number, n >= 0
	 * @param m
	 *            the number of transformation steps permitted, m >= 0
	 * @return true if the transformation is possible and false otherwise
	 */
	public static boolean isPossible(int n, int m) {

	    if (n == 0) {
	        return true;
        }

		if (isFib(n)) {
		    return true;
        } else if (m == 0) {
		    return false;
        } else {
		    if (isPossible(n + 1, m - 1)) {
		        return true;
            } else if (isPossible(2 * n, m - 1)) {
		        numDoublings++;
		        return true;
            } else {
		        return false;
            }
        }

	}

	private static boolean isFib(int k) {

	    int n2 = 1;
	    int n1 = 1;
	    int n = 2;

	    int temp;

	    while (true) {

	        if (n == k) {
	            return true;
            } else if (n > k) {
	            return false;
            }

            temp = n + n1;
	        n2 = n1;
	        n1 = n;
	        n = temp;

        }

    }

}
