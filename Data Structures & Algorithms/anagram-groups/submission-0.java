class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> hm = new HashMap();
        for(int i =0; i<strs.length; i++)
        {
            char [] stringArray = strs[i].toCharArray();
            Arrays.sort(stringArray);
            String s = new String(stringArray);
            
            hm.computeIfAbsent(s, v -> new ArrayList()).add(strs[i]);
        }
        hm.forEach((key,value) -> res.add(value));
        return res;
    }
}
