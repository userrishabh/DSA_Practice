class MinStack {
Stack<Integer> st;
    Stack<Integer> helper;
    public MinStack() {
        st = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(helper.isEmpty())
            helper.push(val);
        else if(helper.peek() < val)
        {
            helper.push(helper.peek());
        }
        else
        {
            helper.push(val);
        }
    }
    
    public void pop() {
        helper.pop();
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return helper.peek();
    }
}
