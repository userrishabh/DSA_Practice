class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int res = length;

        for(int i=0; i<length; i++)
        {
            res += i - nums[i];
        }
    return res;
    }
}
