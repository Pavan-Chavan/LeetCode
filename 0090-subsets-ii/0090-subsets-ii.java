class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        helper(result,temp,nums,0);
        return result;
    }
    private void helper(List<List<Integer>> result,List<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<>(temp));
        for(int i=start; i<nums.length; i++) {
            if(i>start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            helper(result, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}