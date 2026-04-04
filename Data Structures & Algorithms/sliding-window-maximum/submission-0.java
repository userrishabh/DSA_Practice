class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int leftPointer = 0;
        int [] res = new int[nums.length-k+1];
        int maxValue = Integer.MIN_VALUE;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i =0; i<nums.length; i++)
        {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
            {
                dq.pollLast();
            }

            dq.offer(i);

            if(dq.peekFirst() < i-k+1)
                dq.pollFirst();

            if(i>=k-1)
            {
                res[leftPointer] = nums[dq.peekFirst()];
                leftPointer++;
            }
        }
        return res;
    }
}
