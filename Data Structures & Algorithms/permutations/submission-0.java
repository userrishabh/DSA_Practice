class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        getPermutation(res, nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    void getPermutation(List<List<Integer>> res, int[] nums, List<Integer> helper, boolean[] helperBool)
    {
        if(nums.length == helper.size())
        {
            res.add(new ArrayList<>(helper));
            return;
        }

        for(int i=0; i<nums.length; i++)
        {
            if(helperBool[i]) continue;
                
            helperBool[i] = true;
            helper.add(nums[i]);
            getPermutation(res, nums, helper, helperBool);

            helperBool[i] = false;
            helper.remove(helper.size()-1);

        }

    }
}
