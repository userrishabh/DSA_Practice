class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        getSubsets(nums, new ArrayList<>(), 0);
        return res;
    }

    void getSubsets(int[] nums, List<Integer> arr, int index)
    {
        res.add(new ArrayList<>(arr));
        
        for(int i=index; i<nums.length; i++)
        {
            arr.add(nums[i]);

            getSubsets(nums, arr, i+1);

            arr.remove(arr.size()-1);
        }

    }
}
