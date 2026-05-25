class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[][] memo = new int[nums.length][nums.length];

        for(int[] d : memo)
            Arrays.fill(d, -1);

        return getLis(nums, 0, -1, memo);
    }

    int getLis(int[] nums, int indx, int prevIndex, int[][] memo)
    {
        if(indx >= nums.length) return 0;
        if(prevIndex > -1 && memo[indx][prevIndex] != -1) return memo[indx][prevIndex];
        int take = 0;
        if(prevIndex == -1 || nums[indx] > nums[prevIndex])
            take = 1+getLis(nums, indx+1, indx, memo);
        int skip = getLis(nums, indx+1, prevIndex, memo);

        return prevIndex > -1 ? memo[indx][prevIndex] = Math.max(take, skip) : Math.max(take, skip);
    }
}
