class Solution {
    public int lastStoneWeight(int[] stones) {
        int arrLength = stones.length;
        if(arrLength == 1) return stones[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int val : stones)
            maxHeap.offer(val);

        while(!maxHeap.isEmpty() && maxHeap.size() > 1)
        {
            int num1 = maxHeap.poll();
            int num2 = maxHeap.poll();
            int res = num1-num2;

            if(res != 0)
                maxHeap.offer(res);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
