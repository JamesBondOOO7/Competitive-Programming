class Solution {

    // My solution
    public int jump(int[] nums) {
        
        int[] steps = new int[nums.length];
        Arrays.fill(steps, 1000000);
        steps[0] = 0;
        
        for(int i=0; i<nums.length-1; i++)
        {
            for(int j=0; j<=nums[i]; j++)
            {
                if( i+j >= nums.length )
                    break;
                
                steps[i+j] = Math.min(steps[i] + 1, steps[i+j]);
            }
        }
        
        // for(int ele : steps)
        //     System.out.print(ele + " ");
        
        return steps[nums.length - 1];
    }

    public int jump_Leet(int[] nums) 
    {
        int n = nums.length, jumps = 1, max = nums[0], curMax = 0;
        
        if(n == 0 || n == 1) return 0;

        for(int i = 1; i < n-1; i++)
        {
            curMax = Math.max(curMax, i + nums[i]);
            if(i == max)
            {
              max = curMax;
              jumps++;
            } 
        }

        return jumps;
    }
}