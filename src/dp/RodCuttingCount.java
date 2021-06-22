package dp;

//https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14
public class RodCuttingCount {

	public static void main(String[] args) {
		int rodPrice[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int N = rodPrice.length;

		int length[] = new int[N];
		for (int i = 0; i < N; i++)
			length[i] = i;

		System.out.println(rodCutting(rodPrice, N));
		
		System.out.println(rodCut(rodPrice, N));
	}

	// TODO...
	// static int rodCuttingRec(int rodPrice[], int length[], int N)

	// JD- this solution is unbounded Knapsack problem so added length array based
	// on
	// length of a rod.
	public static int rodCutting(int rodPrice[], int N) {

		int n = rodPrice.length;

		int dp[][] = new int[n + 1][N + 1];
		int length[] = new int[N]; // length of a rod.

		for (int i = 0; i < N; i++)
			length[i] = i + 1;

		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= N; j++)
				if (i == 0 || j == 0)
					dp[i][j] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= N; j++) {
				if (length[i - 1] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], rodPrice[i - 1] + dp[i][j - length[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][N];
	}

	public static int rodCut(int[] price, int n) {
		if (n == 0) 
			return 0;

		int maxValue = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) 
			// rod of length `i` has a cost `price[i-1]`
			maxValue = Math.max(maxValue, price[i - 1] + rodCut(price, n - i));

		return maxValue;
	}
}