class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        String temp = "", ans = "";
        for(int i=0;i<n;i++) {
            if(s.charAt(i) != ' ') {
                temp = temp + s.charAt(i);
            } else {
                if(!temp.equals("")) {
                    if(!ans.equals("")) {
                        ans = temp + " " + ans;
                    } else {
                        ans = temp;
                    }
                    temp = "";
                }
            }
        }
        if(!temp.equals("")) {
            if(!ans.equals("")) {
                ans = temp + " " + ans;
            } else {
                ans = temp;
            }
        }
        return ans;
    }
}