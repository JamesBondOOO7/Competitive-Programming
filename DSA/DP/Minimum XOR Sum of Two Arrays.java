class Solution {
    public static int[][] dp;
    
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        dp = new int[n][(1 << n)];
        
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);
        
        return dpMask(nums1, nums2, 0, (1<<n)-1, n);
    }
    
    public static int dpMask(int[] A, int[] B, int i, int mask, int n)
    {
        if( i == n )
            return 0;
        
        if( dp[i][mask] != -1 )
            return dp[i][mask];
        
        int answer = Integer.MAX_VALUE;
        for(int j=0; j<n; j++)
        {
            if( (mask & (1 << j)) != 0 )
            {
                answer = Math.min(answer, (A[i] ^ B[j]) + dpMask(A, B, i + 1, (mask ^ (1<<j)), n));
            }
        }
        
        dp[i][mask] = answer;
        return answer;
    }
}