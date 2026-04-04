class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j= numbers.length-1;
        int index1 = 1;
        int index2 = 2;
        while(i<j)
        {
            int tempSum = numbers[i]+numbers[j];
            if(tempSum == target)
            {
                index1 = i+1;
                index2=j+1;
                break;
            }
            else if(tempSum > target)
            {
                j--;
            }
            else
            {
                i++;
            }

        }
        return new int[] {index1, index2};
    }
}
