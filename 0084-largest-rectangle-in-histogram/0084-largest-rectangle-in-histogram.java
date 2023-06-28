class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int leftSmall[] = new int[len];
        Arrays.fill(leftSmall,0);
        int rightSmall[] = new int[len];
        Arrays.fill(rightSmall,0);

        Stack<Integer> stk = new Stack<>();
        for(int i =0;i<len;i++) {
            while(!stk.empty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            if(!stk.empty()) {
                leftSmall[i] = stk.peek() +1;
            }
            stk.push(i);
        }
        stk.clear();
        for(int i =len-1;i>=0;i--) {
            while(!stk.empty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            if(!stk.empty()) {
                rightSmall[i] = stk.peek()-1;
            } else {
                rightSmall[i] = len-1;
            }
            stk.push(i);
        }
        int maxH = 0;
        for(int i=0; i<len; i++) {
            maxH = Math.max(maxH, (rightSmall[i] - leftSmall[i] +1) * heights[i]);
        }
        return maxH;
    }
}