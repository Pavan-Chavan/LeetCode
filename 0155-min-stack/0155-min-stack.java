class MinStack {
    Stack<Long> stk = new Stack<>();
    Long mini;
    public MinStack() {
        mini = Long.MAX_VALUE;
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);
        if(stk.empty()){
            stk.push(val);
            mini = val;
        } else {
            if(val < mini) {
                stk.push(2 * val - mini);
                mini = val;
            } else {
                stk.push(val);
            }
        }
    }
    
    public void pop() {
        if (stk.isEmpty()) return;

        Long val = stk.pop();
        if (val < mini) {
            mini = 2 * mini - val;
        }
    }
    
    public int top() {
        Long val = stk.peek();
        if (val < mini) {
            return mini.intValue();
        }
        return val.intValue();
    }
    
    public int getMin() {
        return mini.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */