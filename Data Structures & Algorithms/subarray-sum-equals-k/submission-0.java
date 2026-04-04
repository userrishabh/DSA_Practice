class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int prefix = 0;
        int res = 0;
        hm.put(0,1);
        for(int i=0; i<nums.length; i++)
        {
            prefix += nums[i];
            if(hm.containsKey(prefix - k))
                res += hm.get(prefix-k);
            hm.put(prefix, hm.getOrDefault(prefix, 0) +1);
        }
        return res;
    }
}