class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnce = 0,currMax=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 1) {
                maxOnce = Math.max(maxOnce,currMax);
                currMax=0;
            } else {
                currMax++;
            }
        }
        maxOnce = Math.max(maxOnce,currMax);
        return maxOnce;
    }
}