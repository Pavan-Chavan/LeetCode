class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int left=0,right=len-1;
        int result[] = {0,1};

        while(left<right) {
            if(numbers[left] + numbers[right] == target) {
                result[0] = left+1;
                result[1] = right+1;
                return result;
            }
            if(target-numbers[left] < numbers[right]) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}