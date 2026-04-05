class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int arrLength = height.length;
        int leftPointer = 0;
        int rightPointer = arrLength - 1;
        while(leftPointer<rightPointer)
        {
            int diff = rightPointer - leftPointer;
            int smaller = 0;
            if(height[leftPointer]<height[rightPointer])
            {
                smaller = height[leftPointer];
                leftPointer++;
            }
            else
            {
                smaller = height[rightPointer];
                rightPointer--;
            }
            
            int tempRes = smaller*diff;
            if(tempRes > res)
                res = tempRes;
        }
        return res;
    }
}
