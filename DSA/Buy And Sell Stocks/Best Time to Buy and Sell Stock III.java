class Solution {
    public int maxProfit(int[] prices) {
        
        // Max Profit on day =
        // Max Profit if I had bought and sold the stocks before or on this day +
        // Max Profit if I will buy the stock on this day or after and sell it later on the max Price
        // Note : these are non-overlapping
     
        int[] past = new int[prices.length];
        int[] future = new int[prices.length];
        
        // past to day ith
        // maximizing profit if I make a transaction before or upto day ith
        int cp = prices[0];  // cp : cost price
        past[0] = 0;
        
        for(int i=1; i<prices.length; i++)
        {
            past[i] = Math.max(prices[i] - cp, past[i-1]);
            cp = Math.min(cp, prices[i]);
        }
        
        // ith day to the future
        // maximizing profit if I make a transaction on or after ith day
        int sp = prices[prices.length - 1];  // sp : sell price
        future[prices.length - 1] = 0;
        
        for(int i=prices.length-2; i>=0; i--)
        {
            future[i] = Math.max(sp - prices[i], future[i+1]);
            sp = Math.max(sp, prices[i]);
        }
        
        // Now, our answer will be the max of the sum of the past and future profits
        // on the days from i=0 to i=prices.length-1
        
        int ans = 0;
        for(int i=0; i<prices.length; i++)
        {
            ans = Math.max(ans, past[i] + future[i]);
        }
        
        return ans;
    }
}