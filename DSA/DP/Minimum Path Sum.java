class Solution {
    
    public static int[][] memo;
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        memo = new int[n][m];
        for(int i=0; i<n; i++)
            Arrays.fill(memo[i], -1);
        
        return MPSUtil(grid, 0, 0, n, m);
    }
    
    public static int MPSUtil(int[][] grid, int cr, int cc, int n, int m)
    {
        if( cr == n-1 && cc == m-1 )
            return grid[cr][cc];
        
        if( cr == n || cc == m )
            return 10000000;
        
        if( memo[cr][cc] != -1 )
            return memo[cr][cc];
        
        memo[cr][cc] = Math.min(
            MPSUtil(grid, cr + 1, cc, n, m),
            MPSUtil(grid, cr, cc + 1, n, m)
        ) + grid[cr][cc];
        
        return memo[cr][cc];
    }
}