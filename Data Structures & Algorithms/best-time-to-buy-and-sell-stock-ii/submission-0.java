class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int num = prices[0];
        for(int i=0; i<prices.length; i++)
        {
            if(prices[i] > num)
               {
                sum += prices[i]-num;
               }
               num=prices[i];
            
        }
        return sum;
    }
}