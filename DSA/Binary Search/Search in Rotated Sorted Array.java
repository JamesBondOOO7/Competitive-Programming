class Solution {
    public int search(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;
        // 1. Find the pivot element
        // 2. Then search the target in the required half
        while(lo<=hi)
        {
            mid = (lo+hi)/2;
            
            if( arr[mid] == target )
                return mid;
            
            else if( arr[mid] >= arr[lo] )
            {
                if( target >= arr[lo] && target < arr[mid] )
                {
                    hi = mid - 1;
                }
                else
                {
                    lo = mid + 1;
                }
            }
            
            else
            {
                if( target > arr[mid] && target <= arr[hi] )
                {
                    lo = mid + 1;
                }
                else
                {
                    hi = mid - 1;
                }
            }
        }
        
        return -1;
        
    }
    
}