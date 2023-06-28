class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k==len)
            return "0";
        Stack<Character>stk = new Stack<>();
        String result= "";
        for(int i=0; i<num.length(); i++) {
            while(k>0 && !stk.empty() && stk.peek() > num.charAt(i)) {
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
        }
        while(k > 0) {
            stk.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.empty()) {
            sb.append(stk.pop());
        }
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}