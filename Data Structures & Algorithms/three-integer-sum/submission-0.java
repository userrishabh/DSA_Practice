class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int numsLength = nums.length;
        for(int i=0; i<numsLength-2; i++)
        {
            int target = nums[i] != 0 ? 0-nums[i] : 0;;
            int leftPointer = i+1;
            int rightPointer = numsLength-1;
            if(i>0 && nums[i] == nums[i-1]) continue;
            while(leftPointer<rightPointer)
            {
                int tempSum = nums[leftPointer] + nums[rightPointer];
                if(tempSum == target)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[leftPointer]);
                    temp.add(nums[rightPointer]);
                   
                    res.add(temp);
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
                else if(tempSum > target)
                {
                    rightPointer--;
                }
                else
                {
                    leftPointer++;
                }

            }
        }
        return res;
    }
}
