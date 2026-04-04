class Solution {
    public String longestDiverseString(int a, int b, int c) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('a', a);
        hm.put('b', b);
        hm.put('c', c);

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((x,y) -> hm.get(y) - hm.get(x));

        for(char ch : hm.keySet())
            {
                if(hm.get(ch) > 0)
                maxHeap.offer(ch);
            }
        
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty())
        {
            int length = sb.length();
            char first = maxHeap.poll();

            if(length >= 2 && sb.charAt(length - 1) == first && sb.charAt(length - 2) == first)
            {
                if(maxHeap.isEmpty()) break;

                char second = maxHeap.poll();
                sb.append(second);

                hm.put(second, hm.get(second) - 1);

                if(hm.get(second) > 0)
                    maxHeap.offer(second);
                
                maxHeap.offer(first);
            }

            else
            {
                sb.append(first);
                hm.put(first, hm.get(first) - 1);
                if(hm.get(first) > 0)
                    maxHeap.offer(first);
            }
        }

        return sb.toString();
    }
}