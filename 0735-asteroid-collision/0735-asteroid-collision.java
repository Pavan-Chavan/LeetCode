class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for (int val : asteroids) {
            if(val > 0) stk.push(val);
            else {
                while(!stk.empty() && stk.peek() > 0 && stk.peek() < -val) {
                    stk.pop();
                }
                if(!stk.empty() && stk.peek() == -val) {
                    stk.pop();
                } else if (!stk.empty() && stk.peek() > -val) {

                } else {
                    stk.push(val);
                }
            }
        }
        int result[] = new int[stk.size()];
        for(int i=stk.size()-1;i>=0;i--) {
            result[i] = stk.pop();
        }
        return result;
    }
}