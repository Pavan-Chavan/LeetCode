class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int result[] = new int[nums.length];
        int n = nums.length;
        for(int i=2*n-1; i>=0; i-- ) {
            while(!stk.empty() && nums[i%n] >= stk.peek()) {
                stk.pop();
            }
            if(stk.empty()) {
                result[i%n] = -1;
            }
            else {
                result[i%n] = stk.peek();
            }
            stk.push(nums[i%n]);
        }
        return result;
    }
}