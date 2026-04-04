class Solution {
    public String reorganizeString(String s) {
        int length = s.length();

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<length; i++)
        {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            
            if(hm.get(s.charAt(i)) > (length+1)/2) return "";
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> hm.get(b) - hm.get(a));

        for(char ch : hm.keySet())
        {
            maxHeap.offer(ch);
        }

        char prev = '#'; 
        StringBuilder res = new StringBuilder();

        while(!maxHeap.isEmpty())
        {
            char temp = maxHeap.poll();
            res.append(temp);
            hm.put(temp, hm.get(temp) - 1);

            if(prev != '#' && hm.get(prev) > 0)
                maxHeap.offer(prev);
            prev = temp;
        }

        return res.toString();
    }
}