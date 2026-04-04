class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int resSeq = Integer.MAX_VALUE;
        int leftPointer = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum+=nums[i];
            if(sum>=target)
            {while(sum >= target)
            {
                sum -= nums[leftPointer];
                leftPointer++;
            }
            resSeq = Math.min(resSeq, i-leftPointer+2);
            }
        }
        if(resSeq == Integer.MAX_VALUE)
            return 0;
        return resSeq;
    }
}