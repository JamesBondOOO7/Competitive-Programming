import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        VacationsDP(arr, n);
    }

    public static void VacationsDP(int[] arr, int n)
    {
        int[][] dp = new int[n+1][3];

        // Val : Gym  Contest
        // 0   : 0    0
        // 1   : 0    1
        // 2   : 1    0
        // 3   : 1    1

        // dp[n][3]
        // 0 : Rest
        // 1 : Gym
        // 2 : Contest

        for(int i=1; i<=n; i++)
        {
            if( arr[i-1] == 0 )
            {
                dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]);
            }
            else if( arr[i-1] == 1 )
            {
                dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = 1 + Math.max(dp[i-1][0], dp[i-1][1]);
            }
            else if( arr[i-1] == 2 )
            {
                dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                dp[i][1] = 1 + Math.max(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]);
            }
            else
            {
                dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                dp[i][1] = 1 + Math.max(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = 1 + Math.max(dp[i-1][0], dp[i-1][1]);
            }
        }

        System.out.println(n - Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
    }
}