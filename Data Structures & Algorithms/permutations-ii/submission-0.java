class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        getPermuteUnique(res, nums, new ArrayList<>(), new boolean[nums.length]);

        return res;
    }

    void getPermuteUnique(List<List<Integer>> res, int[] nums, List<Integer> helper, boolean[] helperBool)
    {
    if(nums.length == helper.size())
    {
        res.add(new ArrayList<>(helper));
        return;
    }

    for(int i=0; i<nums.length; i++)
    {
        if(helperBool[i]) continue;
        if(i>0 && nums[i] == nums[i-1] && !helperBool[i-1]) continue; // if previous identical number is used then consider else do not consider
        helperBool[i] = true;
        helper.add(nums[i]);
        getPermuteUnique(res, nums, helper, helperBool);

        helperBool[i] = false;
        helper.remove(helper.size()-1);

    }
    }
}