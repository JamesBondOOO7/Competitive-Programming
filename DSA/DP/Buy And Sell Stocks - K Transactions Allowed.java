import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
            
        int k = sc.nextInt();
        
        System.out.println(Ktransaction(arr, k));
    }
    
    public static int Ktransaction(int[] arr, int k)
    {
        int n = arr.length;
        int[][] dp = new int[k+1][n];
        
        for(int t= 1; t<=k; t++)
        {
            int max = -1;
            for(int day=1; day<n; day++)
            {
                dp[t][day] = dp[t][day-1];
                
                if( day == 1 )
                {
                    max = dp[t-1][day-1] - arr[day-1];
                    dp[t][day] = Math.max(dp[t][day], max + arr[day]);
                }
                    
                else
                {
                    max = Math.max(max, dp[t-1][day-1] - arr[day-1]);
                    dp[t][day] = Math.max(dp[t][day], max + arr[day]);
                }
            }
        }
        
        return dp[k][n-1];
    }

}