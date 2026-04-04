class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int arrLength = nums.length;
        int i=0;
        int j=1;
        while(j<arrLength)
        {
            if(nums[i] != nums[j])
            {
                nums[i+1] = nums[j];
                i++;
                k++;
            }
            j++;
        }
        return k;
    }
}