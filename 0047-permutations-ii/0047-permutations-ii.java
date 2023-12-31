class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0, new boolean[nums.length]);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start, boolean [] used) {
        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for(int i=0;i<nums.length;i++) {
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                tempList.add(nums[i]);
                used[i] = true;
                backtrack(list,tempList,nums,i+1,used);
                tempList.remove(tempList.size()-1);
                used[i] = false;
            }
        }
    }
}