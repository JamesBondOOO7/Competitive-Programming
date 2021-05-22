class Solution
{
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        // LIS problem
        // similar to leetcode 354
        
        ArrayList<int[]> box = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            
            int l = length[i];
            int w = width[i];
            int h = height[i];
            int[] arr = {l,w,h};
            Arrays.sort(arr);
            
            // length > width
            box.add(new int[] {arr[1], arr[0], arr[2]});
            box.add(new int[] {arr[2], arr[1], arr[0]});
            box.add(new int[] {arr[2], arr[0], arr[1]});
            
        }
        
        Collections.sort(box, new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                return b[0]*b[1] - a[0]*a[1];
            }
        });
        
        // for(int[] a : box)
        // {
        //     for(int ele : a)
        //         System.out.print(ele + " ");
                
        //     System.out.println();
        // }
        
        int[] dp = new int[box.size()];
        int ans = dp[0];
        for(int i=0; i<box.size(); i++)
        {
            dp[i] = box.get(i)[2];
            // ans = Math.max(dp[i], ans);
        }
        
        for(int i=1; i<dp.length; i++)
        {
            int curr = box.get(i)[0]*box.get(i)[1];
            
            for(int j=0; j<i; j++)
            {
                int prev = box.get(j)[0]*box.get(j)[1];
                
                if( prev > curr )
                {
                    if( box.get(j)[0] > box.get(i)[0] && box.get(j)[1] > box.get(i)[1] )
                    {
                        dp[i] = Math.max(dp[i], dp[j] + box.get(i)[2]);
                    }
                    
                    else if( box.get(j)[0] > box.get(i)[1] && box.get(j)[1] > box.get(i)[0] ) // rotating
                    {
                        dp[i] = Math.max(dp[i], dp[j] + box.get(i)[2]);
                    }
                }
            }
            
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
    
}