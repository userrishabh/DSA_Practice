class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
       int length = profits.length;

        int[][] helper = new int[length][2]; // to store capital and profits as pair

        for(int i=0; i<length; i++)
        {
            helper[i][0] = capital[i];
            helper[i][1] = profits[i];
        }

        Arrays.sort(helper, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // to store profit possible within the capital 

        int res = w;
        int j = 0;
        for(int i=0; i<k; i++)
        {
            while(j < length && helper[j][0] <= res)
            {
                maxHeap.offer(helper[j][1]);
                j++;
            }

            if(maxHeap.isEmpty()) break;

            res += maxHeap.poll();
        }
    return res; 
    }
}