import java.util.*;
public class Main {
    public static void main(String args[]) {

        // task is to find the minimum number of increasing subsequneces
        // which is same as to find the longest decreasing subsequence
        // how to find it ?

        // multiply each element by -1
        // find the LIS
        int[] arr = {1, 3, 2, 4};
        for(int i=0; i<arr.length; i++)
            arr[i] = -arr[i];

        System.out.println(lengthOfLIS(arr));
        
    }

    public static int lengthOfLIS(int[] nums) {
        
        if( nums == null || nums.length == 0)
            return 0;
        
        if( nums.length == 1 )
            return 1;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for(int i=0; i<dp.length; i++)
        {
            int pos = binarySearchPosition(dp, nums[i], i);
            dp[pos] = nums[i];        
        }
        
        for(int i = dp.length - 1;i >= 0;i--)
        {
            if(dp[i] != Integer.MAX_VALUE)
                return i + 1;
        }
        return 1;
    }
    
    public static int binarySearchPosition(int[] dp, int target, int hi)
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

