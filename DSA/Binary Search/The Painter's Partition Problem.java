class Solution{
    static long minTime(int[] arr,int n,int k){
        long lo = 1;
        long hi = (long)1000000000;
        long ans = -1;
        while( lo<=hi )
        {
            long mid = (lo + hi)/2;
            
            if(check(arr, mid, k) <=k)
            {
                hi = mid - 1;
                ans = mid;
            }
            else
                lo = mid + 1;
        }
        
        return ans;
    }
    
    public static int check(int[] arr, long mid, int k)
    {
        int count = 1;
        long sum = 0;
        for(int ele : arr)
        {
            if( ele > mid )
                return Integer.MAX_VALUE;
                
            if (sum + ele <= mid)
                sum += ele;
                
            else
            {
                sum = ele;
                count++;
            }
        }
        
        return count;
    }
}
