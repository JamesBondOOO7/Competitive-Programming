import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        if( n <= 1 )
        {
            System.out.println(0);
        }
        else
        {
            long dp[][] = new long[3][n+1];
            dp[0][2] = k;
            dp[1][2] = k*(k-1);
            dp[2][2] = dp[0][2] + dp[1][2];
            
            for(int i=3; i<=n; i++)
            {
                dp[0][i] = dp[1][i-1];
                dp[1][i] = dp[2][i-1]*(k-1);
                dp[2][i] = dp[0][i] + dp[1][i];
            }
            
            System.out.println(dp[2][n]);
        }
        
    }
}