class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        double limit = Math.pow(2,nums.length);
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0;i<limit;i++) {
            List<Integer> temp = new ArrayList<>();
            for( int j =0;j<nums.length;j++) {
                if((i & (1<<j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            result.add(temp);
        }
        return result;
    }
}