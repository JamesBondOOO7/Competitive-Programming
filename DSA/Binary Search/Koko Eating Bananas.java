class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        // minimize the maximum eating speed : Binary Search
        
        int hi = 1000000000, lo = 1;
        
        // for(int ele : piles)
        // {
        //     hi = Math.max(ele, hi);
        //     lo = Math.min(ele, lo);
        // }
        
        int k = 0;
        while( lo<=hi )
        {
            int mid = lo + (hi - lo)/2;
            
            if( check(piles, mid) <= h )
            {
                hi = mid - 1;
                k = mid;
            }
            else
                lo = mid + 1;
        }
        return k;
    }
    
    public static int check(int[] piles, int mid)
    {
        int count = 0;   
        for(int i=0; i<piles.length; i++)
        {
            if(piles[i] > mid) 
            {
                count += piles[i]/mid;
                
                if( piles[i] % mid != 0)
                    count+=1;
            }
            
            else if( piles[i] <= mid )
                count += 1;
        }
        // 😂
        
        return count;
    }
}