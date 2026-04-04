class Solution {
    public int maxProfit(int[] prices) {
        int smallest_so_far = prices[0];
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++)
        {
            if(prices[i]<smallest_so_far)
            {
                smallest_so_far = prices[i];
            }
            else
            {
                int profit = prices[i] - smallest_so_far;
                if(profit>maxProfit)
                {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
