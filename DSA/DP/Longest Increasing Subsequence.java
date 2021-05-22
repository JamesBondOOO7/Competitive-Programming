class Solution {

    // O(n*n) solution
    public int lengthOfLIS_MySol(int[] nums) {
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        int ans = 1;
        for(int i=1; i<nums.length; i++)
        {
            for(int j=i-1; j>=0; j--)
            {
                if( nums[i] > nums[j] )
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }

    // O(nlogn) Solution
    public int lengthOfLIS(int[] nums) {
        
        if( nums == null || nums.length == 0)
            return 0;
        
        if( nums.length == 1 )
            return 1;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for(int i=0; i<dp.length; i++)
        {
            int pos = binarySearchPosition(dp, nums[i], i);
            dp[pos] = nums[i];        }
        
        for(int i = dp.length - 1;i >= 0;i--)
        {
            if(dp[i] != Integer.MAX_VALUE)
                return i + 1;
        }
        return 1;
    }
    
    public int binarySearchPosition(int[] dp, int target, int hi)
    {
        int lo = 0;
        
        while( lo<=hi )
        {
            int mid = lo + (hi - lo)/2;
            
            if( target == dp[mid] )
                return mid;
            
            else if( target > dp[mid] )
                lo = mid + 1;
            
            else
                hi = mid - 1;
        }
        
        return lo;
    }
}