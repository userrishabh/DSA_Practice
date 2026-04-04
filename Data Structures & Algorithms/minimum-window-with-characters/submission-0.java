class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> freqMap = new HashMap<>();
        for(int i=0; i<t.length(); i++)
        {
            char temp=t.charAt(i);
            freqMap.put(temp, freqMap.getOrDefault(temp, 0) + 1);
        }
        int count=freqMap.size();
        int leftPointer = 0;
        int minLength = Integer.MAX_VALUE;
        int startPointer = 0;
        for(int i=0; i<s.length(); i++)
        {
            char tempChar = s.charAt(i);
            if(freqMap.containsKey(tempChar))
            {
                freqMap.put(tempChar, freqMap.get(tempChar) - 1);
                if(freqMap.get(tempChar) == 0)
                    count--;
            }
            
                while(count==0)
                {
                    char charCheckInFreqMap = s.charAt(leftPointer);
                    
                    if(minLength>i-leftPointer+1)
                        {minLength = i-leftPointer+1;
                        startPointer = leftPointer;}
                
                    if(freqMap.containsKey(charCheckInFreqMap))
                    {
                        freqMap.put(charCheckInFreqMap, freqMap.get(charCheckInFreqMap) + 1);
                        if(freqMap.get(charCheckInFreqMap) == 1)
                        {
                            count++;
                        }
                    }

                    leftPointer++;
                }
        }
        if(minLength == Integer.MAX_VALUE)
            return "";

        return s.substring(startPointer, startPointer + minLength);
    }
}
