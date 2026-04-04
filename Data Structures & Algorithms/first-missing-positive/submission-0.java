class Solution {
    public int firstMissingPositive(int[] nums) {
        int smallest = 0;
        int greatest = 0;
        int n = nums.length;
        for(int i = 0; i<n; i++)
        {
            if(nums[i] !=  i+1)
            {
                int temp = nums[i];
                while(nums[i]>0 && nums[i]<n+1 && nums[i] != nums[nums[i]-1] )
                {
                    int temp2 = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp2;
                }
            }
        }

        for(int i=0; i<n; i++)
        {
            if(nums[i] != i+1)
                return i+1;
        }
        return n+1;
    }
}