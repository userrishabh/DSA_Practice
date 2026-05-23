class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int robA = 0;
        int robB = nums[0];

        int robC = 0;
        int robD = nums[1];

        for(int i=1; i<nums.length-1; i++)
            {
                int tempRobB = robB;
                robB = Math.max(robB, robA+nums[i]);
                robA = tempRobB;

                int tempRobD = robD;
                robD = Math.max(robD, robC+nums[i+1]);
                robC = tempRobD;
            }

        return Math.max(robB, robD);
    }
}
