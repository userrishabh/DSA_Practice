class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();

        getCombinationSum(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    void getCombinationSum(int[] candidates, int target, List<List<Integer>> res, int index, List<Integer> helper)
    {
        if(target == 0)
        { res.add(new ArrayList(helper));
        return;
        }
        if(candidates.length == index || target < 0) 
        {
            return;
        }
        helper.add(candidates[index]);

        getCombinationSum(candidates, target-candidates[index], res, index, helper);
        helper.remove(helper.size() - 1);
        getCombinationSum(candidates, target, res, index+1, helper);
    }
}
