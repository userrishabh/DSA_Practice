class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] tab = new int[nums.length];
        int[] tab2 = new int[nums.length];
        tab2[0]=0;
        tab2[1] = nums[1];

        tab[0] = 0;
        tab[1] = nums[0];

        for(int i=2; i<nums.length; i++)
            {
                tab[i] = Math.max(tab[i-1], nums[i-1]+tab[i-2]);
                tab2[i] = Math.max(tab2[i-1], nums[i]+tab2[i-2]);
            }

        return Math.max(tab2[nums.length-1], tab[nums.length-1]);
    }
}
