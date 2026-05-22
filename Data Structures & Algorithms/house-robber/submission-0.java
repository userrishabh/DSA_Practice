class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return totalAmount(nums, 0, memo);
    }

    int totalAmount(int[] nums, int ind, int[] memo)
    {
        if(ind >= nums.length) return 0;
        if(memo[ind] != -1) return memo[ind];
        return memo[ind] = Math.max(totalAmount(nums, ind+1, memo), nums[ind]+totalAmount(nums, ind+2, memo));
    }
}
