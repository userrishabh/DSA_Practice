class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rankingArray = new int[26];
        for(int i=0; i<order.length(); i++)
        {
            int index = order.charAt(i) - 'a';
            rankingArray[index] = i;
        }

        for(int i=0; i<(words.length-1); i++)
        {
            String temp1 = words[i];
            String temp2 = words[i+1];
            int idx = 0;
            int length = temp1.length();
            if(temp2.length() < temp1.length())
                length = temp2.length();
            while(idx < length)
            {
                int index1 = temp1.charAt(idx) - 'a';
                int index2 = temp2.charAt(idx) - 'a';
                if(rankingArray[index1] > rankingArray[index2]) return false;
                if(rankingArray[index1] < rankingArray[index2]) break;
                idx++;
            }

            if(idx == length && temp2.length() < temp1.length()) return false;
        }

        return true;
    }
}