class MyStack {
Queue<Integer> stackImplemented;
    public MyStack() {
        stackImplemented = new LinkedList<>();
    }
    
    public void push(int x) {
        stackImplemented.offer(x);
        int left = 1;
        int queueSize = stackImplemented.size();
        while(left<queueSize)
        {
            int tempVal = stackImplemented.poll();
            stackImplemented.offer(tempVal);
            left++;
        }
    }
    
    public int pop() {
        return stackImplemented.poll();
    }
    
    public int top() {
        return stackImplemented.peek();
    }
    
    public boolean empty() {
        return stackImplemented.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */