class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>stk = new Stack<Integer>();
        int len = temperatures.length;
        int result[] = new int[len];
        for(int i=0; i<len; i++) {
            while(!stk.empty() && temperatures[stk.peek()] < temperatures[i]){
                int topStack = stk.pop();
                result[topStack] = i - topStack;
            }
            stk.push(i);
        }
        return result;
    }
}