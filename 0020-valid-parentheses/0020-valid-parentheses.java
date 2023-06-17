class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
            char currChar = s.charAt(i);
            if(currChar == '(' || currChar == '[' || currChar == '{') {
                stk.push(currChar);
            } else {
                if(stk.empty()) return false;
                char popedChar = stk.pop();
                if(')' == currChar && popedChar != '(') return false;
                else if(']' == currChar && popedChar != '[') return false;
                else if('}' == currChar && popedChar != '{') return false;
            }
        }
        return stk.empty();
    }
}