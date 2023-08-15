class Solution {
    private void helper(int[] candidates,int target,List<List<Integer>> result,List<Integer> CurrArr,int currSum, int currIndex){
        if(currSum == target ){
            result.add(new ArrayList<>(CurrArr));
            return;
        } else if (currSum > target) return;
        else {
            for(int i = currIndex;i<candidates.length;i++) {
                CurrArr.add(candidates[i]);
                currSum = currSum + candidates[i];
                helper(candidates,target,result,CurrArr,currSum,i);
                CurrArr.remove(CurrArr.size() - 1);
                currSum = currSum - candidates[i];
            }
        } 
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> CurrArr = new ArrayList<>();
        helper(candidates,target,result,CurrArr,0,0);
        return result;
    }
}