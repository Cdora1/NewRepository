package matrix;

//DP Matrix
/*[[0, 0, 0, 0, 0, 0], 
 [0, 1, 0, 1, 0, 0], 
 [0, 1, 0, 1, 1, 1], 
 [0, 1, 1, 1, 2, 2], 
 [0, 1, 0, 0, 1, 0]]*/
public class MaximalSquare {

	public static void main(String args[]) {
		char matrix1[][] = { { '1', '0', '1', '0', '0' }, 
							{ '1', '0', '1', '1', '1' }, 
							{ '1', '1', '1', '1', '1' }, 
							{ '1', '0', '0', '1', '0' } 
						  };
		
		char matrix[][] = {  { '1', '0', '1', '0' }, 
							 { '1', '0', '1', '1' }, 
							 { '1', '1', '1', '1' }, 
							 { '1', '0', '1', '0' } };
		
		System.out.println(maximalSquare(matrix));
	}
	
	static int maximalSquare(char[][] matrix) {
	    
	    if(matrix.length == 0) 
	        return 0;
	        
	    int m = matrix.length, n = matrix[0].length, result = 0;
	    int[][] dp = new int[m+1][n+1];
	        
	    for (int i = 1 ; i <= m; i++) {
	        for (int j = 1; j <= n; j++) {
	            if(matrix[i-1][j-1] == '1') {
	                dp[i][j] = Math.min(Math.min(dp[i][j-1] , dp[i-1][j-1]), dp[i-1][j]) + 1;
	                result = Math.max(dp[i][j], result); // update result
	            }
	        }
	    }
	    
	    return result*result;
	}
	
}
