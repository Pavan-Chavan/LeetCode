class Solution {
    int start = 0;
    int max = 0;
    public String longestPalindrome(String s) {
        if(s.length() < 2 ) return s;

        char [] str = s.toCharArray();

        for(int i=0; i<str.length;i++) {
            findPal(str,i,i);
            findPal(str,i,i+1);
        }
        return s.substring(start, max + start);
    }

    private void findPal(char [] str, int j, int k) {
        while(j>=0 && k < str.length && str[j] == str[k]) {
            j--;
            k++;
        }
        if(max < k-j-1) {
            start = j+1;
            max = k-j-1;
        }
    }
}