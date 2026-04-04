class Solution {
    public void rotate(int[] nums, int k) {
        int totalLength = nums.length;
        int partitionPointer = k%(totalLength);
        int leftPointer = 0;
        int rightPointer = totalLength-partitionPointer-1;
        while(leftPointer < rightPointer)
        {
            int temp = nums[leftPointer];
            nums[leftPointer] = nums[rightPointer];
            nums[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
        leftPointer = totalLength - partitionPointer;
        rightPointer = totalLength-1;
        while(leftPointer<rightPointer)
        {
            int temp = nums[leftPointer];
            nums[leftPointer] = nums[rightPointer];
            nums[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
        leftPointer = 0;
        rightPointer = totalLength - 1;
        while(leftPointer < rightPointer)
        {
            int temp = nums[leftPointer];
            nums[leftPointer] = nums[rightPointer];
            nums[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
    }
}