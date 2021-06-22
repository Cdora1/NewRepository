package dp;

import java.util.Arrays;

public class CoinChainCount {

	/*
	 * Input: coins = [1, 2, 5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
	 */
	public static void main(String[] args) {
		int coins[] = { 1, 2, 5 };
		int sum = 11;
	
		System.out.println("minCoins: " + minCoins(coins, coins.length, sum));

	}


	static int minCoins(int coins[], int m, int V) {
		int dp[] = new int[V + 1];

		// Base case (If given value V is 0)
		dp[0] = 0;

		// Initialize all table values as Infinite
		for (int i = 1; i <= V; i++)
			dp[i] = Integer.MAX_VALUE;

		// Compute minimum coins required for all
		// values from 1 to V
		for (int i = 1; i <= V; i++) {
			// Go through all coins smaller than i
			for (int j = 0; j < m; j++)
				if (coins[j] <= i) {
					int sub_res = dp[i - coins[j]];
					if (sub_res != Integer.MAX_VALUE && sub_res + 1 < dp[i])
						dp[i] = sub_res + 1;

				}

		}
		return dp[V];

	}
}
