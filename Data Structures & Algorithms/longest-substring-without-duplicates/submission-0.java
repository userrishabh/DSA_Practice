class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int res = 0;
        int leftPointer = 0;
        for(int i=0; i<s.length(); i++)
        {
            char tempVal = s.charAt(i);
            while(hs.contains(tempVal))
            {
                hs.remove(s.charAt(leftPointer));
                leftPointer++;
            }
            hs.add(tempVal);
            int strLength = i-leftPointer+1;
            if(strLength>res)
                res=strLength;
        }
        return res;
    }
}
