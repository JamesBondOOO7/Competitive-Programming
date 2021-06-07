import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        // THE PROBLEM BOILS DOWN TO FINDING 2 SUBSETS
        // SUCH THAT ABS(SUM(SUBSET-1) - SUM(SUBSET-2)) IS MINIMIZED
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0; i<=n; i++)
            dp[i][0] = true;

        for(int i=1; i<=n; i++)
        {
            for(int j = 1; j<=sum; j++ )
            {
                if( j>=arr[i-1] )
                {
                    dp[i][j] = dp[i][j] | dp[i-1][j-arr[i-1]] | dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // check in the last row
        int firstpart = 0;
        for(int i=sum/2; i<=sum; i++)
        {
            if( dp[n][i] )
            {
                firstpart = i;
                break;
            }
        }

        int secondPart = sum - firstpart;

        System.out.println(Math.max(firstpart, secondPart));
    }
}