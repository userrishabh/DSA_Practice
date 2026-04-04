class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int stringLength = word1.length();
        if(word2.length()<stringLength)
            stringLength = word2.length();
        int i=0;
        while(i<stringLength)
        {
            res.append(word1.charAt(i));
            res.append(word2.charAt(i));
            i++;
        }
        while(i<word1.length())
        {
            res.append(word1.charAt(i));
            i++;
        }
        while(i<word2.length())
        {
            res.append(word2.charAt(i));
            i++;
        }
        return res.toString();
    }
}