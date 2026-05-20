class Solution {
    public int climbStairs(int n) {
        if(n<0) return 0;
        if(n==0) return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return getTotalPossibilities(dp, n);
        
    }

    int getTotalPossibilities(int[] dp, int n)
    {
        if(n<0) return 0;
        if(n==0) return 1;
        if(dp[n] != -1) return dp[n];

        return dp[n] = getTotalPossibilities(dp, n-1) + getTotalPossibilities(dp, n-2);
    }
}
