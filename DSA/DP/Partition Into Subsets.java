import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubset(int n, int k) {
        
        // recurrent relation:
        // p(n-1, k)*k + p(n-1, k-1)
        
        // rows : k
        // cols : n
        long[][] dp = new long[k+1][n+1];
        
        // if we have 1 team and 1...n players
        // they will belong to 1 team
        for(int i=1; i<=n; i++)
            dp[1][i] = 1;
            
        // now, rest is just the formula
        for(int i=2; i<=k; i++)
        {
            for(int j=2; j<=n; j++)
            {
                dp[i][j] = dp[i][j-1]*i + dp[i-1][j-1];
            }
        }
        
        return dp[k][n];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}