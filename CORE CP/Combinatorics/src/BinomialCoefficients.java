public class BinomialCoefficients {
    public static long[][] dp;
    public static void main(String[] args) {
        // C(n, k)
        // Some IMP Features:
        // C(n, 0) = C(n, n) = 1
        // C(n, k) = C(n-1, k-1) + C(n-1, k)  [ Refer Pascal Triangle ]
        // Can be solved using Bottom up DP

        // Application:
        // 2d grid, (0, 0) to (n-1, m-1)
        // ways = ?

        int n = 10;
        System.out.println(C(10, 2));
    }

    public static long C(int n, int k)
    {
        // FORMING THE PASCAL TRIANGLE
        dp = new long[n+1][];
        for(int i=0; i<=10; i++)
        {
            dp[i] = new long[i + 1];
        }

        // 1st and last element of each row = 1
        for(int i=1; i<=n; i++)
        {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int i=2; i<=n; i++)
        {
            for(int j=1; j<i; j++)
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        }

        for(long[] a : dp)
        {
            for(long ele : a )
                System.out.print(ele + " ");

            System.out.println();
        }

        return dp[n][k];
    }
}
