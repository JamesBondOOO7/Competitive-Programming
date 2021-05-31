package DP_bitmasking;

import java.util.Arrays;

public class NworkersNJobs_Min {
    public static int[][] jobs;
    public static int[][] dp;
    public static void main(String[] args) {
        int n = 4;
        jobs = new int[][]{
                {9, 2, 7, 8},
                {6, 4, 3, 7},
                {5, 8, 1, 8},
                {7, 6, 9, 4}
        };

        dp = new int[n][1<<n];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);

        // Brute force => O( n! )
        // Dp Mask => ( n^2 * 2^n )
        System.out.println(dpMask(0, (1<<n) -1, n));
    }

    public static int dpMask(int i, int mask, int n)
    {
        // i : ith job
        // j : jth person
        if( i == n )
            return 0;

        if( dp[i][mask] != -1 )
            return dp[i][mask];

        int answer = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++)
        {
            if( (mask & (1<<j)) != 0 )
            {
                answer = Math.min(answer, jobs[j][i] + dpMask(i + 1, ( mask ^ (1<<j)), n));
            }
        }

        dp[i][mask] = answer;
        return answer;
    }
}
