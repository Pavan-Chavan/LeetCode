class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,right=0,streak=0;
        int len = nums.length;
        while(right<len) {
        if(nums[right] == 0  && k == 0) {
            while(nums[left] != 0) left++;
            left++;
            k++;
        }
        if(nums[right] == 0) k--;
        streak = Math.max(streak, right-left+1);
        right++;
        }
        return streak;
    }
}