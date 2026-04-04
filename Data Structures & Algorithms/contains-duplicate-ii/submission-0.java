class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0)
            return false;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<nums.length; i++)
        {
            if(hs.contains(nums[i]))
                return true;
            
                if(i>=k)
                    hs.remove(nums[i-k]);
                hs.add(nums[i]);
            
        }

        return false;
    }
}