class Solution {
    public boolean find132pattern(int[] nums) {
        int minimums [] = new int[nums.length];
        Stack<Integer> stk = new Stack<Integer>();
        for(int i=0;i<nums.length;i++) {
            if(i==0) {
                minimums[i] = 0;
            } else if(nums[i] < nums[minimums[i-1]]) {
                minimums[i] = i;
            } else {
                minimums[i] = minimums[i-1];
            }
            while(!stk.empty() && nums[stk.peek()] <= nums[i]) {
                stk.pop();
            }
            if(!stk.empty()) {
                if(nums[minimums[stk.peek()]] < nums[i])
                    return true;
            }
            stk.push(i);
        }
        return false;
    }
}