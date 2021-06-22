package dp;

//https://www.youtube.com/watch?v=hbTaCmQGqLg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30
public class LongestRepeatingSubsequence {

	// LCS only changes with i != j also get 2nd string using given input string
	public static void main(String[] args) {

		String str1 = "AABEBCDD", str2 = str1;
		int n = str1.length(), m = str2.length();
		char x[] = str1.toCharArray();
		char y[] = str2.toCharArray();

		System.out.println(" LongestRepeatingSubsequence using LCS Only changes i != j  " + lcs_topdown(x, y, n, m));

	}

	static int lcs_topdown(char[] x, char[] y, int m, int n) {

		int t[][] = new int[m + 1][n + 1];
		int i = 0, j = 0;
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		for (i = 1; i < m + 1; i++) {
			for (j = 1; j < n + 1; j++) {
				if (x[i - 1] == y[j - 1] && i != j)// main changes here only:- i != j else same lcs
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
			}
		}
		return t[m][n];
	}

}
