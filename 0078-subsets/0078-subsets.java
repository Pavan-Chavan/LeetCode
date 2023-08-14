class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result,new ArrayList<>(), nums, 0);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++) {
            temp.add(nums[i]);
            helper(result,temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}