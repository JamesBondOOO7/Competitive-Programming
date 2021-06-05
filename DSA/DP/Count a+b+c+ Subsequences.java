import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        int n = str.length();
        
        // NOTE :  CAN BE OPTIMIZED WITHOUT USING DP MATRIX
        // Using these recurrence relations
        // a = 2*a + 1
        // ab = 2*ab + a
        // abc = 2*abc + b
        
        int[][] dp = new int[3][n+1];
        // Note: this represents a regular expression
        // 1st row : a+
        // 2nd row : a+b+
        // 3rd row : a+b+c+
        
        for(int i=1; i<=n; i++)
        {
            char ch = str.charAt(i-1);
            
            if( ch == 'a' )
            {
                // affects a+
                dp[0][i] = 2*dp[0][i-1] + 1;
                
                // suppose we have encountered only 1a
                // This time we would be able to make 
                // a
                // aa'
                // a'
                
            }
            else
            {
                // remains same
                dp[0][i] = dp[0][i-1];
            }
            
            if( ch == 'b' )
            {
                // affects a+b+
                // can be attached/not attached to a+ => 2 times ways
                // and a+b+  => only 1 way
                dp[1][i] = 2*dp[1][i-1] + dp[0][i-1];
            }
            else
            {
                // remains same
                dp[1][i] = dp[1][i-1];
            }
            
            if( ch == 'c' )
            {
                // affects a+b+c+
                // can be attached/not attached to a+b+ => 2 times ways
                // and a+b+c+  => only 1 way
                dp[2][i] = 2*dp[2][i-1] + dp[1][i-1];
            }
            else
            {
                // remains same
                dp[2][i] = dp[2][i-1];
            }
        }
        
        System.out.println(dp[2][n]);
    }
}