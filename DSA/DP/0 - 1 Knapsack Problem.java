class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] dp = new int[n+1][W+1];
        
        for(int i=0; i<=W; i++)
            dp[0][i] = 0;
            
        for(int i=1; i<=n; i++)
        {
            for(int w = 1; w<=W; w++)
            {
                if( w < wt[i-1] )
                    dp[i][w] = dp[i-1][w];
                    
                else
                    dp[i][w] = Math.max(dp[i-1][w] , val[i-1] + dp[i-1][w - wt[i-1]] );
            }
        }
        
        return dp[n][W];
    } 
}