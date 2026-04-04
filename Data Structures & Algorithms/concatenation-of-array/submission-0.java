class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = new int[2*len];
        int i = 0;
        for (i = 0; i<len; i++)
        {
            ans[i] = nums[i];
            ans[i+len] = nums[i];
        }
        return ans;
    }
}