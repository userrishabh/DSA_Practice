class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tabu = new int[nums.length];
        Arrays.fill(tabu, 1);
        int res = 1;
        for(int i=0; i<nums.length; i++)
            for(int j=0; j<i; j++)
            {
                if(nums[j]<nums[i])
                   {
                        tabu[i] = Math.max(tabu[i], tabu[j]+1);

                        res = Math.max(tabu[i], res);
                   }
            }

        return res;
    }
}
