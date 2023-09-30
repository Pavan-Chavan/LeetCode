class Solution {
    public int singleNonDuplicate(int[] nums) {
        int size = nums.length;

        if(size==1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[size-1] != nums[size-2]) return nums[size-1];

        int left = 0, right = size-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];
            else if(nums[mid] == nums[mid-1] && (mid%2 == 1) || nums[mid] == nums[mid+1] && (mid%2 == 0) )
                left = mid+1;
            else 
                right = mid-1;
        }
        return -1;
    }
} 