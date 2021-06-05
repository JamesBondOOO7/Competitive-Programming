class Solution {
    public int numDecodings(String str) {
        int n = str.length();
        int[] dp = new int[n];
        
        int ans = 0;
        if( str.charAt(0) != '0' )
            ans++;
            
        if( n == 1)
            return ans;
        
        else
        {
            dp[0] = ans;
            ans = 0;
            
            int c1 = str.charAt(0);
            int c2 = str.charAt(1);
            
            if( c1 == '0' )
                return 0;
                
            if( c1 != '0' && c2 == '0')
            {
                if( c1 <= '2' )   
                    ans = 1;
            }
            
            else if ( c1 == '0' && c2 != '0' )
                ans = 1;
                
            else
            {
                ans = 1;
                
                if( c1 == '1' )
                    ans++;
                    
                else if( c1 == '2' && c2 <= '6' )
                    ans++;
            }
            
            if( n == 2 )
                return ans;
                
            else
            {
                dp[1] = ans;
                
                for(int i=2; i<n; i++)
                {
                    c1 = str.charAt(i-1);
                    c2 = str.charAt(i);
                    ans = 0;
                    
                    if( c1 == '0' && c2 == '0' )
                    {
                        return 0;
                    }
                        
                    else if( c1 != '0' && c2 == '0')
                    {
                        if( c1 <= '2' )  // as c2 can't contribute
                            dp[i] = dp[i-2];
                    }
                    
                    else if ( c1 == '0' && c2 != '0' )
                    {
                        dp[i] = dp[i-1];  // as c1 can't contribute
                    }
                        
                    else
                    {
                        dp[i] = dp[i-1];  // for c2
                        
                        if( (c1 == '1') || (c1 == '2' && c2 <= '6') )  // for c1
                        {
                            dp[i] += dp[i-2];
                        }
                    }
                }
                
//                 for(int ele : dp)
//                     System.out.print(ele + " ");
                    
//                 System.out.println();
                return dp[n-1];
            }
        }
    }
}