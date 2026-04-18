class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int [] freqS1 = new int[26];
        int [] freqS2 = new int[26];
        int leftPointer = 0;
        int windowSize = s1.length();

        for(int i=0; i<windowSize; i++)
        {
            freqS1[s1.charAt(i) - 'a']++;
        }

        for(int i=0; i<s2.length(); i++)
        {
            freqS2[s2.charAt(i)-'a']++;
            if((i-leftPointer+1) == windowSize)
            {
                
                boolean isValid = true;
                for(int j=0; j<26; j++)
                {
                    if(freqS2[j] != freqS1[j])
                    {
                        isValid = false;
                        break;
                    }
                }
                if(isValid)
                    return true;
                freqS2[s2.charAt(leftPointer)-'a']--;
                leftPointer++;
            }
        }
        return false; 
    }
}
