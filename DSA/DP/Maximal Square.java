class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        
        int[][] dp = new int[n][m];
        
        // Fill last row and last column as it is
        // becuase they are gonna be squares of either size 0 or 1
        
        int ans = 0;
        for(int i=0; i<m; i++)
        {
            dp[n-1][i] = matrix[n-1][i] == '0' ? 0 : 1;
            ans = Math.max(ans, dp[n-1][i]);
        }
        
        for(int i=0; i<n; i++)
        {
            dp[i][m-1] = matrix[i][m-1] == '0' ? 0 : 1;
            ans = Math.max(ans, dp[i][m-1]);
        }
        
        // bottom up dp
        // Max area square = 1 + min square from the 3 directions
        for(int i=n-2; i>=0; i--)
        {
            for(int j=m-2; j>=0; j--)
            {
                if( matrix[i][j] == '1')
                {
                    dp[i][j] = 1 + Math.min(
                    dp[i+1][j+1],
                    Math.min(
                        dp[i][j+1],
                        dp[i+1][j]
                    )
                    );
                    
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        
        return ans*ans; // return area
    }
}