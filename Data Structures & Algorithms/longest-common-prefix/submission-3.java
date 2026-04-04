class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        StringBuilder tempStr = new StringBuilder("");
        int i =0, j=0;
        while(i<strs[0].length() && j<strs[1].length())
        {
            if(strs[0].charAt(i) == strs[1].charAt(j))
            {
                tempStr.append(strs[0].charAt(i));
                ++i; ++j;
            }
            else
                break;
        }
        if(strs.length == 2)
            return tempStr.toString();
        for(int k =2; k<strs.length; k++)
        {
            StringBuilder tempVal = new StringBuilder(strs[k]);
            StringBuilder res= new StringBuilder("");
            if (tempStr.length() > 0)
            { for(int l=0; l<tempStr.length() && l<tempVal.length(); l++)
                {
                if(tempStr.charAt(l) == tempVal.charAt(l))
                {res.append(tempStr.charAt(l));}
                else
                {
                    tempStr = res;
                    break;
                }
                }
                tempStr = res;
            }
            else
            {
                return tempStr.toString();
            }
        }
        return tempStr.toString();
    }
}