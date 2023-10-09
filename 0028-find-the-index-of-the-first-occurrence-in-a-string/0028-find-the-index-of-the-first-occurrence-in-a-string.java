class Solution {
    public int strStr(String haystack, String needle) {
        // int len1 = haystack.length(), len2 = needle.length();
        // int i=0,j=0;
        // int result = 0;
        // while(i < (len1 - len2)) {
        //     j=0;
        //     while(j<len2 && haystack.charAt(i+j) == needle.charAt(j)){
        //         if(j == len2) result = i;
        //         j++;
        //     }
        //     i++;
        // }
        return haystack.indexOf(needle);
    }
}