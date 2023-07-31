class Solution {
    public int numSubarrayBoundedMax(int[] nums, int min, int max) {
        int i=0,j=0,maxind=-1,res=0;
        while(j < nums.length) {
            if(nums[j] >= min && nums[j] <= max) {
                maxind = j;
            }
            if(nums[j] > max) {
                j++;
                i=j;
                maxind=-1;
                continue;
            }
            if(maxind != -1) {
                res += maxind-i+1;
            }
            j++;
        }
        return res;
    }
}