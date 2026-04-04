class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        getParenthesis(res, new StringBuilder(), n, n);

        return res;
    }

    void getParenthesis(List<String> res, StringBuilder helper, int open, int closed)
    {
        if(open == 0 && closed == 0)
        {
            res.add(helper.toString());
        }

        if(open>0)
        {
            helper.append('(');
            getParenthesis(res, helper, open-1, closed);
            helper.deleteCharAt(helper.length() -1);
        }

        
        if(closed > open)
        {
            helper.append(')');
            getParenthesis(res, helper, open, closed-1);
            helper.deleteCharAt(helper.length() -1);
        }
        
    }
}
