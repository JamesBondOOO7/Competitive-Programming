class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        int sell = prices[prices.length - 1];
        
        for(int i=prices.length-2; i>=0; i--)
        {
            profit = Math.max( sell - prices[i] , profit);
            
            sell = Math.max(sell, prices[i]);
        }
        
        return profit;
    }
}