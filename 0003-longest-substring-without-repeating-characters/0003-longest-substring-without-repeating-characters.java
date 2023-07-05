class Solution {
    public int lengthOfLongestSubstring(String s) {
       int l =0,maxans=0,len=s.length();
       Set<Character>set = new HashSet<>();
       if(s.length() == 0) return 0;
       for(int r=0;r<len;r++) {
           if(set.contains(s.charAt(r))) {
               while(l<r && set.contains(s.charAt(r))) {
                   set.remove(s.charAt(l));
                   l++;
               }
           }
           set.add(s.charAt(r));
           maxans = Math.max(maxans,r-l+1);
       }
       return maxans;
    }
}