package matrix;

public class FlooFill {

	public static void main(String[] args) {
		
		int grid[][] = { { 1, 1, 1 }, 
						  { 1, 1, 0 }, 
						  { 1, 0, 1 }};
		
		int sr = 0, sc = 1, newColor = 2;
				
		for (int d[] : floodFill(grid, sr, sc, newColor)) {
			System.out.println();
			for (int num : d)
				System.out.print(num + " ");

		}
	}

	public static int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
		
		if (newColor == grid[sr][sc])
			return grid;
		
		int source = grid[sr][sc];
		
		DFS(grid, sr, sc, newColor, grid[sr][sc], source);
		
		return grid;
	}

	private static void DFS(int[][] grid, int i, int j, int color, int oldColor, int source) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length )
			return;
		
		if(grid[i][j] != source)
			return;

		grid[i][j] = color;

		DFS(grid, i - 1, j, color, oldColor, source);
		DFS(grid, i + 1, j, color, oldColor, source);
		DFS(grid, i, j - 1, color, oldColor, source);
		DFS(grid, i, j + 1, color, oldColor, source);
	}
}
