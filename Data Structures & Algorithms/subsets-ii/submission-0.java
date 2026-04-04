class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        getSubsetWithDup(nums, res, 0, new ArrayList<>());

        return res;
    }

    void getSubsetWithDup(int[] nums, List<List<Integer>> res, int index, List<Integer> helper)
    {
        res.add(new ArrayList<>(helper));

        for(int i = index; i<nums.length; i++)
        {
            if(i>index && nums[i] == nums[i-1]) continue;
            helper.add(nums[i]);
            getSubsetWithDup(nums, res, i+1, helper);

            helper.remove(helper.size()-1);
        }
    }
}
