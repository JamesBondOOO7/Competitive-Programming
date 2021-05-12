class Solution {
    public int shipWithinDays(int[] weights, int D) {
        // minimize the max capacity => Binary Search
        
        int lo = 0;
        int hi = 10000000;
        
        int ans = hi;
        while( lo <= hi )
        {
            int mid = (lo + hi)/2;
            int count = check(weights, D, mid);
            
            if( count <= D ) // <= D
            {
                // means we can also decrease the capacity !!
                hi = mid - 1;
                ans = mid;
            }
            
            else
                lo = mid + 1;
        }
        
        return ans;
    }
    
    public static int check(int[] weights, int D, int capacity)
    {
        int count = 1;
        int sum = 0;
        for(int wt : weights)
        {
            if( wt > capacity )
                return Integer.MAX_VALUE;
            
            if( sum + wt <= capacity )
                sum += wt;
            
            else // if ( sum > capacity )
            {
                sum = wt;
                count += 1;
            }
        }
        
        if(count <= D)
            return D;
        
        return count;
    }
}