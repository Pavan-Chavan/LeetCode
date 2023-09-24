class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result,new ArrayList<>(), candidates, target,0,0);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer>tempList, int[] candidates, int target, int start,int currSum) {
        if(currSum == target) {
            result.add(new ArrayList<>(tempList));
            return;
        } else if (currSum > target) return;
        else {
            for(int i=start; i<candidates.length; i++) {
                if(i > start && candidates[i] == candidates[i-1]) continue;
                tempList.add(candidates[i]);
                helper(result,tempList, candidates, target,i+1,currSum+candidates[i]);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}