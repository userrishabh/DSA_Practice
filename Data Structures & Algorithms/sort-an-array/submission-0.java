class Solution {
    public int[] sortArray(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        return mergeSort(nums, startIndex, endIndex);
    }

    public int[] mergeSort(int[] nums, int startIndex, int endIndex)
    {
        if(startIndex == endIndex) return new int[] {nums[startIndex]};
        int mid = startIndex + (endIndex-startIndex)/2;
       int[] part1 = mergeSort(nums, startIndex, mid);
        int [] part2 = mergeSort(nums, mid+1, endIndex);
       return merge(part1, part2);
    }

    public int[] merge(int[] part1, int[] part2)
    {
        int[] res = new int[part1.length + part2.length];
        
        int i=0, j=0;
        while(i<part1.length && j<part2.length)
        {
            if(part1[i]<part2[j])
            {
                res[i+j] = part1[i];
                ++i;
            }
            else
            {
                res[i+j] = part2[j];
                ++j;
            }
        }
        
            while(i<part1.length)
                {res[i+j] = part1[i];
                    i++;
                }
        
        
            while(j<part2.length)
               { res[i+j] = part2[j];
                j++;
               }
        
        return res;

    }
}