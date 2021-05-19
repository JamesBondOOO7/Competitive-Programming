class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr, new Comparator<Item>() {
            
            public int compare(Item a, Item b)
            {
                return b.value*a.weight - a.value*b.weight;
            }
        });
        
        double ans = 0.0;
        
        for(Item it : arr )
        {
            int wt = it.weight;
            int val = it.value;
            
            if( W > wt )
            {
                W -= wt;
                ans += val;
            }
            
            else
            {
                ans += (val*W)/(double)wt;
                break;
            }
        }
        
        return ans;
    }
}