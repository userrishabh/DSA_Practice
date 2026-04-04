class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for(int value : nums)
        {
            minHeap.offer(value);
            if(minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.peek();
    }
}
