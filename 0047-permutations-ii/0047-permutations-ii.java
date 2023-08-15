class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result,new ArrayList<>(),nums,new boolean [nums.length]);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean [] used){
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for(int i=0;i<nums.length;i++) {
                if(used[i] || i> 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true; 
                temp.add(nums[i]);
                helper(result, temp, nums, used);
                used[i] = false; 
                temp.remove(temp.size() - 1);
            }
        }
    }
}