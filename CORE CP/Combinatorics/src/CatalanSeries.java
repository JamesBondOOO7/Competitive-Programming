import java.util.Arrays;

public class CatalanSeries {
    public static long [] dp;
    public static void main(String[] args) {

        // CATALAN SERIES : 1, 1, 2, 5, 14, 42, 132, ...
        // APPLICATION :  https://en.wikipedia.org/wiki/Catalan_number
        // Number of BSTs with N nodes = Catalan(N)
        // Number of balanced parenthesis = Catalan(N)
        // Number of BTs with N nodes = N! * Catalan(N)
        // n*n grid, Number of paths that don't cross the diagonal

        // Direct formula : C(2n, n) / (n+1)
        // Recursive/Recurrence Relation :
        // for all i:
        //      total += Catalan(i-1)*Catalan(N-i)
        int n = 30;
        dp = new long[n+1];
        Arrays.fill(dp, -1);
        System.out.println(Catalan(n));
    }

    public static long Catalan(int num)
    {
        if( num <= 1 )
            return 1;

        if( dp[num] != -1 )
            return dp[num];

        long ans = 0;
        for (int i = 1; i <= num; i++)
        {
            ans += Catalan(i-1)*Catalan(num-i);
        }
        dp[num] = ans;
        return ans;
    }
}
