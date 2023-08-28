class Solution {
    public int majorityElement(int[] nums) {
        int currEle = nums[0];
        int currEleCounter =1;
        for(int i=1;i<nums.length;i++) {
            if(currEle == nums[i]) 
                currEleCounter++;
            else {
                currEleCounter--;
                if(currEleCounter == 0){
                    currEle = nums[i];
                    currEleCounter=1;
                }
            }
        }
        return currEle;
    }
}