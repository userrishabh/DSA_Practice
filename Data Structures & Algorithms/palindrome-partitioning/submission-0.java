class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        getPartition(s, res, 0, new ArrayList<>());
        return res;
    }

    void getPartition( String s, List<List<String>> res, int index, List<String> helper)
    {
        if(index == s.length())
        {
            res.add(new ArrayList<>(helper));
            return;
        }

        for(int last = index; last<s.length(); last++)
        {
            if(isPalindrome(s, index, last))
            {
                helper.add(s.substring(index, last+1));
                getPartition(s, res, last+1, helper);
                helper.remove(helper.size()-1);
            }
        }

    }

    boolean isPalindrome(String s, int initial, int last)
    {
        while(initial<last)
            if (s.charAt(initial++) != s.charAt(last--)) return false;

        return true;
    }
}
