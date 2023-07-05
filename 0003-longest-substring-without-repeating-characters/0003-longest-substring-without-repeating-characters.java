class Solution {
    public int lengthOfLongestSubstring(String S) {
       HashMap<Character, Integer> mpp = new HashMap<Character, Integer> ();
        int len = S.length(), right=0,left=0,maxlen=0;
        if(len==0) return 0;
        while(right<len) {
            if(mpp.containsKey(S.charAt(right)))
                left = Math.max(left,mpp.get(S.charAt(right))+1); // reconsider
            mpp.put(S.charAt(right),right);
            maxlen = Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
    }
}