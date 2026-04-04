class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        getCombination(n, k, res, new ArrayList<>());
        return res;
    }

    void getCombination(int n, int k, List<List<Integer>> res, List<Integer> helper)
    {
        if(helper.size() == k)
        {
            res.add(new ArrayList<>(helper));
            return;
        }
        if(n==0) return;

        helper.add(n);

        getCombination(n-1, k, res, helper);

        helper.remove(helper.size()-1);

        getCombination(n-1, k, res, helper);
    }
}