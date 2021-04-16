import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        long[][] dp = new long[n][n];

        for(int gap=0; gap<n; gap++)
        {
            for(int i=0, j=gap; i<n && j<n; i++, j++)
            {
                if( gap == 0 )
                    dp[i][j] = 0;

                else if( gap == 1 )
                    dp[i][j] = arr[j] - arr[i];

                else
                {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + arr[j] - arr[i];
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}