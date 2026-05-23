class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        int[] memo = new int[nums.length];
        int [] memo2 = new int[nums.length];
        Arrays.fill(memo2, -1);
        Arrays.fill(memo, -1);
        return Math.max(getTotalAmount(nums, 0, nums.length-2, memo), getTotalAmount(nums, 1, nums.length-1, memo2));
    }

    int getTotalAmount(int[] nums, int indx, int n, int[] memo)
    {
        if(indx > n) return 0;
        if(memo[indx] != -1) return memo[indx];
        int steal = nums[indx]+getTotalAmount(nums, indx+2, n, memo);
        int skipped = getTotalAmount(nums, indx+1, n, memo);

        memo[indx] = Math.max(steal, skipped);

        return memo[indx];

    }
}
