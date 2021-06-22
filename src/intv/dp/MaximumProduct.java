package intv.dp;

public class MaximumProduct {

	static int maxProd(int n) {

		// n equals to 2 or 3 must be handled explicitly
		if (n == 2 || n == 3)
			return (n - 1);

		// Keep removing parts of size 3 while n is greater than 4
		int res = 1;
		while (n > 4) {
			n -= 3;

			// Keep multiplying 3 to res
			res *= 3;
		}
		// The last part multiplied by previous parts
		return (n * res);
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		System.out.println("Maximum Product is " + maxProd(5));
	}

}
