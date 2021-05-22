class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        // both width and height of the envelope should be greater
        // similar approach t0 building bridges problem
        // we have to sort the array on the basis of 1st element
        // and find LIS on the basis of the 2nd element
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
            
            public int compare(int[] a, int[] b)
            {
                int val = a[0] - b[0];
                if( val != 0 )
                    return val;
                
                return b[1] - a[1]; // Important optimization !!
            }
        });
        
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for(int i=0; i<envelopes.length; i++)
        {
            int pos = binarySearch(dp, envelopes[i][1], i);
            
            dp[pos] = envelopes[i][1];
        }
        
        for(int i=dp.length-1; i>=0; i--)
        {
            if( dp[i] != Integer.MAX_VALUE )
                return i+1;
        }
        return 1;
    }
    
    public static int binarySearch(int[] dp, int target, int hi)
    {
        int lo = 0;
        
        while( lo<= hi )
        {
            int mid = lo + (hi - lo)/2;
            
            if( dp[mid] == target )
                return mid;
            
            else if( target > dp[mid] )
                lo = mid + 1;
            
            else
                hi = mid - 1;
        }
        
        return lo;
    }
}