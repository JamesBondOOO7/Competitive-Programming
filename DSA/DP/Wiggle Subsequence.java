class Solution {

    static class Node
    {
        int inc;
        int dec;
        
        public Node(int inc, int dec)
        {
            this.inc = inc;
            this.dec = dec;
        }
    }
    
    // My solution --> O(N*N)
    public int wiggleMaxLength_MySol(int[] nums) {
        
        Node[] dp = new Node[nums.length];
        
        for(int i=0; i<nums.length; i++)
        {
            dp[i] = new Node(1, 1);  // 1 element is always a wiggle subsequence
        }
        
        int ans = 1;
        for(int i=1; i<nums.length; i++)
        {
            for(int j=0; j<i; j++)
            {
                if( nums[i] > nums[j] )
                {
                    // increasing
                    dp[i].inc = Math.max(dp[j].dec + 1, dp[i].inc);
                    
                }
                else if( nums[i] < nums[j] )
                {
                    // decreasing
                    dp[i].dec = Math.max(dp[j].inc + 1, dp[i].dec);   
                }
            }
            
            ans = Math.max(ans, Math.max(dp[i].inc, dp[i].dec));
        }
        
        return ans;
        
    }

    public int wiggleMaxLength(int[] nums) {
        // optimized version - O(N)
        
        if( nums.length == 0 )
            return 0;
        
        int[] inc = new int[nums.length];
        int[] dec = new int[nums.length];
        
        inc[0] = 1;
        dec[0] = 1;
        
        for(int i=1; i<nums.length; i++)
        {
            if( nums[i] > nums[i-1] )
            {
                // increasing
                inc[i] = dec[i-1] + 1;
                dec[i] = dec[i-1];  // carry it over
            }
            
            else if( nums[i] < nums[i-1] )
            {
                // decreasing
                dec[i] = inc[i-1] + 1;
                inc[i] = inc[i-1];  // carry it over
            }
            
            else
            {
                // carry them over
                inc[i] = inc[i-1];
                dec[i] = dec[i-1];
            }
        }
        
        return Math.max(inc[nums.length - 1], dec[nums.length - 1]);
        
    }
}