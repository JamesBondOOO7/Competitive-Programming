public class MaxSubarraySizeLessThanK {
    public static void main(String[] args) {
        // Maximum subarray size, such that all subarrays of that size have sum less than k
        // all elements are positive

        int[] arr = {1, 2, 3, 4};
        int k = 8;

        System.out.println(maxSubK_PrefixSum(arr, arr.length, k));
    }

    public static int maxSubK_PrefixSum(int[] arr, int n, int k)
    {
        int[] prefixSum = new int[n+1];

        for(int i=1; i < n+1; i++)
        {
            prefixSum[i] += prefixSum[i-1] + arr[i-1];
        }

        // as all elements are positive
        // prefix sum will be an increasing array
        // find the place, using Binary Search
        return BinarySearch(prefixSum, n, k);
    }

    public static int BinarySearch(int[] prefixSum, int n, int k)
    {
        int ans = -1;

        int left = 1, right = n;

        while( left <= right )
        {
            int mid = (left + right)/2;

            int i;
            for(i=mid; i<=n; i++)
            {
                // check if all subarrays of size mid
                // have sum less than or equak to k
                if( prefixSum[i] - prefixSum[i-mid] > k)
                    break;
            }

            // if all subarrays of size mid
            // have sum <= k
            // increase the size then
            if(i==n+1)
            {
                ans = mid;
                left = mid + 1;
            }

            // it breaked from the loop
            // => subarray size is big
            // reduce it
            else
                right = mid - 1;
        }
        return ans;
    }
}
