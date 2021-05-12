class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if( nums1.length > nums2.length )
        {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int x = nums1.length;
        int y = nums2.length;
        
        int low = 0;
        int high = x;
        
        while( low <= high )
        {
            int px = ( low + high )/2;
            int py = ( x + y + 1)/2 - px;
            
            int maxLeftX = ( px == 0 )? Integer.MIN_VALUE : nums1[px-1];
            int minRightX = ( px == x )? Integer.MAX_VALUE : nums1[px];
            
            int maxLeftY = ( py == 0 )? Integer.MIN_VALUE : nums2[py-1];
            int minRightY = ( py == y )? Integer.MAX_VALUE : nums2[py];
            
            if( maxLeftX <= minRightY && maxLeftY <= minRightX )
            {
                // Partition found !!
                
                if( (x+y) % 2 == 0 ) // Even length
                {
                    return ( (double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                }
                else
                {
                    return (double)Math.max(maxLeftX, maxLeftY); // as in the odd case, left partition will
                    // have 1 extra element = median
                }
            }
            
            else if( maxLeftX > minRightY )
            {
                // we need to go towards a lower partition in X
                high = px - 1;
            }
            
            else
            {
                // we need to go towards a higher partition in X
                low = px + 1;
            }
        }
        
        return 0.0;
    }
}