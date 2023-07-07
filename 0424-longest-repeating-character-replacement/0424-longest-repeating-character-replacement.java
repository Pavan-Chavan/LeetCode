class Solution {
    public int characterReplacement(String s, int k) {
        int []arr = new int[26];
        int largestCount=0,start=0;
        int result=0;
        for(int end =0;end < s.length();end++) {
            arr[s.charAt(end) - 'A']++;
            largestCount = Math.max(largestCount,arr[s.charAt(end) - 'A']);
            while((end-start+1)  - largestCount > k) {
                arr[s.charAt(start) - 'A']--;
                start++;
            }
            result = Math.max(result,end-start+1);
        }
        return result;
    }
}