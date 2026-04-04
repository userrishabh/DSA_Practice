class Solution {
    public int trap(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int lMax = 0;
        int rMax = 0;
        int res = 0;

        while(leftPointer<rightPointer)
        {
            if(height[leftPointer] < height[rightPointer])
            {
                if(lMax <= height[leftPointer])
                    lMax = height[leftPointer];
                else
                {
                    res += lMax - height[leftPointer];
                }
                leftPointer++;
            }
            else
            {
                if(rMax < height[rightPointer])
                    rMax = height[rightPointer];
                else
                {
                    res += rMax - height[rightPointer];
                }
                rightPointer--;
            }
        }
        return res;
    }
}
