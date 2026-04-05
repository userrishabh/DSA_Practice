class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        String[] stringMapping = new String[10];

        stringMapping[2] = "abc";
        stringMapping[3] = "def";
        stringMapping[4] = "ghi";
        stringMapping[5] = "jkl";
        stringMapping[6] = "mno";
        stringMapping[7] = "pqrs";
        stringMapping[8] = "tuv";
        stringMapping[9] = "wxyz";

        getCombinations(digits, stringMapping, res, new StringBuilder(), 0);
        return res;
    }

    void getCombinations(String digits, String[] stringMapping, List<String> res, StringBuilder helper, int index)
    {
        if(digits.length() == index)
        {
            res.add(helper.toString());
            return;
        }

        String tempString = stringMapping[digits.charAt(index) - '0'];

        for(char c : tempString.toCharArray())
        {
            helper.append(c);
            getCombinations(digits, stringMapping, res, helper, index+1);
            helper.deleteCharAt(index);
        }
    }
}
