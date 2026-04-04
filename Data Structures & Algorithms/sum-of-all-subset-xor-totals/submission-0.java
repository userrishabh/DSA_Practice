class Solution {
    public int subsetXORSum(int[] nums) {
        return getSubsetXorSum(nums, 0, 0);
    }

    int getSubsetXorSum(int[] nums, int i, int xor)
    {
        if(nums.length == i) return xor;

        int inclusion = getSubsetXorSum(nums, i+1, xor^nums[i]);

        int exclusion = getSubsetXorSum(nums, i+1, xor);

        return inclusion+exclusion;
    }
}