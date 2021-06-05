import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[][] arr = new int[n][k];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<k; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int[][] dp = new int[k][n];
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        
        for(int i=0; i<k; i++)
        {
            dp[i][0] = arr[0][i];
            
            if( dp[i][0] < least )
            {
                int temp = least;
                least = dp[i][0];
                sleast = temp;
            }
            
            else if( dp[i][0] < sleast )
            {
                sleast = dp[i][0];
            }
        }
        
        // System.out.println(least + " -- " + sleast);
            
        for(int i=1; i<n; i++)
        {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            
            for(int j=0; j<k; j++)
            {
                dp[j][i] = arr[i][j];
                
                if( dp[j][i-1] == least )
                    dp[j][i] += sleast;
                    
                else
                    dp[j][i] += least;
                    
                if( dp[j][i] < nleast )
                {
                    int temp = nleast;
                    nleast = dp[j][i];
                    nsleast = temp;
                }
                
                else if( dp[j][i] < nsleast )
                {
                    nsleast = dp[j][i];
                }
            }
            
            least = nleast;
            sleast = nsleast;
        }
        
        // for(int i=0; i<dp.length; i++)
        // {
        //     for(int j=0; j<dp[0].length; j++)
        //     {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(least);
    }
}