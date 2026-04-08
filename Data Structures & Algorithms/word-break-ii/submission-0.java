class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> hs = new HashSet<>(wordDict);
        wordBreakPartition(s, hs, res, new StringBuilder(), 0);
        return res;
    }

    void wordBreakPartition(String s, Set<String> wordDict, List<String> res, StringBuilder sb, int index)
    {
        if(s.length() == index)
        {
            res.add(sb.toString());
            return;
        }

        for(int last=index; last<s.length(); last++)
        {
            String tempString = s.substring(index, last+1);
            if(wordDict.contains(tempString))
            {
                int length = sb.length();
                if(sb.length() > 0) sb.append(" ");
                sb.append(tempString);

                wordBreakPartition(s, wordDict, res, sb, last+1);

                sb.setLength(length);
            }
        }
    }
}