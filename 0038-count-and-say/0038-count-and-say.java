class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        return countWord(countAndSay(n-1));
    }
    private String countWord(String str) {
        System.out.println("input " + str);
        String result = "";
        int count = 0,i=0;
        int len = str.length();
        if(len == 1) return "11";
        while(i<len-1) {
            count = 1;
            while(i<len-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            result = result + count + str.charAt(i);
            i++;
        }
        System.out.println(i);
        if(str.charAt(len-1) != str.charAt(len-2)) {
            result = result + "1" + str.charAt(len-1);
        }
        return result;
    } 
}