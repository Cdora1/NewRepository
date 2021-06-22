public class Island8Grid {

	public static void main(String[] args) {

		int arr[][] = { { 1, 0, 1, 0, 1 }, 
						{ 0, 0, 1, 0, 0 }, 
						{ 0, 0, 1, 1, 0 }, 
						{ 0, 1, 0, 0, 1 }, 
						{ 1, 1, 0, 0, 0 } };

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					dfs(arr, i, j);
					count++;
				}
			}
		}
		System.out.println(count);
	}

	static void dfs(int arr[][], int i, int j) {
		if (i >= 0 && j >= 0 && i < arr.length && j < arr[0].length && arr[i][j] == 1) {

			arr[i][j] = 0;

			dfs(arr, i + 1, j);
			dfs(arr, i - 1, j);
			dfs(arr, i, j + 1);
			dfs(arr, i, j - 1);

			dfs(arr, i - 1, j + 1);
			dfs(arr, i - 1, j - 1);
			dfs(arr, i + 1, j - 1);
			dfs(arr, i + 1, j + 1);
		}

	}

}
