class Solution {
    public int characterReplacement(String s, int k) {
        int [] freqArray = new int[26];
        int left = 0;
        int res = 0;
        int maxFreq = 0;

        for(int right=0; right<s.length(); right++)
        {
            freqArray[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freqArray[s.charAt(right)-'A']);
            while((right-left+1) - maxFreq > k)
                {
                    freqArray[s.charAt(left) - 'A']--;
                    left++;
                }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}
