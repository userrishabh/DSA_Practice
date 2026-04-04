class MedianFinder {
PriorityQueue<Integer> maxHeap; // to store left part of sorted num
    PriorityQueue<Integer> minHeap; // to store right part

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())
        {
            minHeap.offer(maxHeap.poll());
        }

        if(maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());
        else if(minHeap.size() > maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size() != maxHeap.size())
            return maxHeap.peek();
        return (double)(minHeap.peek() + maxHeap.peek())/ 2;
    }
}
