class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int arrLength = heights.length;
        int leftPointer = 0;
        int rightPointer = arrLength - 1;
        while(leftPointer<rightPointer)
        {
            int diff = rightPointer - leftPointer;
            int smaller = 0;
            if(heights[leftPointer]<heights[rightPointer])
            {
                smaller = heights[leftPointer];
                leftPointer++;
            }
            else
            {
                smaller = heights[rightPointer];
                rightPointer--;
            }
            
            int tempRes = smaller*diff;
            if(tempRes > res)
                res = tempRes;
        }
        return res;
    }
}
