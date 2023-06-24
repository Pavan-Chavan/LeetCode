class Solution {
    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        Stack<Integer> stk = new Stack<>();
        int leftMin[] = new int[len];
        Arrays.fill(leftMin,-1);
        int rightMin[] = new int[len];
        Arrays.fill(rightMin,len);
        int mod = 1000000007;

        for(int i=0; i<len; i++) {
            while(!stk.empty() && arr[stk.peek()] >= arr[i]) {
                int index = stk.pop();
                rightMin[index] = i;
            }
            stk.push(i);
        }
        stk.clear();

        for(int i=len-1; i>=0; i--) {
            while(!stk.empty() && arr[stk.peek()] > arr[i]) {
                int index = stk.pop();
                leftMin[index] = i;
            }
            stk.push(i);
        }
        long res =0;
        for(int i =0;i<len;i++) {
            int leftLen = i - leftMin[i];
            int rightLen = rightMin[i] - i;
            res = (res + ((long)arr[i]*leftLen*rightLen)%mod)%mod;
        }
        return (int)res;
    }
} 