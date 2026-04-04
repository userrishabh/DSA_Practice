class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        System.out.println(nums.length);
        for(int i : nums)
            hs.add(i);
        int resCount = 0;
        for(int i : hs)
        {
            int temp = i;
            if(hs.contains(temp-1))
                continue;
            int tempCount = 0;
            while(hs.contains(temp))
             {   tempCount++;
                temp++;
             }
             resCount = resCount<tempCount ? tempCount : resCount;
        }
        return resCount;
    }
}
