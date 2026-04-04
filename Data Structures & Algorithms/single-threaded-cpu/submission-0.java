class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
    
    // Add index
    int[][] arr = new int[n][3];
    for (int i = 0; i < n; i++) {
        arr[i][0] = tasks[i][0]; // enqueue
        arr[i][1] = tasks[i][1]; // processing
        arr[i][2] = i;           // index
    }
    
    Arrays.sort(arr, (a, b) -> a[0] - b[0]);
    
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]
    );
    
    int[] res = new int[n];
    int time = 0, i = 0, k = 0;
    
    while (k < n) {
        
        // add available tasks
        while (i < n && arr[i][0] <= time) {
            pq.offer(arr[i]);
            i++;
        }
        
        if (pq.isEmpty()) {
            time = arr[i][0]; // jump time
        } else {
            int[] curr = pq.poll();
            time += curr[1];
            res[k++] = curr[2];
        }
    }
    
    return res;
    }
}