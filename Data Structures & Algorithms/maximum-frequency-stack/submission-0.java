class FreqStack {
HashMap<Integer, Integer> freqMap;
    HashMap<Integer, Deque<Integer>> freqToElementMap;
    int maxFreqSoFar;
    public FreqStack() {
        freqMap = new HashMap<>();
        freqToElementMap = new HashMap<>();
        maxFreqSoFar=0;
    }
    
    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        int freq = freqMap.get(val);
        maxFreqSoFar = Math.max(maxFreqSoFar, freq);

        Deque<Integer> dataStack = freqToElementMap.getOrDefault(freq, new ArrayDeque<>());
        dataStack.push(val);
        freqToElementMap.put(freq, dataStack);
    }
    
    public int pop() {
        Deque<Integer> res = freqToElementMap.get(maxFreqSoFar);
        int resElement = res.pop();
        freqMap.put(resElement, freqMap.get(resElement)-1);
        if(res.size() == 0)
            maxFreqSoFar--;
        
        return resElement;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */