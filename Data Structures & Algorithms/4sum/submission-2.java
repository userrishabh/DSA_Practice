class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int arrLength = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<arrLength-3; i++)
        {
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<arrLength-2;j++)
            {
                if(j>i+1 && nums[j] == nums[j-1]) continue;

                long tempSum = nums[i] + nums[j];
                long tempTarget = target - tempSum;
                int leftPointer = j+1;
                int rightPointer = arrLength-1;
                while(leftPointer<rightPointer)
                {
                    long sum = nums[leftPointer] + nums[rightPointer];
                    if(sum == tempTarget)
                    {   ArrayList<Integer> tempRes = new ArrayList<>();
                        tempRes.add(nums[i]);
                        tempRes.add(nums[j]);
                        tempRes.add(nums[leftPointer]);
                        tempRes.add(nums[rightPointer]);
                        res.add(tempRes);

                        leftPointer++;
                        rightPointer--;
                        while(leftPointer<rightPointer && nums[leftPointer] == nums[leftPointer-1])
                        {
                            leftPointer++;
                        }
                        while(leftPointer<rightPointer && nums[rightPointer] == nums[rightPointer+1])
                        {
                            rightPointer--;
                        }
                    }
                    else if(sum<tempTarget)
                        leftPointer++;
                    else
                        rightPointer--;
                }
            }
        }
        return res;
    }
}