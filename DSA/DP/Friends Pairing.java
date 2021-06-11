import java.io.*;
import java.util.*;

public class Main {
    public static long[] dp;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new long[n+1];
        System.out.println(friendsPairing(n));
    }
    
    public static long friendsPairing(int n)
    {
        if( n <= 1 )
            return 1;
            
        if( dp[n] != 0 )
            return dp[n];
            
        dp[n] = friendsPairing(n-1) + (n-1)*friendsPairing(n-2);
        return dp[n];
    }
}