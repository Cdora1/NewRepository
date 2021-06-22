package dp;

public class EqualSumPartition {

	public static void main(String[] args) {

		int arr[] = { 1, 5, 11, 4 };
		int totalSum = 0;
		for (int in : arr)
			totalSum += in;
		boolean dp[][] = new boolean[arr.length + 1][totalSum / 2 + 1];
		if (totalSum % 2 != 0)
			System.out.println("false");
		else
			System.out.println(equalSumPartition(arr, totalSum / 2, arr.length, dp));

	}

	static boolean equalSumPartition(int arr[], int sum, int n, boolean dp[][]) {

		if (sum == 0)
			return true;
		if (arr.length == 0 && sum != 0)
			return false;

		if (dp[n][sum] != false)
			return true;

		if (arr[n - 1] > sum)
			return dp[n][sum] = equalSumPartition(arr, sum, n - 1, dp);
		else
			return dp[n][sum] = equalSumPartition(arr, sum - arr[n - 1], n - 1, dp)
					|| equalSumPartition(arr, sum, n - 1, dp);
	}

}
