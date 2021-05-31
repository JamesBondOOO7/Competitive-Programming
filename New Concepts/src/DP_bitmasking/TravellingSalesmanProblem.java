package DP_bitmasking;

import java.util.Arrays;

public class TravellingSalesmanProblem {
    public static int[][]dp;
    public static int visited_all;
    public static void main(String[] args) {
        // Brute force => O(n!)
        // Dp with bitmasking => O( 2^n * n^2 )

        // dist[i][j] represents distance between 2 cities
        // the salesman starts from 0th city and has to return to the 0th city
        // what is the minimum cost
        int[][] dist = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        // 0 : city not visited yet
        // 1 : city is visited

        int n = dist.length;
        visited_all = (1<<n)-1;
        dp = new int[n][(1<<n)];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);

        System.out.println(TSP(dist, 0, 0, n));
    }

    public static int TSP(int[][] dist, int pos, int mask, int n)
    {
        if( mask == visited_all )
            return dist[pos][0];

        if( dp[pos][mask] != -1 )
            return dp[pos][mask];

        int answer = Integer.MAX_VALUE;

        for(int city=0; city<n; city++)
        {
            if( (mask&(1<<city)) == 0 )  // city is not visited
            {
                answer = Math.min(answer, dist[pos][city] + TSP(dist, city, (mask | ( 1 << city)), n));
            }
        }

        dp[pos][mask] = answer;
        return answer;
    }
}
