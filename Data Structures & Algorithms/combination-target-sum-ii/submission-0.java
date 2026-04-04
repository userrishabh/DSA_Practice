class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        getCombinationSum(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    void getCombinationSum(int[] candidates, int target, List<List<Integer>> res, List<Integer> helper, int index)
    {
        if(target == 0) 
        {
            res.add(new ArrayList<>(helper));
            return;
        }

            for(int i=index; i<candidates.length; i++)
            {
                if(i>index && candidates[i] == candidates[i-1]) continue;
                if(target<candidates[i]) return;
                helper.add(candidates[i]);

                getCombinationSum(candidates,target-candidates[i], res, helper, i+1);

                helper.remove(helper.size()-1);
            }
        

    }
}
