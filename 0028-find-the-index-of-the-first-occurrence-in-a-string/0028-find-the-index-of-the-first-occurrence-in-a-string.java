class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length();
        int i=0,j=0;
        int result = -1;
        while(i < (len1 - len2 + 1)) {
            j=0;
            while(j<len2 && haystack.charAt(i+j) == needle.charAt(j)){
                if(j == len2-1) result = i;
                j++;
            }
            if(result != -1) break;
            i++;
        }
        return result;
    }
}