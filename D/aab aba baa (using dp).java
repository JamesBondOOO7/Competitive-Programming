import java.util.*;
public class Main {
    public static long[][] dp;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long k = sc.nextLong();
        
        dpSol(a, b, k);
    }

    public static void dpSol(int a, int b, long k)
    {

        // This problem is reducable to counting number of ways
        // starting from (0, 0) to (i, j)
        // which can be found using DP

        // if i == 0:
        //      repitition of b
        // if j == 0:
        //      repitition of a
        // if i>0 and j>0:
        //      if dp[i-1, j] >= k :
        //          ans is "a" followed by dp(i-1, j, k) || k doesn't change
        //      if dp[i-1, j] < k :
        //          ans is "b" followed by dp(i, j-1, k-dp[i-1, j]) || subtract the ways in which the strings starts with 'a'

        dp = new long[31][31];
        dp[0][0] = 1;
        for(int i=0; i<=a; i++)  // count of a's
        {
            for(int j=0; j<=b; j++)  // count of b's
            {
                if( i>0 )
                    dp[i][j] += dp[i-1][j];

                if( j>0 )
                    dp[i][j] += dp[i][j-1];
            }
        }

        System.out.println(findKth(a, b, k));
    }

    public static String findKth(int a, int b, long k)
    {
        if( a == 0 )
        {
            String ans = "";
            for(int i=1; i<=b; i++)
                ans += "b";

            return ans;
        }
        if( b == 0 )
        {
            String ans = "";
            for(int i=1; i<=a; i++)
                ans += "a";

            return ans;
        }

        if( k <= dp[a-1][b] )
            return "a" + findKth(a-1, b, k);

        else
            return "b" + findKth(a, b-1, k - dp[a-1][b] );
    }
}