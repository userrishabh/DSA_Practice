class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        return Math.max(getTotalAmount(nums, 0, nums.length-2), getTotalAmount(nums, 1, nums.length-1));
    }

    int getTotalAmount(int[] nums, int indx, int n)
    {
        if(indx > n) return 0;

        int steal = nums[indx]+getTotalAmount(nums, indx+2, n);
        int skipped = getTotalAmount(nums, indx+1, n);

        return Math.max(steal, skipped);


    }
}
