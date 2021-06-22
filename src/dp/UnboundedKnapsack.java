package dp;

public class UnboundedKnapsack {
	private static int max(int i, int j) {
		return (i > j) ? i : j;
	}

	public static void main(String[] args) {
		int W = 100;
		int val[] = { 10, 30, 20 };
		int wt[] = { 5, 10, 15 };
		int n = val.length;
		System.out.println(unboundedKnapSackAditya(W, wt, val, n));
		System.out.println();
		System.out.println(unboundedKnapsackRecursive(val, wt, W, n));
	}

	static int unboundedKnapSackAditya(int W, int wt[], int val[], int n) {
		int i, j;
		int t[][] = new int[n + 1][W + 1];

		for (i = 0; i <= n; i++) {
			for (j = 0; j <= W; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
				else if (wt[i - 1] <= j)
					t[i][j] = max(val[i - 1] + t[i][j - wt[i - 1]], t[i - 1][j]);
				else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[n][W];
	}
	
	public static int unboundedKnapsackRecursive(int val[], int wt[], int bgWeight, int n) {
		if (n == 0 || bgWeight == 0)
			return 0;

		if (wt[n - 1] > bgWeight)
			return unboundedKnapsackRecursive(val, wt, bgWeight, n - 1);
		else
			return max(val[n - 1] + unboundedKnapsackRecursive(val, wt, bgWeight - wt[n - 1], n),
					unboundedKnapsackRecursive(val, wt, bgWeight, n - 1));
	}
}
