class Solution {
    public int splitArray(int[] nums, int m) {
        // minimize the largest sum : Binary Search
        
        int lo = 0;
        int hi = 1000000000;
        int ans = -1;
        while( lo<=hi )
        {
            int mid = lo + (hi - lo)/2;
            
            if( check(nums, mid) <= m )
            {
                hi = mid - 1;
                ans = mid;
            }
            else
                lo = mid + 1;
            
        }
        
        return ans;
    }
    
    public static int check(int[] nums, int mid)
    {
        int curr = 0;
        int count = 1;
        
        for(int ele : nums )
        {
            if( ele > mid )
                return Integer.MAX_VALUE;
            
            if( curr + ele <= mid )
                curr += ele;
            
            else
            {
                curr = ele;
                count += 1;
            }
        }
        
        return count;
    }
}