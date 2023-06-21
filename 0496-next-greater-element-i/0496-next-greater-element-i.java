class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>stk = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums2) {
            while (!stk.empty() && stk.peek() < num) {
                map.put(stk.pop(),num);
            }
            stk.push(num);
        }
        for(int i =0;i<nums1.length;i++) {
            nums1[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        return nums1;
    }
}