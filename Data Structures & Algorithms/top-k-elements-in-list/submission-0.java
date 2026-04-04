class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> frequencyMap= new HashMap<Integer,Integer>();
        int[] res = new int[k];
        for(int i=0; i<nums.length; i++)
        {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0)+1);
        }
        HashMap<Integer, List<Integer>> frequencyToElementMap = new HashMap<>();
        for(int num : frequencyMap.keySet())
        {
            int freq = frequencyMap.get(num);
            frequencyToElementMap.putIfAbsent(freq,new ArrayList<>());
            frequencyToElementMap.get(freq).add(num);
        }
        int i = nums.length;
        int j = 0;
        while(i>0)
        {
            if(frequencyToElementMap.containsKey(i))
            {
                for(int num : frequencyToElementMap.get(i))
                {
                    if(j != k)
                    {
                        res[j]=num;
                        ++j;
                    }
                    else
                    {
                        return res;
                    }
                }
            }
            --i;
        }
        return res; 
    }
}
