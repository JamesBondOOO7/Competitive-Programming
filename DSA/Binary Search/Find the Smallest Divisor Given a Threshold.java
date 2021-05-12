class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        // Binary Search
        int lo = 1;
        int hi = 1000000000;
        int ans = -1;
        
        while( lo<=hi )
        {
            int mid = lo + (hi-lo)/2;
            
            int curr_sum = check(nums, mid, threshold);
            
            if( curr_sum <= threshold )
            {
                ans = mid;
                hi = mid - 1;
            }
            else
                lo = mid + 1;
        }
        
        return ans;
    }
    
    public static int check(int[] nums, int mid, int threshold)
    {
        int sum = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum += nums[i]/mid;
            
            if(nums[i] % mid != 0)
                sum++;
        }
        
        return sum;
    }
}