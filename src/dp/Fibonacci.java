package dp;

/* Java program for Memoized version */
public class Fibonacci {
	final int MAX = 5;
	final int NIL = -1;

	int lookup[] = new int[MAX];

	/* Function to initialize NIL values in lookup table */
	void _initialize() {
		for (int i = 0; i < MAX; i++)
			lookup[i] = NIL;
	}

	int fib(int n) {
		if (lookup[n] == NIL) {
			if (n <= 1)
				lookup[n] = n;
			else
				lookup[n] = fib(n - 1) + fib(n - 2);
		}
		return lookup[n];
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		int n = 4;
		f._initialize();
		System.out.println("Fibonacci number is" + " " + f.fib(n));
	}

	public static void print() {

		int prev = 0;
		int next = 1;
		int temp = 0;
		System.out.println(prev);
		while (next < 25) {
			temp = prev + next;
			prev = next;
			next = temp;
			System.out.println(prev);
		}
	}

}
